import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {HomeComponent} from './components/home/home.component';
import {ListCustomerComponent} from './components/customer/list-customer/list-customer.component';
import {UpdateCustomerComponent} from './components/customer/update-customer/update-customer.component';
import {CreateCustomerComponent} from './components/customer/create-customer/create-customer.component';

const routes: Routes = [
  {
    component: HomeComponent, path: ''
  },
  {
    component:ListCustomerComponent, path:'list'
  },
  {
    component:UpdateCustomerComponent, path:'update/:id'
  },
  {
    component:CreateCustomerComponent , path:'add'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]

})
export class AppRoutingModule {
}
