import {Component, OnInit} from '@angular/core';
import {CustomerService} from '../../../service/customer.service';
import {DeleteCustomerComponent} from '../delete-customer/delete-customer.component';
import {MatDialog} from '@angular/material/dialog';

@Component({
  selector: 'app-list-customer',
  templateUrl: './list-customer.component.html',
  styleUrls: ['./list-customer.component.css']
})
export class ListCustomerComponent implements OnInit {

  alert: boolean = false;
  public collection: any = [];
  p: any;
  term: string;

  constructor(private customerService: CustomerService,
              public dialog: MatDialog) {
  }

  ngOnInit(): void {
    this.customerService.getCustomerList().subscribe((result) => {
      this.collection = result;
      console.log(this.collection);
    });
  }

  deleteCustomer(customer, i) {
    this.collection.this.collection.splice(i, 1);
    this.customerService.deleteCustomer(customer.id).subscribe((result) => {
      console.log('Data is Deleted Successfull !', result);
      this.alert = true;
    });
  }

  openDialog(customerId): void {
    this.customerService.getCurrentData(customerId).subscribe(customer => {
      const dialogRef = this.dialog.open(DeleteCustomerComponent, {
        width: '500px',
        data: {data1: customer},
        disableClose: true,
        panelClass: 'custom-modalbox'
      });
      dialogRef.afterClosed().subscribe(result => {
        console.log('The dialog was closed');
        this.ngOnInit();
      });
    });
  }
  closeAlert() {
    this.alert = false;
  }
  search (keyword: string)  {
    this.customerService.searchAll(keyword.toString()).subscribe((customer) =>{
      console.log(customer);
      this.collection = customer;
    });
  }
}
