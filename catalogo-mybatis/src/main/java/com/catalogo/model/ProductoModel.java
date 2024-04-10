package com.catalogo.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class ProductoModel {
    @NotNull(message = "El ID no puede ser nulo")
    @NotBlank(message = "El ID no puede ser vacio")
    private int id;
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    @NotNull
    private boolean status;

}
