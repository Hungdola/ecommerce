package com.hungtran.ecommerce.service;

import com.hungtran.ecommerce.model.User;
import com.hungtran.ecommerce.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Data
@NoArgsConstructor
//@AllArgsConstructor
public class CustomerServiceImplementation implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

//        User userOptional = userRepository.findByEmail(username);
//
//        User user = userOptional.orElse(new User()); // Trả về một User mặc định nếu không tìm thấy
//        String userEmail = user.getEmail();
//        String userPassword = user.getPassword();

        User user = userRepository.findByEmail(username);

        if( user == null) {
            throw new UsernameNotFoundException("user not found with email -"+ username);
        }
        List<GrantedAuthority> authorities = new ArrayList<>();

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }
}
