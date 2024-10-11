package ru.orbitel.api.DTO;

import lombok.NonNull;

import java.math.BigDecimal;

public record ContractDTO(
        long contractId,
        @NonNull
        String connectAddress,
        BigDecimal Balance,
        @NonNull
        String contractNumber,
        @NonNull
        String personalAccount
) {
}
