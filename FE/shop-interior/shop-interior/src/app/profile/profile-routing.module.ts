import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ProfileListComponent} from "./profile/profile-list/profile-list.component";

const routes: Routes = [
  {path:"profile",component:ProfileListComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProfileRoutingModule { }
