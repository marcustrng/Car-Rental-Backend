package com.server.domain.models.binding;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SendEmailBindingModel implements Serializable {
    private String firstName;
    private String lastName;
    private String email;
    private String subject;
    private String text;
}
