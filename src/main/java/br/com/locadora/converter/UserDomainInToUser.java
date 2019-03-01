package br.com.locadora.converter;

import br.com.locadora.domain.UserDomainIn;
import br.com.locadora.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class UserDomainInToUser implements Converter<UserDomainIn, User> {

    private final ModelMapper modelMapper;

    public UserDomainInToUser(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public User convert(UserDomainIn userDomainIn) {
        User user = modelMapper.map(userDomainIn, User.class);

        user.setIdUser(null);

        if (Objects.isNull(user)) {
            throw new IllegalArgumentException("Objeto UserDomainIn não pode ser convertido em User");
        }

        return user;
    }
}
