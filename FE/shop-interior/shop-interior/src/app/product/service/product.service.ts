import {Injectable} from '@angular/core';
import {HttpClient, HttpClientModule, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Product} from "../../entity/product";

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };
  private API_URL = 'http://localhost:8080/api/product';
  private API_URL_Image = 'http://localhost:8080/api/image/save';

  constructor(private httpClient: HttpClient) {
  }




  findByIDProduct(id: number):Observable<Product> {
return  this.httpClient.get<Product>(this.API_URL+'/'+id);
  }

  createProduct(value: any) {
    return this.httpClient.post(this.API_URL_Image, JSON.stringify(value), this.httpOptions)
  }

  getListProduct(s: string, s2: string, s3: string,size: number) {
    return this.httpClient.get<Product[]>(this.API_URL+'?searchNameProduct='+s3+'&&searchMinPrice='+s+'&&searchMaxPrice='+s2+'&&size='+size);
  }
  getListProductPage(s: string, s2: string, s3: string,page: number) {
    return this.httpClient.get<Product[]>(this.API_URL+'?searchNameProduct='+s3+'&&searchMinPrice='+s+'&&searchMaxPrice='+s2+'&&page='+page);
  }
}
