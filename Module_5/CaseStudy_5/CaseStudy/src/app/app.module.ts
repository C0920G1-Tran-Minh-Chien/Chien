import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateCustomerComponent } from './components/customer/create-customer/create-customer.component';
import { UpdateCustomerComponent } from './components/customer/update-customer/update-customer.component';
import { ListCustomerComponent } from './components/customer/list-customer/list-customer.component';

@NgModule({
  declarations: [
    AppComponent,
    CreateCustomerComponent,
    UpdateCustomerComponent,
    ListCustomerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
