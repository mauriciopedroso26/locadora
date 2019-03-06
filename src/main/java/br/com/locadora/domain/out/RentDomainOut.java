package br.com.locadora.domain.out;

public class RentDomainOut {

    private Long idRent;
    private String email;
    private MovieRentDomainOut movieRent;
    private boolean isCurrent;

    public Long getIdRent() {
        return idRent;
    }

    public void setIdRent(Long idRent) {
        this.idRent = idRent;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public MovieRentDomainOut getMovieRent() {
        return movieRent;
    }

    public void setMovieRent(MovieRentDomainOut movieRent) {
        this.movieRent = movieRent;
    }

    public boolean isCurrent() {
        return isCurrent;
    }

    public void setCurrent(boolean current) {
        isCurrent = current;
    }
}
