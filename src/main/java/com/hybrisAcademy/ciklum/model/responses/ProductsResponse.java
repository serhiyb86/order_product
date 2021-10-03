package com.hybrisAcademy.ciklum.model.responses;


import com.hybrisAcademy.ciklum.model.Products;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@EqualsAndHashCode
//@SqlResultSetMapping(
//        name = "ProductMapping",
//        entities = @EntityResult(
//                entityClass = ProductsResponse.class,
//                fields = {
//                        @FieldResult(name = "id", column = "id"),
//                        @FieldResult(name = "name", column = "name"),
//                        @FieldResult(name = "status", column = "status"),
//                        @FieldResult(name = "created_at", column = "created_at"),
//                        @FieldResult(name = "price", column = "price"),
//                        @FieldResult(name = "ordered", column = "ordered")}))

public class ProductsResponse extends Products {

    private int ordered;

    @Override
    public String toString() {
        return super.toString() +
                " ordered=" + ordered +
                '}';
    }
}
