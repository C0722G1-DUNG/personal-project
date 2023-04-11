import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import {TokenService} from "./token.service";

@Injectable({
  providedIn: 'root'
})
export class EmployeeGuard implements CanActivate {
  constructor(private tokenService:TokenService) {
  }
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
   if (this.tokenService.isLogger()) {
     if (this.tokenService.getRole() == 'ROLE_ADMIN' || this.tokenService.getRole() == 'ROLE_EMPLOYEE') {
       return true;
     } else {
       return false;
     }
   } else {
     return  false;
   }
    return false;
  }

}
