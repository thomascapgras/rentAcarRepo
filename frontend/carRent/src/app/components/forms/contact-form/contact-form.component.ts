import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ContactService } from 'src/app/services/shares/contact.service';
import { ContactModalComponent } from '../../shares/modals/contact-modal/contact-modal.component';
import { Contact } from 'src/app/entities/shares/contact.interface';
import { ContactFactory } from 'src/app/entities/shares/contact.factory';


@Component({
  selector: 'app-contact-form',
  templateUrl: './contact-form.component.html',
  styleUrls: ['./contact-form.component.css']
})
export class ContactFormComponent implements OnInit {

  contact : Contact;

  constructor(private contactService : ContactService,private dialog: MatDialog) {
    this.contact=ContactFactory.createcontact();
   }

  ngOnInit(): void {
  }

  onSubmit():void{
    this.contactService.sendContact(this.contact).subscribe({
      next: (response) => {
        console.log(response);
        this.openDialog();
      },
      error: (err) => {
        console.log(err);
      }
    });
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(ContactModalComponent, {
      width: '30%', 
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('the modal has been closed');
    });
  }

}
