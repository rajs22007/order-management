package com.siesta.ordermanagement.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.util.UUID;


@Entity//(name = "METADATA")
@Getter
@Setter
@NoArgsConstructor
public class MetaData {
    @Id
    @Setter(AccessLevel.PROTECTED)
    private String id = UUID.randomUUID().toString();
    private String metaId;
    private String metaType;
    // https://stackoverflow.com/questions/50363639/how-spring-boot-jpahibernate-saves-images
    @Lob
    private Byte[] data;
    private String fileName;
}
