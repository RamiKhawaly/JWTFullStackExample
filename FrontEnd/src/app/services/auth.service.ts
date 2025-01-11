import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';


const JWT_TOKEN_ENTRY = "jwtToken"
@Injectable({
  providedIn: 'root'
})


export class AuthService {

  loginUrl:string = `${environment.apiBaseUrl}/authentication/login`;

  public token:string="";
  constructor(private http:HttpClient) {
    const savedToken = localStorage.getItem(JWT_TOKEN_ENTRY);
    if (savedToken) {
      this.token = savedToken;
    }
  }


  login(username:string, password:string, success: Function, failure : Function)
  {
    this.http.get(this.loginUrl + `?username=${username}&password=${password}`).subscribe({
      next: (res: any) => {
        console.log('Response:', res);
        if (res.token) {
          this.token = res.token;
          localStorage.setItem(JWT_TOKEN_ENTRY, this.token);
          success();
        } else {
          failure();
        }
      },
      error: (err) => {
        console.error('Error:', err);
        failure();
      },
      complete: () => {
        console.log('Request completed');
      }
    });

  }

  logout()
  {
    this.token = '';
    localStorage.removeItem(JWT_TOKEN_ENTRY);
  }
}
