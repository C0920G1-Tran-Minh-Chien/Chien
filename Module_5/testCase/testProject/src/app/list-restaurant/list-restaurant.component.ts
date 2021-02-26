import { Component, OnInit } from '@angular/core';
import {CommonService } from '../common.service';

@Component({
  selector: 'app-list-restaurant',
  templateUrl: './list-restaurant.component.html',
  styleUrls: ['./list-restaurant.component.css']
})
export class ListRestaurantComponent implements OnInit {
  alert:boolean= false;
public collection:any= [];
  constructor(private commonService:CommonService) { }

  ngOnInit(): void {
    this.commonService.getRestoList().subscribe((result)=>{
      this.collection= result;
      console.log(this.collection)
    });
  }

  deleteResto(resto, i){
    this.collection.
    this.collection.splice(i,1);
    this.commonService.deleteResto(resto.id).subscribe((result)=>{
      console.log("Data is Deleted Successfull !", result);
      this.alert= true;
    })
  }
  closeAlert(){
    this.alert= false;
  }

}
