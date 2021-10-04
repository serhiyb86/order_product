package com.hybrisAcademy.ciklum.controller;

import com.hybrisAcademy.ciklum.model.Products;
import com.hybrisAcademy.ciklum.service.OrdersService;
import com.hybrisAcademy.ciklum.service.OrdersServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@WebMvcTest
@AutoConfigureMockMvc
@SpringBootTest
class OrdersControllerTest {
    @MockBean
    private OrdersService ordersService;


    @Autowired
    private MockMvc mvc;

    @Test
    void testCreatePostMethod() {
        Products product = new Products();
        product.setId(1);

    }

    @Test
    void update() {
    }
}