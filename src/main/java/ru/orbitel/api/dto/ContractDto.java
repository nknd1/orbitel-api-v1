package ru.orbitel.api.DTO;


import java.math.BigDecimal;

public record ContractDTO(
        long contractId,
        String connectAddress,
        BigDecimal Balance,
        String contractNumber,
        String personalAccount
) {
}
