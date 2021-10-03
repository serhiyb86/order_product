package com.hybrisAcademy.ciklum.service;

import com.hybrisAcademy.ciklum.model.OrderItems;
import com.hybrisAcademy.ciklum.model.OrderItemsId;
import com.hybrisAcademy.ciklum.model.Orders;
import com.hybrisAcademy.ciklum.model.Products;
import com.hybrisAcademy.ciklum.repository.OrdersItemsRepository;
import com.hybrisAcademy.ciklum.repository.OrdersRepository;
import com.hybrisAcademy.ciklum.repository.ProductsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@SpringBootTest
class OrdersServiceTest {
    @Mock
    private OrdersRepository ordersRepository;
    @Mock
    private ProductsRepository productsRepository;
    @Mock
    private OrdersItemsRepository ordersItemsRepository;
    @InjectMocks
    private OrdersServiceImpl ordersService;

    private Orders expected;
    @BeforeEach
    public void setUp() {
        expected = new Orders();
        expected.setStatus("Test status #1");
        expected.setCreated_at(LocalDateTime.now());
        expected.setUser_id(157);
    }

    @Test
    void readById() {
        when(ordersRepository.findById(anyInt())).thenReturn(Optional.of(expected));
        Orders actual = ordersService.readById(anyInt());

        assertEquals(expected, actual);
        verify(ordersRepository, times(1)).findById(anyInt());
    }
    @Test
  //@Transactional
    void createOrder() {
        Orders order = new Orders();
        order.setCreated_at(LocalDateTime.now());
        order.setStatus("NEW");
        order.setUser_id(5);
        order = ordersRepository.save(order);
        System.out.println(order);
        Orders byId = ordersRepository.getById(1);
//        System.out.println("Read  ->"+byId);
        Products product1 = productsRepository.getById(1);
        System.out.println(product1);
        Products product2 = productsRepository.getById(3);
        System.out.println(product2);
        Products product3 = productsRepository.getById(5);
        System.out.println(product3);
        List<OrderItems> orderItems=new ArrayList<>();

        OrderItems order1 = new OrderItems();
        OrderItems order2 = new OrderItems();
        OrderItems order3 = new OrderItems();

        order1.setProducts(product1);
        order1.setQuantity(3);
        order1.setOrders(order);
        order1.setOrderItemsKey(new OrderItemsId(order.getId(),product1.getId()));


        order2.setProducts(product2);
        order2.setQuantity(5);
        order2.setOrders(order);
        order2.setOrderItemsKey(new OrderItemsId(order.getId(),product2.getId()));

        order3.setProducts(product3);
        order3.setQuantity(9);
        order3.setOrders(order);
        order3.setOrderItemsKey(new OrderItemsId(order.getId(),product3.getId()));

        System.out.println(order1);
        System.out.println(order2);
        System.out.println(order3);

        order1 = ordersItemsRepository.save(order1);
        order2 = ordersItemsRepository.save(order2);
        order3 = ordersItemsRepository.save(order3);

        orderItems.add(order1);
        orderItems.add(order2);
        orderItems.add(order3);

        order.setOrderProducts(orderItems);
        System.out.println();
        System.out.println("Before saving");
        //System.out.println(order);
        //ordersRepository.save(order);



    }



    @Test
    void update() {
    }

    @Test
    void getAll() {
    }
}