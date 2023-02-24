import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { RestaurantService } from '../restaurant-service';


@Component({
  selector: 'app-cuisine-list',
  templateUrl: './cuisine-list.component.html',
  styleUrls: ['./cuisine-list.component.css']
})
export class CuisineListComponent implements OnInit, OnDestroy {

  constructor(
    private activatedRoute: ActivatedRoute,
    private restrauntSvc: RestaurantService,
    private router: Router
  ) {}

  ngOnDestroy(): void {


    throw new Error('Method not implemented.');
  }
  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

	// TODO Task 2
	// For View 1
  getCuisines() {
    this.router.navigate(['/api/cuisines'])
    this.restrauntSvc.getCuisineList
  }

}
