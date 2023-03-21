import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {DetailComponent} from "./detail/detail.component";
import {CartComponent} from "./cart/cart.component";
import {BodyComponent} from "./body/body.component";

const routes: Routes = [
  {path: "" ,component:BodyComponent},
  {path: "detail" ,component:DetailComponent},
  {path: "cart" ,component:CartComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomeRoutingModule { }