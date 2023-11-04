package com.example.InsuranceCardProject.Controller;

import com.example.InsuranceCardProject.Entity.Accident;
import com.example.InsuranceCardProject.Entity.Compensation;
import com.example.InsuranceCardProject.Service.AccidentService;
import com.example.InsuranceCardProject.Service.CompensationService;
import com.example.InsuranceCardProject.dto.RequestAccidentDTO;
import com.example.InsuranceCardProject.dto.RequestCompensationDTO;
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
public class CompensationController {
    private final CompensationService compensationService;
    @PostMapping("/addCompensation")
    public Compensation addCompensation(@RequestBody RequestCompensationDTO requestCompensationDTO) {
        System.out.println("add");
        return compensationService.addNewCompensation(requestCompensationDTO);
    }
    @GetMapping("/getCompensation")
    public List<Compensation> getCompensation() {
        System.out.println("get");
        return compensationService.getAllCompensation();
    }
    @GetMapping("/getCompensation/{id}")
    public List<Compensation> getCompensationByAccId(@PathVariable Integer id) {
        System.out.println("get");
        return compensationService.getCompensationByAccId(id);
    }
    @PutMapping("/compensation/{id}")
    public Compensation updateCompensation(@PathVariable Integer id, @RequestBody RequestCompensationDTO requestCompensationDTO) {
        System.out.println("update");
        return compensationService.updateCompensation(id, requestCompensationDTO);
    }
    @DeleteMapping("/compensation/{id}")
    public ResponseEntity deleteCompensation(@PathVariable Integer id) {
        System.out.println("delete");
        compensationService.deleteCompensation(id);
        return ResponseEntity.ok("delete ok");
    }
}
