package br.com.locadora.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "TA_MOVIE")
public class Movie implements Serializable {

    private static final long serialVersionUID = 4251449537575911440L;

    @Id
    @GeneratedValue
    @Column(name = "ID_MOVIE", nullable = false)
    private Long idMovie;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "DIRECTOR", nullable = false)
    private String director;

    @Column(name = "QUANTITY", nullable = false)
    private Integer quantity;

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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(idMovie, movie.idMovie) &&
                Objects.equals(title, movie.title) &&
                Objects.equals(director, movie.director) &&
                Objects.equals(quantity, movie.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMovie, title, director, quantity);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "idMovie=" + idMovie +
                ", title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
