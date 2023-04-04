import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HomeRoutingModule } from './home-routing.module';
import {HttpClientModule} from "@angular/common/http";
import {BrowserModule} from "@angular/platform-browser";
import {ReactiveFormsModule} from "@angular/forms";
import { OderDetailComponent } from './cart/oder/oder-detail/oder-detail.component';


@NgModule({
  declarations: [OderDetailComponent],
  exports: [
    OderDetailComponent
  ],
  imports: [
    CommonModule,
    HomeRoutingModule,
    HttpClientModule,
    BrowserModule,
    ReactiveFormsModule
  ]
})
export class HomeModule { }
