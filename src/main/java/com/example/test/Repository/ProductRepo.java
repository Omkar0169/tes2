package com.example.test.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.test.Model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

}
