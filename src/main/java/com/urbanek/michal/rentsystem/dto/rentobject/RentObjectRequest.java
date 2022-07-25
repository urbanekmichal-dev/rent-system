package com.urbanek.michal.rentsystem.dto.rentobject;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class RentObjectRequest {
    @NotBlank(message = "Name field is mandatory")
    @Size(min = 5,max=1000,message = "Name size should be between 2 to 100 characters")
    @Pattern(regexp="^[A-Za-zżźćńółęąśŻŹĆĄŚĘŁÓŃ]*$",message = "Name should contain only letters!")
    private String name;

    @NotNull(message = "Price field is mandatory")
    @DecimalMin(value="0.0",message = "Price can't be negative value")
    @DecimalMax(value="1000000.0", message="Price can't be higher than 1 million")
    private Double price;

    @NotNull(message = "Area field is mandatory")
    @DecimalMin(value="0.0",message = "Are can't be negative value")
    @DecimalMax(value="1000000.0", message="Area can't be higher than 1 million")
    private Double area;

    @NotBlank(message = "Description field is mandatory")
    @Size(min = 5,max=1000,message = "Description size should be between 5 to 1000 characters")
    private String description;
}
