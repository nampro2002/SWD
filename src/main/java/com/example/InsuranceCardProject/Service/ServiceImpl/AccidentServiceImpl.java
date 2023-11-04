package com.example.InsuranceCardProject.Service.ServiceImpl;

import com.example.InsuranceCardProject.Entity.Accident;
import com.example.InsuranceCardProject.Entity.Card;
import com.example.InsuranceCardProject.Entity.Contract;
import com.example.InsuranceCardProject.Entity.Participant;
import com.example.InsuranceCardProject.Repository.AccidentRepository;
import com.example.InsuranceCardProject.Repository.ContractRepository;
import com.example.InsuranceCardProject.Repository.ParticipantRepository;
import com.example.InsuranceCardProject.Service.AccidentService;
import com.example.InsuranceCardProject.dto.RequestAccidentDTO;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccidentServiceImpl implements AccidentService {
    private final ParticipantRepository participantRepository;
    private final ContractRepository contractRepository;
    private final AccidentRepository accidentRepository;
    @Override
    public Accident addNewAccident(RequestAccidentDTO requestAccidentDTO) {
        Participant participant = participantRepository.findById(requestAccidentDTO.getParticipantId()).get();
        Contract contract = contractRepository.findById(requestAccidentDTO.getContractId()).get();
        Accident accident = new Accident();
        accident.setContract(contract);
        accident.setParticipant(participant);
        accident.setCode(requestAccidentDTO.getCode());
        accident.setDate(requestAccidentDTO.getDate());
        accident.setDescription(requestAccidentDTO.getDescription());

        return accidentRepository.save(accident);
    }

    @Override
    public List<Accident> getAllAccident() {
        return accidentRepository.findAll();
    }

    @Override
    public List<Accident> getAccidentByParId(Integer id) {
        return accidentRepository.findByParId(id);
    }

    @Override
    public Accident updateAccident(Integer id, RequestAccidentDTO requestAccidentDTO) {
        Accident accident = accidentRepository.findById(id).get();
        accident.setCode(requestAccidentDTO.getCode());
        accident.setDate(requestAccidentDTO.getDate());
        accident.setDescription(requestAccidentDTO.getDescription());
        return accidentRepository.save(accident);
    }

    @Override
    public void deleteAccident(Integer id) {
        Accident accident = accidentRepository.findById(id).get();
         accidentRepository.delete(accident);
    }
}
