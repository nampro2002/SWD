package com.example.InsuranceCardProject.Controller;

import com.example.InsuranceCardProject.Entity.AccidentEvidence;
import com.example.InsuranceCardProject.Entity.Card;
import com.example.InsuranceCardProject.Service.AccidentEvidenceService;
import com.example.InsuranceCardProject.Service.CardService;
import com.example.InsuranceCardProject.dto.RequestCardDTO;
import com.example.InsuranceCardProject.dto.RequestEvidenceDTO;
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
public class AccidentEvidenceController {
    private final AccidentEvidenceService accidentEvidenceService;
    @PostMapping("/addEvidence")
    public AccidentEvidence addEvidence(@RequestBody RequestEvidenceDTO requestEvidenceDTO) {
        System.out.println("add");
        return accidentEvidenceService.addNewEvidence(requestEvidenceDTO);
    }
    @GetMapping("/getEvidence")
    public List<AccidentEvidence> getEvidence() {
        System.out.println("get");
        return accidentEvidenceService.getAllEvidence();
    }
    @PutMapping("/evidence/{id}")
    public AccidentEvidence updateEvidence(@PathVariable Integer id, @RequestBody RequestEvidenceDTO requestEvidenceDTO) {
        System.out.println("update");
        return accidentEvidenceService.updateEvidence(id, requestEvidenceDTO);
    }
    @DeleteMapping("/evidence/{id}")
    public ResponseEntity deleteEvidence(@PathVariable Integer id) {
        System.out.println("delete");
        accidentEvidenceService.deleteEvidence(id);
        return ResponseEntity.ok("delete ok");
    }
}
