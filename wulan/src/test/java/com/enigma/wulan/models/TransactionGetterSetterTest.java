package com.enigma.wulan.models;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class TransactionGetterSetterTest {

    private TransactionElement element;
    private TransactionRequest request;
    private TransactionResponse response;
    private TransactionSearch search;
    private ItemElement item;
    private ItemResponse itemResponse;

    @Test
    void TransactionElementGetSet() {
        TransactionElement expected = new TransactionElement();
        expected.setId(1);
        expected.setItem(item);
        expected.setQuantity(10);



       TransactionElement actual = new TransactionElement();
        actual.setId(1);
        actual.setItem(item);
        actual.setQuantity(10);

        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getItem(), actual.getItem());
        assertEquals(expected.getQuantity(), actual.getQuantity());

    }
    @Test
    void TransactionRequestGetSet() {
        TransactionRequest expected = new TransactionRequest();
        expected.setItemId(1);
        expected.setQuantity(10);

        TransactionRequest actual = new TransactionRequest();
        actual.setItemId(1);
        actual.setQuantity(10);

        assertEquals(expected.getItemId(), actual.getItemId());
        assertEquals(expected.getQuantity(),actual.getQuantity());
    }

    @Test
    void TransactionResponseGetSet() {
        TransactionResponse expected = new TransactionResponse();
        expected.setId(1);
        expected.setItem(itemResponse);
        expected.setQuantity(10);

        TransactionResponse actual = new TransactionResponse();
        actual.setId(1);
        actual.setItem(itemResponse);
        actual.setQuantity(10);

        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getItem(),actual.getItem());
        assertEquals(expected.getQuantity(),actual.getQuantity());
    }

    @Test
    void TransactionSearchGetSet() {
        TransactionSearch expected = new TransactionSearch();
        expected.setQuantity(10);

        TransactionSearch actual = new TransactionSearch();
        actual.setQuantity(10);

        assertEquals(expected.getQuantity(), actual.getQuantity());

    }
}
