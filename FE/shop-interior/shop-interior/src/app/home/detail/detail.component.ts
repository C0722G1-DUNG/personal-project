import { Component, OnInit } from '@angular/core';
import {Title} from "@angular/platform-browser";
import {ActivatedRoute, ParamMap} from "@angular/router";
import {ProductService} from "../../product/service/product.service";
import {Product} from "../../entity/product";
import {ShareService} from "../../log-in/service/share.service";

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {
  a =0;
  id = 0;
  product: Product = {imageOne: "", imageThree: "", imageTwo: ""};
  urlShow: string | undefined;
  constructor( private title: Title,private activatedRoute: ActivatedRoute,private productService:ProductService,private  shareService: ShareService) {
    this.title.setTitle('xem chi tiết sản phẩm')
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = parseInt(paramMap.get('id') as string);
      this.getInfo(this.activatedRoute.snapshot.params.id);
    });
  }

  ngOnInit(): void {
    window.scrollTo(0, 0);
  }


  private getInfo(id: number) {
    this.productService.findByIDProduct(this.id).subscribe(
      data=>{
        this.product = data;
        this.urlShow = this.product.imageOne;
      }
    )
  }
  changeImgTwo(url: string) {
    if (this.urlShow!=this.product.imageTwo && this.product.imageTwo!=this.product.imageOne && this.urlShow!=this.product.imageOne  ){
      this.changeImgThree(this.product.imageThree);
    }
    if (this.urlShow != null) {
      this.product.imageTwo = this.urlShow;
    }
    this.urlShow = url;

  }
  changeImgThree(url: string) {
    if (this.urlShow!=this.product.imageThree && this.product.imageThree!=this.product.imageOne && this.urlShow!=this.product.imageOne  ){
      this.changeImgTwo(this.product.imageTwo);
    }
    if (this.urlShow != null) {
      this.product.imageThree = this.urlShow;
    }
    this.urlShow = url;
    console.log(this.product.imageThree)
  }
}
