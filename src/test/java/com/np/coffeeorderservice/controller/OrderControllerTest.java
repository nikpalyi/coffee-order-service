package com.np.coffeeorderservice.controller;

import com.np.coffeeorderservice.model.Order;
import com.np.coffeeorderservice.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OrderControllerTest {

    @Mock
    private OrderService orderService;

    @InjectMocks
    private OrderController orderController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testFindOrderById() {
        Order expectedOrder = new Order();
        expectedOrder.setId(1L);
        expectedOrder.setProductName("Coffee");
        expectedOrder.setQuantity(2);
        expectedOrder.setOrderDate(LocalDateTime.now());

        when(orderService.findOrderById(1L)).thenReturn(expectedOrder);

        ResponseEntity<Order> responseEntity = orderController.findOrderById(1L);
        Order responseOrder = responseEntity.getBody();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedOrder, responseOrder);
    }

    @Test
    void testSaveOrder() {
        Order orderToSave = new Order();
        orderToSave.setId(1L);
        orderToSave.setProductName("Tea");
        orderToSave.setQuantity(3);
        orderToSave.setOrderDate(LocalDateTime.now());

        when(orderService.saveOrder(orderToSave)).thenReturn(orderToSave);

        Order savedOrder = orderController.saveOrder(orderToSave);

        assertEquals(orderToSave, savedOrder);
    }

    @Test
    void testFindAllOrders() {
        List<Order> expectedOrders = new ArrayList<>();
        Order order1 = new Order();
        order1.setId(1L);
        order1.setProductName("Coffee");
        order1.setQuantity(2);
        order1.setOrderDate(LocalDateTime.now());
        expectedOrders.add(order1);

        Order order2 = new Order();
        order2.setId(2L);
        order2.setProductName("Tea");
        order2.setQuantity(3);
        order2.setOrderDate(LocalDateTime.now());
        expectedOrders.add(order2);

        when(orderService.findAllOrders()).thenReturn(expectedOrders);

        List<Order> actualOrders = orderController.findAllOrders();

        assertEquals(expectedOrders.size(), actualOrders.size());
        assertEquals(expectedOrders, actualOrders);
    }


    @Test
    void testUpdateOrder() {
        Order updatedOrder = new Order();
        updatedOrder.setId(1L);
        updatedOrder.setProductName("Updated Product Name");
        updatedOrder.setQuantity(10);
        updatedOrder.setOrderDate(LocalDateTime.now());

        when(orderService.updateOrder(updatedOrder)).thenReturn(updatedOrder);

        ResponseEntity<Order> responseEntity = orderController.updateOrder(1L, updatedOrder);
        Order responseOrder = responseEntity.getBody();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(updatedOrder, responseOrder);
    }

    @Test
    void testDeleteOrder() {
        orderController.deleteOrder(1L);
        verify(orderService, times(1)).deleteOrder(1L);
    }

    @Test
    void testDeleteAllOrders() {
        orderController.deleteAllOrders();
        verify(orderService, times(1)).deleteAllOrders();
    }

}
