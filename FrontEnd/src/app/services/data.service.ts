import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { DataModel } from '../models/data.model';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  getDataURL:string = "http://localhost:8080/data/getAll";
  public token:string="";
  constructor(private http:HttpClient) { }


  getData():Observable<DataModel[]>
  {
    return this.http.get<DataModel[]>(this.getDataURL)
  }
}
