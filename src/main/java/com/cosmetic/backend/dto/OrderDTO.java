package com.cosmetic.backend.dto;

import com.cosmetic.backend.entity.OrderDetailEntity;
import lombok.Data;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
public class OrderDTO {
    private int orderId;
    private Integer status;
    private LocalDate createdDate;
    @NotNull(message = "payment not null")
    private String paymentMethods;
    private int userId;
    private String fullName;
    private long total;
    private long totalPayment;
    private List<OrderDetailDTO> orderDetailDTOS;
}
