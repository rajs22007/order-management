package com.flexi.siesta.ordermanagement.common;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.util.UUID;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MetaData {
    @Id
    @Setter(AccessLevel.PROTECTED)
    private UUID id = UUID.randomUUID();
    private String metaId;
    private String metaType;
    // https://stackoverflow.com/questions/50363639/how-spring-boot-jpahibernate-saves-images
    @Lob
    private Byte[] data;
}
