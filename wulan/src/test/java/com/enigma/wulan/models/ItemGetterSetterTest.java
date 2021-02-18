package com.enigma.wulan.models;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class ItemGetterSetterTest {


    private ItemElement element;
    private ItemSearch search;
    private ItemRequest request;
    private UnitModel model;

    @Test
    void ItemSearchGetSet() {
        ItemSearch expected = new ItemSearch();
        expected.setId(1);
        expected.setName("name");
        expected.setPrice(1000.0);

        ItemSearch actual = new ItemSearch();
        actual.setId(1);
        actual.setName("name");
        actual.setPrice(1000.0);


        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getName(),actual.getName());
        assertEquals(expected.getPrice(),actual.getPrice());
        assertEquals(expected.getStock(),actual.getStock());

    }

    @Test
    void ItemRequestGetSet() {
        ItemRequest expected = new ItemRequest();
        expected.setName("name");
        expected.setPrice(1000.0);
        expected.setUnitId(1);
        expected.setStock(0);

        ItemRequest actual = new ItemRequest();
        actual.setName("name");
        actual.setPrice(1000.0);
        actual.setUnitId(1);
        actual.setStock(0);

        assertEquals(expected.getName(),actual.getName());
        assertEquals(expected.getPrice(),actual.getPrice());
        assertEquals(expected.getUnitId(),actual.getUnitId());
        assertEquals(expected.getStock(),actual.getStock());


    }
    @Test
    void ItemResponseGetSet() {
        ItemResponse expected = new ItemResponse();
        expected.setId(1);
        expected.setName("name");
        expected.setPrice(1000.0);
        expected.setUnit(model);

        ItemResponse actual = new ItemResponse();
        actual.setId(1);
        actual.setName("name");
        actual.setPrice(1000.0);
        actual.setUnit(model);

        assertEquals(expected.getId(),actual.getId());
        assertEquals(expected.getPrice(),actual.getPrice());
        assertEquals(expected.getName(),actual.getName());
        assertEquals(expected.getUnit(),actual.getUnit());

    }

}
