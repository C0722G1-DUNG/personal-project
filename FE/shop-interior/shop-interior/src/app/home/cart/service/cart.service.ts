import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Cart} from "../../../entity/cart";

@Injectable({
  providedIn: 'root'
})
export class CartService {
  private API_URL = 'http://localhost:8080/api/cart';
  constructor(private httpClient:HttpClient) { }

  getListCart(idUser: string | null | undefined): Observable<Cart[]> {
return this.httpClient.get<Cart[]>(this.API_URL+'?idAccount='+idUser)
  }

  totalCost() {

  }
}
