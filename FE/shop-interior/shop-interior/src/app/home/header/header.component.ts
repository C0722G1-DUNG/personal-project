import { Component, OnInit } from '@angular/core';
import {TokenService} from "../../log-in/service/token.service";
import {LogInService} from "../../log-in/service/log-in.service";
import {Router} from "@angular/router";
import {ShareService} from "../../log-in/service/share.service";
import {User} from "../../entity/user";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  user: User = {};
  role = 'none';
  name = 'Đăng nhập'
  isLogged = false;
  constructor(private login: LogInService, private token: TokenService, private router: Router, private share: ShareService) { }

  ngOnInit(): void {
  }
  logout() {
    this.role = 'none';
    this.name = 'Đăng nhập';
    this.isLogged = false;
    this.token.logout();
    this.router.navigateByUrl('/');
  }

}
