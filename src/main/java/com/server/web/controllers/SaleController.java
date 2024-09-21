package com.server.web.controllers;

import com.server.domain.models.binding.SendEmailBindingModel;
import com.server.domain.models.view.SaleViewModel;
import com.server.services.ContractService;
import com.server.services.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class SaleController {

    private final SaleService saleService;
    private final ContractService contractService;


    @GetMapping("/sales/all/{username}")
    public Page<SaleViewModel> getAllByUser(Pageable pageable,
                                            @PathVariable String username,
                                            @RequestParam(value = "query", required = false) String query) {

        return this.saleService.findAllByUsername(pageable, username, query);
    }

    @PostMapping("/contract")
    public ResponseEntity<Boolean> sendEmail(@RequestBody SendEmailBindingModel request) {
        contractService.contract(request);

        return ResponseEntity.ok().build();
    }
}
