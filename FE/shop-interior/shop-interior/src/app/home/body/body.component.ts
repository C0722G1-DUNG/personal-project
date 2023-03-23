import { Component, OnInit } from '@angular/core';
import {ProductService} from "../../product/service/product.service";
import {Product} from "../../entity/product";

@Component({
  selector: 'app-body',
  templateUrl: './body.component.html',
  styleUrls: ['./body.component.css']
})
export class BodyComponent implements OnInit {
productList:Product[] =[];
  constructor(private productService:ProductService) { }

  ngOnInit(): void {
    window.scrollTo(0, 0);
    this.productService.getListProduct().subscribe(data=>{
      this.productList = data;
      }
    ,error => {}
    ,()=>{});
  }


}
