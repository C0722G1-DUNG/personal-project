package com.example.shopinterior.service.oder;

import com.example.shopinterior.dto.oder.IOderDto;
import com.example.shopinterior.entity.oder.Oder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IOderService {
    Oder save(Oder oder);
    Page<IOderDto> showListOder(Pageable pageable);
}
