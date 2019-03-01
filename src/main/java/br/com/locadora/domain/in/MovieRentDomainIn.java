package br.com.locadora.domain.in;

import javax.validation.constraints.NotNull;

public class MovieRentDomainIn {

    @NotNull(message = "{field} Id Movie {required}")
    private Long idMovie;

    public Long getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(Long idMovie) {
        this.idMovie = idMovie;
    }
}
