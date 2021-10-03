package com.hybrisAcademy.ciklum.service;

import com.hybrisAcademy.ciklum.model.OrderItems;
import com.hybrisAcademy.ciklum.model.OrderItemsId;
import com.hybrisAcademy.ciklum.repository.OrdersItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersItemsServiceImpl implements OrdersItemsService{
    @Autowired
    private OrdersItemsRepository ordersItemsRepository;
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private ProductsService productsService;

    @Override
    public OrderItems findOrderItemsBy2Id(int orderId, int productId) {
        OrderItems id = ordersItemsRepository.findBy2Id(orderId, productId);
        return id;
    }

    @Override
    public OrderItems addProductToOrder(int orderId, int productId, int quantity) {
        OrderItems by2Id = ordersItemsRepository.findBy2Id(orderId, productId);
                if (by2Id!=null){
                    by2Id.setQuantity(by2Id.getQuantity()+quantity);
                    by2Id = ordersItemsRepository.saveAndFlush(by2Id);
                    return by2Id;
                }
                OrderItems orderItems =new OrderItems();
                orderItems.setOrders(ordersService.readById(orderId));
                orderItems.setProducts(productsService.getById(productId));
                orderItems.setQuantity(quantity);
                orderItems.setOrderItemsKey(new OrderItemsId(orderId,productId));
                orderItems = ordersItemsRepository.saveAndFlush(orderItems);
                return orderItems;
    }

    @Override
    public void removeOrederItems(OrderItems orderItem) {
        ordersItemsRepository.deleteByOrdersItems(orderItem.getOrders().getId(), orderItem.getProducts().getId());
    }


}
