package com.example.shopinterior.service.oder;

import com.example.shopinterior.dto.oder.IOderDto;
import com.example.shopinterior.dto.oder.ITotalOrderValue;
import com.example.shopinterior.entity.oder.Oder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface IOderService {
    Oder save(Oder oder);
    Page<IOderDto> showListOder(Pageable pageable);
    Page<IOderDto> showListOderDetailUser(@Param("idUser") int idUser, Pageable pageable);
    ITotalOrderValue totalOderDetailUser(@Param("idUser") int idUser);
}
