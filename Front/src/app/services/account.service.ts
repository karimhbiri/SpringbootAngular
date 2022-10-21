import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { sharedConstants } from '../../app/shared/shared-constants';

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  constructor(private http: HttpClient) { }

  updateAccount(params : any = []) {
    return this.http.get(sharedConstants.API_ENDPOINT+ 'comptes/update', {params})
  }

  removeAccount(id : any ,params : any = []) {
      return this.http.post(sharedConstants.API_ENDPOINT + 'comptes/delete/'+id , params);
  }

  addAccount(params : any = []) {
    return this.http.post(sharedConstants.API_ENDPOINT + 'comptes/save' , params);
  }

  getAccount(id : any ,params : any = []) {
    return this.http.get(sharedConstants.API_ENDPOINT+ 'comptes/'+id, {params})
  }

  getAccounts(params : any = []) {
    return this.http.get(sharedConstants.API_ENDPOINT+ 'comptes/all-json', {params})
  }

}
