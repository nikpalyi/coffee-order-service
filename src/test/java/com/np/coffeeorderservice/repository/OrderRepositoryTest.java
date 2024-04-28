package com.np.coffeeorderservice.repository;

import com.np.coffeeorderservice.model.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    private Order order;

    @BeforeEach
    void setUp() {
        order = new Order();
        order.setProductName("Coffee");
        order.setQuantity(2);
        order.setOrderDate(LocalDateTime.now());
        orderRepository.save(order);
    }

    @Test
    void findByOrderDateBetweenReturnsOrders() {
        LocalDateTime startDate = LocalDateTime.now().minusDays(1);
        LocalDateTime endDate = LocalDateTime.now().plusDays(1);
        List<Order> orders = orderRepository.findByOrderDateBetween(startDate, endDate);
        assertFalse(orders.isEmpty());
        assertEquals(order.getProductName(), orders.get(0).getProductName());
    }

    @Test
    void findByOrderDateAfterReturnsOrders() {
        LocalDateTime startDate = LocalDateTime.now().minusHours(1);
        List<Order> orders = orderRepository.findByOrderDateAfter(startDate);
        assertFalse(orders.isEmpty());
        assertEquals(order.getProductName(), orders.get(0).getProductName());
    }

    @Test
    void findByOrderDateBeforeReturnsEmpty() {
        LocalDateTime endDate = LocalDateTime.now().minusDays(1);
        List<Order> orders = orderRepository.findByOrderDateBefore(endDate);
        assertFalse(orders.isEmpty());
    }

    @Test
    void findByOrderDateBetweenAndProductNameReturnsOrders() {
        LocalDateTime startDate = LocalDateTime.now().minusDays(1);
        LocalDateTime endDate = LocalDateTime.now().plusDays(1);
        List<Order> orders = orderRepository.findByOrderDateBetweenAndProductName(startDate, endDate, "Coffee");
        assertFalse(orders.isEmpty());
        assertEquals(order.getProductName(), orders.get(0).getProductName());
    }

    @Test
    void findByOrderDateAfterAndProductNameReturnsOrders() {
        LocalDateTime startDate = LocalDateTime.now().minusHours(1);
        List<Order> orders = orderRepository.findByOrderDateAfterAndProductName(startDate, "Coffee");
        assertFalse(orders.isEmpty());
        assertEquals(order.getProductName(), orders.get(0).getProductName());
    }

    @Test
    void findByOrderDateBeforeAndProductNameReturnsEmpty() {
        LocalDateTime endDate = LocalDateTime.now().minusDays(1);
        List<Order> orders = orderRepository.findByOrderDateBeforeAndProductName(endDate, "Coffee");
        assertTrue(orders.isEmpty());
    }

    @Test
    void findTopByOrderDateBeforeAndProductNameOrderByOrderDateDescReturnsOrder() {
        LocalDateTime endDate = LocalDateTime.now().plusDays(1);
        Order foundOrder = orderRepository.findTopByOrderDateBeforeAndProductNameOrderByOrderDateDesc(endDate, "Coffee");
        assertNotNull(foundOrder);
        assertEquals(order.getProductName(), foundOrder.getProductName());
    }

    @Test
    void findTopByOrderDateBeforeAndProductNameOrderByOrderDateAscReturnsNull() {
        LocalDateTime endDate = LocalDateTime.now().minusDays(1);
        Order foundOrder = orderRepository.findTopByOrderDateBeforeAndProductNameOrderByOrderDateAsc(endDate, "Coffee");
        assertNull(foundOrder);
    }

    @Test
    void findTopByOrderDateAfterAndProductNameOrderByOrderDateAscReturnsOrder() {
        LocalDateTime startDate = LocalDateTime.now().minusHours(1);
        Order foundOrder = orderRepository.findTopByOrderDateAfterAndProductNameOrderByOrderDateAsc(startDate, "Coffee");
        assertNotNull(foundOrder);
        assertEquals(order.getProductName(), foundOrder.getProductName());
    }

    @Test
    void findTopByOrderDateAfterAndProductNameOrderByOrderDateDescReturnsNull() {
        LocalDateTime startDate = LocalDateTime.now().plusDays(1);
        Order foundOrder = orderRepository.findTopByOrderDateAfterAndProductNameOrderByOrderDateDesc(startDate, "Coffee");
        assertNull(foundOrder);
    }

    @Test
    void findTopByOrderDateBetweenAndProductNameOrderByOrderDateDescReturnsOrder() {
        LocalDateTime startDate = LocalDateTime.now().minusDays(1);
        LocalDateTime endDate = LocalDateTime.now().plusDays(1);
        Order foundOrder = orderRepository.findTopByOrderDateBetweenAndProductNameOrderByOrderDateDesc(startDate, endDate, "Coffee");
        assertNotNull(foundOrder);
        assertEquals(order.getProductName(), foundOrder.getProductName());
    }
}