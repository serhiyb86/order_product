package com.hybrisAcademy.ciklum.model;

import lombok.*;

import javax.persistence.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class OrderItems {
@EmbeddedId
    OrderItemsId orderItemsKey;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @MapsId("ordersId")
    @JoinColumn (name = "orders_id")
    private Orders orders;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @MapsId("productsId")
    @JoinColumn(name = "products_id")
    private Products products;

    @Column(name = "quantity")
    private int quantity;
}
