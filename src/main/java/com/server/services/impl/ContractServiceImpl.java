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
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(sendTo);
        message.setSubject(model.getSubject());
        message.setText(model.getText());
        String FROM_PATTERN = "%s %s - (%s)";
        message.setFrom(
                String.format(
                        FROM_PATTERN,
                        model.getFirstName(),
                        model.getLastName(),
                        model.getEmail()
                )
        );

        mailSender.send(message);
    }
}
