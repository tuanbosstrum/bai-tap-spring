package edu.phuxuan.k17.spring.baitapcontrollerdemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.phuxuan.k17.spring.baitapcontrollerdemo.model.Product;
import edu.phuxuan.k17.spring.baitapcontrollerdemo.repository.ProductRepository;

public class ProductServiceImpl implements ProductService {

    @Autowired
    public ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Product findById(int id) {
        return this.productRepository.findById(id);
    }

    @Override
    public void save(Product product) {
        this.productRepository.save(product);
    }
}