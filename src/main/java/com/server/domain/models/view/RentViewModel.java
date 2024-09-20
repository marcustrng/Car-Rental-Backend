package com.server.domain.models.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RentViewModel {

    private String id;
    private LocalDate startDate;
    private LocalDate endDate;
    private CarViewModel car;
    private boolean isApproved;
    private boolean isFinished;
    private Double totalPrice;
}
