import {AfterViewInit, Component, OnInit} from '@angular/core';
import {Cart} from "../../../../entity/cart";
import {ITotalCart} from "../../../../entity/itotal-cart";
import {CartService} from "../../service/cart.service";
import {TokenService} from "../../../../log-in/service/token.service";
import {Title} from "@angular/platform-browser";
import {ShareService} from "../../../../log-in/service/share.service";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {LogInService} from "../../../../log-in/service/log-in.service";
import {User} from "../../../../entity/user";
import {Oder} from "../../../../entity/oder";
import {render} from 'creditcardpayments/creditCardPayments';
import {Router} from "@angular/router";
import Swal from "sweetalert2";
@Component({
  selector: 'app-oder-create',
  templateUrl: './oder-create.component.html',
  styleUrls: ['./oder-create.component.css']
})
export class OderCreateComponent implements OnInit {
  id='';
  temp:Oder = {};
  oder:Oder = {};
  cartList: Cart[] = [];
  totalCart: ITotalCart = {quantityUser: 0, totalCostUser:0};
  idUser: string | null | undefined;
  user:User = {};
  formOderCreate = new FormGroup({
    deliveryAddress: new FormControl("",[Validators.required]),
    deliverPhone: new FormControl("",[Validators.required]),
  });
  // @ts-ignore
  money: number;
  constructor(private cartService: CartService, private tokenService: TokenService,
              private title: Title, private shareService: ShareService,
              private logInService:LogInService,
              private router:Router) {
    this.title.setTitle('thanh toán');

  }
  ngOnInit(): void {

    window.scroll(0, 0);
    if (this.tokenService.getToken()) {
      this.idUser = this.tokenService.getId();
    }
    this.list();
    this.getCostTotal();
    this.getUserById();
  }
  loaderPayPal() {
      render(
        {
          id: "#payments",
          currency: "USD",
          value: String(this.money),
          onApprove: (details) => {
           this.createOder();
           this.router.navigateByUrl("/home");
            Swal.fire({
              position: 'center',
              icon: 'success',
              title: 'THanh toán thành công',
              showConfirmButton: false,
              timer: 2000
            })

          }
        }
      );
  }

  private list() {
    this.cartService.getListCart(this.idUser).subscribe(data => {
      this.cartList = data;
    }, error => {
    }, () => {
    })

  }

  private getCostTotal() {
    this.cartService.totalCost(this.idUser).subscribe(data => {
        this.totalCart = data;
        this.money = +(this.totalCart.totalCostUser/23000).toFixed(2);
        this.loaderPayPal();
      }
      , error => {
      },
      () => {
      });
  }
  getUserById() {
    this.logInService.profile(this.idUser).subscribe(data => {
      this.user = data;
      console.log(this.user)
    }, error => {
    }, () => {
    });
  }
  setOrder() {
    this.oder = this.formOderCreate.value;
    this.oder.userDto = this.user;
    this.oder.purchaseHistorySet = this.cartList;
    this.oder.orderValue = this.totalCart.totalCostUser;
  }
  createOder() {
    this.setOrder();
    this.cartService.createOrder(this.oder).subscribe(data => {
      console.log(data);
      this.cartService.totalCost(this.idUser);
      this.temp = data;
      this.shareService.sendClickEvent();
    }, error => {
    }, () => {
    })
  }
}
