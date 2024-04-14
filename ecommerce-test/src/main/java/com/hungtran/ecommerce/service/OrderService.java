package com.hungtran.ecommerce.service;

import com.hungtran.ecommerce.exception.OrderException;
import com.hungtran.ecommerce.model.Address;
import com.hungtran.ecommerce.model.Order;
import com.hungtran.ecommerce.model.User;

import java.util.List;

public interface OrderService  {
    public Order createOrder(User user, Address shippingAddress);
    public Order findOrderById(Long orderId) throws OrderException;
    public List<Order> usersOrderHistory(Long userId);
    public Order placedOrder(Long orderId) throws OrderException;
    public Order confirmedOrder(Long orderId) throws OrderException;
    public Order shippedOrder(Long orderId) throws OrderException;
    public Order deliveredOrder(Long orderId) throws OrderException;
    public Order canceledOrder(Long orderId) throws OrderException;
    public List<Order>getAllOrders();
    public void deletedOrder(Long orderId) throws OrderException;
}
