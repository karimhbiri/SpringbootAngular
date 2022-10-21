import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { sharedConstants } from '../../app/shared/shared-constants';

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  constructor(private http: HttpClient) { }

  updateClient(params : any = []) {
    return this.http.post(sharedConstants.API_ENDPOINT+ 'clients/update', params)
  }

  removeClient(id : any ,params : any = []) {
      return this.http.post(sharedConstants.API_ENDPOINT + 'clients/delete/'+id , params);
  }

  addClient(params : any = []) {
    return this.http.post(sharedConstants.API_ENDPOINT + 'clients/add' , params);
  }

  getClient(id : any ,params : any = []) {
    return this.http.get(sharedConstants.API_ENDPOINT+ 'clients/'+id, {params})
  }

  getClients(params : any = []) {
    return this.http.get(sharedConstants.API_ENDPOINT+ 'clients/', {params})
  }

}
