import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Cart} from "../../../entity/cart";
import {CartDto} from "../../../entity/cart-dto";
import {ITotalCart} from "../../../entity/itotal-cart";

@Injectable({
  providedIn: 'root'
})
export class CartService {
  private API_URL = 'http://localhost:8080/api/cart';
  private API_URL_ODER = 'http://localhost:8080/api/oder';

  constructor(private httpClient: HttpClient) {
  }

  getListCart(idUser: string | null | undefined): Observable<Cart[]> {
    return this.httpClient.get<Cart[]>(this.API_URL + '?idAccount=' + idUser)
  }

  totalCost(idUser: string | null | undefined):Observable<ITotalCart> {
    return this.httpClient.get<ITotalCart>(this.API_URL+'/total'+ '?idAccount='+idUser);
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

  createOrder(order: any) {
    return  this.httpClient.post(this.API_URL_ODER+'/create',order);
  }
}
