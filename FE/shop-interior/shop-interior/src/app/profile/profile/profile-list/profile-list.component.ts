import { Component, OnInit } from '@angular/core';
import {ShareService} from "../../../log-in/service/share.service";
import {TokenService} from "../../../log-in/service/token.service";
import {LogInService} from "../../../log-in/service/log-in.service";
import {CartService} from "../../../home/cart/service/cart.service";
import {User} from "../../../entity/user";
import {IOderDto} from "../../../entity/ioder-dto";
import {IPurchaseHistoryDto} from "../../../entity/ipurchase-history-dto";
import {ITotalOrderValue} from "../../../entity/itotal-order-value";

@Component({
  selector: 'app-profile-list',
  templateUrl: './profile-list.component.html',
  styleUrls: ['./profile-list.component.css']
})
export class ProfileListComponent implements OnInit {
  purchaseHistoryList: IPurchaseHistoryDto[] = [];
  oderList:IOderDto[] = [];
  idUser: string | null | undefined;
  userDetail:User = {};
  page: number = 0;
  totalPage: number = 0;
  size = 0;
  totalOderUser: ITotalOrderValue = {};
  constructor(private shareService:ShareService,
              private tokenService:TokenService,
              private logInService:LogInService,
              private cartService:CartService) { }

  ngOnInit(): void {
    if (this.tokenService.getToken()){
      this.idUser = this.tokenService.getId();
    }
    this.detailUser(this.idUser);
    this.getAlltOderDetailUser(this.idUser,this.page)
    this.totalOder(this.idUser);
  }
  getAlltOderDetailUser(idUser: string | null | undefined, page: number) {
    this.cartService.getListOderDetailUser(idUser,page).subscribe(data=>{
      // @ts-ignore
      this.oderList = data.content;
      // @ts-ignore
      this.totalPage = data.totalPages;
      // @ts-ignore
      this.page = data.number;
      // @ts-ignore
      this.size = data.size;
    });
  }

   detailUser(idUser: string | null | undefined) {
    this.logInService.profile(idUser).subscribe(data=>{
      this.userDetail = data;
      }
    ,error => {}
    ,()=>{})
  }


  previousPage() {
    if (this.page > 0){
      this.page = this.page - 1;
      this.getAlltOderDetailUser(this.idUser,this.page);
    }
  }

  nextPage() {
    if (this.page < this.totalPage - 1){
      this.page = this.page + 1;
      this.getAlltOderDetailUser(this.idUser,this.page);
    }
  }

  getDetailPurchaseHistory(idOder: number| undefined) {
    this.cartService.getDetailPurchaseHistory(idOder).subscribe(
      data => {
        this.purchaseHistoryList = data;
        console.log(data)
        console.log("detail"+this.purchaseHistoryList);
      },
      error => {
      }, () => {
      }
    )
  }

  private totalOder(idUser: string | null | undefined) {
    this.cartService.getTotalOderlUser(idUser).subscribe(data=>{
      // @ts-ignore
      this.totalOderUser = data.totalOrderValue;
      console.log(this.totalOderUser);
    });
  }
}
