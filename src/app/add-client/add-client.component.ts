import { Component, OnInit } from '@angular/core';
import { ClientService } from 'app/services/client.service';

@Component({
  selector: 'app-add-client',
  templateUrl: './add-client.component.html',
  styleUrls: ['./add-client.component.css']
})
export class AddClientComponent implements OnInit {

  clientFirstName: string = "";
  clientLastName: string = "";
  clientEmail: string = "";
  clientOccupation : string = "";
  clientCin: string = "";
  clientAddress: string = "";
  clientCity: string = "";
  clientPostalCode: string = "";
  clientCountry: string = "";
  clientAboutMe: string = "";

  constructor(private clienService: ClientService) { }

  ngOnInit() {
  }

  addClient() {
    if(this.clientCin !=='' && this.clientLastName !== '' && this.clientFirstName !== '') {
      let data = {
        cin: this.clientCin,
        nom: this.clientLastName,
        prenom: this.clientFirstName
      }
      this.clienService.addClient(data).subscribe({
        next: (event: any) => {
          alert('has been added');
        },
        error: err => {
          alert('error');
        },
        complete: () => {
    
        }
      })
    }
    else
    {
      alert('Please verify your input fields.');
    }
  }

}
