package com.hybrisAcademy.ciklum.service;

import com.hybrisAcademy.ciklum.model.PrStatus;
import com.hybrisAcademy.ciklum.model.Products;
import com.hybrisAcademy.ciklum.model.responses.ProductsResponse;
import com.hybrisAcademy.ciklum.repository.OrdersRepository;
import com.hybrisAcademy.ciklum.repository.ProductsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class ProductsServiceImplTest {
    @Mock
    private ProductsRepository productsRepository;
    @Mock
    private OrdersRepository ordersRepository;
    @InjectMocks
    private ProductsServiceImpl productsService;

    private Products expected;

    @BeforeEach
    public void setUp() {
        expected = new Products();
        expected.setName("Test product #1");
        expected.setPrice(45.6);
        expected.setStatus(PrStatus.in_stock);
        expected.setCreated_at(LocalDateTime.now());
    }

    @Test
    void create() {

       when(productsRepository.save(expected)).thenReturn(expected);
       Products actual = productsService.create(expected);

        assertEquals(expected, actual);
        verify(productsRepository, times(1)).save(expected);
    }

    @Test
    void allProducts() {

        List<Products> expected = List.of(new Products(), new Products(), new Products(), new Products());
        when(productsRepository.findAll()).thenReturn(expected);

        List<Products> actual = productsService.allProducts();
        assertEquals(expected, actual);
        verify(productsRepository, times(1)).findAll();

    }

    @Test
    void getOrderedProductsList() {
//        List<ProductsResponse> productsResponses = productsRepository.findAll();
//        productsResponses.forEach(System.out::println);
    }

    @Test
    void removeById() {
    }

    @Test
    void removeAll() {
    }

    @Test
    void productsByOrdersId() {


    }

    @Test
    void getAll() {
        productsRepository.findAll().forEach(System.out::println);


    }



}