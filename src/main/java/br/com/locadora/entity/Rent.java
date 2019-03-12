package br.com.locadora.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "TA_RENT")
public class Rent implements Serializable {

    private static final long serialVersionUID = 7338170326140072859L;

    @Id
    @GeneratedValue
    @Column(name = "ID_RENT", nullable = false)
    private Long idRent;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "ID_MOVIE")
    private Long idMovie;

    @JoinColumn(name = "ID_MOVIE", referencedColumnName = "ID_MOVIE", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Movie movie;

    @Column(name = "IS_CURRENT")
    private boolean current;

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

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public boolean isCurrent() {
        return current;
    }

    public void setCurrent(boolean current) {
        this.current = current;
    }

    public Long getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(Long idMovie) {
        this.idMovie = idMovie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rent rent = (Rent) o;
        return current == rent.current &&
                Objects.equals(idRent, rent.idRent) &&
                Objects.equals(email, rent.email) &&
                Objects.equals(idMovie, rent.idMovie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRent, email, idMovie, current);
    }

    @Override
    public String toString() {
        return "Rent{" +
                "idRent=" + idRent +
                ", email='" + email + '\'' +
                ", idMovie=" + idMovie +
                ", current=" + current +
                '}';
    }
}
