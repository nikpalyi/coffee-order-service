CREATE TABLE IF NOT EXISTS coffee_order (
                                      id INT AUTO_INCREMENT PRIMARY KEY,
                                      product_name VARCHAR(255) NOT NULL,
    quantity INT NOT NULL,
    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );
