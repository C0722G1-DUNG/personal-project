import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Cart} from "../../../entity/cart";
import {CartDto} from "../../../entity/cart-dto";

@Injectable({
  providedIn: 'root'
})
export class CartService {
  private API_URL = 'http://localhost:8080/api/cart';

  constructor(private httpClient: HttpClient) {
  }

  getListCart(idUser: string | null | undefined): Observable<Cart[]> {
    return this.httpClient.get<Cart[]>(this.API_URL + '?idAccount=' + idUser)
  }

  totalCost(idUser: string | null | undefined) {
    return this.httpClient.get(this.API_URL+'/total'+ '?idAccount='+idUser);
  }


  addProductToCart(cart: CartDto) {
    return this.httpClient.post(this.API_URL + '/add-product-to-cart', cart);
  }

  plus(idCart: number) {
    return this.httpClient.get(this.API_URL + '/plus/'+idCart);
  }

  minus(idCart: number) {
    return this.httpClient.get(this.API_URL + '/minus/'+idCart);
  }


  deleteCart(idCart: number) {
    return this.httpClient.delete(this.API_URL+'/delete/'+idCart);
  }
}
