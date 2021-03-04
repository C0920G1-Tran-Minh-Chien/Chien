import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ListComponent} from './components/list/list.component';
import {CreateComponent} from './components/create/create.component';
import {UpdateComponent} from './components/update/update.component';


const routes: Routes = [
  {
    component:ListComponent, path:'list'
  },
  {
    component:  CreateComponent , path:'add'
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
