package br.com.locadora.service;

import br.com.locadora.entity.Movie;
import br.com.locadora.entity.Rent;
import br.com.locadora.repository.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class RentService {

    private final RentRepository rentRepository;
    private final MovieService movieService;
    private final UserService userService;

    @Autowired
    public RentService(RentRepository rentRepository, MovieService movieService, UserService userService) {
        this.rentRepository = rentRepository;
        this.movieService = movieService;
        this.userService = userService;
    }

    public Rent save(Rent rent) {
        saveMovie(rent);
        userService.loadUserByUsername(rent.getEmail());
        return rentRepository.save(rent);
    }

    public Rent update(Rent rent) {
        Rent rentFound = rentRepository.findFirstByCurrentTrueAndEmailAndIdMovie(rent.getEmail(), rent.getIdMovie());

        if (Objects.nonNull(rentFound)) {
            Optional<Movie> movie = movieService.findById(rentFound.getIdMovie());
            movie.ifPresent(movie1 -> {
                movie1.setQuantity(movie1.getQuantity() + 1);
                movieService.save(movie1);
            });
            rentFound.setCurrent(false);
            rentRepository.save(rentFound);

            return rentFound;
        } else {
            throw new IllegalArgumentException(String.format("Não existe locação para o usuário %s, para o filme com id %s",
                    rent.getEmail(),
                    rent.getIdMovie()));
        }
    }

    private void saveMovie(Rent rent) {
        Optional<Movie> movie = movieService.findById(rent.getIdMovie());

        validIfExistAvailablaQuantityAndUpdateQuantity(movie);

        rent.setCurrent(true);
        rent.setMovie(movie.get());
        movieService.save(movie.get());
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
}
