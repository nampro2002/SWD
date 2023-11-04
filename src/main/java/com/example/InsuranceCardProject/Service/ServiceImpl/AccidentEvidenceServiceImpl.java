package com.example.InsuranceCardProject.Service.ServiceImpl;

import com.example.InsuranceCardProject.Entity.Accident;
import com.example.InsuranceCardProject.Entity.AccidentEvidence;
import com.example.InsuranceCardProject.Repository.AccidentEvidenceRepository;
import com.example.InsuranceCardProject.Repository.AccidentRepository;
import com.example.InsuranceCardProject.Service.AccidentEvidenceService;
import com.example.InsuranceCardProject.dto.RequestEvidenceDTO;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccidentEvidenceServiceImpl implements AccidentEvidenceService {

    private final AccidentEvidenceRepository accidentEvidenceRepository;
    private final AccidentRepository accidentRepository;
    @Override
    public AccidentEvidence addNewEvidence(RequestEvidenceDTO requestEvidenceDTO) {
        Accident accident = accidentRepository.findById(requestEvidenceDTO.getAccidentId()).get();
        AccidentEvidence accidentEvidence = new AccidentEvidence();
        accidentEvidence.setAccident(accident);
        accidentEvidence.setInjuryEvidence(requestEvidenceDTO.getInjuryEvidence());
        accidentEvidence.setMedicalReport(requestEvidenceDTO.getMedicalReport());
        accidentEvidence.setMedicineReceipt(requestEvidenceDTO.getMedicineReceipt());
        return accidentEvidenceRepository.save(accidentEvidence);
    }

    @Override
    public List<AccidentEvidence> getAllEvidence() {
        return accidentEvidenceRepository.findAll();
    }

    @Override
    public AccidentEvidence updateEvidence(Integer id, RequestEvidenceDTO requestEvidenceDTO) {
        AccidentEvidence accidentEvidence =accidentEvidenceRepository.findById(id).get();
        accidentEvidence.setInjuryEvidence(requestEvidenceDTO.getInjuryEvidence());
        accidentEvidence.setMedicalReport(requestEvidenceDTO.getMedicalReport());
        accidentEvidence.setMedicineReceipt(requestEvidenceDTO.getMedicineReceipt());
        return accidentEvidenceRepository.save(accidentEvidence);
    }

    @Override
    public void deleteEvidence(Integer id) {
        AccidentEvidence accidentEvidence =accidentEvidenceRepository.findById(id).get();
        accidentEvidenceRepository.delete(accidentEvidence);
    }
}
