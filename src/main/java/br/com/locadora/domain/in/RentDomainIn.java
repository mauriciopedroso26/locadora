package br.com.locadora.domain.in;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class RentDomainIn {

    @NotNull(message = "{field} MovieRentDomainIn {required}")
    @Valid
    private MovieRentDomainIn movieRentDomainIn;

    public RentDomainIn() {
        movieRentDomainIn = new MovieRentDomainIn();
    }

    public MovieRentDomainIn getMovieRentDomainIn() {
        return movieRentDomainIn;
    }

    public void setMovieRentDomainIn(MovieRentDomainIn movieRentDomainIn) {
        this.movieRentDomainIn = movieRentDomainIn;
    }
}
