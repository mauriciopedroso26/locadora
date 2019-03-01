package br.com.locadora.facade;

import br.com.locadora.converter.MovieToMovieDomainOutConverter;
import br.com.locadora.domain.out.MovieDomainOut;
import br.com.locadora.entity.Movie;
import br.com.locadora.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovieFacade {

    private final MovieService movieService;
    private final MovieToMovieDomainOutConverter movieToMovieDomainOutConverter;

    @Autowired
    public MovieFacade(MovieService movieService, MovieToMovieDomainOutConverter movieToMovieDomainOutConverter) {
        this.movieService = movieService;
        this.movieToMovieDomainOutConverter = movieToMovieDomainOutConverter;
    }

    public List<MovieDomainOut> findByTitle(String title) {
        List<Movie> movieList = movieService.findByTitle(title);
        List<MovieDomainOut> movieDomainOutList = new ArrayList<>();

        movieList.forEach(conta -> movieDomainOutList.add(movieToMovieDomainOutConverter.convert(conta)));

        return movieDomainOutList;
    }

    public List<MovieDomainOut> findAll() {
        List<Movie> movieList = movieService.findAll();
        List<MovieDomainOut> movieDomainOutList = new ArrayList<>();

        movieList.forEach(conta -> movieDomainOutList.add(movieToMovieDomainOutConverter.convert(conta)));

        return movieDomainOutList;
    }
}
