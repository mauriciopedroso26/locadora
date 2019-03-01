package br.com.locadora.facade;

import br.com.locadora.converter.RentDomainInToRent;
import br.com.locadora.converter.RentToRentDomainOut;
import br.com.locadora.domain.in.RentDomainIn;
import br.com.locadora.domain.out.RentDomainOut;
import br.com.locadora.entity.Rent;
import br.com.locadora.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RentFacade {

    private final RentService rentService;
    private final RentDomainInToRent rentDomainInToRent;
    private final RentToRentDomainOut rentToRentDomainOut;

    @Autowired
    public RentFacade(RentService rentService, RentDomainInToRent rentDomainInToRent,
                      RentToRentDomainOut rentToRentDomainOut) {
        this.rentService = rentService;
        this.rentDomainInToRent = rentDomainInToRent;
        this.rentToRentDomainOut = rentToRentDomainOut;
    }

    public RentDomainOut save(RentDomainIn rentDomainIn) {
        Rent rent = rentService.save(rentDomainInToRent.convert(rentDomainIn));
        return rentToRentDomainOut.convert(rent);
    }

    public RentDomainOut update(RentDomainIn rentDomainIn) {
        Rent rent = rentService.update(rentDomainInToRent.convert(rentDomainIn));
        return rentToRentDomainOut.convert(rent);
    }
}
