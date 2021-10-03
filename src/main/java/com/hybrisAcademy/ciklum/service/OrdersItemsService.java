package com.hybrisAcademy.ciklum.service;

import com.hybrisAcademy.ciklum.model.OrderItems;

public interface OrdersItemsService {


    OrderItems findOrderItemsBy2Id(int orderId, int productId);

    OrderItems addProductToOrder(int orderId, int productId, int quantity);

    void removeOrederItems(OrderItems orderItem);
}
