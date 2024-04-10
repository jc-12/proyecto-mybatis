package com.catalogo.service;

import com.catalogo.model.ProductoModel;

import java.util.List;

public interface ProductoService {

    List<ProductoModel> findAll();
    ProductoModel findById(int id);
    int deleteById(int id);
    boolean save(ProductoModel item);
    int update (ProductoModel item);
}
