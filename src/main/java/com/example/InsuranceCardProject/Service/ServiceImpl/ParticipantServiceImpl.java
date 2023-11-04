package com.example.InsuranceCardProject.Service.ServiceImpl;

import com.example.InsuranceCardProject.Entity.Category;
import com.example.InsuranceCardProject.Entity.Participant;
import com.example.InsuranceCardProject.Repository.ParticipantRepository;
import com.example.InsuranceCardProject.Service.ParticipantService;
import com.example.InsuranceCardProject.dto.RequestParticipantDTO;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ParticipantServiceImpl implements ParticipantService {

    private final ParticipantRepository participantRepository;
    @Override
    public Participant addNewParticipant(RequestParticipantDTO requestParticipantDTO) {
        Participant participant = new Participant();
        participant.setName(requestParticipantDTO.getName());
        participant.setDateOfBirth(requestParticipantDTO.getDateOfBirth());
        participant.setIdNumber(requestParticipantDTO.getIdNumber());
        participant.setAddress(requestParticipantDTO.getAddress());
        participant.setGender(requestParticipantDTO.isGender());
        return participantRepository.save(participant);
    }

    @Override
    public List<Participant> getAllParticipant() {
        return participantRepository.findAll();
    }

    @Override
    public Participant updateParticipant(Integer id, RequestParticipantDTO requestParticipantDTO) {
        Participant participant = participantRepository.findById(id).get();
        participant.setName(requestParticipantDTO.getName());
        participant.setDateOfBirth(requestParticipantDTO.getDateOfBirth());
        participant.setIdNumber(requestParticipantDTO.getIdNumber());
        participant.setAddress(requestParticipantDTO.getAddress());
        participant.setGender(requestParticipantDTO.isGender());
        return participantRepository.save(participant);
    }

    @Override
    public void deleteParticipant(Integer id) {
        Participant participant = participantRepository.findById(id).get();
        participantRepository.delete(participant);
    }
}
