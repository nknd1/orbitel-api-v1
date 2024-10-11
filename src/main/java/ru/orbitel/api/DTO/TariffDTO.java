package ru.orbitel.api.DTO;

import java.math.BigDecimal;

public record TariffDTO(
     Long tariffId,
     String tariffName,
     BigDecimal pricePerMonth,
     String Speed
){}