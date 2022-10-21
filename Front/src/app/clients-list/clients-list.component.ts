import { Component, OnInit } from '@angular/core';
import { ClientService } from 'app/services/client.service';

@Component({
  selector: 'app-clients-list',
  templateUrl: './clients-list.component.html',
  styleUrls: ['./clients-list.component.css']
})
export class ClientsListComponent implements OnInit {

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
  clients: any[] = [{cin:'1111',nom:'nom',prenom:'prenom',email:'email@'}];
  myClient: any = null;

  constructor(private clientService: ClientService) { }

  ngOnInit() {
    this.getClients();
  }

  getClients() {
    this.clientService.getClients().subscribe({
      next: (event: any) => {
        this.clients = event;
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

  editClient(cin) {
    this.clients.forEach(elem => {
      if(elem.cin == cin) {
        console.log(elem);
        this.clientCin = elem.cin;
        this.clientFirstName = elem.prenom;
        this.clientLastName = elem.nom;
        this.clientEmail = elem.email;
        console.log(this.clientEmail);
      }
    })
    document.querySelector('.m-edit-modal').classList.remove('is-hidden');
  }

  cancelUpdateClient() {
    document.querySelector('.m-edit-modal').classList.add('is-hidden');
  }

  updateClient() {
    this.myClient = {
      cin: this.clientCin,
      nom: this.clientLastName,
      prenom: this.clientFirstName
    }

    this.clientService.updateClient(this.myClient).subscribe({
      next: (event: any) => {
        alert('Client has been updated');
      },
      error: err => {
        alert("client couldn't be updated.");
      },
      complete: () => {
        this.getClients();
        document.querySelector('.m-edit-modal').classList.add('is-hidden');
      }
    })

  }

  removeClient(cin) {
    if (confirm('Are you sure you want to remove this client?')) {
      this.clientService.removeClient(cin).subscribe({
        next: (event: any) => {
          alert('Client has been removed');
        },
        error: err => {
          alert("client couldn't be removed.");
        },
        complete: () => {
          this.getClients();
        }
      })
    }
  }

}
