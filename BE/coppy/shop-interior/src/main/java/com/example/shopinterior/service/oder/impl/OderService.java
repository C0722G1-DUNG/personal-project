package com.example.shopinterior.service.oder.impl;

import com.example.shopinterior.entity.oder.Oder;
import com.example.shopinterior.repository.oder.IOderRepository;
import com.example.shopinterior.service.oder.IOderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OderService implements IOderService {
    @Autowired
    private IOderRepository iOderRepository;
    @Override
    public Oder save(Oder oder) {

        return iOderRepository.save(oder);
    }
}
