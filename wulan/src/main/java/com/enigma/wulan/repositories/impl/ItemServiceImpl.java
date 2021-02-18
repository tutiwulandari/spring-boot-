package com.enigma.wulan.repositories.impl;
import com.enigma.wulan.entities.Item;
import com.enigma.wulan.entities.Unit;
import com.enigma.wulan.repositories.ItemRepository;
import com.enigma.wulan.services.ItemService;
import com.enigma.wulan.services.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ItemServiceImpl extends CommonServiceImpl<Item, Integer> implements ItemService {

    @Autowired
    private UnitService unitService;

    @Autowired
    public ItemServiceImpl(ItemRepository repository) {
        super(repository);
    }

//    @Override
//    public Item addWithUnit(Item entity) {
//        Unit unit = unitService.save(entity.getUnit());
//        entity.setUnit(unit);
//
//        return repository.save(entity);
//    }
}
