package com.server.domain.models.binding;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterBindingModel implements Serializable {

    @NotEmpty
    @Length(min = 4, max = 15)
    private String username;

    @Email
    @Length(min = 4, max = 35)
    private String email;

    @NotEmpty
    @Length(min = 4, max = 20)
    private String password;

    @NotEmpty
    @Length(min = 4, max = 20)
    private String repeatPassword;

    @NotEmpty
    @Length(min = 4, max = 20)
    private String firstName;

    @NotEmpty
    @Length(min = 4, max = 20)
    private String lastName;
}
