import { Component, OnInit } from '@angular/core';
import {User} from '../user';
import {UserService} from '../user.service';
import {DeleteComponent} from '../delete/delete.component';
import {MatDialog} from '@angular/material/dialog';
import {UpdateComponent} from '../update/update.component';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  userTypeList: any = [];
  users: User[];
  constructor(private userService: UserService,
              public dialog: MatDialog) { }

  ngOnInit(): void {
    this.userService.getAllUserType().subscribe(data => {
      this.userTypeList = data;
      console.log(this.userTypeList);
    },error => console.log(error));
    this.userService.getUsers().subscribe((data: User[]) =>{
      console.log(data);
      this.users = data;
    });
  }

  openDialog(userId): void {
    this.userService.getUserById(userId).subscribe(user => {
      const dialogRef = this.dialog.open(DeleteComponent, {
        width: '500px',
        data: {data1: user},
        disableClose: true,
        panelClass: 'custom-modalbox'
      });
      dialogRef.afterClosed().subscribe(result => {
        console.log('The dialog was closed');
        this.ngOnInit();
      });
    });
  }

  openDialogUpdate(userId) {
    this.userService.getUserById(userId).subscribe(user => {
      const dialogRef = this.dialog.open(UpdateComponent, {
        width: '500px',
        data: {data2: user},
        disableClose: true,
        panelClass: 'custom-modalbox'
      });
      dialogRef.afterClosed().subscribe(result => {
        console.log('The dialog was closed');
        this.ngOnInit();
      });
    });
  }
}

