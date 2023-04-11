package com.example.shopinterior.service.oder.impl;

import com.example.shopinterior.dto.oder.IOderDto;
import com.example.shopinterior.dto.oder.ITotalOrderValue;
import com.example.shopinterior.entity.oder.Oder;
import com.example.shopinterior.repository.oder.IOderRepository;
import com.example.shopinterior.service.oder.IOderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OderService implements IOderService {
    @Autowired
    private IOderRepository iOderRepository;
    @Override
    public Oder save(Oder oder) {

        return iOderRepository.save(oder);
    }

    @Override
    public Page<IOderDto> showListOder(Pageable pageable) {
        return iOderRepository.showListOder(pageable);
    }

    @Override
    public Page<IOderDto> showListOderDetailUser(int idUser, Pageable pageable) {
        return iOderRepository.showListOderDetailUser(idUser,pageable);
    }

    @Override
    public ITotalOrderValue totalOderDetailUser(int idUser) {
        return iOderRepository.totalOderDetailUser(idUser);
    }
}
