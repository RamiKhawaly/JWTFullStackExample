import { Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';

export const routes: Routes = [
    {
        path:'',
        redirectTo: 'dashboard',
        pathMatch:'full'
    },
    {
        path:'dashboard',
        component:DashboardComponent
    }
];
