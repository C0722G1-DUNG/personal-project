import { Component, OnInit } from '@angular/core';
import {ProductService} from "../../product/service/product.service";
import {Product} from "../../entity/product";
import {ViewportScroller} from "@angular/common";

@Component({
  selector: 'app-body',
  templateUrl: './body.component.html',
  styleUrls: ['./body.component.css']
})
export class BodyComponent implements OnInit {
  numberPage: number = 0;
  totalPages = 0;
  page = 0;
  size: number = 3;
  last: any;
  first: any;
productList:Product[] =[];
  searchNameProduct= '';
  searchMinPrice= '';
  searchMaxPrice= '';
  flagDisplay: boolean = false;
  constructor(private productService:ProductService,private viewportScroller:ViewportScroller) { }

  ngOnInit(): void {
  this.getAll(this.size);
  }
  getAll(size: number): void{
    this.productService.getListProduct(this.searchMinPrice.trim(),this.searchMaxPrice.trim(),this.searchNameProduct,size).subscribe(data=>{
       if (data!=null){
         // @ts-ignore
         this.productList = data.content;
         // @ts-ignore
         this.numberPage = data.number;
         // @ts-ignore
         this.size = data.size;
         console.log(this.size);
         // @ts-ignore
         this.totalPages = data.totalPages;
         // @ts-ignore
         this.first = data.first;
         // @ts-ignore
         this.last = data.last;
         this.flagDisplay=true
       }

      }
      ,error => {
      this.flagDisplay =false
      }
      ,()=>{});
  }


  search() {
this.ngOnInit();
  }

  scrollToBlog() {
    this.viewportScroller.scrollToPosition([0, 2200]);
  }
}
