import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  URL = 'http://localhost:3000/customer';
  regURL = 'http://localhost:3000/customerType';
  constructor(private _http: HttpClient) {
  }
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };
  getCustomerList() {
    return this._http.get(this.URL);
  }


  addCustomer(data) {
    // return this._http.post(this.URL, data);
    return this._http.post(this.URL, data, this.httpOptions);
  }

  deleteCustomer(id) {
    return this._http.delete(this.URL + '/' + id);
  }

  getCurrentData(id) {
    return this._http.get(`${this.URL}/${id}`);
  }

  updateCustomer(id, data) {
    return this._http.put(`${this.URL}/${id}`, data);
  }

  getAllCustomerType(){
    return this._http.get(this.regURL);
  }
  searchAll(keyword){
    return this._http.get(this.URL+ '?name_like=' + keyword, this.httpOptions);
  }
}
