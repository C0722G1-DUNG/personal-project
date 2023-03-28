import {Component, OnInit} from '@angular/core';
import {Cart} from "../../entity/cart";
import {CartService} from "./service/cart.service";
import {TokenService} from "../../log-in/service/token.service";
import {Title} from "@angular/platform-browser";
import {ITotalCart} from "../../entity/itotal-cart";
import {ShareService} from "../../log-in/service/share.service";

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  cartList: Cart[] = [];
  totalCart:ITotalCart ={};
  checkLogin = false;
  idUser: string | null | undefined;
  mess = "";
  flagDisplay = false;
  totalCost = 0;

  constructor(private cartService: CartService, private tokenService: TokenService, private title: Title,private a:ShareService) {
    this.title.setTitle('giỏ hàng');
  }

  ngOnInit(): void {
    window.scroll(0, 0);
    if (this.tokenService.getToken()) {
      this.idUser = this.tokenService.getId();
    }
    this.list();
    this.getCostTotal();
  }

  private list() {
    this.cartService.getListCart(this.idUser).subscribe(data=>{
      this.cartList =data;
      if (data != null) {
        this.flagDisplay = true;
      } else {
        this.flagDisplay = false;
        this.mess = "Không có sản phẩm nào trong giỏ hàng.";
      }
    },error => {
      this.mess = "Không có sản phẩm nào trong giỏ hàng.";
    },()=>{})

  }

  private getCostTotal() {
    this.cartService.totalCost(this.idUser).subscribe(data=>{
      this.totalCart =data;
      }
    ,error => {},
      ()=>{});
  }
  minus(idCart: number) {
    this.cartService.minus(idCart).subscribe(data=>{
        this.ngOnInit();
      }
      ,error => {},
      ()=>{});
  }

  plus(idCart: number) {
    this.cartService.plus(idCart).subscribe(data=>{
      this.ngOnInit();
      }
      ,error => {},
      ()=>{});
  }
}
