package com.hybrisAcademy.ciklum.repository;

import com.hybrisAcademy.ciklum.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Orders,Integer> {


}
