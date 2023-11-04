package com.example.InsuranceCardProject.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String code;
    @ManyToOne
    @JoinColumn(name = "buyerId")
    private User user;
    @ManyToOne
    @JoinColumn(name = "participantId")
    private Participant participant;
    //ProductId
    private Date activeDate;
    private Date refreshDate;
    private boolean isActive;
    private Date continuousYear;
    @OneToMany(mappedBy = "contract", fetch =  FetchType.LAZY, cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude // không sử dụng trường này trong khi equals và
    @ToString.Exclude // Không sử dụng trong khi toString()
    @JsonIgnore
    private List<Accident> accidentList;
    @ManyToOne
    @JoinColumn(name = "productId")
    private Card card;

}
