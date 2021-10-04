package com.hybrisAcademy.ciklum.controller;


import com.hybrisAcademy.ciklum.model.OrderItems;
import com.hybrisAcademy.ciklum.model.PrStatus;
import com.hybrisAcademy.ciklum.model.Products;
import com.hybrisAcademy.ciklum.model.responses.ProductsByOrderResponse;
import com.hybrisAcademy.ciklum.model.responses.ProductsResponse;
import com.hybrisAcademy.ciklum.service.OrdersItemsService;
import com.hybrisAcademy.ciklum.service.ProductsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class ProductController {
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    private ProductsService productsService;
    @Autowired
    private OrdersItemsService ordersItemsService;

    @GetMapping("listProducts")
    public String listProducts(Model model) {
        logger.info("Product list was called! ");
        List<Products> products = productsService.allProducts();
        model.addAttribute("list", products);
        return "products-list";
    }

    @GetMapping("listOderedProducts")
    public String listOderedProducts(Model model) {
        logger.info("Products ordered at least once was called! ");
        List<ProductsResponse> products = productsService.getOrderedProductsList();
        model.addAttribute("list", products);
        return "productsOdered-list";
    }

    @GetMapping("listProductsByOrder")
    public String listProductsByOrder(Model model) {
        logger.info("Products ordered by orders was called! ");
        List<ProductsByOrderResponse> products = productsService.getListProductByOrderResponse();
        model.addAttribute("list", products);
        return "productsByOrder-list";
    }

    @GetMapping("newProduct")
    public String newProduct(Model model) {
        logger.info("Created Product was called! ");
        model.addAttribute("statuses", PrStatus.values());
        return "create-product";
    }

    @PostMapping("saveProduct")
    public String newProduct(@ModelAttribute("product") Products product) {
        product.setCreated_at(LocalDateTime.now());
        productsService.create(product);
        logger.info("Product created!");
        return "redirect:listProducts";
    }

    @GetMapping("removeProduct/{product_id}")
    public String removeProduct(@PathVariable int product_id) {
        logger.info("Product delete was called! " + product_id);
        productsService.removeById(product_id);
        return "redirect:listProducts";
    }

    @GetMapping("{prod_id}/addProductOrder/{order_id}")
    public String addProductOrder(@PathVariable int order_id,
                                  @PathVariable int prod_id, @RequestParam(value = "quantity") int quantity) {
        logger.info("Add product for order was called!");
        logger.info("prod_id " + prod_id + " order_id " + order_id + "quantity " + quantity);
        ordersItemsService.addProductToOrder(order_id, prod_id, quantity);
        return "redirect:/updateOrder/" + order_id;
    }

    @GetMapping("{prod_id}/removeProductOrder/{order_id}")
    public String removeProductOrder(@PathVariable int order_id, @PathVariable int prod_id) {
        logger.info("Remove product " + prod_id + " from order " + order_id);
        ordersItemsService.removeOrderItems(order_id, prod_id);
        return "redirect:/updateOrder/" + order_id;
    }

    @GetMapping("{prod_id}/quantityProductOrder/{order_id}")
    public String quantityProductOrder(@PathVariable int order_id, @PathVariable int prod_id,
                                       @RequestParam(value = "quantity") int quantity) {
        logger.info("Update quantity of products in the order " + prod_id + " from order " + order_id);
        ordersItemsService.updateQuantity(order_id, prod_id, quantity);
        return "redirect:/updateOrder/" + order_id;
    }


    @Autowired
    public void setProductsService(ProductsService productsService) {
        this.productsService = productsService;
    }
}
