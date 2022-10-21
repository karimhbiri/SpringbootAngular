import { Component, OnInit } from '@angular/core';
import { AccountService } from 'app/services/account.service';
import { ClientService } from 'app/services/client.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-account',
  templateUrl: './add-account.component.html',
  styleUrls: ['./add-account.component.css']
})
export class AddAccountComponent implements OnInit {

  selectedClient: any = null;
  clients: any[] = [{cin:'110994545',nom: 'Oussema', prenom:'Kassis'},{cin:'12345678',nom: 'nom', prenom:'prenom'}];
  account: any = null;
  accountRib: string = "";
  accountSolde: string = "";

  constructor(private clientService: ClientService, private accountService: AccountService,private router: Router) { }

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

  createAccount() {
    if(this.accountRib !== '' && this.selectedClient !== '') {
      this.account = {
        rib: this.accountRib,
        solde: this.accountSolde,
        cin: this.selectedClient,
      }
      if (confirm('Do you want to create a new account?')) {
        console.log(this.account);
        this.accountService.addAccount(this.account).subscribe({
          next: (event: any) => {
            alert('Account has been created');
          },
          error: err => {
            alert("Account couldn't be created.");
          },
          complete: () => {
            this.router.navigate(['../accounts-list']);
          }
        })
      }
    } else {
      alert('Please verify the input fields.');
    }
  }

}
