import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BodyComponent } from './home/body/body.component';
import { HeaderComponent } from './home/header/header.component';
import { FooterComponent } from './home/footer/footer.component';
import { CartComponent } from './home/cart/cart.component';
import { DetailComponent } from './home/detail/detail.component';
import { LoginComponent } from './log-in/log-in.component';
import {LogInModule} from "./log-in/log-in.module";
import {AngularFireModule} from "@angular/fire";
import {environment} from "../environments/environment";
import {ProductModule} from "./product/product.module";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {OderCreateComponent} from "./home/cart/oder/oder-create/oder-create.component";
import {OderListComponent} from "./home/cart/oder/oder-list/oder-list.component";
import {HomeModule} from "./home/home.module";
import {ProfileListComponent} from "./profile/profile/profile-list/profile-list.component";
import {ProfileModule} from "./profile/profile.module";
import {ProfileDetailComponent} from "./profile/profile/profile-detail/profile-detail.component";
@NgModule({
  declarations: [
    AppComponent,
    BodyComponent,
    HeaderComponent,
    FooterComponent,
    CartComponent,
    DetailComponent,
    OderCreateComponent,
    OderListComponent,
    ProfileListComponent,
    ProfileDetailComponent,

  ],
    imports: [
        LogInModule,
        BrowserModule,
        AppRoutingModule,
        AngularFireModule.initializeApp(environment.firebaseConfig),
        ProductModule,
        FormsModule,
        ReactiveFormsModule,
        HomeModule,
        ProfileModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
