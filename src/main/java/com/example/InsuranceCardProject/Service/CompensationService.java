package com.example.InsuranceCardProject.Service;

import com.example.InsuranceCardProject.Entity.Compensation;
import com.example.InsuranceCardProject.dto.RequestCompensationDTO;
import java.util.List;

public interface CompensationService {

    Compensation addNewCompensation(RequestCompensationDTO requestCompensationDTO);

    List<Compensation> getAllCompensation();

    List<Compensation> getCompensationByAccId(Integer id);

    Compensation updateCompensation(Integer id, RequestCompensationDTO requestCompensationDTO);

    void deleteCompensation(Integer id);
}
