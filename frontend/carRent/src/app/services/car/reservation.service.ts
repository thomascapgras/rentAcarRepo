import { HttpClient, HttpHeaders, HttpParams, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, BehaviorSubject } from 'rxjs';
import { map } from 'rxjs/operators';
import { ReservationDto } from 'src/app/entities/shares/reservation.interface';
import { ReservationFactory } from 'src/app/entities/shares/reserversation.factory';
import { SHARESCONST } from 'src/app/url-constantes';
import { UserService } from '../shares/user.service';

@Injectable({
  providedIn: 'root'
})
export class ReservationService {
  
  private reservation: ReservationDto;
  private reservationsSubject: BehaviorSubject<ReservationDto[]> = new BehaviorSubject<ReservationDto[]>([]);
  public reservations$: Observable<ReservationDto[]> = this.reservationsSubject.asObservable();

  constructor(private http: HttpClient,private  userService : UserService) {
    this.reservation = ReservationFactory.createReservation();
  }

  setReservation(reservation: ReservationDto): void {
    this.reservation = reservation;
  }

  getReservation(): ReservationDto {
    return this.reservation;
  }

  setReservations(reservations: ReservationDto[]): void {                                                                   
    this.reservationsSubject.next(reservations);
  }

  getReservations(): ReservationDto[] {
    return this.reservationsSubject.value;
  }

  setCityReservation(city: string): void {
    this.reservation.city = city;
  }

  resetReservation():void{
    this.reservation = ReservationFactory.createReservation();
  }

  clearReservations(): void {
    this.reservationsSubject.next([]);
  }

  saveReservation(reservation: ReservationDto, userId: number): Observable<HttpResponse<any>> {
    let params = new HttpParams();
    const Url = SHARESCONST.urlSaveResrvation;
    params = params.append('userId', userId.toString());

    const options = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      }),
      params: params,
      observe: 'response' as 'response'
    };

    return this.http.post<any>(Url, reservation, options);
  }

  getReservationsByUserId(id: number): Observable<ReservationDto[]> {
    const url = `${SHARESCONST.urlGetReservationsByUserId}/${id}`;
    return this.http.get<ReservationDto[]>(url, { withCredentials: true }).pipe(
      map(reservations => {
        this.setReservations(reservations);  
        return reservations;
      })
    );
  }

  deleteReservationsById(id: number): Observable<ReservationDto[]> {
    let params = new HttpParams();
    params = params.append('userId', this.userService.getUser().id.toString());
    const url = `${SHARESCONST.urlDeleteReservation}/${id}`;
    return this.http.delete<ReservationDto[]>(url, { 
      params: params,
      withCredentials: true 
    });
  }
  
}
