package ru.orbitel.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.orbitel.api.DTO.ContractDTO;
import ru.orbitel.api.DTO.TariffDTO;
import ru.orbitel.api.repository.ContractRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/contracts")
public class ContractController {
    private final ContractRepository contractRepository;

    public ContractController(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }


    @GetMapping("/")
    public List<ContractDTO> getAllContracts() {
        return contractRepository.findAll().stream()
                .map(contractsRecord -> new ContractDTO(
                        contractsRecord.getContractId(),
                        contractsRecord.getConnectAddress(),
                        contractsRecord.getBalance(),
                        contractsRecord.getContractNumber(),
                        contractsRecord.getPersonalAccount()
                ))
                .collect(Collectors.toList());
    }
}
