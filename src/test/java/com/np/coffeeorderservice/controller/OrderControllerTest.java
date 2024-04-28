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
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
        assertEquals(expectedOrder.getId(), responseOrder.getId());
        assertEquals(expectedOrder.getProductName(), responseOrder.getProductName());
        assertEquals(expectedOrder.getQuantity(), responseOrder.getQuantity());
        assertEquals(expectedOrder.getOrderDate(), responseOrder.getOrderDate());
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
        assertEquals(expectedOrders.get(0), actualOrders.get(0));
        assertEquals(expectedOrders.get(1), actualOrders.get(1));
    }

    @Test
    void findOrderByIdReturnsOrderWhenFound() {
        Order order = new Order();
        when(orderService.findOrderById(1L)).thenReturn(order);

        ResponseEntity<Order> result = orderController.findOrderById(1L);

        assertEquals(order, result.getBody());
        assertEquals(200, result.getStatusCodeValue());
    }

    @Test
    void findOrderByIdReturnsNotFoundWhenNotFound() {
        when(orderService.findOrderById(1L)).thenReturn(null);

        ResponseEntity<Order> result = orderController.findOrderById(1L);

        assertNull(result.getBody());
        assertEquals(404, result.getStatusCodeValue());
    }

    @Test
    void updateOrderReturnsUpdatedOrder() {
        Order order = new Order();
        when(orderService.updateOrder(order)).thenReturn(order);

        Order result = orderController.updateOrder(order);

        assertEquals(order, result);
    }

    @Test
    void deleteOrderCallsService() {
        orderController.deleteOrder(1L);

        verify(orderService, times(1)).deleteOrder(1L);
    }

    @Test
    void deleteAllOrdersCallsService() {
        orderController.deleteAllOrders();

        verify(orderService, times(1)).deleteAllOrders();
    }

    @Test
    void findOrdersByOrderDateBetweenReturnsOrders() {
        LocalDateTime startDate = LocalDateTime.now().minusDays(1);
        LocalDateTime endDate = LocalDateTime.now();
        Order order1 = new Order();
        Order order2 = new Order();
        when(orderService.findOrdersByOrderDateBetween(startDate, endDate)).thenReturn(Arrays.asList(order1, order2));

        List<Order> result = orderController.findOrdersByOrderDateBetween(startDate, endDate);

        assertEquals(2, result.size());
        assertTrue(result.contains(order1));
        assertTrue(result.contains(order2));
    }

}
