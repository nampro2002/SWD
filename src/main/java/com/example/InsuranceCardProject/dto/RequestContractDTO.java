package com.example.InsuranceCardProject.dto;

import com.example.InsuranceCardProject.Entity.Accident;
import com.example.InsuranceCardProject.Entity.Card;
import com.example.InsuranceCardProject.Entity.Participant;
import com.example.InsuranceCardProject.Entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Builder
public class RequestContractDTO {
    private int userId;
    private int cardId;
    private int participantId;
    private String code;
    private Date activeDate;
    private Date refreshDate;
    private Date continuousYear;
}
