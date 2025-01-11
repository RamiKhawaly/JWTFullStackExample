import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
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

  onLogin()
  {
    alert('Not implemented');
  }

}
