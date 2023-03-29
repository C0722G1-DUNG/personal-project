import {Component, OnInit} from '@angular/core';
import {Title} from "@angular/platform-browser";
import {ActivatedRoute, ParamMap} from "@angular/router";
import {ProductService} from "../../product/service/product.service";
import {Product} from "../../entity/product";
import {ShareService} from "../../log-in/service/share.service";
import {CartDto} from "../../entity/cart-dto";
import {TokenService} from "../../log-in/service/token.service";
import {CartService} from "../cart/service/cart.service";
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
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {
  cart: CartDto = {};
  a = 0;
  id = 0;
  product: Product = {imageOne: "", imageThree: "", imageTwo: ""};
  urlShow: string | undefined;
  quantityProduct: number = 0;
  idUser :any;
  constructor(private title: Title,
              private activatedRoute: ActivatedRoute,
              private productService: ProductService,
              private  tokenService: TokenService,
              private cartService:CartService) {
    this.title.setTitle('xem chi tiết sản phẩm')
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = parseInt(paramMap.get('id') as string);
      this.getInfo(this.activatedRoute.snapshot.params.id);
    });
  }

  ngOnInit(): void {
    window.scrollTo(0, 0);
   if (this.tokenService.getToken()) {
     this.idUser = this.tokenService.getId();
   }
  }


  private getInfo(id: number) {
    this.productService.findByIDProduct(this.id).subscribe(
      data => {
        this.product = data;
        this.urlShow = this.product.imageOne;
      }
    )
  }

  changeImgTwo(url: string) {
    if (this.urlShow != this.product.imageTwo && this.product.imageTwo != this.product.imageOne && this.urlShow != this.product.imageOne) {
      this.changeImgThree(this.product.imageThree);
    }
    if (this.urlShow != null) {
      this.product.imageTwo = this.urlShow;
    }
    this.urlShow = url;

  }

  changeImgThree(url: string) {
    if (this.urlShow != this.product.imageThree && this.product.imageThree != this.product.imageOne && this.urlShow != this.product.imageOne) {
      this.changeImgTwo(this.product.imageTwo);
    }
    if (this.urlShow != null) {
      this.product.imageThree = this.urlShow;
    }
    this.urlShow = url;
    console.log(this.product.imageThree)
  }

  addProductToCart(product: Product) {
    this.cart.productDto = product;
    this.cart.quantity = this.quantityProduct;
    this.cart.id =Number(this.idUser);
    this.cartService.addProductToCart(this.cart).subscribe(data=>{
      Toast.fire({
        html: '<span style="font-size: 16px;color: blue">Đã thêm vào giỏ</span>  <img style="width: 200px;height: 100px;object-fit: cover"  src="' +product.imageOne  + '">'
      })
      this.quantityProduct = 0;
    },error => {
      alert("thêm thất bại");
    });
  }
}
