package com.example.InsuranceCardProject.Controller;

import com.example.InsuranceCardProject.Entity.Accident;
import com.example.InsuranceCardProject.Entity.Card;
import com.example.InsuranceCardProject.Service.AccidentService;
import com.example.InsuranceCardProject.dto.RequestAccidentDTO;
import com.example.InsuranceCardProject.dto.RequestCardDTO;
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
public class AccidentController {
   private final AccidentService accidentService;
    @PostMapping("/addAccident")
    public Accident addAccident(@RequestBody RequestAccidentDTO requestAccidentDTO) {
        System.out.println("add");
        return accidentService.addNewAccident(requestAccidentDTO);
    }
    @GetMapping("/getAccident")
    public List<Accident> getAccident() {
        System.out.println("get");
        return accidentService.getAllAccident();
    }
    @GetMapping("/getAccident/{id}")
    public List<Accident> getAccidentByParId(@PathVariable Integer id) {
        System.out.println("get");
        return accidentService.getAccidentByParId(id);
    }
    @PutMapping("/accident/{id}")
    public Accident updateCard(@PathVariable Integer id, @RequestBody RequestAccidentDTO requestAccidentDTO) {
        System.out.println("update");
        return accidentService.updateAccident(id, requestAccidentDTO);
    }
    @DeleteMapping("/accident/{id}")
    public ResponseEntity deleteAccident(@PathVariable Integer id) {
        System.out.println("delete");
        accidentService.deleteAccident(id);
        return ResponseEntity.ok("delete ok");
    }
}
