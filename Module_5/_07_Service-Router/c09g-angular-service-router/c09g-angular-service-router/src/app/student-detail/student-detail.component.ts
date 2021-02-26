import {Component, OnInit} from '@angular/core';
import {Student} from '../student';
import {StudentService} from '../student.service';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-student-detail',
  templateUrl: './student-detail.component.html',
  styleUrls: ['./student-detail.component.css']
})
export class StudentDetailComponent implements OnInit {

  student: Student;

  constructor(private studentService: StudentService,
              private activatedRoute: ActivatedRoute) {
    // this.student = this.findById(6546);

    const studentId = Number(this.activatedRoute.snapshot.params.idStudent);
    console.log(studentId);
    this.student = this.studentService.findById(studentId);
  }

  ngOnInit(): void {
  }

  // // get data from API
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
