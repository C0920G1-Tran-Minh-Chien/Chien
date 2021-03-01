import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {CustomerService} from '../../../service/customer.service';

@Component({
  selector: 'app-update-customer',
  templateUrl: './update-customer.component.html',
  styleUrls: ['./update-customer.component.css']
})
export class UpdateCustomerComponent implements OnInit {

  customerTypeList: any = [];
  alert: boolean = false;
  editCustomer = new FormGroup({
    name: new FormControl('', [Validators.required]),
    dateOfBirth: new FormControl('', [Validators.required]),
    gender: new FormControl('', [Validators.required]),
    idcard: new FormControl('', [Validators.required]),
    phoneNumber: new FormControl('', [Validators.required]),
    email: new FormControl('', [Validators.required]),
    address: new FormControl('', [Validators.required]),
    customerType: new FormControl('', [Validators.required])
  });

  constructor(
    private customer: CustomerService,
    private router: ActivatedRoute,
    private route: Router
  ) {}


  ngOnInit(): void {
    this.getAllCustomerType();
    console.log(this.router.snapshot.params.id);
    this.customer.getCurrentData(this.router.snapshot.params.id).subscribe((result) => {
      console.log(result);
      this.editCustomer.setValue(result);
      console.log(this.editCustomer);
    });
  }

  updateCustomer() {
    console.log(this.editCustomer.value);
    this.customer.updateCustomer(this.router.snapshot.params.id, this.editCustomer.value).subscribe((result) => {
      console.log(result, 'data updated successfull');
      this.alert = true;
      this.route.navigateByUrl('list')
    });
  }

  getAllCustomerType() {
    this.customer.getAllCustomerType().subscribe((data) => {
      this.customerTypeList = data;
    }, error => console.log(error));
  }

  closeAlert() {
    this.alert = false;
  }
}
