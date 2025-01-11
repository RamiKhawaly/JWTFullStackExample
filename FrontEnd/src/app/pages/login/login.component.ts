import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';
import { User } from '../../models/user.model';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  userData : User = {
    username:"",
    password:""
  };
  authService= inject(AuthService);
  router = inject(Router);


  onLogin() {
    this.authService.login(this.userData.username, this.userData.password, ()=>{
      this.router.navigateByUrl('dashboard')
    },
  ()=>{
    alert("Error login")
  })
  }
}
