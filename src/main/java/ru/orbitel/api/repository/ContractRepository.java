package ru.orbitel.api.repository;

import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;

import static ru.orbitel.jooq.generated.public_.tables.Contracts.CONTRACTS;

@Repository(value = "contractRepository")
public class ContractRepository {
    private final DSLContext dslContext;

    public ContractRepository(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    public List<ru.orbitel.jooq.generated.public_.tables.records.ContractsRecord> findAll() {
        return dslContext.selectFrom(ru.orbitel.jooq.generated.public_.Tables.CONTRACTS)
                .orderBy(CONTRACTS.CONTRACT_ID.asc())
                .fetch();
    }

}
