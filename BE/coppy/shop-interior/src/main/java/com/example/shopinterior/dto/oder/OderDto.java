package com.example.shopinterior.dto.oder;

import com.example.shopinterior.dto.user.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OderDto {
    private Integer idOder;
    private String code;
    private String deliveryAddress;
    private String deliverPhone;
    private String flagDelete;
    private String orderDate;
    private boolean paymentMethod;
    private Set<PurchaseHistoryDto> purchaseHistorySet;
    private UserDto userDto;
    private double orderValue;
}
