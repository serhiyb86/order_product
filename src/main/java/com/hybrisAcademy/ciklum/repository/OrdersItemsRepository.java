package com.hybrisAcademy.ciklum.repository;

import com.hybrisAcademy.ciklum.model.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface OrdersItemsRepository extends JpaRepository<OrderItems, Integer> {
    @Query(value = "select * from order_items where orders_id=?1 AND products_id=?2",nativeQuery = true)
    OrderItems findBy2Id(int ordersId, int productsId);

    @Query(value = "DELETE FROM `order_items` WHERE orders_id=?1 and products_id=?2",nativeQuery = true)
    void deleteByOrdersItems(int ordersId, int productsId);

}
