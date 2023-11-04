package com.example.InsuranceCardProject.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.math.BigDecimal;
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
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "categoryId") // thông qua khóa ngoại user_id
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Category category;
    private String price;
    private Float compensationRate;
    private String description;
    private int expirationInterval;
    @OneToMany(mappedBy = "card", fetch =  FetchType.LAZY, cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude // không sử dụng trường này trong khi equals và
    @ToString.Exclude // Không sử dụng trong khi toString()
    @JsonIgnore
    private List<Contract> contractList;
}
