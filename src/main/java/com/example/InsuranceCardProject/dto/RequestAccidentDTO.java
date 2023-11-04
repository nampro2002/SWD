package com.example.InsuranceCardProject.dto;

import com.example.InsuranceCardProject.Entity.Contract;
import com.example.InsuranceCardProject.Entity.Participant;
import java.util.Date;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestAccidentDTO {
    private String code;
    private Date date;
    private String description;
    private int participantId;
    private int contractId;
}
