package com.comercio.loja.controller;
import com.comercio.loja.service.ProductService;
import com.comercio.loja.product.ProductRequestDTO;
import com.comercio.loja.product.ProductResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveProduct(@RequestBody ProductRequestDTO data) {
        productService.saveProduct(data);
    }

    @GetMapping
    public List<ProductResponseDTO> getAll() {
        return productService.getAll();
    }

    @DeleteMapping("(/product/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}

