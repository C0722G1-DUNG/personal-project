import {Component, Input, OnInit} from '@angular/core';
import {IPurchaseHistoryDto} from "../../../../entity/ipurchase-history-dto";
import {CartService} from "../../service/cart.service";

@Component({
  selector: 'app-oder-detail',
  templateUrl: './oder-detail.component.html',
  styleUrls: ['./oder-detail.component.css']
})
export class OderDetailComponent implements OnInit {
  @Input()
  purchaseHistoryDetail: IPurchaseHistoryDto[] = [];
  pageDetail: number =0;
  totalPageDetail: any;

  constructor(private cartService: CartService) {
  }

  ngOnInit(): void {
    window.scroll(0, 0);
  }

  previousPage() {

  }

  nextPage() {

  }
}
