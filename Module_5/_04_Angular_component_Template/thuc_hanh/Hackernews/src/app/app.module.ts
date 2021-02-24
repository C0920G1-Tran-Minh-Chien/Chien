// @ts-ignore
import { BrowserModule } from '@angular/platform-browser';
// @ts-ignore
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
// @ts-ignore
import {FormsModule} from '@angular/forms';
import { LikesComponent } from './likes/likes.component';
import { MenuComponent } from './menu/menu.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { AddNewArticleComponent } from './add-new-article/add-new-article.component';

@NgModule({
  declarations: [
    AppComponent,
    LikesComponent,
    MenuComponent,
    HeaderComponent,
    FooterComponent,
    AddNewArticleComponent
  ],
    imports: [
        BrowserModule,
        FormsModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
