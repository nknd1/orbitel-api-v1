package ru.orbitel.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.orbitel.api.DTO.TariffDTO;
import ru.orbitel.api.mapper.TariffDTOMapper;
import ru.orbitel.api.repository.TariffRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tariffs")
public class TariffController {
    private final TariffRepository tariffRepository;
    private final TariffDTOMapper tariffDTOMapper;

    public TariffController(TariffRepository tariffRepository, TariffDTOMapper tariffDTOMapper) {
        this.tariffRepository = tariffRepository;
        this.tariffDTOMapper = tariffDTOMapper;
    }

    @GetMapping("/")
    public List<TariffDTO> getAllTariffs() {
        return tariffRepository.findAll().stream()
                .map(tariffDTOMapper).collect(Collectors.toList());
    }
}

