package com.np.coffeeorderservice.service;

import com.np.coffeeorderservice.model.Order;
import com.np.coffeeorderservice.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OrderServiceTest {

    @Mock
    private OrderRepository repository;

    @InjectMocks
    private OrderService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findOrderByIdReturnsOrder() {
        Order order = new Order();
        when(repository.findById(1L)).thenReturn(Optional.of(order));

        Order result = service.findOrderById(1L);

        assertEquals(order, result);
    }

    @Test
    void findOrderByIdReturnsNullWhenNotFound() {
        when(repository.findById(1L)).thenReturn(Optional.empty());

        Order result = service.findOrderById(1L);

        assertNull(result);
    }

    @Test
    void saveOrderReturnsSavedOrder() {
        Order order = new Order();
        when(repository.save(order)).thenReturn(order);

        Order result = service.saveOrder(order);

        assertEquals(order, result);
    }

    @Test
    void findAllOrdersReturnsAllOrders() {
        Order order1 = new Order();
        Order order2 = new Order();
        when(repository.findAll()).thenReturn(Arrays.asList(order1, order2));

        List<Order> result = service.findAllOrders();

        assertEquals(2, result.size());
        assertTrue(result.contains(order1));
        assertTrue(result.contains(order2));
    }

    @Test
    void updateOrderReturnsUpdatedOrder() {
        Order order = new Order();
        when(repository.save(order)).thenReturn(order);

        Order result = service.updateOrder(order);

        assertEquals(order, result);
    }

    @Test
    void deleteOrderCallsDeleteById() {
        service.deleteOrder(1L);

        verify(repository, times(1)).deleteById(1L);
    }

    @Test
    void deleteAllOrdersCallsDeleteAll() {
        service.deleteAllOrders();

        verify(repository, times(1)).deleteAll();
    }

    @Test
    void findOrdersByOrderDateBetweenAndProductNameReturnsOrders() {
        LocalDateTime startDate = LocalDateTime.now().minusDays(1);
        LocalDateTime endDate = LocalDateTime.now();
        String productName = "Espresso";
        Order order1 = new Order();
        Order order2 = new Order();
        when(repository.findByOrderDateBetweenAndProductName(startDate, endDate, productName)).thenReturn(Arrays.asList(order1, order2));

        List<Order> result = service.findOrdersByOrderDateBetweenAndProductName(startDate, endDate, productName);

        assertEquals(2, result.size());
        assertTrue(result.contains(order1));
        assertTrue(result.contains(order2));
    }

    @Test
    void findTopOrderBetweenAndProductNameOrderByOrderDateDescReturnsOrder() {
        LocalDateTime startDate = LocalDateTime.now().minusDays(1);
        LocalDateTime endDate = LocalDateTime.now();
        String productName = "Espresso";
        Order order = new Order();
        when(repository.findTopByOrderDateBetweenAndProductNameOrderByOrderDateDesc(startDate, endDate, productName)).thenReturn(order);

        Order result = service.findTopOrderBetweenAndProductNameOrderByOrderDateDesc(startDate, endDate, productName);

        assertEquals(order, result);
    }

    @Test
    void findOrdersByOrderDateBetweenReturnsOrders() {
        LocalDateTime startDate = LocalDateTime.now().minusDays(1);
        LocalDateTime endDate = LocalDateTime.now();
        Order order1 = new Order();
        Order order2 = new Order();
        when(repository.findByOrderDateBetween(startDate, endDate)).thenReturn(Arrays.asList(order1, order2));

        List<Order> result = service.findOrdersByOrderDateBetween(startDate, endDate);

        assertEquals(2, result.size());
        assertTrue(result.contains(order1));
        assertTrue(result.contains(order2));
    }

    @Test
    void findOrdersByOrderDateAfterAndProductNameReturnsOrders() {
        LocalDateTime startDate = LocalDateTime.now().minusDays(1);
        String productName = "Espresso";
        Order order1 = new Order();
        Order order2 = new Order();
        when(repository.findByOrderDateAfterAndProductName(startDate, productName)).thenReturn(Arrays.asList(order1, order2));

        List<Order> result = service.findOrdersByOrderDateAfterAndProductName(startDate, productName);

        assertEquals(2, result.size());
        assertTrue(result.contains(order1));
        assertTrue(result.contains(order2));
    }

    @Test
    void findOrdersByOrderDateBeforeAndProductNameReturnsOrders() {
        LocalDateTime endDate = LocalDateTime.now();
        String productName = "Espresso";
        Order order1 = new Order();
        Order order2 = new Order();
        when(repository.findByOrderDateBeforeAndProductName(endDate, productName)).thenReturn(Arrays.asList(order1, order2));

        List<Order> result = service.findOrdersByOrderDateBeforeAndProductName(endDate, productName);

        assertEquals(2, result.size());
        assertTrue(result.contains(order1));
        assertTrue(result.contains(order2));
    }

    @Test
    void findTopOrderBeforeAndProductNameOrderByOrderDateDescReturnsOrder() {
        LocalDateTime endDate = LocalDateTime.now();
        String productName = "Espresso";
        Order order = new Order();
        when(repository.findTopByOrderDateBeforeAndProductNameOrderByOrderDateDesc(endDate, productName)).thenReturn(order);

        Order result = service.findTopOrderBeforeAndProductNameOrderByOrderDateDesc(endDate, productName);

        assertEquals(order, result);
    }

    @Test
    void findTopOrderAfterAndProductNameOrderByOrderDateDescReturnsOrder() {
        LocalDateTime startDate = LocalDateTime.now().minusDays(1);
        String productName = "Espresso";
        Order order = new Order();
        when(repository.findTopByOrderDateAfterAndProductNameOrderByOrderDateDesc(startDate, productName)).thenReturn(order);

        Order result = service.findTopOrderAfterAndProductNameOrderByOrderDateDesc(startDate, productName);

        assertEquals(order, result);
    }

    @Test
    void findTopOrderBeforeAndProductNameOrderByOrderDateAscReturnsOrder() {
        LocalDateTime endDate = LocalDateTime.now();
        String productName = "Espresso";
        Order order = new Order();
        when(repository.findTopByOrderDateBeforeAndProductNameOrderByOrderDateAsc(endDate, productName)).thenReturn(order);

        Order result = service.findTopOrderBeforeAndProductNameOrderByOrderDateAsc(endDate, productName);

        assertEquals(order, result);
    }

    @Test
    void findTopOrderAfterAndProductNameOrderByOrderDateAscReturnsOrder() {
        LocalDateTime startDate = LocalDateTime.now().minusDays(1);
        String productName = "Espresso";
        Order order = new Order();
        when(repository.findTopByOrderDateAfterAndProductNameOrderByOrderDateAsc(startDate, productName)).thenReturn(order);

        Order result = service.findTopOrderAfterAndProductNameOrderByOrderDateAsc(startDate, productName);

        assertEquals(order, result);
    }

}