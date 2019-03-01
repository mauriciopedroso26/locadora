package br.com.locadora.service;

import br.com.locadora.entity.MovieRent;
import br.com.locadora.repository.MovieRentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieRentService {

    private final MovieRentRepository movieRentRepository;

    @Autowired
    public MovieRentService(MovieRentRepository movieRentRepository) {
        this.movieRentRepository = movieRentRepository;
    }

    public MovieRent save(MovieRent movieRent){
        return movieRentRepository.save(movieRent);
    }

    public MovieRent findByIdRent(Long idRent){
        return movieRentRepository.findByIdRent(idRent);
    }
}
