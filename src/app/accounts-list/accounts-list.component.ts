import { Component, OnInit } from '@angular/core';
import { AccountService } from 'app/services/account.service';
import { ClientService } from 'app/services/client.service';

@Component({
  selector: 'app-accounts-list',
  templateUrl: './accounts-list.component.html',
  styleUrls: ['./accounts-list.component.css']
})
export class AccountsListComponent implements OnInit {

  selectedClient: any = null;
  clients: any[] = [{cin:'110994545',nom:'nom',prenom:'prenom',email:'email@'}];
  accountId: string = "";
  accountRib: string = "";
  accountClientCin: string = "";
  accountClientFN: string = "";
  accountCreatedAt : string = "";
  accounts: any[] = [{id:'12',rib:'123456789879456', client:{cin:'110994545',nom: 'nom', prenom:'prenom'}, createdAt:'21-10-2022'}];
  myAccount: any = null;

  constructor(private clientService: ClientService, private accountService: AccountService) { }

  ngOnInit() {
  }

  getAccounts() {
    this.accountService.getAccounts().subscribe({
      next: (event: any) => {
        this.accounts = event;
      },
      error: err => {
        console.log('no accounts found!');
      },
      complete: () => {
  
      }
    })
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

  openProfile(id) {
    // TODO
    alert(id);
  }

  editAccount(id) {
    this.accounts.forEach(elem => {
      if(elem.id == id) {
        this.accountId = elem.cin;
        this.accountRib = elem.prenom;
        this.selectedClient = elem.client.cin;
        this.accountCreatedAt = elem.createdAt;
      }
    })
    document.querySelector('.m-edit-modal').classList.remove('is-hidden');
  }

  cancelUpdateAccount() {
    document.querySelector('.m-edit-modal').classList.add('is-hidden');
  }

  updateAccount() {
    this.myAccount = {
      id: this.accountId,
      rib: this.accountRib,
      clientCin: this.accountClientCin,
      createdAt: this.accountCreatedAt
    }

    this.accountService.updateAccount(this.myAccount).subscribe({
      next: (event: any) => {
        alert('Account has been updated');
      },
      error: err => {
        alert("Account couldn't be updated.");
      },
      complete: () => {
        this.getAccounts();
        document.querySelector('.m-edit-modal').classList.add('is-hidden');
      }
    })
  }

  removeAccount(id) {
    if (confirm('Are you sure you want to remove this client?')) {
      this.accountService.removeAccount(id).subscribe({
        next: (event: any) => {
          alert('Client has been removed');
        },
        error: err => {
          alert("client couldn't be removed.");
        },
        complete: () => {
          this.getAccounts();
        }
      })
    }
  }
}
