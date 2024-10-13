import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { FiltersDto } from 'src/app/entities/car/filters.interface';
import { FiltersService } from 'src/app/services/forms/filters.service';

@Component({
  selector: 'app-filters',
  templateUrl: './filters.component.html',
  styleUrls: ['./filters.component.css']
})
export class FiltersComponent implements OnInit {
  filters: FiltersDto;

  constructor(
    public dialogRef: MatDialogRef<FiltersComponent>,
    private filtersService: FiltersService
  ) {
    this.filters = this.filtersService.getFilters();
  }

  ngOnInit(): void {
    this.filtersService.resetFilters();
    console.log( this.filtersService.getFilters);

  }

  public close(refresh: boolean = false): void {
    this.dialogRef.close({ refresh });
  }

  onCheckboxChange(filter: keyof FiltersDto, event: Event): void {
    const input = event.target as HTMLInputElement;
    if (filter === 'gps') {
      this.filtersService.setGps(input.checked);
    } else if (filter === 'backupCamera') {
      this.filtersService.setBackupCamera(input.checked);
    } else if (filter === 'manualTransmission') {
      this.filtersService.setManualTransmission(input.checked);
    } else if (filter === 'bluetooth') {
      this.filtersService.setBluetooth(input.checked);
    }
  }
}
