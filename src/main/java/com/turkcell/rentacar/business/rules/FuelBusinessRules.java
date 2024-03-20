package com.turkcell.rentacar.business.rules;

import com.turkcell.rentacar.core.utilities.exceptions.types.BusinessException;
import com.turkcell.rentacar.dataAccess.abstracts.FuelRepository;
import com.turkcell.rentacar.entities.concretes.Fuel;
import com.turkcell.rentacar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@AllArgsConstructor
public class FuelBusinessRules {
    private FuelRepository fuelRepository;
    public void fuelNameCanNotBeDuplicated(String fuelName){
        Optional<Fuel> fuel=this.fuelRepository.findByNameIgnoreCase(fuelName);
        if (fuel.isPresent()){
            throw new BusinessException("FuelExists");
        }
    }
}
