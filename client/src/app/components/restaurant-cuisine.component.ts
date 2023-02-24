import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { Restaurant } from '../models';
import { RestaurantService } from '../restaurant-service';

@Component({
  selector: 'app-restaurant-cuisine',
  templateUrl: './restaurant-cuisine.component.html',
  styleUrls: ['./restaurant-cuisine.component.css']
})
export class RestaurantCuisineComponent implements OnInit {
	
	// TODO Task 3
	// For View 2

  params$!:Subscription
  restaurant!:Restaurant

  constructor(private fb:FormBuilder, private activatedRoute: ActivatedRoute, private rSvc: RestaurantService) {}

  ngOnInit(): void {
    this.params$ = this.activatedRoute.params.subscribe(
      (params) => {
        const cuisine = params['cuisine']
        this.rSvc.getRestaurantsByCuisine(cuisine)
      }
    )
  }

}
