package com.server.domain.models.binding;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WithinDatesAndUserNameModel {

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate endDate;

    private String username;
}
