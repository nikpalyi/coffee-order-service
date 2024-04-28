package com.np.coffeeorderservice.service;

import com.np.coffeeorderservice.model.Order;
import com.np.coffeeorderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository repository;

    // Constructor with @Autowired (if using constructor injection)
    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }



    // Business methods that use the repository...
    public Order findOrderById(Long id) {
        return
                repository.findById(id).orElse(null);

    }

    public Order saveOrder(Order order) {
        return repository.save(order);
    }

    public List<Order> findAllOrders() {
        return repository.findAll();
    }

    public Order updateOrder(Order order) {
        return repository.save(order);
    }

    public void deleteOrder(Long id) {
        repository.deleteById(id);
    }

    public void deleteAllOrders() {
        repository.deleteAll();
    }

    public List<Order> findOrdersByOrderDateBetween(LocalDateTime startDate, LocalDateTime endDate) {
        return repository.findByOrderDateBetween(startDate, endDate);
    }

    public List<Order> findOrdersByOrderDateAfter(LocalDateTime startDate) {
        return repository.findByOrderDateAfter(startDate);
    }

    public List<Order> findOrdersByOrderDateBefore(LocalDateTime endDate) {
        return repository.findByOrderDateBefore(endDate);
    }

    public List<Order> findOrdersByOrderDateBetweenAndProductName(LocalDateTime startDate, LocalDateTime endDate, String productName) {
        return repository.findByOrderDateBetweenAndProductName(startDate, endDate, productName);
    }

    public List<Order> findOrdersByOrderDateAfterAndProductName(LocalDateTime startDate, String productName) {
        return repository.findByOrderDateAfterAndProductName(startDate, productName);
    }

    public List<Order> findOrdersByOrderDateBeforeAndProductName(LocalDateTime endDate, String productName) {
        return repository.findByOrderDateBeforeAndProductName(endDate, productName);
    }

    public Order findTopOrderBeforeAndProductNameOrderByOrderDateDesc(LocalDateTime endDate, String productName) {
        return repository.findTopByOrderDateBeforeAndProductNameOrderByOrderDateDesc(endDate, productName);
    }

    public Order findTopOrderAfterAndProductNameOrderByOrderDateDesc(LocalDateTime startDate, String productName) {
        return repository.findTopByOrderDateAfterAndProductNameOrderByOrderDateDesc(startDate, productName);
    }

    public Order findTopOrderBetweenAndProductNameOrderByOrderDateDesc(LocalDateTime startDate, LocalDateTime endDate, String productName) {
        return repository.findTopByOrderDateBetweenAndProductNameOrderByOrderDateDesc(startDate, endDate, productName);
    }

    public Order findTopOrderBeforeAndProductNameOrderByOrderDateAsc(LocalDateTime endDate, String productName) {
        return repository.findTopByOrderDateBeforeAndProductNameOrderByOrderDateAsc(endDate, productName);
    }

    public Order findTopOrderAfterAndProductNameOrderByOrderDateAsc(LocalDateTime startDate, String productName) {
        return repository.findTopByOrderDateAfterAndProductNameOrderByOrderDateAsc(startDate, productName);
    }

}