package com.rlabs.AuthenticationWithJWTApp.repositories;

import com.rlabs.AuthenticationWithJWTApp.entities.Data;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataRepository extends JpaRepository<Data,Long> {

}
