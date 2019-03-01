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

    @OneToOne(mappedBy = "rent", fetch = FetchType.LAZY)
    private MovieRent movieRent;

    @Column(name = "IS_CURRENT")
    private boolean current;

    public Long getIdRent() {
        return idRent;
    }

    public void setIdRent(Long idRent) {
        this.idRent = idRent;
    }

    public MovieRent getMovieRent() {
        return movieRent;
    }

    public void setMovieRent(MovieRent movieRent) {
        this.movieRent = movieRent;
    }

    public boolean isCurrent() {
        return current;
    }

    public void setCurrent(boolean current) {
        this.current = current;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rent rent = (Rent) o;
        return Objects.equals(idRent, rent.idRent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRent);
    }

    @Override
    public String toString() {
        return "Rent{" +
                "idRent=" + idRent +
                '}';
    }
}
