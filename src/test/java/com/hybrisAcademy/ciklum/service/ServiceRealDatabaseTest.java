package com.hybrisAcademy.ciklum.service;

import com.hybrisAcademy.ciklum.model.OrderItems;
import com.hybrisAcademy.ciklum.model.Orders;
import com.hybrisAcademy.ciklum.model.Products;
import com.hybrisAcademy.ciklum.model.responses.ProductsByOrderResponse;
import com.hybrisAcademy.ciklum.model.responses.ProductsResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ServiceRealDatabaseTest {
    @Autowired
    private ProductsService productsService;
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private OrdersItemsService ordersItemsService;

    @Test
    void getOrderedProductsList() {
        List<ProductsResponse> list = productsService.getOrderedProductsList();
        list.forEach(System.out::println);
    }

    @Test
    void listProductByOrderResponseTest() {
        List<ProductsByOrderResponse> response = productsService.getListProductByOrderResponse();
        response.forEach(System.out::println);
    }

    @Test
    void addProductToOrderTest() {
        OrderItems by2Id = ordersItemsService.findOrderItemsBy2Id(1, 4);
        System.out.println(by2Id);
        ordersItemsService.addProductToOrder(1,4,5);
        OrderItems by2Id2 = ordersItemsService.findOrderItemsBy2Id(1, 4);
        System.out.println(by2Id2);
    }

    @Test
    void deleteOrderItemYest(){
        Orders orders = ordersService.readById(1);
        Products byId = productsService.getById(4);

        ordersItemsService.removeOrderItems(1,4);

    }

    @Test
    void orderItemsUpdateQuantity(){
        OrderItems by2Id = ordersItemsService.findOrderItemsBy2Id(1, 4);
        System.out.println(by2Id);

        OrderItems orderItems = ordersItemsService.updateQuantity(1, 4, 10000);
        System.out.println(orderItems);
    }

}
