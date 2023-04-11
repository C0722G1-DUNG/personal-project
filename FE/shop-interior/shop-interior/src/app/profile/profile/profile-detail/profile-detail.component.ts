import {Component, Input, OnInit} from '@angular/core';
import {IPurchaseHistoryDto} from "../../../entity/ipurchase-history-dto";

@Component({
  selector: 'app-profile-detail',
  templateUrl: './profile-detail.component.html',
  styleUrls: ['./profile-detail.component.css']
})
export class ProfileDetailComponent implements OnInit {
  @Input()
  purchaseHistoryDetail: IPurchaseHistoryDto[] = [];
  constructor() { }

  ngOnInit(): void {
  }

}
