package com.example.InsuranceCardProject.Service;

import com.example.InsuranceCardProject.Entity.Category;
import com.example.InsuranceCardProject.Entity.Participant;
import com.example.InsuranceCardProject.dto.RequestParticipantDTO;
import java.util.List;

public interface ParticipantService {

    Participant addNewParticipant(RequestParticipantDTO requestParticipantDTO);

    List<Participant> getAllParticipant();

    Participant updateParticipant(Integer id, RequestParticipantDTO requestParticipantDTO);

    void deleteParticipant(Integer id);
}
