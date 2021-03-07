import {Component, Inject, OnInit} from '@angular/core';
import {UserService} from '../user.service';
import {ActivatedRoute, Router} from '@angular/router';
import {FormControl, FormGroup} from '@angular/forms';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {

  userTypeList: any = [];
  updateUserList = new FormGroup({
    id: new FormControl(''),
    firstName: new FormControl(''),
    lastName: new FormControl(''),
    email: new FormControl(''),
    imgUrl: new FormControl(''),
    userType: new FormControl('')
  });

  constructor(public dialogRef: MatDialogRef<UpdateComponent>,
              @Inject(MAT_DIALOG_DATA) public data: any,
    private userService: UserService,
    private router: ActivatedRoute,
    private route: Router
  ) {
  }

  ngOnInit(): void {
    this.getAllUserType();
    console.log(this.updateUserList.value);
    console.log(this.data.data2.id);
    this.userService.getUserById(this.data.data2.id).subscribe(data => {
      console.log(data);
      this.updateUserList.setValue(data);
    });
  }
  // Chỉnh sửa User
  editUser(){
    //Loi khong update dc type, lấy về được userType thay đổi nhưng add vào hàm service k đổi.
    console.log(this.updateUserList.value);
    this.userService.updateUser(this.data.data2.id, this.updateUserList.value).subscribe(data => {
      console.log(this.updateUserList.value);
      console.log(data, 'data updated successfull');
      this.dialogRef.close();
      this.route.navigateByUrl('list');
    })
  }
  getAllUserType() {
    this.userService.getAllUserType().subscribe(data => {
      this.userTypeList = data;
    }, error => console.log(error));

  }
}
