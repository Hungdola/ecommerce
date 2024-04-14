package com.hungtran.ecommerce.service;

import com.hungtran.ecommerce.exception.ProductException;
import com.hungtran.ecommerce.model.Rating;
import com.hungtran.ecommerce.model.User;
import com.hungtran.ecommerce.request.RatingRequest;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RatingService {

    public Rating createRating(RatingRequest req, User user) throws ProductException;
    public List<Rating> getProductsRating(Long productId);

}
