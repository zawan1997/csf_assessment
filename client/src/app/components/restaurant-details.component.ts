import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Comment } from '../models';
import { RestaurantService } from '../restaurant-service';

@Component({
  selector: 'app-restaurant-details',
  templateUrl: './restaurant-details.component.html',
  styleUrls: ['./restaurant-details.component.css']
})
export class RestaurantDetailsComponent implements OnInit{
	
	// TODO Task 4 and Task 5
	// For View 3
form!:FormGroup
comment!:Comment

constructor(private fb:FormBuilder, private router:Router, private rSvc:RestaurantService) {}



ngOnInit(): void {
    this.form = this.createForm()
}

process() {
  this.comment= this.form.value as Comment
}

private createForm() {
  return this.fb.group({
    name: this.fb.control<string>('', [Validators.required,Validators.minLength(4)]),
    rating: this.fb.control<number>(1,[Validators.min(1), Validators.max(5)]),
    text:this.fb.control<string>('', Validators.required)
  })
}
}
