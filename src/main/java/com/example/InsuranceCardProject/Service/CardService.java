package com.example.InsuranceCardProject.Service;

import com.example.InsuranceCardProject.Entity.Card;
import com.example.InsuranceCardProject.Entity.Category;
import com.example.InsuranceCardProject.dto.RequestCardDTO;
import java.util.List;

public interface CardService {

    Card addNewCard(RequestCardDTO requestCardDTO);

    List<Card> getAllCard();

    Card updateCard(Integer id, RequestCardDTO requestCardDTO);

    void deleteCard(Integer id);
}
