package br.com.locadora.facade;

import br.com.locadora.converter.UserDomainInToUser;
import br.com.locadora.converter.UserToUserDomainOut;
import br.com.locadora.domain.UserDomainIn;
import br.com.locadora.domain.UserDomainOut;
import br.com.locadora.entity.User;
import br.com.locadora.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserFacade {

    private final UserService userService;
    private final UserDomainInToUser userDomainInToUser;
    private final UserToUserDomainOut userToUserDomainOut;

    @Autowired
    public UserFacade(UserService userService, UserDomainInToUser userDomainInToUser, UserToUserDomainOut userToUserDomainOut) {
        this.userService = userService;
        this.userDomainInToUser = userDomainInToUser;
        this.userToUserDomainOut = userToUserDomainOut;
    }

    public UserDomainOut save(UserDomainIn userDomainIn){
        User user = userService.save(userDomainInToUser.convert(userDomainIn));
        return userToUserDomainOut.convert(user);
    }
}
