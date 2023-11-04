package com.example.InsuranceCardProject.Entity;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Accident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String code;
    private Date date;
    private String description;
    @ManyToOne
    @JoinColumn(name = "participantId") // thông qua khóa ngoại participantId
    private Participant participant;
    @ManyToOne
    @JoinColumn(name = "contract_id")
    private Contract contract;
}
