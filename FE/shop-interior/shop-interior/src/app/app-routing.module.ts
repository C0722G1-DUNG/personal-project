import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {CartComponent} from "./home/cart/cart.component";
import {BodyComponent} from "./home/body/body.component";
import {DetailComponent} from "./home/detail/detail.component";
import {LogInComponent} from "./log-in/log-in.component";

const routes: Routes = [
  {path:'',loadChildren: () => import('./home/home-routing.module').then(module => module.HomeRoutingModule)},
  {path:'login',loadChildren: () => import('./log-in/log-in-routing.module').then(module => module.LogInRoutingModule)},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
