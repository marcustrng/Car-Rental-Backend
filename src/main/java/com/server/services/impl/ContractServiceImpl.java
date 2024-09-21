package com.server.services.impl;

import com.server.domain.models.binding.SendEmailBindingModel;
import com.server.services.ContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContractServiceImpl implements ContractService {
    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String sendTo;

    @Override
    public void contract(SendEmailBindingModel model) {
        String TEXT_PATTERN = "%s %s - (%s)\n\n %s";

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(sendTo);
        message.setSubject(model.getSubject());
        message.setText(
                String.format(
                        TEXT_PATTERN,
                        model.getFirstName(),
                        model.getLastName(),
                        model.getEmail(),
                        model.getText()
                )
        );
        message.setFrom(model.getEmail());

        mailSender.send(message);
    }
}
