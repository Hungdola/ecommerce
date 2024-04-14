package com.hungtran.ecommerce.controller;

import com.hungtran.ecommerce.exception.CartItemException;
import com.hungtran.ecommerce.exception.UserException;
import com.hungtran.ecommerce.model.CartItem;
import com.hungtran.ecommerce.model.User;
import com.hungtran.ecommerce.response.ApiResponse;
import com.hungtran.ecommerce.service.CartItemService;
import com.hungtran.ecommerce.service.CartService;
import com.hungtran.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart_items")
public class CartItemsController {

    @Autowired
    private CartService cartService;
    @Autowired
    private CartItemService cartItemService;
    @Autowired
    private UserService userService;

    @DeleteMapping("/{cartItemId}")
    public ResponseEntity<ApiResponse>RemoveCartItem( @PathVariable Long cartItemId, @RequestHeader("Authorization") String jwt) throws CartItemException, UserException {
        User user = userService.findUserProfileByJwt(jwt);

        cartItemService.removeCartItem(user.getId(), cartItemId );

        ApiResponse res = new ApiResponse();
        res.setMessage("deleted item from cart");
        res.setStatus(true);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PutMapping("/{cartItemId}")
    public ResponseEntity<CartItem> updateCartItem(@RequestBody CartItem cartItem,
                                                   @PathVariable Long cartItemId, @RequestHeader("Authorization") String jwt) throws UserException, CartItemException {
        User user = userService.findUserProfileByJwt(jwt);

        CartItem updatedCartItem = cartItemService.updateCartItem(user.getId(), cartItemId, cartItem);

        return new ResponseEntity<>(updatedCartItem, HttpStatus.OK);
    }


}
