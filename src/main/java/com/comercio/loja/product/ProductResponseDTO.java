package com.comercio.loja.product;

public record ProductResponseDTO(Long Id, String name, Double price, String image ) {
    public ProductResponseDTO(Product product){
        this(product.getId(), product.getName(), product.getPrice(), product.getImage());
    }
}
