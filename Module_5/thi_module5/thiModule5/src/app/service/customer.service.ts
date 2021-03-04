import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  URL = 'http://localhost:3000/soTietKiem';
  regURL = 'http://localhost:3000/khachHang';
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
    return this._http.delete(this.URL + '/' +id);
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
  searchAll(keyword, keyword2){
    return this._http.get(this.URL+ '?name_like=' + keyword + '&customerType.name=' + keyword2, this.httpOptions);
  }
  findById(idSearch: string){
    return this._http.get(this.URL + '?id_like=' + idSearch);
  }
  findByName(nameSearch: string){
    return this._http.get(this.URL + '?khachHang.name_like=' + nameSearch);
  }
  sortByName(order){
    return this._http.get(this.URL + '?_sort=name&_order=' + order);
  }
}
