package br.com.locadora.repository;

import br.com.locadora.entity.MovieRent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRentRepository extends JpaRepository<MovieRent, Long> {

    MovieRent findByIdRent(Long idRent);
}
