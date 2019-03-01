package br.com.locadora.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserDomainIn {

    @Email(message = "{email}")
    @NotBlank(message = "{field} Email {required}")
    private String email;

    @NotBlank(message = "{field} Name {required}")
    private String name;

    @NotBlank(message = "{field} Password {required}")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
