import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProductRoutingModule } from './product-routing.module';
import { ProductListComponent } from './product-list/product-list.component';
import { ProductCreateComponent } from './product-create/product-create.component';
import {ReactiveFormsModule} from "@angular/forms";
import {AngularFireModule} from "@angular/fire";
import {environment} from "../../environments/environment";


@NgModule({
  declarations: [ProductListComponent, ProductCreateComponent],
    imports: [
        CommonModule,
        ProductRoutingModule,
        ReactiveFormsModule,
      AngularFireModule.initializeApp(environment.firebaseConfig)
    ]
})
export class ProductModule { }
