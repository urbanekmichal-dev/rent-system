package com.urbanek.michal.rentsystem.dto.landlord;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class LandlordRequest {
    @NotBlank(message = "Name field is mandatory")
    @Size(min = 5,max=1000,message = "Name size should be between 2 to 100 characters")
    @Pattern(regexp="^[A-Za-zżźćńółęąśŻŹĆĄŚĘŁÓŃ]*$",message = "Name should contain only letters!")
    private String name;
}
