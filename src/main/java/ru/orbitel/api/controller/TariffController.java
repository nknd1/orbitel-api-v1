package ru.orbitel.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.orbitel.api.DTO.TariffDTO;
import ru.orbitel.api.repository.TariffRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tariffs")
public class TariffController {
    private final TariffRepository tariffRepository;

    public TariffController(TariffRepository tariffRepository) {
        this.tariffRepository = tariffRepository;
    }

    @GetMapping("/")
    public List<TariffDTO> getAllTariffs() {
        return tariffRepository.findAll().stream()
                .map(tariffsRecord -> new TariffDTO(
                    tariffsRecord.getTariffId(),
                    tariffsRecord.getTariffName(),
                    tariffsRecord.getPricePerMonth(),
                    tariffsRecord.getSpeed()))
                .collect(Collectors.toList());
    }
}

