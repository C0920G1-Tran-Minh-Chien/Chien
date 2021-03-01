import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {CustomerService} from '../../service/customer.service';

@Component({
  selector: 'app-create-customer',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {

  customerTypeList: any = [];
  public maxDate = new Date();
  public minDate = new Date(1900,0,1);
  alert: boolean = false;
  createCustomer = new FormGroup({
    name: new FormControl('', [Validators.required]),
    dateOfBirth: new FormControl('', Validators.compose([Validators.required])),
    gender: new FormControl('', [Validators.required]),
    idcard: new FormControl('', [Validators.required]),
    phoneNumber: new FormControl('', [Validators.required]),
    email: new FormControl('', [Validators.required]),
    address: new FormControl('', [Validators.required]),
    customerType: new FormControl('', [Validators.required])
  });

  constructor(private customer: CustomerService,
              private route: Router) {
  }

  ngOnInit(): void {
    this.getAllCustomerType();
  }

  addCustomer() {

    console.log(this.createCustomer.value);
    this.customer.addCustomer(this.createCustomer.value).subscribe(data => {
      this.alert = true;
      console.log(this.createCustomer.value);
      this.route.navigateByUrl('list')
    }, error => console.log(error));
  };

  getAllCustomerType() {
    this.customer.getAllCustomerType().subscribe((data) => {
      this.customerTypeList = data;
    }, error => console.log(error));
  }

  closeAlert() {
    this.alert = false;
  }

}
