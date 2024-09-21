package com.server.services;

import com.server.domain.models.binding.SendEmailBindingModel;

public interface ContractService {
    void contract(SendEmailBindingModel sendEmailBindingModel);
}
