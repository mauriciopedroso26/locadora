package br.com.locadora.service;

import br.com.locadora.entity.Movie;
import br.com.locadora.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> findByTitle(String title) {
        return movieRepository.findByTitle(title);
    }

    public List<Movie> findAll() {
        List<Movie> movieList = new ArrayList<>();

        movieRepository.findAll().forEach(movie -> {
            if (movie.getQuantity() > 0) {
                movieList.add(movie);
            }
        });

        return movieList;
    }

    public Optional<Movie> findById(Long idMovie) {

        Optional<Movie> movie = movieRepository.findById(idMovie);

        if (movie.isPresent()) {
            return movie;
        } else {
            throw new IllegalArgumentException(String.format("Movie com o id %s não encontrado", idMovie));
        }
    }

    public Movie save(Movie movie){
        return movieRepository.save(movie);
    }
}
