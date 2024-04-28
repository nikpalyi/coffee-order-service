package com.np.coffeeorderservice;

import com.np.coffeeorderservice.model.Order;
import com.np.coffeeorderservice.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CoffeeOrderServiceIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    void testCreateOrder() {
        Order order = new Order();
        order.setProductName("Espresso");
        order.setQuantity(2);
        order.setOrderDate(LocalDateTime.now());

        ResponseEntity<Order> response = restTemplate.postForEntity("/orders", order, Order.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        Order createdOrder = response.getBody();
        assertEquals(order.getProductName(), createdOrder.getProductName());
        assertEquals(order.getQuantity(), createdOrder.getQuantity());

        // Clean up the database
        orderRepository.delete(createdOrder);
    }
}
