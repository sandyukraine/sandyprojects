import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs/index";

@Injectable({
  providedIn: 'root'
})
export class CityService { // TODO: rename to StreetConcertService

  constructor(private http: HttpClient) { }

  getCities(): Observable<any> {
    return this.http.get('//localhost:8080/cities');
  }
}
