import { Component, OnInit } from '@angular/core';
import {TokenService} from "../../log-in/service/token.service";
import {LogInService} from "../../log-in/service/log-in.service";
import {Router} from "@angular/router";
import {ShareService} from "../../log-in/service/share.service";
import {User} from "../../entity/user";
import Swal from "sweetalert2";
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  user: User = {};
  role = 'none';
  isLogged = false
  name = 'Đăng nhập'
  token: any;
  constructor(private login: LogInService, private tokenService: TokenService, private router: Router, private share: ShareService) {
    this.loader()
    this.share.getClickEvent().subscribe(data=>{
     this.loader()
    });

    this.token= this.tokenService.getToken();
    console.log(this.token);
  }
  loader() {
    this.isLogged = this.tokenService.isLogger();
    if (this.isLogged) {
      this.login.profile(this.tokenService.getId()).subscribe(
        next => this.user = next
      )
    }
  }
  ngOnInit(): void {
  }
  logout() {
    // this.role = 'none';
    // this.name = 'Đăng nhập';
    this.isLogged = false
    this.tokenService.logout();
    this.router.navigateByUrl('/home');
    Swal.fire({
      position: 'center',
      icon: 'success',
      title: 'Đăng xuất thành công!',
      showConfirmButton: false,
      timer: 2000
    });
  }

}
