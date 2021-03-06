package com.minhhieu.library.dto;

import lombok.*;

import javax.validation.constraints.Size;

@Data
@NoArgsConstructor @AllArgsConstructor
public class AdminDto {
    @Size(min = 3, max = 10, message = "Invalid first name (3-10  character)")
    public String firstName;
    @Size(min = 3, max = 10, message = "Invalid last name (3-10  character)")
    public String lastName;

    public String username;
    @Size(min = 5, max = 15, message = "Invalid password (5-15  character)")
    public String password;

    public String repeatPassword;
}
