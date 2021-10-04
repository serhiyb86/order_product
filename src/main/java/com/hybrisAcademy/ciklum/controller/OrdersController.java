package com.hybrisAcademy.ciklum.controller;

import com.hybrisAcademy.ciklum.model.Orders;
import com.hybrisAcademy.ciklum.service.OrdersService;
import com.hybrisAcademy.ciklum.service.ProductsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class OrdersController {
    private static final Logger logger = LoggerFactory.getLogger(OrdersController.class);
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private ProductsService productsService;

    @GetMapping("newOrder")
    public String create(Model model) {
        logger.info("Create order page was called! ");
        Orders order = ordersService.createOrder();
        model.addAttribute("order", order);
        model.addAttribute("created", "Your order was created!");
        model.addAttribute("products", productsService.allProducts());
        logger.info("New order -> " + order);
        return "addProducts-toOrder";
    }

    @GetMapping("updateOrder/{order_id}")
    public String update(@PathVariable("order_id") int id, Model model) {
        logger.info("Update order page was called! ");
        Orders order = ordersService.readById(id);
        model.addAttribute("order", order);
        model.addAttribute("created", "Update your order!");
        model.addAttribute("products", productsService.allProducts());
        logger.info("New order -> " + order);
        return "addProducts-toOrder";
    }

}
