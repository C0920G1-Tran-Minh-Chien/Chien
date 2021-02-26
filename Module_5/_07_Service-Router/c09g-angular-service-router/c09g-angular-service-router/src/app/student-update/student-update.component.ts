import {Component, OnInit} from '@angular/core';
import {Student} from '../student';
import {AbstractControl, FormBuilder, FormGroup, Validators} from '@angular/forms';
import {StudentService} from '../student.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-student-update',
  templateUrl: './student-update.component.html',
  styleUrls: ['./student-update.component.css']
})
export class StudentUpdateComponent implements OnInit {

  formStudent: FormGroup;

  constructor(private fb: FormBuilder,
              private studentService: StudentService,
              private activatedRoute: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit(): void {
    // const student = this.findById(6546);
    const studentId = Number(this.activatedRoute.snapshot.params.idStudent);
    const student = this.studentService.findById(studentId);

    this.formStudent = this.fb.group({
      name: [student.name, [Validators.required, Validators.pattern('[A-Za-z ]+')]],
      dateOfBirth: [student.dateOfBirth, this.checkDateOfBirth]
    });
  }

  updateInfoStudent(): void {
    console.log(this.formStudent.value);
    this.router.navigate(['']);
  }

  // truong hop OK tra ve null, NG thi tra ve errorCode co gia tri true
  checkDateOfBirth(absControl: AbstractControl): any {
    const value = absControl.value; // 2021-02-24
    const year = Number(value.substr(0, 4));

    return new Date().getFullYear() - year >= 18 ? null : {c09Abc: true};
  }

  // get data from API
  // findById(studentId: number): Student {
  //   const studentList = new Array();
  //   studentList.push(new Student(12312, 'Nguyen Van A', '2001-02-23', 1));
  //   studentList.push(new Student(6546, 'Nguyen Thi D', '2002-02-24', 0));
  //   studentList.push(new Student(2343, 'Nguyen Thi B', '2003-02-25', 0));
  //   studentList.push(new Student(7776, 'Nguyen Van C', '2004-02-26', 1));
  //
  //   return studentList.find(studentObj => studentObj.id === studentId);
  // }

}
