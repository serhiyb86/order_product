package com.hybrisAcademy.ciklum.service;

import com.hybrisAcademy.ciklum.model.Products;
import com.hybrisAcademy.ciklum.model.responses.ProductsByOrderResponse;
import com.hybrisAcademy.ciklum.model.responses.ProductsResponse;
import com.hybrisAcademy.ciklum.repository.ProductsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService {
    private static final Logger logger = LoggerFactory.getLogger(ProductsServiceImpl.class);
    @Autowired
    private ProductsRepository productsRepository;
    @Autowired
    private OrdersItemsService ordersItemsService;


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
    @Transactional
    @Modifying
    public void removeById(int id) {
        ordersItemsService.removeOrderItemsByProductId(id);
        productsRepository.deleteById(id);
    }

    @Override
    @Transactional
    @Modifying
    public void removeAllProducts() {
        productsRepository.deleteAll();
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
