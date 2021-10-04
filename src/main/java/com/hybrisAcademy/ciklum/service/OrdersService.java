package com.hybrisAcademy.ciklum.service;

import com.hybrisAcademy.ciklum.model.Orders;

public interface OrdersService {

    Orders readById(int id);

    Orders createOrder();


}
