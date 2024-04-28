Feature: Testing Order Controller

  Background:
    * url 'http://localhost:8082'

  Scenario: Create a New Order
    Given path '/orders'
    And request { productName: 'Latte', quantity: 2, orderDate: '2024-04-29T00:00:00' }
    When method POST
    Then status 200

  Scenario: Retrieve Order by ID
    Given path '/orders/1'
    When method GET
    Then status 200

  Scenario: Get all orders
    Given path '/orders'
    When method get
    Then status 200

  Scenario: Update an order
    Given path '/orders/1'
    And request { productName: 'Updated Product Name', quantity: 10, orderDate: '2024-04-28T00:00:00' }
    When method put
    Then status 200

  Scenario: Delete an order
    Given path '/orders/1'
    When method delete
    Then status 200

  Scenario: Delete all orders
    Given path '/orders'
    When method delete
    Then status 200

  Scenario: Find orders by date range
    Given path '/orders/date/2024-01-01T00:00:00/2024-12-31T23:59:59'
    When method get
    Then status 200
