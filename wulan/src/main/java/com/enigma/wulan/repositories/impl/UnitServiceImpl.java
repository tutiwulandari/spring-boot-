package com.enigma.wulan.repositories.impl;


import com.enigma.wulan.entities.Unit;
import com.enigma.wulan.repositories.UnitRepository;
import com.enigma.wulan.services.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UnitServiceImpl extends CommonServiceImpl<Unit, Integer> implements UnitService {

    @Autowired
    public UnitServiceImpl(UnitRepository repository) {
        super(repository);
    }
}

