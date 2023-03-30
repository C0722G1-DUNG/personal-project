import {Component, OnInit} from '@angular/core';
import {Cart} from "../../entity/cart";
import {CartService} from "./service/cart.service";
import {TokenService} from "../../log-in/service/token.service";
import {Title} from "@angular/platform-browser";
import {ITotalCart} from "../../entity/itotal-cart";
import {ShareService} from "../../log-in/service/share.service";
import {render} from 'creditcardpayments/creditCardPayments';


@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  cartList: Cart[] = [];
  totalCart: ITotalCart = {};
  idUser: string | null | undefined;
  mess = "";
  flagDisplay = false;
  constructor(private cartService: CartService, private tokenService: TokenService,
              private title: Title, private shareService: ShareService) {
    this.title.setTitle('giỏ hàng');
    this.shareService.getClickEvent().subscribe(data => {
      this.list();
      this.getCostTotal();
    })
  }


  ngOnInit(): void {

    window.scroll(0, 0);
    if (this.tokenService.getToken()) {
      this.idUser = this.tokenService.getId();
    }
    this.list();
    this.getCostTotal();
    this.loaderPayPal();
  }

  loaderPayPal() {
    setTimeout(()=>{
      render(
        {
          id: "#payments",
          currency: "USD",
          value: "100.00",
          onApprove: (details) => {
            alert("thanh toán thành công");
          }
        }
      );
    }, 200);

  }

  private list() {
    this.cartService.getListCart(this.idUser).subscribe(data => {
      this.cartList = data;
      if (data != null) {

        this.flagDisplay = true;
      } else {
        this.flagDisplay = false;
        this.mess = "Không có sản phẩm nào trong giỏ hàng.";
      }
    }, error => {
      this.mess = "Không có sản phẩm nào trong giỏ hàng.";
    }, () => {
    })

  }

  private getCostTotal() {
    this.cartService.totalCost(this.idUser).subscribe(data => {
        this.totalCart = data;
      }

      , error => {
      },
      () => {
      });
  }

  minus(idCart: number) {
    this.cartService.minus(idCart).subscribe(data => {
        this.ngOnInit();
      }
      , error => {
      },
      () => {
      });
  }

  plus(idCart: number) {
    this.cartService.plus(idCart).subscribe(data => {
        this.ngOnInit();
      }
      , error => {
      },
      () => {
      });
  }

  deleteCart(item: Cart) {
    this.cartService.deleteCart(item.idCart).subscribe(data => {
      this.shareService.sendClickEvent();
    }, error => {
      alert("xóa thất bại")
    }, () => {
    });
  }

}
