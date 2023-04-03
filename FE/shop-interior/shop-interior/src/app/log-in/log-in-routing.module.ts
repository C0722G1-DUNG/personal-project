import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {LoginComponent} from "./log-in.component";
import {SignUpComponent} from "./sign-up/sign-up.component";


const routes: Routes = [
  {path: "login", component:LoginComponent},
  {path: "login/signUp", component:SignUpComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LogInRoutingModule { }
