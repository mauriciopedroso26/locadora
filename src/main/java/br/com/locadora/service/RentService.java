package br.com.locadora.service;

import br.com.locadora.entity.Movie;
import br.com.locadora.entity.Rent;
import br.com.locadora.repository.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RentService {

    private final RentRepository rentRepository;
    private final MovieService movieService;
    private final MovieRentService movieRentService;

    @Autowired
    public RentService(RentRepository rentRepository, MovieService movieService, MovieRentService movieRentService) {
        this.rentRepository = rentRepository;
        this.movieService = movieService;
        this.movieRentService = movieRentService;
    }

    public Rent save(Rent rent) {
        saveMovieRent(rent);
        Rent rentSaved = rentRepository.save(rent);
        updateMovieRentWithForeignkeyRent(rentSaved);

        return rentSaved;
    }

    public Rent update(Rent rent) {
        List<Rent> rentList = rentRepository.findByCurrentTrue();

        Optional<Rent> rentOptional = rentList.stream().filter(rent1 -> rent1.getMovieRent().getIdMovie().equals(rent.getMovieRent().getIdMovie()))
                .findFirst();

        rentOptional.ifPresent(rent1 -> {
            Optional<Movie> movie = movieService.findById(rent1.getMovieRent().getIdMovie());
            movie.ifPresent(movie1 -> {
                movie1.setQuantity(movie1.getQuantity() + 1);
                movieService.save(movie1);
            });
            rent1.setCurrent(false);
            rentRepository.save(rent1);

        });

        if (rentOptional.isPresent()) {
            return rentOptional.get();
        } else {
            throw new IllegalArgumentException(String.format("Não existe locação para o filme com id %s",
                    rent.getMovieRent().getIdMovie()));
        }
    }

    private void saveMovieRent(Rent rent) {
        Optional<Movie> movie = movieService.findById(rent.getMovieRent().getIdMovie());

        validIfExistAvailablaQuantityAndUpdateQuantity(movie);

        rent.setCurrent(true);
        movieRentService.save(rent.getMovieRent());
    }

    private void validIfExistAvailablaQuantityAndUpdateQuantity(Optional<Movie> movie) {
        movie.ifPresent(movie1 -> {
            if (movie1.getQuantity() > 0) {
                movie1.setQuantity(movie1.getQuantity() - 1);
            } else {
                throw new IllegalArgumentException(
                        String.format("Não existem nenhum %s disponível para locação no momento", movie1.getTitle()));
            }
        });
    }

    private void updateMovieRentWithForeignkeyRent(Rent rentSaved) {
        rentSaved.getMovieRent().setIdRent(rentSaved.getIdRent());
        movieRentService.save(rentSaved.getMovieRent());
    }

}
