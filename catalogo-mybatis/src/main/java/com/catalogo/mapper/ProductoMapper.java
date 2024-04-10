package com.catalogo.mapper;

import com.catalogo.model.ProductoModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductoMapper {
    @Select("SELECT * FROM Producto")
    List<ProductoModel> finAll();
@Select("SELECT * FROM Producto WHERE id = #{id}")
    ProductoModel findById(@Param("id") int id);
@Delete("DELETE  FROM Producto WHERE id = #{id}")
    int deletedById(@Param("id") int id);
@Insert("INSERT INTO Producto(id, name, status) VALUES (#{id}, #{name}, #{status})")
    int save(ProductoModel item);
@Update("UPDATE Producto SET  name=#{name}, status=#{status} WHERE id = #{id}")
    int update( ProductoModel  item);



}
