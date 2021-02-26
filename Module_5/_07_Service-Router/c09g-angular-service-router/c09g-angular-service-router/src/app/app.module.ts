import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';
import {StudentListComponent} from './student-list/student-list.component';
import {StudentDetailComponent} from './student-detail/student-detail.component';
import {StudentUpdateComponent} from './student-update/student-update.component';
import {ReactiveFormsModule} from '@angular/forms';
import {StudentRoutingModule} from './student-routing.module';
import {RouterModule} from '@angular/router';
import { InstructorListComponent } from './instructor-list/instructor-list.component';

@NgModule({
  declarations: [
    AppComponent,
    StudentListComponent,
    StudentDetailComponent,
    StudentUpdateComponent,
    InstructorListComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    StudentRoutingModule,
    RouterModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
