package com.example.InsuranceCardProject.Service;

import com.example.InsuranceCardProject.Entity.Accident;
import com.example.InsuranceCardProject.Entity.Card;
import com.example.InsuranceCardProject.dto.RequestAccidentDTO;
import java.util.List;

public interface AccidentService {

    Accident addNewAccident(RequestAccidentDTO requestAccidentDTO);

    List<Accident> getAllAccident();

    List<Accident> getAccidentByParId(Integer id);

    Accident updateAccident(Integer id, RequestAccidentDTO requestAccidentDTO);

    void deleteAccident(Integer id);
}
