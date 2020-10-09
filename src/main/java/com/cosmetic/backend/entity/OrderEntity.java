package com.cosmetic.backend.entity;

import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "status")
    private Integer status;

    @Column(name = "created_date")
//    @Temporal(TemporalType.DATE)
//    @CreatedDate
    private LocalDate createdDate;

    @NotNull(message = "payment not null")
    @Column(name = "payment_methods")
    private String paymentMethods;

    @OneToMany(mappedBy = "orderEntity")
    private List<OrderDetailEntity> orderDetailEntities = new ArrayList<>();

    @NotFound(action = NotFoundAction.IGNORE)
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;






}
