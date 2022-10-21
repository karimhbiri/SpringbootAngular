import { Component, OnInit } from '@angular/core';
import { AccountService } from 'app/services/account.service';
import { ClientService } from 'app/services/client.service';

@Component({
  selector: 'app-accounts-list',
  templateUrl: './accounts-list.component.html',
  styleUrls: ['./accounts-list.component.css']
})
export class AccountsListComponent implements OnInit {

  accounts: any[] = [];

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
}
