package br.com.locadora.converter;

import br.com.locadora.domain.UserDomainOut;
import br.com.locadora.domain.out.RentDomainOut;
import br.com.locadora.entity.Rent;
import br.com.locadora.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class UserToUserDomainOut implements Converter<User, UserDomainOut> {

    private final ModelMapper modelMapper;

    public UserToUserDomainOut(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDomainOut convert(User user) {
        UserDomainOut userDomainOut = modelMapper.map(user, UserDomainOut.class);

        if (Objects.isNull(userDomainOut)) {
            throw new IllegalArgumentException("Objeto User não pode ser convertido em UserDomainOut");
        }

        return userDomainOut;
    }
}
