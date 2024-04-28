package com.np.coffeeorderservice.repository;

import com.np.coffeeorderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByOrderDateBetween(LocalDateTime startDate, LocalDateTime endDate);
    List<Order> findByOrderDateAfter(LocalDateTime startDate);
    List<Order> findByOrderDateBefore(LocalDateTime endDate);
    List<Order> findByOrderDateBetweenAndProductName(LocalDateTime startDate, LocalDateTime endDate, String productName);
    List<Order> findByOrderDateAfterAndProductName(LocalDateTime startDate, String productName);
    List<Order> findByOrderDateBeforeAndProductName(LocalDateTime endDate, String productName);
    Order findTopByOrderDateBeforeAndProductNameOrderByOrderDateDesc(LocalDateTime endDate, String productName);
    Order findTopByOrderDateBeforeAndProductNameOrderByOrderDateAsc(LocalDateTime endDate, String productName);
    Order findTopByOrderDateAfterAndProductNameOrderByOrderDateAsc(LocalDateTime startDate, String productName);
    Order findTopByOrderDateAfterAndProductNameOrderByOrderDateDesc(LocalDateTime startDate, String productName);
    Order findTopByOrderDateBetweenAndProductNameOrderByOrderDateDesc(LocalDateTime startDate, LocalDateTime endDate, String productName);
}