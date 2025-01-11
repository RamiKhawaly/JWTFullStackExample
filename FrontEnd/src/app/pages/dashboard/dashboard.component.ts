

import { Component, OnInit,inject } from '@angular/core';
import { DataService } from '../../services/data.service';
import { DataModel } from '../../models/data.model';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';


@Component({
  selector: 'app-dashboard',
  standalone: true,
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css',
  imports:[CommonModule]

})
export class DashboardComponent implements OnInit {


  dataList:DataModel[] = [];

  constructor(private dataService: DataService, private router:Router)
  {

  }

  ngOnInit(): void {
    this.dataService.getData().subscribe({
      next: (data: DataModel[]) => {
        this.dataList = data
      },
      error: (err) => {
       /// this.router.navigateByUrl("/login")
      },
      complete: () => {

      }
    });
  }

}
