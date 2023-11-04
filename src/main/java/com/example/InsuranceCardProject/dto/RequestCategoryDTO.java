package com.example.InsuranceCardProject.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestCategoryDTO {
    private String categoryName;
    private String description;
}
