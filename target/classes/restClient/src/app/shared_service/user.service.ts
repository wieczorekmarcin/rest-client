import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { map } from "rxjs/operators";

import { User } from '../user';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private baseUrl:string = window.location.href + '/api';

  private headers = new Headers({'Content-Type':'application/json;charset=utf-8'});
  private options = new RequestOptions({headers:this.headers});
  private user: User;
  private sortOrderProperty:String;

  constructor(private _http:Http) { }

  getUsers(){
    return this._http.get(this.baseUrl + '/users')
      .pipe(map((response:Response) => response.json().content),
      catchError(this.errorHandler));
  }

  getUser(id:Number){
    return this._http.get(this.baseUrl + '/user/' + id)
      .pipe(map((response:Response) => response.json()),
      catchError(this.errorHandler));
  }

  deleteUser(id:Number){
    return this._http.delete(this.baseUrl + '/user/' + id)
      .pipe(map((response:Response) => response.json()),
      catchError(this.errorHandler));
  }

  createUser(user:User){
    console.log(user);
    return this._http.post(this.baseUrl + '/user/', JSON.stringify(user), this.options)
      .pipe(map((response:Response) => response.json()),
      catchError(this.errorHandler));
  }

  updateUser(user:User){
    return this._http.put(this.baseUrl + '/user/', JSON.stringify(user), this.options)
      .pipe(map((response:Response) => response.json()),
      catchError(this.errorHandler));
  }

  errorHandler(error:Response){
    return Observable.throw(error || "SERVER ERROR");
  }

  setter(user:User){
    this.user=user;
  }

  getter(){
    return this.user;
  }

  sortOrder(sortOrderProperty:String){
    var splitedValue = sortOrderProperty.split("_");
    return this._http.get(this.baseUrl + '/users?sort=' + splitedValue[0] +',' + splitedValue[1])
      .pipe(map((response:Response) => response.json().content),
      catchError(this.errorHandler));
  }
}
