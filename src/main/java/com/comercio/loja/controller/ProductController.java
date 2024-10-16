package com.comercio.loja.controller;

import com.comercio.loja.product.Product;
import com.comercio.loja.product.ProductRepository;
import com.comercio.loja.product.ProductRequestDTO;
import com.comercio.loja.product.ProductResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveProduct(@RequestBody ProductRequestDTO data){
        Product productData = new Product(data);
        repository.save(productData);
    }


        @GetMapping
    public List<ProductResponseDTO> getAll(){
        List<ProductResponseDTO> productList = repository.findAll().stream().map(ProductResponseDTO :: new).collect(Collectors.toList());
        return productList;
    }

}

