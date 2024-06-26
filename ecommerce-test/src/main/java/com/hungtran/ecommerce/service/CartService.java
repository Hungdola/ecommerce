package com.hungtran.ecommerce.service;

import com.hungtran.ecommerce.exception.ProductException;
import com.hungtran.ecommerce.model.Cart;
import com.hungtran.ecommerce.model.User;
import com.hungtran.ecommerce.request.AddItemRequest;

public interface CartService {

    public Cart createCart(User user);
    public String addCartItem(Long userId, AddItemRequest req) throws ProductException;

    public Cart findUserCart(Long userId);

}
