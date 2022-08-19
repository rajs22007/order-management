package com.flexi.siesta.ordermanagement.common;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MetaRepository extends JpaRepository<MetaData, UUID> {
    @Query(value = "select m.id from MetaData m WHERE m.metaId = :metaId")
    List<UUID> findIdByMetaId(String metaId);
    @Query(value = "select m.data from MetaData m WHERE m.id = :id")
    Byte[] findDataByIdAndMetaId(UUID id);
}
