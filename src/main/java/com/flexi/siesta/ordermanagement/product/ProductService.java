package com.flexi.siesta.ordermanagement.product;

import com.flexi.siesta.ordermanagement.common.MetaData;
import com.flexi.siesta.ordermanagement.common.MetaRepository;
import com.flexi.siesta.ordermanagement.exception.ImageNotFoundException;
import com.flexi.siesta.ordermanagement.exception.ProductNotFoundException;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Product Service deals with product lifecycle,
 * including all CRUD operation with future scope of
 * filters support, caching techniques, catalog binding etc
 */
@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final MetaRepository metaRepository;
    private final ProductMapper productMapper;


    @Autowired
    public ProductService(ProductRepository productRepository, MetaRepository metaRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.metaRepository = metaRepository;
        this.productMapper = productMapper;
    }

    /**
     * @return Fetches all the products along with media links
     */
    public List<ProductResponse> getProducts() {
        return productRepository.findAll().stream().map(product -> {
            ProductResponse productResponse = productMapper.toProductResponse(product);
            if (product.getHasMetaData()) {
                List<String> allIdByMetaId = metaRepository.findIdByMetaId(product.getProductCode());
                productResponse.setProductImage(productMapper.toImageURIs(allIdByMetaId, product.getProductCode()));
            }
            return productResponse;
        }).collect(Collectors.toList());
    }

    public ProductResponse getProduct(String productCode) {
        return productRepository.findOneByProductCode(productCode).map(product -> {
            ProductResponse productResponse = productMapper.toProductResponse(product);
            if (product.getHasMetaData()) {
                List<String> allIdByMetaId = metaRepository.findIdByMetaId(product.getProductCode());
                productResponse.setProductImage(productMapper.toImageURIs(allIdByMetaId, product.getProductCode()));
            }
            return productResponse;
        }).orElseThrow(() -> new ProductNotFoundException("Product Not Found for productCode=" + productCode));
    }


    /**
     * @param productRequest Product Creation Request with product and attachments
     * @return returns the product code to be used to generate location of product
     */
    @Transactional
    public String createProduct(ProductRequest productRequest) {
        List<MetaData> metaDataList = productMapper.metaDataMapper(productRequest);
        Boolean hasMetaData = Boolean.FALSE;
        if (!metaDataList.isEmpty()) {
            metaRepository.saveAllAndFlush(metaDataList);
            hasMetaData = Boolean.TRUE;
        }
        Product product = productRepository.saveAndFlush(productMapper.toProduct(productRequest, hasMetaData));

        return product.getProductCode();
    }

    /**
     * @param productCode product code associated with image
     * @param imageId     image id for the image
     * @return Pair of image and fileName
     */
    public Pair<byte[], String> getImageByProductCodeAndImageId(String productCode, String imageId) {
        Optional<MetaData> metaData = metaRepository.findById(imageId);
        return metaData
                .map(meta -> Pair.of(ArrayUtils.toPrimitive(meta.getData()), meta.getFileName()))
                .orElseThrow(() -> new ImageNotFoundException("Image Not Found for productCode=" + productCode + ", imageId=" + imageId));
    }

}
