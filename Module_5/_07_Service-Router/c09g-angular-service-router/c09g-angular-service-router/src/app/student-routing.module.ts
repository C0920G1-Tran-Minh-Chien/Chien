import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {StudentListComponent} from './student-list/student-list.component';
import {StudentDetailComponent} from './student-detail/student-detail.component';
import {StudentUpdateComponent} from './student-update/student-update.component';
import {InstructorListComponent} from './instructor-list/instructor-list.component';

// path khong duoc bat dau voi /
// voi redirectTo thi phai co pathMatch: 'full'
const routes: Routes = [
  {path: '', redirectTo: 'student', pathMatch: 'full'},
  {path: 'student', component: StudentListComponent},
  {path: 'student/detail/:idStudent', component: StudentDetailComponent},
  {path: 'student/update/:idStudent', component: StudentUpdateComponent},
  {path: 'instructor', component: InstructorListComponent}
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ]
})
export class StudentRoutingModule { }
