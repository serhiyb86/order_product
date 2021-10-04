package com.hybrisAcademy.ciklum.repository;

import com.hybrisAcademy.ciklum.model.PrStatus;
import com.hybrisAcademy.ciklum.model.responses.ProductsByOrderResponse;
import com.hybrisAcademy.ciklum.model.responses.ProductsResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ProductResponseRepositoryImpl implements ProductResponseRepository {
    public static final Logger logger = LoggerFactory.getLogger(ProductResponseRepositoryImpl.class);

    @PersistenceContext
    private EntityManager entityManager;
    private static final String QUERY = "SELECT sum(quantity) as ordered, products_id as id, name, price, status, created_at \n" +
            "FROM order_items\n" +
            "INNER JOIN products on products.id=order_items.products_id\n" +
            "group by  products_id\n" +
            "ORDER by ordered DESC";

    private static final String QUERY2 = "SELECT orders.id, sum(price) as total, name, quantity, orders.created_at\n" +
            "from products\n" +
            "INNER join order_items on order_items.products_id=products.id\n" +
            "INNER JOIN orders on order_items.orders_id=orders.id\n" +
            "GROUP by products_id\n" +
            "ORDER BY orders_id";

    @Override
    public List<ProductsResponse> listProductResponses() {
        Query nativeQuery = entityManager.createNativeQuery(QUERY);
        List<Object[]> resultList = nativeQuery.getResultList();
        List<ProductsResponse> productsResponses = new ArrayList<>();
        for (Object[] object : resultList) {
            ProductsResponse pr = new ProductsResponse();
            BigDecimal b = (BigDecimal) object[0];
            pr.setOrdered(b.intValue());
            pr.setId((Integer) object[1]);
            pr.setName((String) object[2]);
            pr.setPrice((double) object[3]);
            pr.setStatus(PrStatus.valueOf((String) object[4]));
            Timestamp date = (Timestamp) object[5];
            pr.setCreated_at(date.toLocalDateTime());
            productsResponses.add(pr);
        }
        return productsResponses;
    }

    @Override
    public List<ProductsByOrderResponse> listProductByOrderResponse() {
        Query nativeQuery = entityManager.createNativeQuery(QUERY2);
        List<Object[]> resultList = nativeQuery.getResultList();
        List<ProductsByOrderResponse> productsResponses = new ArrayList<>();
        for (Object[] object : resultList) {
            ProductsByOrderResponse pr = new ProductsByOrderResponse();
            //BigDecimal b = (BigDecimal) object[0];

            pr.setOrders_id((Integer) object[0]);
            pr.setTotal((double) object[1]);
            pr.setName((String) object[2]);
            pr.setQuantity((Integer) object[3]);
            Timestamp date = (Timestamp) object[4];
            pr.setCreated_at(date.toLocalDateTime());
            productsResponses.add(pr);
        }
        return productsResponses;
    }
}
