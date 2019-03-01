package br.com.locadora.resource;

import br.com.locadora.domain.in.RentDomainIn;
import br.com.locadora.domain.out.RentDomainOut;
import br.com.locadora.facade.RentFacade;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/admin/rent")
public class RentResource {

    private final RentFacade rentFacade;

    @Autowired
    public RentResource(RentFacade rentFacade) {
        this.rentFacade = rentFacade;
    }

    @PostMapping
    @ApiOperation(value = "Salva uma locação", response = RentDomainOut.class)
    public ResponseEntity<RentDomainOut> save(@Valid @RequestBody RentDomainIn rentDomainIn) {
        return ResponseEntity.ok(rentFacade.save(rentDomainIn));
    }

    @PutMapping
    @ApiOperation(value = "Faz a devolução de um filme", response = RentDomainOut.class)
    public ResponseEntity<RentDomainOut> update(@Valid @RequestBody RentDomainIn rentDomainIn) {
        return ResponseEntity.ok(rentFacade.update(rentDomainIn));
    }
}
