package com.example.InsuranceCardProject.Service;

import com.example.InsuranceCardProject.Entity.AccidentEvidence;
import com.example.InsuranceCardProject.Entity.Card;
import com.example.InsuranceCardProject.dto.RequestEvidenceDTO;
import java.util.List;

public interface AccidentEvidenceService {

    AccidentEvidence addNewEvidence(RequestEvidenceDTO requestEvidenceDTO);

    List<AccidentEvidence> getAllEvidence();

    AccidentEvidence updateEvidence(Integer id, RequestEvidenceDTO requestEvidenceDTO);

    void deleteEvidence(Integer id);
}
