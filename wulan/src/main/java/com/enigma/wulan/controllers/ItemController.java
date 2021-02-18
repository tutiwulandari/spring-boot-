package com.enigma.wulan.controllers;

import com.enigma.wulan.entities.Item;
import com.enigma.wulan.entities.Transaction;
import com.enigma.wulan.entities.Unit;
import com.enigma.wulan.exceptions.EntityNotFoundException;
import com.enigma.wulan.models.*;
import com.enigma.wulan.services.ItemService;
import com.enigma.wulan.services.TransactionService;
import com.enigma.wulan.services.UnitService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("ALL")
@RequestMapping("/items")
@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private UnitService unitService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private TransactionService transactionService;



    @PostMapping
    public ResponseMessage<ItemResponse> add(@RequestBody @Valid ItemRequest model) {
        Item entity = modelMapper.map(model, Item.class);

        Unit unit = unitService.findById(model.getUnitId());
        entity.setUnit(unit);

        entity = itemService.save(entity);

        ItemResponse data = modelMapper.map(entity, ItemResponse.class);
        return ResponseMessage.success(data);
    }

    @PutMapping("/{id}")
    public ResponseMessage<ItemResponse> edit(
            @PathVariable Integer id, @RequestBody @Valid ItemRequest model) {
        Item entity = itemService.findById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }

        Unit unit = unitService.findById(model.getUnitId());
        entity.setUnit(unit);

        modelMapper.map(model, entity);

        entity = itemService.save(entity);

        ItemResponse data = modelMapper.map(entity, ItemResponse.class);
        return ResponseMessage.success(data);
    }

    @DeleteMapping("{id}")
    public ResponseMessage<ItemResponse> removeById(@PathVariable Integer id) {
        Item entity = itemService.removeById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }
        ItemResponse data = modelMapper.map(entity, ItemResponse.class);
        return ResponseMessage.success(data);
    }

    @GetMapping("/{id}")
    public ResponseMessage<ItemResponse> findById(@PathVariable("id") Integer id) {
        Item entity = itemService.findById(id);
        if (itemService.findById(id) != null) {
            ItemResponse data = modelMapper.map(entity, ItemResponse.class);
            return ResponseMessage.success(data);
        }
        throw new EntityNotFoundException();

    }

    @GetMapping
    public ResponseMessage<PagedList<ItemElement>> findAll(
            @Valid ItemSearch model
    ) {
        Item search = modelMapper.map(model, Item.class);

        Page<Item> entityPage = itemService.findAll(search,
                model.getPage(), model.getSize(), model.getSort());

        List<Item> entities = entityPage.toList();

        List<ItemElement> models = entityPage.stream()
                .map(e -> modelMapper.map(e, ItemElement.class))
                .collect(Collectors.toList());

        PagedList<ItemElement> data = new PagedList<>(models,
                entityPage.getNumber(), entityPage.getSize(),
                entityPage.getTotalElements());

        return ResponseMessage.success(data);
    }
}

