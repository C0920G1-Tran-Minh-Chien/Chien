import {Component, OnInit} from '@angular/core';
import {User} from '../user';
import {UserService} from '../user.service';
import {Router} from '@angular/router';
import {FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {
  submitted = false;
  public user: User = new User();
  userTypeList: any = [];
  addUserList = new FormGroup({
    firstName: new FormControl(''),
    lastName: new FormControl(''),
    email: new FormControl(''),
    userType: new FormControl('')
  });

  constructor(private userService: UserService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.getAllUserType();
  }


  createUser() {
    console.log(this.addUserList.value);
    this.userService.createUser(this.addUserList.value).subscribe(data => {
      console.log(data);
      this.user = new User();
    });
  }

  onSubmit() {
    this.submitted = true;
    this.createUser();
  }

  goToList() {
    this.router.navigate(['/users']);
  }

  getAllUserType() {
    this.userService.getAllUserType().subscribe(data => {
      this.userTypeList = data;
    }, error => console.log(error));

  }
}
