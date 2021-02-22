import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'testsautet';
  name = "";
  en: string = "hello";
  vn: string = "chao";
  imageUrl = "https://angular.io/assets/images/logos/angular/logo-nav@2x.png";
  forgot = false;

  toggleForgot(){
    this.forgot = !this.forgot;
  }

}
