import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {DetailComponent} from "./detail/detail.component";
import {CartComponent} from "./cart/cart.component";
import {BodyComponent} from "./body/body.component";
import {OderCreateComponent} from "./cart/oder/oder-create/oder-create.component";
import {OderListComponent} from "./cart/oder/oder-list/oder-list.component";
import {EmployeeGuard} from "../log-in/service/employee.guard";
import {CustomerGuard} from "../log-in/service/customer.guard";

const routes: Routes = [
  {path: "" ,component:BodyComponent},
  {path: "home" ,component:BodyComponent},
  {path: "detail/:id" ,component:DetailComponent,canActivate:[CustomerGuard]},
  {path: "cart" ,component:CartComponent,canActivate:[CustomerGuard]},
  {path: "oder/list" ,component:OderListComponent,canActivate:[EmployeeGuard]},
  {path: "oder/create" ,component: OderCreateComponent,canActivate:[CustomerGuard]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomeRoutingModule { }
