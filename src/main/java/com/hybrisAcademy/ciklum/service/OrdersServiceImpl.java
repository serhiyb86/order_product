package com.hybrisAcademy.ciklum.service;

import com.hybrisAcademy.ciklum.model.Orders;
import com.hybrisAcademy.ciklum.repository.OrdersItemsRepository;
import com.hybrisAcademy.ciklum.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.Random;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private OrdersItemsRepository ordersItemsRepository;

    @Override
    public Orders readById(int id) {
        return ordersRepository.findById(id).orElseThrow(()
                -> new EntityNotFoundException("Orders with ID " + id + " didnt find"));
    }


    @Override
    public Orders createOrder() {
        Random random = new Random(10000);
        Orders order = new Orders();
        order.setStatus("Test status #1");
        order.setCreated_at(LocalDateTime.now());
        order.setUser_id(random.nextInt());
        return ordersRepository.save(order);
    }


}
