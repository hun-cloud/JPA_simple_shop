package com.example.demo.shop.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
// @NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery")
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status; // READY(준비), COMP(배송)

    public Delivery() {
    }

    public Delivery(Address address) {
        this.address = address;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
