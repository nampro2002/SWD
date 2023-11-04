package com.example.InsuranceCardProject.dto;

import com.example.InsuranceCardProject.Entity.Accident;
import java.util.Date;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestCompensationDTO {
    private int accidentId;
    private String status;
    private String description;
    private Date responseDate;
}
