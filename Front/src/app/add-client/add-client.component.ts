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
  clients: any[] = [{cin:'110994545',nom: 'nom', prenom:'prenom'}];

  constructor(private clienService: ClientService) { }

  ngOnInit() {
    this.getClients();
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
          this.getClients();
        }
      })
    }
    else
    {
      alert('Please verify your input fields.');
    }
  }

  getClients() {
    this.clienService.getClients().subscribe({
      next: (event: any) => {
        event.array.forEach((element, index) => {
          if(index < 3) {
            this.clients.push(element);
          }
        });
      },
      error: err => {
        console.log('no clients found!');
      },
      complete: () => {
  
      }
    })
  }

  openProfile(cin) {
    // TODO
    alert(cin);
  }

}
