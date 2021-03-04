import {Component, OnInit} from '@angular/core';
import {MatDialog} from '@angular/material/dialog';
import {CustomerService} from '../../service/customer.service';
import {DeleteComponent} from '../delete/delete.component';

@Component({
  selector: 'app-list-customer',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  nameSearch: string = '';
  idSearch: string = '';
  customerTypeList: any = [];
  order: string = '';
  flag: boolean = true;
  alert: boolean = false;
  public collection: any = [];
  p: any;
  term: string;

  constructor(private customerService: CustomerService,
              public dialog: MatDialog) {
  }

  ngOnInit(): void {
    this.customerService.getAllCustomerType().subscribe((data) => {
      this.customerTypeList = data;
    }, error => console.log(error));

    this.customerService.getCustomerList().subscribe((result) => {
      this.collection = result;
      console.log(this.collection);
    });
  }

  // deleteCustomer(customer, i) {
  //   this.collection.this.collection.splice(i, 1);
  //   this.customerService.deleteCustomer(customer.id).subscribe((result) => {
  //     console.log('Data is Deleted Successfull !', result);
  //     this.alert = true;
  //   });
  // }

  openDialog(customerId): void {
    this.customerService.getCurrentData(customerId).subscribe(customer => {
      const dialogRef = this.dialog.open(DeleteComponent, {
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

  search(keyword, keyword2) {
    console.log(keyword.value);
    console.log(keyword2.value.name);
    this.customerService.searchAll(keyword.value, keyword2.value).subscribe((customer) => {
      console.log(customer);
      this.collection = customer;
    });
  }
  searchByName(): void{
    console.log(this.nameSearch);
    this.customerService.findByName(this.nameSearch).subscribe(customer => {
      this.collection = customer;
    });
  }
  searchById(): void{
    console.log(this.idSearch);
    this.customerService.findById(this.idSearch).subscribe(customer => {
      this.collection = customer;
    });
  }
  sortByName() {

    if (this.flag) {
      this.order = 'asc';
      this.customerService.sortByName(this.order).subscribe((customer) => {
        this.collection = customer;
      });
      this.flag = false;
    } else {
      this.order = 'desc';
      this.customerService.sortByName(this.order).subscribe((customer) => {
        this.collection = customer;
      });
      this.flag = true;
    }
    console.log("sort");
  }
  getAllCustomerType() {
    this.customerService.getAllCustomerType().subscribe((data) => {
      this.customerTypeList = data;
    }, error => console.log(error));
  }
}
