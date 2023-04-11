import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  {path:'',loadChildren: () => import('./home/home-routing.module').then(module => module.HomeRoutingModule)},
  {path:'',loadChildren: () => import('./log-in/log-in-routing.module').then(module => module.LogInRoutingModule)},
  {path:'',loadChildren: () => import('./product/product-routing.module').then(module => module.ProductRoutingModule)},
  {path:'',loadChildren: () => import('./profile/profile-routing.module').then(module => module.ProfileRoutingModule)},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
