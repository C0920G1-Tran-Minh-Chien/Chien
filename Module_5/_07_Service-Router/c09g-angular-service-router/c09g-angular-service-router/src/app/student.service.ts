import { Injectable } from '@angular/core';
import {Student} from './student';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  constructor() { }

  // get data from API
  findById(studentId: number): Student {
    const studentList = new Array();
    studentList.push({(12312, 'Nguyen Van A', '2001-02-23', 1)});
    // studentList.push(new Student(6546, 'Nguyen Thi D', '2002-02-24', 0));
    // studentList.push(new Student(2343, 'Nguyen Thi B', '2003-02-25', 0));
    // studentList.push(new Student(7776, 'Nguyen Van C', '2004-02-26', 1));

    return studentList.find(studentObj => studentObj.id === studentId);
  }
}
