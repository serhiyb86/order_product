package com.hybrisAcademy.ciklum.repository;

import com.hybrisAcademy.ciklum.model.Products;
import com.hybrisAcademy.ciklum.model.responses.ProductsResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductsRepository extends JpaRepository<Products, Integer>, ProductResponseRepository{
    @Query(value = "select * from products where id = ?1", nativeQuery = true)
    Products getById(int id);



}
