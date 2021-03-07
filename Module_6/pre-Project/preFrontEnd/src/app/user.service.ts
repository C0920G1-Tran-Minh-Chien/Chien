import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class UserService {
  private userTypeURL = "http://localhost:8080/api/usertype";
  private baseURL = "http://localhost:8080/api/users";
  private createURL = "http://localhost:8080/api/users/create";
  private deleteURL = "http://localhost:8080/api/users/";
  private userURL = "http://localhost:8080/api/users/";
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };
  constructor(private http: HttpClient) { }

  getUsers(){
    return this.http.get(this.baseURL);
  }
  getAllUserType(){
    return this.http.get(this.userTypeURL);
  }
  deleteUser(id){
    return this.http.delete(this.deleteURL + id)
  }
  getUserById(id){
    return this.http.get(this.userURL + id);
  }
  createUser(user){
    return this.http.post(this.createURL, JSON.stringify(user), this.httpOptions)
  }
  updateUser(id, data){
    return this.http.put(this.userURL + id, data);
  }
}
