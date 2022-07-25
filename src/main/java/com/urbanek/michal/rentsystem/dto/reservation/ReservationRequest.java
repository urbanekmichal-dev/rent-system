package com.urbanek.michal.rentsystem.dto.reservation;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;


@Data
public class ReservationRequest {
    @NotNull(message = "Start date field is mandatory")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate startDate;

    @NotNull(message = "End date field is mandatory")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate endDate;

    @NotBlank(message = "Rent object name field is mandatory")
    @Pattern(regexp="^[A-Za-zżźćńółęąśŻŹĆĄŚĘŁÓŃ]*$",message = "Rent object name should contain only letters!")
    private String rentObjectName;

    @NotBlank(message = "Landlord name field is mandatory")
    @Pattern(regexp="^[A-Za-zżźćńółęąśŻŹĆĄŚĘŁÓŃ]*$",message = "Landlord name should contain only letters!")
    private String landlordName;

    @NotBlank(message = "Tenant name field is mandatory")
    @Pattern(regexp="^[A-Za-zżźćńółęąśŻŹĆĄŚĘŁÓŃ]*$",message = "Tenant name should contain only letters!")
    private String tenantName;
}
