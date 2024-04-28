package com.np.coffeeorderservice.model;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void getIdReturnsCorrectId() {
        Order order = new Order();
        order.setId(1L);
        assertEquals(1L, order.getId());
    }

    @Test
    void setIdUpdatesId() {
        Order order = new Order();
        order.setId(2L);
        assertEquals(2L, order.getId());
    }

    @Test
    void getProductNameReturnsCorrectName() {
        Order order = new Order();
        order.setProductName("Coffee");
        assertEquals("Coffee", order.getProductName());
    }

    @Test
    void setProductNameUpdatesName() {
        Order order = new Order();
        order.setProductName("Tea");
        assertEquals("Tea", order.getProductName());
    }

    @Test
    void getQuantityReturnsCorrectQuantity() {
        Order order = new Order();
        order.setQuantity(10);
        assertEquals(10, order.getQuantity());
    }

    @Test
    void setQuantityUpdatesQuantity() {
        Order order = new Order();
        order.setQuantity(20);
        assertEquals(20, order.getQuantity());
    }

    @Test
    void getOrderDateReturnsCorrectDate() {
        Order order = new Order();
        LocalDateTime now = LocalDateTime.now();
        order.setOrderDate(now);
        assertEquals(now, order.getOrderDate());
    }

    @Test
    void setOrderDateUpdatesDate() {
        Order order = new Order();
        LocalDateTime now = LocalDateTime.now();
        order.setOrderDate(now);
        assertEquals(now, order.getOrderDate());
    }
}