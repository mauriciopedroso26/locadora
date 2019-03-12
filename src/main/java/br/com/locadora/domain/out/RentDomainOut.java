package br.com.locadora.domain.out;

public class RentDomainOut {

    private Long idRent;
    private String email;
    private Long idMovie;
    private MovieDomainOut movie;
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

    public Long getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(Long idMovie) {
        this.idMovie = idMovie;
    }

    public MovieDomainOut getMovie() {
        return movie;
    }

    public void setMovie(MovieDomainOut movie) {
        this.movie = movie;
    }

    public boolean isCurrent() {
        return isCurrent;
    }

    public void setCurrent(boolean current) {
        isCurrent = current;
    }
}
