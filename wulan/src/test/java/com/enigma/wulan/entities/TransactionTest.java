package com.enigma.wulan.entities;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class TransactionTest {

    @Mock
    private Item item;

    @Test
    void setItemEntity() {
        Transaction expected = new Transaction();
        expected.setId(1);
        expected.setQuantity(100);
        expected.setItem(item);
        expected.setSubTotal(1000.0);

        Transaction actual = new Transaction();
        actual.setId(1);
        actual.setQuantity(100);
        actual.setItem(item);
        actual.setSubTotal(1000.0);

        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getQuantity(), actual.getQuantity());
        assertEquals(expected.getItem(), actual.getItem());
        assertEquals(expected.getSubTotal(), actual.getSubTotal());
    }


}
