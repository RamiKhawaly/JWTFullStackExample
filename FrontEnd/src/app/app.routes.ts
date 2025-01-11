import { Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { environment } from '../environments/environment';

export const routes: Routes = [
    {
        path:'',
        redirectTo: 'dashboard',
        pathMatch:'full'
    },
    {
        path:`${environment.loginPage}`,
        component:LoginComponent
    },
    {
      path:'dashboard',
      component:DashboardComponent
    }
];
