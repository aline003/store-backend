package com.comercio.loja.service;

import com.comercio.loja.product.Product;
import com.comercio.loja.product.ProductRepository;
import com.comercio.loja.product.ProductRequestDTO;
import com.comercio.loja.product.ProductResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public void saveProduct(@RequestBody ProductRequestDTO data) {
        Product productData = new Product(data);
        repository.save(productData);
    }

    public List<ProductResponseDTO> getAll() {
        List<ProductResponseDTO> productList = repository.findAll().stream().map(ProductResponseDTO::new).collect(Collectors.toList());
        return productList;
    }

    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }
}

