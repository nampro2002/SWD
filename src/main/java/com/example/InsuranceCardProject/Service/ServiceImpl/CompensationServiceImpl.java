package com.example.InsuranceCardProject.Service.ServiceImpl;

import com.example.InsuranceCardProject.Entity.Accident;
import com.example.InsuranceCardProject.Entity.Compensation;
import com.example.InsuranceCardProject.Repository.AccidentRepository;
import com.example.InsuranceCardProject.Repository.CompensationRepository;
import com.example.InsuranceCardProject.Service.CompensationService;
import com.example.InsuranceCardProject.dto.RequestCompensationDTO;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompensationServiceImpl implements CompensationService {

    private final CompensationRepository compensationRepository;
    private final AccidentRepository accidentRepository;

    @Override
    public Compensation addNewCompensation(RequestCompensationDTO requestCompensationDTO) {
        Accident accident = accidentRepository.findById(requestCompensationDTO.getAccidentId()).get();
        Compensation compensation = new Compensation();
        compensation.setAccident(accident);
        compensation.setStatus(requestCompensationDTO.getStatus());
        compensation.setDescription(requestCompensationDTO.getDescription());
        compensation.setResponseDate(requestCompensationDTO.getResponseDate());
        return compensationRepository.save(compensation);
    }

    @Override
    public List<Compensation> getAllCompensation() {
        return compensationRepository.findAll();
    }

    @Override
    public List<Compensation> getCompensationByAccId(Integer id) {
        return compensationRepository.findByAccidentId(id);
    }

    @Override
    public Compensation updateCompensation(Integer id,
            RequestCompensationDTO requestCompensationDTO) {
        Compensation compensation = compensationRepository.findById(id).get();
        compensation.setStatus(requestCompensationDTO.getStatus());
        compensation.setDescription(requestCompensationDTO.getDescription());
        compensation.setResponseDate(requestCompensationDTO.getResponseDate());
        return compensationRepository.save(compensation);
    }

    @Override
    public void deleteCompensation(Integer id) {
        Compensation compensation = compensationRepository.findById(id).get();
         compensationRepository.delete(compensation);
    }
}
