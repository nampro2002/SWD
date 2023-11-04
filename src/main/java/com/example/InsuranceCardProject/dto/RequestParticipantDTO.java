package com.example.InsuranceCardProject.dto;

import java.util.Date;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestParticipantDTO {
    private String name;
    private Date dateOfBirth;
    private int idNumber;
    private String address;
    private boolean gender;
}
