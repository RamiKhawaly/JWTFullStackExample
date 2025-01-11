package com.rlabs.AuthenticationWithJWTApp.repositories;

import com.rlabs.AuthenticationWithJWTApp.entities.Data;
import com.rlabs.AuthenticationWithJWTApp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataRepository extends JpaRepository<Data,Long> {

}
