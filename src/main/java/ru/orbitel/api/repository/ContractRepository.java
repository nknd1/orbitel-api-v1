package ru.orbitel.api.repository;

import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import ru.orbitel.jooq.generated.public_.tables.Contracts;
import ru.orbitel.jooq.generated.public_.tables.records.ContractsRecord;



@Repository(value = "contractRepository")
public class ContractRepository {

    private final DSLContext dslContext;

    public ContractRepository(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    public List<ContractsRecord> findAll() {
        return dslContext.selectFrom(Contracts.CONTRACTS)
                .orderBy(Contracts.CONTRACTS.CONTRACT_ID.asc())
                .fetch();
    }

}
