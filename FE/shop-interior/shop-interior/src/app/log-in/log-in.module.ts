import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LogInRoutingModule } from './log-in-routing.module';
import {LoginComponent} from "./log-in.component";
import {HttpClientModule} from "@angular/common/http";
import {ReactiveFormsModule} from "@angular/forms";


@NgModule({
  declarations: [LoginComponent],
  imports: [
    CommonModule,
    LogInRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ]
})
export class LogInModule { }
