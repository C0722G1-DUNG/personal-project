import { Component, OnInit } from '@angular/core';
import {ProductService} from "../../product/service/product.service";
import {Product} from "../../entity/product";
import {ViewportScroller} from "@angular/common";
import {CartService} from "../cart/service/cart.service";
import {ProductDto} from "../../entity/product-dto";
import {CartDto} from "../../entity/cart-dto";
import {TokenService} from "../../log-in/service/token.service";
import Swal from "sweetalert2";

const Toast = Swal.mixin({
  toast: true,
  position: 'center-right',
  showConfirmButton: false,
  timer: 3000,
  timerProgressBar: true,
  didOpen: (toast) => {
    toast.addEventListener('mouseenter', Swal.stopTimer)
    toast.addEventListener('mouseleave', Swal.resumeTimer)
  }
})
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
  cart:CartDto = {};
  idUser :any;
productList:Product[] =[];
  searchNameProduct= '';
  searchMinPrice= '';
  searchMaxPrice= '';
  flagDisplay: boolean = false;
  constructor(private productService:ProductService,
              private viewportScroller:ViewportScroller,
              private cartService:CartService,
              private tokenService:TokenService) {
  }

  ngOnInit(): void {
    window.scroll(0, 0);
    if (this.tokenService.getToken()) {
      this.idUser = this.tokenService.getId();
    }
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

  addProductToCart(item: Product) {
    this.cart.productDto=item;
    this.cart.quantity=1;
    this.cart.id = Number(this.idUser);
    this.cartService.addProductToCart(this.cart).subscribe(data=>{
      Toast.fire({
        html: '<span style="font-size: 16px;color: blue">Đã thêm vào giỏ</span>  <img style="width: 250px;height: 100px;object-fit: cover"  src="' +item.imageOne  + '">'
      })
    },);

  }
}
