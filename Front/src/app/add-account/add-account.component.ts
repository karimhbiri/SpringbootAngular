import { Component, OnInit } from '@angular/core';
import { AccountService } from 'app/services/account.service';
import { ClientService } from 'app/services/client.service';

@Component({
  selector: 'app-add-account',
  templateUrl: './add-account.component.html',
  styleUrls: ['./add-account.component.css']
})
export class AddAccountComponent implements OnInit {

  selectedClient: any = null;
  clients: any[] = [{cin:'1111',nom:'nom',prenom:'prenom'}];
  account: any = null;
  accountRib: string = "";
  accountDate: string = "";

  constructor(private clientService: ClientService, private accountService: AccountService) { }

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
    this.account = {
      rib: this.accountRib,
      date: this.accountDate,
      clientCin: this.selectedClient,
    }
    if (confirm('Do you want to create a new account?')) {
      this.accountService.addAccount(this.account).subscribe({
        next: (event: any) => {
          alert('Account has been created');
        },
        error: err => {
          alert("Account couldn't be removed.");
        },
        complete: () => {

        }
      })
    }
  }

}
