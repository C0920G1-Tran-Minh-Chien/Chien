// import { Component, OnInit } from '@angular/core';
//
// @Component({
//   selector: 'app-delete-customer',
//   templateUrl: './delete-customer.component.html',
//   styleUrls: ['./delete-customer.component.css']
// })
// export class DeleteCustomerComponent implements OnInit {
//
//   constructor() { }
//
//   ngOnInit(): void {
//   }
//
// }
import {Component, OnInit, Inject} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
import {CustomerService} from '../../service/customer.service';

@Component({
  selector: 'app-delete',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.css']
})
export class DeleteComponent implements OnInit {
  public customerOfFullName;
  public customerOfId;

  constructor(
    public dialogRef: MatDialogRef<DeleteComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    public customer: CustomerService
  ) {
  }

  ngOnInit(): void {
    console.log(this.data.data1);
    this.customerOfFullName = this.data.data1.name;
    this.customerOfId = this.data.data1.id;
  }

  deleteCustomer() {
    this.customer.deleteCustomer(this.customerOfId).subscribe(data => {
      this.dialogRef.close();
    });
  }
}
