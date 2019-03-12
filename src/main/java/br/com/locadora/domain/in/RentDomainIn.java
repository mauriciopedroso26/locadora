package br.com.locadora.domain.in;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class RentDomainIn {

    @NotBlank(message = "{field} Email {required}")
    private String email;

    @NotNull(message = "{field} MovieRentDomainIn {required}")
    private Long idMovie;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(Long idMovie) {
        this.idMovie = idMovie;
    }
}
