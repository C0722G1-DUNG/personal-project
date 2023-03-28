import {ProductDto} from "./product-dto";

export interface CartDto {
  idCart?: number;
  quantity?: number;
  productDto?:ProductDto;
  id?: number;
}
//dùng để thêm mới
