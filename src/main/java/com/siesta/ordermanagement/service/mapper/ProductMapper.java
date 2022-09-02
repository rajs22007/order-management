package com.siesta.ordermanagement.service.mapper;

import com.siesta.ordermanagement.entity.MetaData;
import com.siesta.ordermanagement.entity.Product;
import com.siesta.ordermanagement.dto.ProductRequest;
import com.siesta.ordermanagement.dto.ProductResponse;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Initial mapper solution. Open for transformation with framework based mappers
 */
@Component
public class ProductMapper {

    private final ObjectFactory<ProductResponse> productResponseObjectFactory;
    private final ObjectFactory<Product> productObjectFactory;
    private final ObjectFactory<MetaData> metaDataObjectFactory;

    public ProductMapper(ObjectFactory<ProductResponse> productResponseObjectFactory, ObjectFactory<Product> productObjectFactory, ObjectFactory<MetaData> metaDataObjectFactory) {
        this.productResponseObjectFactory = productResponseObjectFactory;
        this.productObjectFactory = productObjectFactory;
        this.metaDataObjectFactory = metaDataObjectFactory;
    }


    public ProductResponse toProductResponse(Product product) {
        ProductResponse productResponse = productResponseObjectFactory.getObject();
        BeanUtils.copyProperties(product, productResponse);
        BeanUtils.copyProperties(product, productResponse.getAudit());
        return productResponse;
    }

    public List<URI> toImageURIs(List<String> imageIds, String productCode) {
        return imageIds.stream()
                .map(id -> ServletUriComponentsBuilder.fromCurrentRequest()
                        .replacePath("/siesta/api/product/{productCode}/image/{imageId}")
                        .buildAndExpand(productCode, id)
                        .toUri())
                .collect(Collectors.toList());
    }

    public Product toProduct(ProductRequest productRequest, Boolean hasMetaData) {
        Product product = productObjectFactory.getObject();
        BeanUtils.copyProperties(productRequest, product);
        product.setHasMetaData(hasMetaData);
        return product;
    }

    public List<MetaData> metaDataMapper(ProductRequest productRequest) {
        if (ArrayUtils.isEmpty(productRequest.getProductImages())) {
            return Collections.emptyList();
        }

        List<MetaData> metaDataList = new ArrayList<>();
        for (var image : productRequest.getProductImages()) {
            MetaData metaData = metaDataObjectFactory.getObject();
            metaData.setMetaId(productRequest.getProductCode());
            metaData.setMetaType(productRequest.getProductCategory());
            try {
                metaData.setFileName(image.getOriginalFilename());
                metaData.setData(ArrayUtils.toObject(image.getBytes()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            metaDataList.add(metaData);
        }
        return metaDataList;
    }
}
