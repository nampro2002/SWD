package com.example.InsuranceCardProject.Service.ServiceImpl;

import com.example.InsuranceCardProject.Entity.Card;
import com.example.InsuranceCardProject.Entity.Category;
import com.example.InsuranceCardProject.Repository.CardRepository;
import com.example.InsuranceCardProject.Repository.CategoryRepository;
import com.example.InsuranceCardProject.Service.CardService;
import com.example.InsuranceCardProject.dto.RequestCardDTO;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {
    private  final CardRepository cardRepository;
    private  final CategoryRepository categoryRepository;
    @Override
    public Card addNewCard(RequestCardDTO requestCardDTO) {
        Category category =  categoryRepository.findById(requestCardDTO.getCategoryId()).get();
        Card card = new Card();
        card.setCategory(category);
        card.setPrice(requestCardDTO.getPrice());
        card.setCompensationRate(requestCardDTO.getCompensationRate());
        card.setDescription(requestCardDTO.getDescription());
        card.setExpirationInterval(requestCardDTO.getExpirationInterval());
        return cardRepository.save(card);
    }

    @Override
    public List<Card> getAllCard() {
        return cardRepository.findAll();
    }

    @Override
    public Card updateCard(Integer id, RequestCardDTO requestCardDTO) {
        Category category =  categoryRepository.findById(requestCardDTO.getCategoryId()).get();
        Card card = cardRepository.findById(id).get();
        card.setCategory(category);
        card.setPrice(requestCardDTO.getPrice());
        card.setCompensationRate(requestCardDTO.getCompensationRate());
        card.setDescription(requestCardDTO.getDescription());
        card.setExpirationInterval(requestCardDTO.getExpirationInterval());
        return cardRepository.save(card);
    }

    @Override
    public void deleteCard(Integer id) {
        Card card = cardRepository.findById(id).get();
        cardRepository.delete(card);
    }
}
