import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {UserComponent} from './user/user.component';
import {UpdateComponent} from './update/update.component';


const routes: Routes = [
  {
    component: UserComponent, path: 'list'
  },
  {
    component: UpdateComponent, path:'update/:id'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
