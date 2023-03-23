import {Injectable} from '@angular/core';
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {Observable} from "rxjs";
import {Product} from "../../entity/product";

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private API_URL = 'http://localhost:8080/api/product';

  constructor(private httpClient: HttpClient) {
  }

  getListProduct(): Observable<Product[]> {
    return this.httpClient.get<Product[]>(this.API_URL);
  }


  findByIDProduct(id: number):Observable<Product> {
return  this.httpClient.get<Product>(this.API_URL+'/'+id);
  }
}
