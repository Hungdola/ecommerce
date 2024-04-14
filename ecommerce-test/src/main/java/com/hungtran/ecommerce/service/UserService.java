package com.hungtran.ecommerce.service;

import com.hungtran.ecommerce.exception.UserException;
import com.hungtran.ecommerce.model.User;

public interface UserService {

    public User findUserById(Long userId) throws UserException;

    public User findUserProfileByJwt(String jwt) throws UserException;
}
