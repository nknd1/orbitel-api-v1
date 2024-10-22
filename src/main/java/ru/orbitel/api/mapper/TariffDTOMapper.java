package ru.orbitel.api.mapper;
import org.springframework.stereotype.Service;
import ru.orbitel.api.DTO.TariffDTO;
import ru.orbitel.jooq.generated.public_.tables.records.TariffsRecord;

import java.util.function.Function;


@Service
public class TariffDTOMapper implements Function<TariffsRecord, TariffDTO> {
    @Override
    public TariffDTO apply(TariffsRecord tariffsRecord) {
        return new TariffDTO(
                tariffsRecord.getTariffId(),
                tariffsRecord.getTariffName(),
                tariffsRecord.getPricePerMonth(),
                tariffsRecord.getSpeed());
    }
}
