import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ApiService } from './api.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent  {
  title = 'get-a-sum';

  myFormGroup : FormGroup ; 
  result : any ;

  constructor(
    private service: ApiService, 
    private formBuilder: FormBuilder
  ) {
    this.myFormGroup = this.formBuilder.group({
      a: [0],
      b: [0]
    });  
  }



  getSum = () => {
    const { a, b } = this.myFormGroup.value ; 
    const error = (error: any) => {
    };
    const complete = () => {
    };
    const next = (next: any) => {
      const nextProduct = (nextProduct:any) => {
        const nextPower = (nextPower:any)=>{
          console.log("Result is ", nextPower);
          this.result = nextPower; 
        };
        this.service.getAPower(nextProduct).subscribe({next:nextPower,error,complete});
      }
      this.service.getAProduct(next).subscribe({next:nextProduct,error,complete});
    }
    this.service.getASum( a, b ).subscribe({next,error,complete})
  }


}
