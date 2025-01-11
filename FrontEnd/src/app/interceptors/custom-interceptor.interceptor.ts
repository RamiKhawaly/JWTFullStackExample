import { inject } from '@angular/core';
import { HttpInterceptorFn } from '@angular/common/http';
import { AuthService } from '../services/auth.service';
import { Router } from '@angular/router';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';
import { environment } from '../../environments/environment';

export const customInterceptorInterceptor: HttpInterceptorFn = (req, next) => {
  const authService = inject(AuthService); // Inject AuthService
  const router = inject(Router); // Inject Router for navigation
  const token = authService.token; // Retrieve the token from AuthService

  // Skip adding Authorization header for /login endpoint
  if (req.url.includes(`${environment.loginPage}`)) {
    return next(req);
  }

  // Clone the request to add the Authorization header and credentials
  const clonedRequest = token
  ? req.clone({
      setHeaders: {
        Authorization: `Bearer ${token}`,
      },
    })
  : req.clone();


  // Handle the request and add error handling logic
  return next(clonedRequest).pipe(
    catchError((error) => {
      if (error.status === 401 || error.status === 0) {
        // Clear any stored tokens or session data
        authService.logout(); // Assuming logout clears tokens and session

        // Redirect to the login page
        router.navigate([`${environment.loginPage}`]);
      }
      return throwError(() => error); // Rethrow the error
    })
  );
};

