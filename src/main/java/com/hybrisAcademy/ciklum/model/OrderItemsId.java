package com.hybrisAcademy.ciklum.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class OrderItemsId implements Serializable {
@Column(name = "orders_id")
    private int ordersId;
    @Column(name = "products_id")
    private int productsId;

}
