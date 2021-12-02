package com.example.demo.Contract;

import com.example.demo.Hospital.Hospital;
import com.example.demo.Hospital.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ContractServies {
    private final ContractRepository contractRepository;
    @Autowired
    public ContractServies(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }
    public List<Contract> gitContracts() {
        return contractRepository.findAll();
    }

    public Contract gitContract(String id) {
        Long contract_id = Long.parseLong(id);
        return contractRepository.findById(contract_id).orElse(null);
    }

    public Contract createContract(Contract contract) {
        return contractRepository.save(contract);
    }

    public void deleteContract(String id) {
        Long contract_id = Long.parseLong(id);
        contractRepository.deleteById(contract_id);
    }

    public void deleteAllContract() {
        contractRepository.deleteAll();
    }

    public void updateContract(String id, Contract data) {
        Long contract_id = Long.parseLong(id);
        Contract contract = contractRepository.findById(contract_id).orElse(null);
        if (contract != null) {
            contract.setStart_date(data.getStart_date());
            contract.setEnd_date(data.getEnd_date());
            contract.setOwner(data.getOwner());
            //contractRepository.save(con)
        }
    }
}



