package br.com.locadora.resource;

import br.com.locadora.domain.UserDomainIn;
import br.com.locadora.domain.UserDomainOut;
import br.com.locadora.facade.UserFacade;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/admin/user")
public class UserResource {

    private final UserFacade userFacade;

    @Autowired
    public UserResource(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    @PostMapping
    @ApiOperation(value = "Salva um novo usuário", response = UserDomainOut.class)
    public ResponseEntity<UserDomainOut> save(@Valid @RequestBody UserDomainIn userDomainIn) {
        return ResponseEntity.ok(userFacade.save(userDomainIn));
    }
}
