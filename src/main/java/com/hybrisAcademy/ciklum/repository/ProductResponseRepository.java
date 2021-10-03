package com.hybrisAcademy.ciklum.repository;

import com.hybrisAcademy.ciklum.model.responses.ProductsByOrderResponse;
import com.hybrisAcademy.ciklum.model.responses.ProductsResponse;

import java.util.List;

public interface ProductResponseRepository {

    List<ProductsResponse> listProductResponses();

    List<ProductsByOrderResponse> listProductByOrderResponse();


}
