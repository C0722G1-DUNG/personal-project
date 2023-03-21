import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BodyComponent } from './home/body/body.component';
import { HeaderComponent } from './home/header/header.component';
import { FooterComponent } from './home/footer/footer.component';
import { CartComponent } from './home/cart/cart.component';
import { DetailComponent } from './home/detail/detail.component';
import { LoginComponent } from './log-in/log-in.component';
import {LogInModule} from "./log-in/log-in.module";

@NgModule({
  declarations: [
    AppComponent,
    BodyComponent,
    HeaderComponent,
    FooterComponent,
    CartComponent,
    DetailComponent,
    // LogInComponent
  ],
  imports: [
    LogInModule,
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
