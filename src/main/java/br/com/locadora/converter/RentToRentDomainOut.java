package br.com.locadora.converter;

import br.com.locadora.domain.out.RentDomainOut;
import br.com.locadora.entity.Rent;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class RentToRentDomainOut implements Converter<Rent, RentDomainOut> {

    private final ModelMapper modelMapper;

    public RentToRentDomainOut(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public RentDomainOut convert(Rent rent) {
        RentDomainOut rentDomainOut = modelMapper.map(rent, RentDomainOut.class);

        if (Objects.isNull(rentDomainOut)) {
            throw new IllegalArgumentException("Objeto Rent não pode ser convertido em RenteDomainOut");
        }

        return rentDomainOut;
    }
}
