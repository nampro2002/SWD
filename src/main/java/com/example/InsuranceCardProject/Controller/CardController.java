package com.example.InsuranceCardProject.Controller;

import com.example.InsuranceCardProject.Entity.Card;
import com.example.InsuranceCardProject.Entity.Category;
import com.example.InsuranceCardProject.Service.CardService;
import com.example.InsuranceCardProject.Service.CategoryService;
import com.example.InsuranceCardProject.dto.RequestCardDTO;
import com.example.InsuranceCardProject.dto.RequestCategoryDTO;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;
    @PostMapping("/addCard")
    public Card addCategory(@RequestBody RequestCardDTO requestCardDTO) {
        System.out.println("add");
        return cardService.addNewCard(requestCardDTO);
    }
    @GetMapping("/getCard")
    public List<Card> getCard() {
        System.out.println("get");
        return cardService.getAllCard();
    }
    @PutMapping("/card/{id}")
    public Card updateCard(@PathVariable Integer id, @RequestBody RequestCardDTO RequestCardDTO) {
        System.out.println("update");
        return cardService.updateCard(id, RequestCardDTO);
    }
    @DeleteMapping("/card/{id}")
    public ResponseEntity deleteCategory(@PathVariable Integer id) {
        System.out.println("delete");
        cardService.deleteCard(id);
        return ResponseEntity.ok("delete ok");
    }
}
