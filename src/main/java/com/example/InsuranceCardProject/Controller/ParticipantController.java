package com.example.InsuranceCardProject.Controller;

import com.example.InsuranceCardProject.Entity.Category;
import com.example.InsuranceCardProject.Entity.Participant;
import com.example.InsuranceCardProject.Service.ParticipantService;
import com.example.InsuranceCardProject.dto.RequestCategoryDTO;
import com.example.InsuranceCardProject.dto.RequestParticipantDTO;
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
public class ParticipantController {
    private final ParticipantService participantService;
    @PostMapping("/addParticipant")
    public Participant addParticipant(@RequestBody RequestParticipantDTO requestParticipantDTO) {
        System.out.println("add");
        return participantService.addNewParticipant(requestParticipantDTO);
    }
    @GetMapping("/getParticipant")
    public List<Participant> getParticipant() {
        System.out.println("get");
        return participantService.getAllParticipant();
    }
    @PutMapping("/participant/{id}")
    public Participant updateParticipant(@PathVariable Integer id, @RequestBody RequestParticipantDTO requestParticipantDTO) {
        System.out.println("update");
        return participantService.updateParticipant(id, requestParticipantDTO);
    }
    @DeleteMapping("/participant/{id}")
    public ResponseEntity deleteParticipant(@PathVariable Integer id) {
        System.out.println("delete");
        participantService.deleteParticipant(id);
        return ResponseEntity.ok("delete ok");
    }
}
