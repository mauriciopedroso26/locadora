package br.com.locadora.converter;

import br.com.locadora.domain.in.RentDomainIn;
import br.com.locadora.entity.Rent;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class RentDomainInToRent implements Converter<RentDomainIn, Rent> {

    private final ModelMapper modelMapper;

    public RentDomainInToRent(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public Rent convert(RentDomainIn rentDomainIn) {
        Rent rent = modelMapper.map(rentDomainIn, Rent.class);

        rent.setIdRent(null);
        rent.getMovie().setIdMovie(null);

        if (Objects.isNull(rent)) {
            throw new IllegalArgumentException("Objeto RenteDomainIn não pode ser convertido em Rent");
        }

        return rent;
    }
}
