package com.example.InsuranceCardProject.Service;

import com.example.InsuranceCardProject.Entity.Contract;
import com.example.InsuranceCardProject.Entity.Participant;
import com.example.InsuranceCardProject.dto.RequestContractDTO;
import java.util.List;

public interface ContractService {

    Contract addNewContract(RequestContractDTO requestContractDTO);

    List<Contract> getAllContract();

    Contract updateContract(Integer id, RequestContractDTO requestContractDTO);

    void deleteContract(Integer id);

    Contract activeContract(Integer id);
}
