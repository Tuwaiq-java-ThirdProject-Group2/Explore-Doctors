package com.example.demo.Contract;

import com.example.demo.Hospital.Hospital;
import com.example.demo.Hospital.HospitalServies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "contract")
public class ContractController {
    private final ContractServies contractServies;

    @Autowired
    public ContractController(ContractServies contractServies) {
        this.contractServies = contractServies;
    }

    @GetMapping
    private List<Contract> gitContracts() {
        return contractServies.gitContracts();
    }

    @GetMapping("/{id}")
    public Contract gitContract(@PathVariable String id) {
        return contractServies.gitContract(id);

    }

    @PostMapping
    public Contract createContract(@RequestBody Contract contract) {
        return contractServies.createContract(contract);
    }

    @DeleteMapping("/{id}")
    public void deleteContract(@PathVariable String id) {
        contractServies.deleteContract(id);

    }

    @DeleteMapping("/deleteAll")
    public void deleteAllContract() {
        contractServies.deleteAllContract();

    }

    @PutMapping("/{id}")
    public void updateContract(@PathVariable String id, @RequestBody Contract data) {
        contractServies.updateContract(id, data);
    }


}
