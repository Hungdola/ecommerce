package com.hungtran.ecommerce.controller;

import com.hungtran.ecommerce.exception.OrderException;
import com.hungtran.ecommerce.exception.RazorpayException;
import com.hungtran.ecommerce.exception.UserException;
import com.hungtran.ecommerce.model.Order;
import com.hungtran.ecommerce.repository.OrderRepository;
import com.hungtran.ecommerce.service.OrderService;
import com.hungtran.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PaymentController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;
    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/payments/{orderId}")
    public ResponseEntity<PaymentLinkResponse> createPaymentLink(@PathVariable Long orderId, @RequestHeader("Authorization") String jwt) throws RazorpayException, UserException, OrderException {
        Order order = orderService.findOrderById(orderId);

       return null;
    }

}
