package ru.orbitel.api.repository;

import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import ru.orbitel.jooq.generated.public_.tables.Tariffs;

import java.util.List;

@Repository("tariffRepository")
public class TariffRepository {

    private final DSLContext dslContext;


    public TariffRepository(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    public List<ru.orbitel.jooq.generated.public_.tables.records.TariffsRecord> findAll() {
        return dslContext.selectFrom(Tariffs.TARIFFS).fetch();
    }
}