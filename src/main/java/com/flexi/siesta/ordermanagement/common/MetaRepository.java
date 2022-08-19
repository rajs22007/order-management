package com.flexi.siesta.ordermanagement.common;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MetaRepository extends JpaRepository<MetaData, String> {
    @Query(value = "select m.id from MetaData m WHERE m.metaId = :metaId")
    List<String> findIdByMetaId(String metaId);
}
