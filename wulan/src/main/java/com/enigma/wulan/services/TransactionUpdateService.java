package com.enigma.wulan.services;

import com.enigma.wulan.entities.Item;
import com.enigma.wulan.entities.Transaction;
import com.enigma.wulan.models.TransactionRequest;
import com.enigma.wulan.repositories.ItemRepository;
import com.enigma.wulan.repositories.TransactionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class TransactionUpdateService {
    @Autowired
    TransactionRepository repoTransaction;

    @Autowired
    ItemRepository repoItem;

    @Transactional
    public Transaction transactionCreate(TransactionRequest request) {
        Transaction transaction = new Transaction();
        transaction.setQuantity(request.getQuantity());


        Optional<Item> entityItem = repoItem.findById(request.getItemId());
        Item item = new Item();
        item.setId(entityItem.get().getId());
        item.setUnit(entityItem.get().getUnit());
        item.setName(entityItem.get().getName());
        item.setPrice(entityItem.get().getPrice());
        item.setStock(entityItem.get().getStock());
        transaction.setSubTotal(item.getPrice()* transaction.getQuantity());

        transaction.setItem(item);

        transaction = repoTransaction.save(transaction);

        item.setStock(item.getStock() - transaction.getQuantity());
        repoItem.save(item);

        return transaction;
    }

}
