package com.example.InsuranceCardProject.Service.ServiceImpl;

import com.example.InsuranceCardProject.Entity.Card;
import com.example.InsuranceCardProject.Entity.Contract;
import com.example.InsuranceCardProject.Entity.Participant;
import com.example.InsuranceCardProject.Entity.User;
import com.example.InsuranceCardProject.Repository.CardRepository;
import com.example.InsuranceCardProject.Repository.ContractRepository;
import com.example.InsuranceCardProject.Repository.ParticipantRepository;
import com.example.InsuranceCardProject.Repository.UserRepository;
import com.example.InsuranceCardProject.Service.ContractService;
import com.example.InsuranceCardProject.dto.RequestContractDTO;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContractServiceImpl implements ContractService {
    private final ContractRepository contractRepository;
    private final ParticipantRepository participantRepository;
    private final CardRepository cardRepository;
    private final UserRepository userRepository;
    @Override
    public Contract addNewContract(RequestContractDTO requestContractDTO) {
        User user = userRepository.findById(requestContractDTO.getUserId()).get();
        Card card = cardRepository.findById(requestContractDTO.getCardId()).get();
        Participant participant = participantRepository.findById(
                requestContractDTO.getParticipantId()).get();
        Contract contract = new Contract();
        contract.setUser(user);
        contract.setCard(card);
        contract.setParticipant(participant);
        contract.setCode(requestContractDTO.getCode());
        contract.setActiveDate(requestContractDTO.getActiveDate());
        contract.setRefreshDate(requestContractDTO.getRefreshDate());
        contract.setActive(false);
        contract.setContinuousYear(requestContractDTO.getContinuousYear());
        return contractRepository.save(contract);

    }

    @Override
    public List<Contract> getAllContract() {
        return contractRepository.findAll();
    }

    @Override
    public Contract updateContract(Integer id, RequestContractDTO requestContractDTO) {
        Contract contract = contractRepository.findById(id).get();
        contract.setCode(requestContractDTO.getCode());
        contract.setActiveDate(requestContractDTO.getActiveDate());
        contract.setRefreshDate(requestContractDTO.getRefreshDate());
        contract.setActive(false);
        contract.setContinuousYear(requestContractDTO.getContinuousYear());
        return contractRepository.save(contract);
    }

    @Override
    public void deleteContract(Integer id) {
        Contract contract = contractRepository.findById(id).get();
        contractRepository.delete(contract);
    }

    @Override
    public Contract activeContract(Integer id) {
        Contract contract = contractRepository.findById(id).get();
        contract.setActive(true);
      return contractRepository.save(contract);
    }
}
