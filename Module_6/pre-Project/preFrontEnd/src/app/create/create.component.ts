import {Component, OnInit} from '@angular/core';
import {User} from '../user';
import {UserService} from '../user.service';
import {Router} from '@angular/router';
import {FormControl, FormGroup} from '@angular/forms';
import {AngularFireStorage} from '@angular/fire/storage';
import {finalize} from 'rxjs/operators';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {
  imgSrc: string = '/assets/img/img1.jpg';
  selectImg: any = null;


  submitted = false;
  public user: User = new User();
  userTypeList: any = [];
  addUserList = new FormGroup({
    firstName: new FormControl(''),
    lastName: new FormControl(''),
    email: new FormControl(''),
    userType: new FormControl(''),
    imgUrl: new FormControl('')
  });

  constructor(private userService: UserService,
              private router: Router,
              private storage: AngularFireStorage) {
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

  // Code upload anh len firebase nam trong onsubmit.
  onSubmit(formValue) {
    if (this.addUserList.valid) {
      console.log(this.selectImg);
      const filePath = `${formValue.categories}/${this.selectImg.name}_${new Date().getTime()}`;
      console.log(filePath);
      const fileRef = this.storage.ref(filePath);
      this.storage.upload(filePath,this.selectImg).snapshotChanges().pipe(
        finalize(() => {
          fileRef.getDownloadURL().subscribe((url) => {
            formValue['imgUrl'] = url;
            // this.userService.insertImageDetails(formValue);
          })
        })
      ).subscribe();
    }
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

  showPreview(event: any) {
    if (event.target.files && event.target.files[0]) {
      const reader = new FileReader();
      reader.onload = (e: any) => this.imgSrc = e.target.result;
      reader.readAsDataURL(event.target.files[0]);
      this.selectImg = event.target.files[0];
    } else {
      this.imgSrc = '/assets/img/img1.jpg';
      this.selectImg = null;
    }
  }

  get formControls() {
    return this.addUserList['controls'];
  }
  resetForm(){
    this.addUserList.reset();
    this.addUserList.setValue({
      firstName: new FormControl(''),
      lastName: new FormControl(''),
      email: new FormControl(''),
      userType: new FormControl(''),
      imgUrl: new FormControl('')
    });
    this.imgSrc = '/assets/img/img1.jpg';
    this.selectImg = null;
  }
}
