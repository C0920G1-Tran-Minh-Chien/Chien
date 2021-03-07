import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {AngularFireDatabase, AngularFireList} from '@angular/fire/database';
import firebase from 'firebase';


@Injectable({
  providedIn: 'root'
})
export class UserService {
  imageDetailList: AngularFireList<any>;

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
  constructor(private http: HttpClient,
              private firebase: AngularFireDatabase) { }

  insertImageDetails(imageDetails){
    this.imageDetailList.push(imageDetails);
  }

  getImageDetailList(){
    this.imageDetailList = this.firebase.list('imageDetails');
  }

  getUsers(page: number){
    return this.http.get(this.baseURL + "?page=" + page);
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
