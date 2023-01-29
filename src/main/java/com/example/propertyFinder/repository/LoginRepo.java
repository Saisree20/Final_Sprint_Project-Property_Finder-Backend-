package com.example.propertyFinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.propertyFinder.entity.Login;

@Repository
public interface LoginRepo extends JpaRepository<Login,String>{

}
