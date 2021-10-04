package com.hybrisAcademy.ciklum.service;

import com.hybrisAcademy.ciklum.model.OrderItems;

public interface OrdersItemsService {


    OrderItems findOrderItemsBy2Id(int orderId, int productId);

    OrderItems addProductToOrder(int orderId, int productId, int quantity);

    void removeOrderItems(int orderId, int productId);

    OrderItems updateQuantity(int orderId, int productId, int quantity);

    void removeOrderItemsByProductId(int productId);

}
