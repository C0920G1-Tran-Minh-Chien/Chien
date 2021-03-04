import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {CustomerService} from '../../service/customer.service';

@Component({
  selector: 'app-update-customer',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {

  public nameKhachHang = '';
  public maxDate = new Date();
  public minDate = new Date(2021, 2,3);
  customerTypeList: any = [];
  alert: boolean = false;
  editSoTietKiem = new FormGroup({
    id: new FormControl(''),
    ngayMoSo: new FormControl('', [Validators.required]),
    ngayGui: new FormControl('', [Validators.required]),
    ngayRut: new FormControl('', [Validators.required, ]),
    soTien: new FormControl('', [Validators.required, Validators.min(10000000), Validators.pattern('^[-+]?[0-9]*[.,]?[0-9]+$')]),
    laiSuat: new FormControl('', [Validators.required, Validators.pattern('[0-9](%)')]),
    uuDai: new FormControl('', [Validators.required]),
    khachHang: new FormControl('', [Validators.required])
  });

  constructor(
    private customer: CustomerService,
    private router: ActivatedRoute,
    private route: Router
  ) {}


  ngOnInit(): void {
    console.log(this.minDate);
    this.getAllCustomerType();
    console.log(this.router.snapshot.params.id);
    this.customer.getCurrentData(this.router.snapshot.params.id).subscribe((result) => {
      console.log(result);
      this.editSoTietKiem.setValue(result);
      console.log(this.editSoTietKiem);
    });
  }


  updateCustomer() {
    console.log(this.editSoTietKiem.value);
    this.customer.updateCustomer(this.router.snapshot.params.id, this.editSoTietKiem.value).subscribe((result) => {
      console.log(result, 'data updated successfull');
      alert('Update Success!');
      this.alert = true;
      this.route.navigateByUrl('list')
    });
  }

  getAllCustomerType() {
    this.customer.getAllCustomerType().subscribe((data) => {
      this.customerTypeList = data;
    }, error => console.log(error));
  }

  validation_messages = {

    'startDate': [
      {type: 'required', message: 'Date is not required.'},
      {type: 'pattern', message: 'Date is not correct.'}
    ],
    'bonus': [
      {type: 'required', message: 'Bonus is not Required'}
    ]
  };
  closeAlert() {
    this.alert = false;
  }

  backList() {
    this.route.navigateByUrl('list');
  }
}
