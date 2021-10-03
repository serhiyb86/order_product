package com.hybrisAcademy.ciklum.model.responses;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ProductsByOrderResponse {
    private int orders_id;
    private double total;
    private String name;
    private int quantity;
    private LocalDateTime created_at;

}
