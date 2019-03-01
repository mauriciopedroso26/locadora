package br.com.locadora.converter;

import br.com.locadora.domain.out.MovieDomainOut;
import br.com.locadora.entity.Movie;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class MovieToMovieDomainOutConverter implements Converter<Movie, MovieDomainOut> {

    private final ModelMapper modelMapper;

    public MovieToMovieDomainOutConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public MovieDomainOut convert(Movie movie) {
        MovieDomainOut movieDomainOut = modelMapper.map(movie, MovieDomainOut.class);

        if (Objects.isNull(movieDomainOut)) {
            throw new IllegalArgumentException("Objeto Movie não pode ser convertido em MovieDomainOut");
        }

        return movieDomainOut;
    }
}
