import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { sharedConstants } from '../../app/shared/shared-constants';

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  constructor(private http: HttpClient) { }

  updateAccount(params : any = []) {
    return this.http.get(sharedConstants.API_ENDPOINT+ 'accounts/update', {params})
  }

  removeAccount(id : any ,params : any = []) {
      return this.http.post(sharedConstants.API_ENDPOINT + 'accounts/delete/'+id , params);
  }

  addAccount(params : any = []) {
    return this.http.post(sharedConstants.API_ENDPOINT + 'accounts/add' , params);
  }

  getAccount(id : any ,params : any = []) {
    return this.http.get(sharedConstants.API_ENDPOINT+ 'accounts/'+id, {params})
  }

}
