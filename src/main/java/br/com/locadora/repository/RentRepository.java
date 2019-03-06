package br.com.locadora.repository;

import br.com.locadora.entity.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentRepository extends JpaRepository<Rent, Long> {

    List<Rent> findByCurrentTrueAndEmail(String email);
}
