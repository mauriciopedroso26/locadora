package br.com.locadora.domain.in;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class RentDomainIn {

    @NotBlank(message = "{field} Email {required}")
    private String email;

    @NotNull(message = "{field} MovieRentDomainIn {required}")
    @Valid
    private MovieRentDomainIn movieRentDomainIn;

    public RentDomainIn() {
        movieRentDomainIn = new MovieRentDomainIn();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public MovieRentDomainIn getMovieRentDomainIn() {
        return movieRentDomainIn;
    }

    public void setMovieRentDomainIn(MovieRentDomainIn movieRentDomainIn) {
        this.movieRentDomainIn = movieRentDomainIn;
    }
}
