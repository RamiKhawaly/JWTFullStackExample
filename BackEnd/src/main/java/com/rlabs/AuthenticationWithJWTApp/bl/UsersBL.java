package com.rlabs.AuthenticationWithJWTApp.bl;

import com.rlabs.AuthenticationWithJWTApp.entities.User;
import com.rlabs.AuthenticationWithJWTApp.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersBL {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void createUsers()
    {
        User user = new User();
        user.setEmail("rami.khawaly@gmail.com");
        user.setUsername("ramix");
        user.setPassword("rami1234");

        this.userRepository.save(user);
    }

    public User getUser(String username)
    {
        User existingUser = this.userRepository.findByUsername(username);
        if(existingUser !=null)
        {
            return existingUser;
        }
        return null;
    }
}
