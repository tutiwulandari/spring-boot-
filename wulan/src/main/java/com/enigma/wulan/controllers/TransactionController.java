package com.enigma.wulan.controllers;

import com.enigma.wulan.entities.Item;
import com.enigma.wulan.entities.Transaction;
import com.enigma.wulan.exceptions.EntityNotFoundException;
import com.enigma.wulan.models.*;
import com.enigma.wulan.models.TransactionRequest;
import com.enigma.wulan.models.TransactionResponse;
import com.enigma.wulan.services.ItemService;
import com.enigma.wulan.services.TransactionService;
import com.enigma.wulan.services.TransactionUpdateService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@RequestMapping("/transactions")
@RestController
public class TransactionController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private TransactionUpdateService transactionUpdateService;

    @Autowired
    private ModelMapper modelMapper;


    @PostMapping
    public ResponseMessage<Transaction> add(
            @RequestBody @Valid TransactionRequest model) {
        Transaction entity = transactionUpdateService.transactionCreate(model);

        return ResponseMessage.success(entity);
    }

    @DeleteMapping("{id}")
    public ResponseMessage<TransactionResponse> removeById(@PathVariable Integer id) {
        Transaction entity = transactionService.removeById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }
        TransactionResponse data = modelMapper.map(entity, TransactionResponse.class);
        return ResponseMessage.success(data);
    }

    @GetMapping("/{id}")
    public ResponseMessage<TransactionResponse> findById(
            @PathVariable("id") Integer id) {

        Transaction entity = transactionService.findById(id);
        if (entity != null) {
            TransactionResponse data = modelMapper.map(entity, TransactionResponse.class);
            return ResponseMessage.success(data);
        }
        throw new EntityNotFoundException();
    }
    @GetMapping
    public ResponseMessage<PagedList<TransactionElement>> findAll(
            @Valid TransactionSearch model
    ) {
        Transaction search = modelMapper.map(model, Transaction.class);

        Page<Transaction> entityPage = transactionService.findAll(search,
                model.getPage(), model.getSize(), model.getSort());

        List<Transaction> entities = entityPage.toList();

        List<TransactionElement> models = entities.stream()
                .map(e -> modelMapper.map(e, TransactionElement.class))
                .collect(Collectors.toList());

        PagedList<TransactionElement> data = new PagedList<>(models,
                entityPage.getNumber(), entityPage.getSize(),
                entityPage.getTotalElements());

        return ResponseMessage.success(data);
    }

}

