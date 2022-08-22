package com.flexi.siesta.ordermanagement.repository;

import com.flexi.siesta.ordermanagement.entity.MetaData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MetaRepository extends JpaRepository<MetaData, String> {
    @Query(value = "select m.id from MetaData m WHERE m.metaId = :metaId")
    List<String> findIdByMetaId(String metaId);

    List<MetaData> findAllByMetaId(String metaId);
}
