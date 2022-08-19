package com.flexi.siesta.ordermanagement.product;

import com.flexi.siesta.ordermanagement.common.MetaData;
import com.flexi.siesta.ordermanagement.common.MetaRepository;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final MetaRepository metaRepository;
    private final ObjectFactory<ProductResponse> productResponseObjectFactory;
    private final ObjectFactory<Product> productObjectFactory;
    private final ObjectFactory<MetaData> metaDataObjectFactory;

    @Autowired
    public ProductService(ProductRepository productRepository, MetaRepository metaRepository, ObjectFactory<ProductResponse> productResponseObjectFactory, ObjectFactory<Product> productObjectFactory, ObjectFactory<MetaData> metaDataObjectFactory) {
        this.productRepository = productRepository;
        this.metaRepository = metaRepository;
        this.productResponseObjectFactory = productResponseObjectFactory;
        this.productObjectFactory = productObjectFactory;
        this.metaDataObjectFactory = metaDataObjectFactory;
    }

    public List<ProductResponse> getProducts() {
        return productRepository.findAll().stream().map(this::productResponseMapper).collect(Collectors.toList());
    }

    private ProductResponse productResponseMapper(Product product) {
        ProductResponse productResponse = productResponseObjectFactory.getObject();
        BeanUtils.copyProperties(product, productResponse);
        BeanUtils.copyProperties(product, productResponse.getAudit());
        if (product.getMetaData()) {
            List<UUID> allIdByMetaId = metaRepository.findIdByMetaId(product.getProductCode());
            /*List<URI> uris = allIdByMetaId.stream()
                    .map(uuid -> URI.create("/siesta/api/product/" + product.getProductCode() + "/image/" + uuid.toString()))
                    .collect(Collectors.toList());*/
            List<URI> uris = allIdByMetaId.stream()
                    .map(uuid -> ServletUriComponentsBuilder.fromCurrentRequest()
                            .replacePath("/siesta/api/product/{productCode}/image/{imageId}")
                            .buildAndExpand(product.getProductCode(), uuid.toString())
                            .toUri())
                    .collect(Collectors.toList());
            productResponse.setProductImage(uris);
        }
        return productResponse;
    }

    @Transactional
    public String createProduct(ProductRequest productRequest) {
        List<MetaData> metaDataList = metaDataMapper(productRequest);
        Boolean hasMetaData = Boolean.FALSE;
        if (!metaDataList.isEmpty()) {
            metaRepository.saveAllAndFlush(metaDataList);
            hasMetaData = Boolean.TRUE;
        }
        Product product = productRepository.saveAndFlush(productMapper(productRequest, hasMetaData));

        return product.getProductCode();
    }

    public byte[] getImageByProductCodeAndImageId(String productCode, String imageId) {
        List<MetaData> metaData = metaRepository.findAll();
        Byte[] data = metaData.stream()
                .filter(md -> md.getMetaId().equals(productCode)
                        && md.getId().toString().equals(imageId)).findFirst().map(MetaData::getData)
                .orElse(ArrayUtils.toObject(new byte[0]));
        return ArrayUtils.toPrimitive(data);
    }

    private Product productMapper(ProductRequest productRequest, Boolean hasMetaData) {
        Product product = productObjectFactory.getObject();
        BeanUtils.copyProperties(productRequest, product);
        product.setMetaData(hasMetaData);
        return product;
    }

    private List<MetaData> metaDataMapper(ProductRequest productRequest) {
        if (ArrayUtils.isEmpty(productRequest.getProductImages())) {
            return Collections.emptyList();
        }

        List<MetaData> metaDataList = new ArrayList<>();
        for (var image : productRequest.getProductImages()) {
            MetaData metaData = metaDataObjectFactory.getObject();
            metaData.setMetaId(productRequest.getProductCode());
            metaData.setMetaType(productRequest.getProductCategory());
            try {
                metaData.setData(ArrayUtils.toObject(image.getBytes()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            metaDataList.add(metaData);
        }
        return metaDataList;
    }
}
