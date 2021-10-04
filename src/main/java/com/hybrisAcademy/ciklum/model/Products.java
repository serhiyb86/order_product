package com.hybrisAcademy.ciklum.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "products")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double price;
    @Enumerated(EnumType.STRING)
    private PrStatus status;
    private LocalDateTime created_at;
    @OneToMany(mappedBy = "products", cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private List<OrderItems> orders;

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", status=" + status +
                ", created_at=" + created_at +
                ", orders amount=" + " orders.size()" +
                '}';
    }
}
