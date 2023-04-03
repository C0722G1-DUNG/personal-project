import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {DetailComponent} from "./detail/detail.component";
import {CartComponent} from "./cart/cart.component";
import {BodyComponent} from "./body/body.component";
import {OderCreateComponent} from "./cart/oder/oder-create/oder-create.component";

const routes: Routes = [
  {path: "" ,component:BodyComponent},
  {path: "home" ,component:BodyComponent},
  {path: "detail/:id" ,component:DetailComponent},
  {path: "cart" ,component:CartComponent},
  {path: "oder/create" ,component: OderCreateComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomeRoutingModule { }
