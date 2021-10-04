package com.hybrisAcademy.ciklum.service;

import com.hybrisAcademy.ciklum.model.Products;
import com.hybrisAcademy.ciklum.model.responses.ProductsByOrderResponse;
import com.hybrisAcademy.ciklum.model.responses.ProductsResponse;

import java.util.List;

public interface ProductsService {
    Products create(Products product);

    Products getById(int id);

    void removeById(int id);

    void removeAllProducts();

    List<Products> allProducts();

    List<ProductsResponse> getOrderedProductsList();

    List<ProductsByOrderResponse> getListProductByOrderResponse();
}
