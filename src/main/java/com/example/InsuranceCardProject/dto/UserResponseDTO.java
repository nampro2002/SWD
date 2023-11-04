package com.example.InsuranceCardProject.dto;

import java.util.Date;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponseDTO {
    private String name;
    private String username;
    private String email;
    private String phone;
    private String address;
    private Date dateOfBirth;
    private boolean gender;
    private String role;
}
