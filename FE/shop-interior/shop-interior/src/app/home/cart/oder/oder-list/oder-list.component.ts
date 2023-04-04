import { Component, OnInit } from '@angular/core';
import {CartService} from "../../service/cart.service";
import {Oder} from "../../../../entity/oder";
import {IPurchaseHistoryDto} from "../../../../entity/ipurchase-history-dto";
import {IOderDto} from "../../../../entity/ioder-dto";

@Component({
  selector: 'app-oder-list',
  templateUrl: './oder-list.component.html',
  styleUrls: ['./oder-list.component.css']
})
export class OderListComponent implements OnInit {
  purchaseHistoryList: IPurchaseHistoryDto[] = [];
  page: number = 0;
  totalPage: number = 0;
  size = 0;
  oderList:IOderDto[] = [];
  constructor(private cartService:CartService) {
this.getAlltOder(this.page)
  }
  ngOnInit(): void {
  }
  getAlltOder(page: number){
    this.cartService.getListOder(page).subscribe(data =>{
      // @ts-ignore
        this.oderList = data.content;
        // @ts-ignore
        this.totalPage = data.totalPages;
        // @ts-ignore
        this.page = data.number;
        // @ts-ignore
        this.size = data.size;

      },
      error => {}
      ,()=>{})
  }
  previousPage(): void {
    if (this.page > 0){
      this.page = this.page - 1;
      this.getAlltOder(this.page);
    }
  }

  nextPage(): void {
    if (this.page < this.totalPage - 1){
      this.page = this.page + 1;
      this.getAlltOder(this.page);
    }
  }

  getDetailPurchaseHistory(idOder: number| undefined) {
    this.cartService.getDetailPurchaseHistory(idOder).subscribe(
      data => {
        // @ts-ignore
        this.purchaseHistoryList = data.content;
        console.log(data)
        console.log("detail"+this.purchaseHistoryList);
      },
      error => {
      }, () => {
      }
    )
  }
}
