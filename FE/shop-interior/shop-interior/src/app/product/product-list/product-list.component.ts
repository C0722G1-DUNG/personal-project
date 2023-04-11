import { Component, OnInit } from '@angular/core';
import {Product} from "../../entity/product";
import {ProductService} from "../service/product.service";
import {Title} from "@angular/platform-browser";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  productList: Product[] = [];
  page: number = 0;
  size: number = 6;
  last: any;
  first: any;
  searchNameProduct = '';
  searchMinPrice = '';
  searchMaxPrice = '';
  flagDisplay: boolean = false;
  totalPage: number = 0;
  constructor(private productService: ProductService,private title: Title) {
    this.title.setTitle('trang quản lý sản phẩm');
    this.getAll(this.page);
  }

  ngOnInit(): void {

  }

  private getAll(page: number) {
    this.productService.getListProductPage(this.searchMinPrice.trim(), this.searchMaxPrice.trim(), this.searchNameProduct, page).subscribe(data => {
        if (data != null) {
          // @ts-ignore
          this.productList = data.content;
          // @ts-ignore
          this.page = data.number;
          // @ts-ignore
          this.size = data.size;
          console.log(this.size);
          // @ts-ignore
          this.totalPage = data.totalPages;
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

  previousPage() {
    if (this.page > 0){
      this.page = this.page - 1;
      this.getAll(this.page);
    }
  }

  nextPage() {
    if (this.page < this.totalPage - 1){
      this.page = this.page + 1;
      this.getAll(this.page);
    }
  }
}
