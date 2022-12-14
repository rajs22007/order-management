package com.flexi.siesta.ordermanagement.config;

import com.flexi.siesta.ordermanagement.dto.AuditInfoResponse;
import com.flexi.siesta.ordermanagement.entity.MetaData;
import com.flexi.siesta.ordermanagement.entity.Product;
import com.flexi.siesta.ordermanagement.dto.ProductResponse;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ApplicationConfig {

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public ProductResponse productResponse() {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setAudit(new AuditInfoResponse());
        return productResponse;
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Product product() {
        return new Product();
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public MetaData metaData() {
        return new MetaData();
    }

}
