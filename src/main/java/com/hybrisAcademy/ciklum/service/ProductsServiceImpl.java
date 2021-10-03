package com.hybrisAcademy.ciklum.service;

import com.hybrisAcademy.ciklum.model.Products;
import com.hybrisAcademy.ciklum.model.responses.ProductsByOrderResponse;
import com.hybrisAcademy.ciklum.model.responses.ProductsResponse;
import com.hybrisAcademy.ciklum.repository.ProductsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService {
    private static final Logger logger = LoggerFactory.getLogger(ProductsServiceImpl.class);
    @Autowired
    private ProductsRepository productsRepository;


    @Override
    public Products create(Products product) {
        logger.info("We have recieved product to service - > " + product);
        if (product != null) {
            return productsRepository.save(product);
        }
        throw new NullPointerException("Product cannot be null!");
    }

    @Override
    public Products getById(int id) {
        EntityNotFoundException exception = new EntityNotFoundException("Product with id " + id + " not found");
        return productsRepository.findById(id).orElseThrow(
                () -> exception);
    }

    @Override
    public void removeById(int id) {

    }

    @Override
    public void removeAll(String password) {

    }

    @Override
    public List<Products> productsByOrdersId(int id) {
        return null;
    }

    @Override
    public List<Products> allProducts() {

        return productsRepository.findAll();
    }

    @Override
    public List<ProductsResponse> getOrderedProductsList() {

        return productsRepository.listProductResponses();
    }

    @Override
    public List<ProductsByOrderResponse> getListProductByOrderResponse() {
        return productsRepository.listProductByOrderResponse();
    }
}
