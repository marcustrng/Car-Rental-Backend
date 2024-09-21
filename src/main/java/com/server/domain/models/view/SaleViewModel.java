package com.server.domain.models.view;

import com.server.domain.enums.SaleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleViewModel implements Serializable {

    private String id;
    private String rentId;
    private String carBrand;
    private String carModel;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate issueDate;
    private Double pricePaid;
    private SaleType type;
}
