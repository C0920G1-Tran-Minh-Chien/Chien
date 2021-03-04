import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
import {UserService} from '../user.service';

@Component({
  selector: 'app-delete',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.css']
})
export class DeleteComponent implements OnInit {
  public userOfName;
  public userOfId;

  constructor(public dialogRef: MatDialogRef<DeleteComponent>,
              @Inject(MAT_DIALOG_DATA) public data: any,
              private userService: UserService ) {
  }

  ngOnInit(): void {
    console.log(this.data.data1);
    this.userOfName = this.data.data1.name;
    this.userOfId = this.data.data1.id;
  }
  deleteUser() {
    this.userService.deleteUser(this.userOfId).subscribe(data => {
      this.dialogRef.close();
      alert("Delete Success");
    });
  }
}
