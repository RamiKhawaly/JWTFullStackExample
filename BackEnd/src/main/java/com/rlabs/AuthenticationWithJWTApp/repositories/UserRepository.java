package com.rlabs.AuthenticationWithJWTApp.repositories;

import com.rlabs.AuthenticationWithJWTApp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsername(String username);
}
