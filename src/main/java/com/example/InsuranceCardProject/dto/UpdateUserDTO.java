package com.example.InsuranceCardProject.dto;

import java.util.Date;
import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class UpdateUserDTO {

        private String name;
        private String password;
        private String email;
        private String phone;
        private String address;
        private Date dateOfBirth;
        private boolean gender;

}
