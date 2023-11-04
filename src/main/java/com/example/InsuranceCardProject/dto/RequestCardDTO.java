package com.example.InsuranceCardProject.dto;

import com.example.InsuranceCardProject.Entity.Category;
import com.example.InsuranceCardProject.Entity.Contract;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
@Data
@Builder
public class RequestCardDTO {
    private int categoryId;
    private String price;
    private Float compensationRate;
    private String description;
    private int expirationInterval;
}
