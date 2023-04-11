import {Component, OnInit} from '@angular/core';
import {ProductService} from "../../product/service/product.service";
import {Product} from "../../entity/product";
import {ViewportScroller} from "@angular/common";
import {CartService} from "../cart/service/cart.service";
import {ProductDto} from "../../entity/product-dto";
import {CartDto} from "../../entity/cart-dto";
import {TokenService} from "../../log-in/service/token.service";
import Swal from "sweetalert2";
import {ShareService} from "../../log-in/service/share.service";
import {SellingProducts} from "../../entity/selling-products";
import {Title} from "@angular/platform-browser";

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
  size: number = 6;
  last: any;
  first: any;
  cart: CartDto = {};
  idUser: any;
  productList: Product[] = [];
  sellingProductList: SellingProducts[] = [];
  searchNameProduct = '';
  searchMinPrice = '';
  searchMaxPrice = '';
  flagDisplay: boolean = false;
  firstPage:any;
  lastPage: any;
  role = '';


  constructor(private productService: ProductService,
              private viewportScroller: ViewportScroller,
              private cartService: CartService,
              private tokenService: TokenService,
              private  shareService: ShareService,
              private title: Title) {
    this.title.setTitle('trang chủ');
  }

  ngOnInit(): void {
    if (this.tokenService.getToken()) {
      this.role = this.tokenService.getRole();
      this.idUser = this.tokenService.getId();
    }
    this.getAll(this.size);
    this.getAllSellingProducts(this.page);
  }

  getAll(size: number): void {
    this.productService.getListProduct(this.searchMinPrice.trim(), this.searchMaxPrice.trim(), this.searchNameProduct, size).subscribe(data => {
        if (data != null) {
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
          this.flagDisplay = true
        }

      }
      , error => {
        this.flagDisplay = false
      }
      , () => {
      });
  }

  getAllSellingProducts(page: number) {

    this.cartService.getAllSellingProducts(page).subscribe(data => {
        // @ts-ignore
        this.sellingProductList = data.content;
        // @ts-ignore
        this.firstPage = data.first;
        // @ts-ignore
        this.lastPage = data.last;
        // @ts-ignore
      this.page = data.size;
      },
      error => {
      },
      () => {
      })
  }

  search() {
    this.getAll(this.size);
  }

  scrollToBlog() {
    this.viewportScroller.scrollToPosition([0, 2200]);
  }

  addProductToCart(item: any) {
    this.cart.productDto = item;
    this.cart.quantity = 1;
    this.cart.id = Number(this.idUser);
    this.cartService.addProductToCart(this.cart).subscribe(data => {
      Toast.fire({
        html: '<span style="font-size: 16px;color: blue">Đã thêm vào giỏ</span>  <img style="width: 200px;height: 100px;object-fit: cover"  src="' + item.imageOne + '">'
      })
      this.shareService.sendClickEvent()
    }, error => {
      Swal.fire({
        position: 'center',
        icon: 'error',
        title: 'THêm vào giỏ hàng thất bại!',
        text: 'Sản phẩm hiện tại đã hết',
        showConfirmButton: false,
        timer: 2000
      })
    });

  }


}
