package com.np.coffeeorderservice.controller;

import com.np.coffeeorderservice.model.Order;
import com.np.coffeeorderservice.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    // Constructor with @Autowired (if using constructor injection)
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    // @GetMapping, @PostMapping, @PutMapping, @DeleteMapping methods...
    @GetMapping("/{id}")
    public Order findOrderById(@PathVariable Long id) {
        return orderService.findOrderById(id);
    }

    @PostMapping
    public Order saveOrder(@RequestBody Order order) {
        return orderService.saveOrder(order);
    }

    @GetMapping
    public List<Order> findAllOrders() {
        return orderService.findAllOrders();
    }

    @PutMapping
    public Order updateOrder(@RequestBody Order order) {
        return orderService.updateOrder(order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }

    @DeleteMapping
    public void deleteAllOrders() {
        orderService.deleteAllOrders();
    }

    @GetMapping("/date/{startDate}/{endDate}")
    public List<Order> findOrdersByOrderDateBetween(@PathVariable LocalDateTime startDate, @PathVariable LocalDateTime endDate) {
        return orderService.findOrdersByOrderDateBetween(startDate, endDate);
    }

}