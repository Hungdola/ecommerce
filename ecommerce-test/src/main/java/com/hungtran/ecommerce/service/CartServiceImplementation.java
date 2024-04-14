package com.hungtran.ecommerce.service;

import com.hungtran.ecommerce.exception.ProductException;
import com.hungtran.ecommerce.model.Cart;
import com.hungtran.ecommerce.model.CartItem;
import com.hungtran.ecommerce.model.Product;
import com.hungtran.ecommerce.model.User;
import com.hungtran.ecommerce.repository.CartRepository;
import com.hungtran.ecommerce.request.AddItemRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CartServiceImplementation implements CartService{

    private CartRepository cartRepository;
    private CartItemService cartItemService;
    private ProductService productService;
    @Override
    public Cart createCart(User user) {

        Cart cart = new Cart();
        cart.setUser(user);
        return cartRepository.save(cart);
    }

    @Override
    public String addCartItem(Long userId, AddItemRequest req) throws ProductException {

        Cart cart = cartRepository.findByUserId(userId);
        System.out.println("id cart là:"+cart.getId());
        Product product = productService.findProductById(req.getProductId());
        System.out.println("product id là:"+product.getId());

        CartItem isPresent = cartItemService.isCartItemExist(cart, product, req.getSize(), userId);

        if(isPresent == null) {
            CartItem cartItem = new CartItem();
            cartItem.setProduct(product);
            cartItem.setCart(cart);
            cartItem.setQuantity(req.getQuantity());
            cartItem.setUserId(userId);

            int price = req.getQuantity() * product.getDiscountedPrice();
            cartItem.setPrice(price);
            System.out.println("Price cua item la:"+cartItem.getPrice());
            cartItem.setSize(req.getSize());
            System.out.println("size của item la:"+cartItem.getSize());

            CartItem createdCartItem = cartItemService.createCartItem(cartItem);
            cart.getCartItems().add(createdCartItem);
            System.out.println("add thanh cong con cặc:");

        }
        return "Item add to cart";
    }

    @Override
    public Cart findUserCart(Long userId) {

        Cart cart = cartRepository.findByUserId(userId);

        int totalPrice = 0;
        int totalDiscountedPrice = 0;
        int totalItem = 0;

        System.out.println("userId:"+userId);

        for (CartItem cartItem:cart.getCartItems()) {
            System.out.println("id của cart la hien tai:"+cartItem.getId());
            totalPrice= totalPrice + cartItem.getPrice();
            totalDiscountedPrice = totalDiscountedPrice+ cartItem.getDiscountedPrice();
            totalItem =totalItem + cartItem.getQuantity();
        }

        cart.setTotalPrice(totalPrice);
        cart.setTotalDiscountedPrice(totalDiscountedPrice);
        cart.setTotalItem(totalItem);
        cart.setDiscounted(totalPrice-totalDiscountedPrice);

        return cartRepository.save(cart);
    }
}
