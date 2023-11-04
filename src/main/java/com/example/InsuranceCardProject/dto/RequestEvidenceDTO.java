package com.example.InsuranceCardProject.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestEvidenceDTO {
    private String injuryEvidence;
    private String medicineReceipt;
    private String medicalReport;
    private int accidentId;
}
