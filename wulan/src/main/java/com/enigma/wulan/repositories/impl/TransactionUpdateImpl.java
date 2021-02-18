package com.enigma.wulan.repositories.impl;

import com.enigma.wulan.entities.Transaction;
import com.enigma.wulan.repositories.TransactionRepository;
import com.enigma.wulan.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TransactionUpdateImpl extends CommonServiceImpl<Transaction, Integer> implements TransactionService {

    @Autowired
    public TransactionUpdateImpl(TransactionRepository repository) {
        super(repository);
    }

}
