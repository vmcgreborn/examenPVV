import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(
    private httpClient: HttpClient,
  ) { }


  getASum = (a:number,b:number) : Observable<any> => {
    console.log("request getASum is ", { a, b });
    return this.httpClient
      .post( "http://localhost:8080/operation/getASum", {a, b} );

  }
  getAProduct = (a:number) : Observable<any> => {
    console.log("request product is ", { a });
    return this.httpClient
      .post( "http://localhost:8080/operation/getAProduct", {a} );

  }
  getAPower = (a:number) : Observable<any> => {
    console.log("request power is ", { a });
    return this.httpClient
      .post( "http://localhost:8080/operation/getAPower", {a} );

  }
}
