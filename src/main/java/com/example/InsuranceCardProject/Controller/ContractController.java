package com.example.InsuranceCardProject.Controller;

import com.example.InsuranceCardProject.Entity.Contract;
import com.example.InsuranceCardProject.Entity.Participant;
import com.example.InsuranceCardProject.Service.ContractService;
import com.example.InsuranceCardProject.dto.RequestContractDTO;
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
public class ContractController {
    private final ContractService contractService;
    @PostMapping("/addContract")
    public Contract addContract(@RequestBody RequestContractDTO requestContractDTO) {
        System.out.println("add");
        return contractService.addNewContract(requestContractDTO);
    }
    @GetMapping("/getContract")
    public List<Contract> getContract() {
        System.out.println("get");
        return contractService.getAllContract();
    }
    @PutMapping("/contract/{id}")
    public Contract updateContract(@PathVariable Integer id, @RequestBody RequestContractDTO requestContractDTO) {
        System.out.println("update");
        return contractService.updateContract(id, requestContractDTO);
    }
    @PutMapping("/contract/{id}")
    public Contract activeContract(@PathVariable Integer id) {
        System.out.println("update");
        return contractService.activeContract(id);
    }
    @DeleteMapping("/contract/{id}")
    public ResponseEntity deleteContract(@PathVariable Integer id) {
        System.out.println("delete");
        contractService.deleteContract(id);
        return ResponseEntity.ok("delete ok");
    }
}
