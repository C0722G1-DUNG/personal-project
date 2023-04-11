import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ProductCreateComponent} from "./product-create/product-create.component";
import {ProductListComponent} from "./product-list/product-list.component";

const routes: Routes = [
  {path: "create", component:ProductCreateComponent},
  {path: "product/list", component:ProductListComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProductRoutingModule { }
