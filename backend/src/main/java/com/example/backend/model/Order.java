package com.example.backend.model;

import com.example.backend.model.enums.PaymentMethodEnum;
import com.example.backend.model.enums.StatusEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Order extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    @JsonIgnore
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonProperty
    private User user;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    @JsonProperty
    private Restaurant restaurant;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    @JsonProperty(value = "status")
    private StatusEnum status;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_method")
    @JsonProperty(value = "payment_method")
    private PaymentMethodEnum paymentMethod;
}