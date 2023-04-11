import {Component, OnInit} from '@angular/core';
import {TokenService} from "../../log-in/service/token.service";
import {LogInService} from "../../log-in/service/log-in.service";
import {Router} from "@angular/router";
import {ShareService} from "../../log-in/service/share.service";
import {User} from "../../entity/user";
import Swal from "sweetalert2";
import {CartService} from "../cart/service/cart.service";
import {ITotalCart} from "../../entity/itotal-cart";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  totalCart: ITotalCart = {quantityUser: 0, totalCostUser:0};
  user: User = {};
  idUser: string | null | undefined;
  role = '';
  isLogged = false
  name = 'Đăng nhập'
  token: any;
  num = 0;

  constructor(private login: LogInService,
              private tokenService: TokenService,
              private router: Router,
              private share: ShareService,
              private cartService: CartService) {
    this.isLogged =this.tokenService.isLogger()
    this.loader()
    this.getCostTotal();
    this.share.getClickEvent().subscribe(data => {
      this.isLogged =this.tokenService.isLogger()
      this.loader();
      this.getCostTotal();
    });

    this.token = this.tokenService.getToken();
    console.log(this.token);
  }

  ngOnInit(): void {
  }

  loader() {
    if (this.isLogged) {
      this.role = this.tokenService.getRole();
      this.idUser = this.tokenService.getId();
      this.getCostTotal();
      this.login.profile(this.tokenService.getId()).subscribe(
        next => this.user = next
      )
      this.getCostTotal();

    }
  }

  logout() {
    this.role='';
    this.isLogged = false
    this.tokenService.logout();
    this.router.navigateByUrl('/home');
    this.share.sendClickEvent();
    this.num =0;

    Swal.fire({
      position: 'center',
      icon: 'success',
      title: 'Đăng xuất thành công!',
      showConfirmButton: false,
      timer: 2000
    });
  }

  private getCostTotal() {
    if (!this.isLogged) {
      this.num = 0;
      return
    }
    this.cartService.totalCost(this.tokenService.getId()).subscribe(data => {
        console.log(data);
        if(data){
          this.totalCart = data;
          this.num = data.quantityUser;
        }
      }
      , error => {
        this.num = 0;
      },
      () => {
      });
  }

}
