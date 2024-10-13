import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { Router } from '@angular/router';

@Component({
  selector: 'app-contact-modal',
  templateUrl: './contact-modal.component.html',
  styleUrls: ['./contact-modal.component.css']
})
export class ContactModalComponent implements OnInit {
  private timer: any;

  constructor(public dialogRef: MatDialogRef<ContactModalComponent>, private router : Router) { }


  ngOnInit(): void {
    this.startTimer();
  }

  ngOnDestroy(): void {
    clearTimeout(this.timer);
  }

  startTimer(): void {
    this.timer = setTimeout(() => {
      this.router.navigate(['/']);
    })
  }


  close(): void {
    this.dialogRef.close();
    this.startTimer();
  }


}
