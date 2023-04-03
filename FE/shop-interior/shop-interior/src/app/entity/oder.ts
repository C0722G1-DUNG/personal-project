import {User} from "./user";
import {PurchaseHistory} from "./purchase-history";

export interface Oder {
  idOder?: number;
  code?: string;
  deliveryAddress?: string;
  deliverPhone?: string;
  orderDate?: string;
  paymentMethod?: boolean;
  userDto?: User;
  purchaseHistorySet?: PurchaseHistory[];
  orderValue?: number;

}
