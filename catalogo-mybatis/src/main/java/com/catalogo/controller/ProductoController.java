package com.catalogo.controller;

import com.catalogo.model.ProductoModel;
import com.catalogo.service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Validated
@RestController
@RequestMapping(value = "/productos")
public class ProductoController {

    private final ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }

    @GetMapping
    public List<ProductoModel> findAll(){
        return service.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") int id){
        Optional<ProductoModel> res = Optional.ofNullable(service.findById(id));
       if(res.isPresent()){
           return new ResponseEntity<>(res,HttpStatus.OK );
       }else {
           return new ResponseEntity<>("No se econtro el producto con ese id",HttpStatus.OK );

       }

    }
    @PostMapping
    public ResponseEntity<Object> save(@Valid  @RequestBody ProductoModel producto){
        boolean res=service.save(producto);
        if(res){
            return new ResponseEntity<>("El producto se guardo correctamente",HttpStatus.CREATED );
        }else{
            return new ResponseEntity<>("El producto ya Exite",HttpStatus.CONFLICT );

        }

    }
    @PutMapping
    public int update(@RequestBody ProductoModel producto){
        return service.update(producto);
    }
    @DeleteMapping("/{id}")
    public  int deleteById(@PathVariable("id") int id){

        Optional<Integer> res = Optional.ofNullable(service.deleteById(id));
        if(res.isPresent()){
            return new ResponseEntity<>(res,HttpStatus.OK).getStatusCodeValue();
        }else {
            return new ResponseEntity<>("No se econtro el producto con ese id",HttpStatus.OK ).getStatusCodeValue();

        }


    }


}
