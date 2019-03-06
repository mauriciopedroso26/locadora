package br.com.locadora.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "TA_MOVIE_RENT")
public class MovieRent implements Serializable {

    private static final long serialVersionUID = 475648155344743328L;

    @Id
    @GeneratedValue
    @Column(name = "ID_MOVIE_RENT", nullable = false)
    private Long idMovieRent;

    @Column(name = "ID_MOVIE")
    private Long idMovie;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "DIRECTOR", nullable = false)
    private String director;

    @Column(name = "ID_RENT")
    private Long idRent;

    @JoinColumn(name = "ID_RENT", referencedColumnName = "ID_RENT", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Rent rent;

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

    public Rent getRent() {
        return rent;
    }

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieRent movieRent = (MovieRent) o;
        return  Objects.equals(idMovieRent, movieRent.idMovieRent) &&
                Objects.equals(idMovie, movieRent.idMovie) &&
                Objects.equals(idRent, movieRent.idRent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMovieRent, idMovie, idRent);
    }

    @Override
    public String toString() {
        return "MovieRent{" +
                "idMovieRent=" + idMovieRent +
                ", idMovie=" + idMovie +
                ", idRent=" + idRent +
                '}';
    }
}
