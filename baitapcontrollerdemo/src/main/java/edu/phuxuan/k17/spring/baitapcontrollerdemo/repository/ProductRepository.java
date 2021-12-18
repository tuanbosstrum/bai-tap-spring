package edu.phuxuan.k17.spring.baitapcontrollerdemo.repository;

import java.util.List;

import edu.phuxuan.k17.spring.baitapcontrollerdemo.model.Product;

public interface ProductRepository {
    List<Product> findAll();

    Product findById(int id);

    void save(Product product);
}