package com.catalogo.service;

import com.catalogo.mapper.ProductoMapper;
import com.catalogo.model.ProductoModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpliments implements ProductoService {

    private final ProductoMapper mapper;


    public ProductoServiceImpliments(ProductoMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public boolean save(ProductoModel item) {
        boolean saved = false;
        int res = item.getId();
        Optional<ProductoModel> producto = Optional.ofNullable(mapper.findById(res));
        if (!producto.isPresent()) {
            mapper.save(item);
            saved = true;
        }

        return saved;

    }

    @Override
    public ProductoModel findById(int id) {
        return mapper.findById(id);
    }

    @Override
    public int deleteById(int id) {
     boolean deleted = false;
     int respuesta = deleteById(id);
     Optional<Integer> producto = Optional.ofNullable(mapper.deletedById(respuesta));
        if (!producto.isPresent()) {
            mapper.deletedById(id);
            deleted = true;
        }

        return resp
                


    }

    @Override
    public List<ProductoModel> findAll() {
        return mapper.finAll();
    }

    @Override
    public int update(ProductoModel item) {
        return mapper.update(item);
    }
}
