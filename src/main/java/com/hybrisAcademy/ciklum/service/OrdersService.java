package com.hybrisAcademy.ciklum.service;

import com.hybrisAcademy.ciklum.model.OrderItems;
import com.hybrisAcademy.ciklum.model.Orders;

import java.util.List;

public interface OrdersService {

    Orders readById(int id);

    Orders createOrder();



}
