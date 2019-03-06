package br.com.locadora.domain.out;

public class MovieRentDomainOut {

    private Long idMovieRent;
    private Long idMovie;
    private String title;
    private String director;
    private Long idRent;

    public Long getIdMovieRent() {
        return idMovieRent;
    }

    public void setIdMovieRent(Long idMovieRent) {
        this.idMovieRent = idMovieRent;
    }

    public Long getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(Long idMovie) {
        this.idMovie = idMovie;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Long getIdRent() {
        return idRent;
    }

    public void setIdRent(Long idRent) {
        this.idRent = idRent;
    }
}
