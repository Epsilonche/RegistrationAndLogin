package org.hbrs.se2.project.hellocar.control;

import org.hbrs.se2.project.hellocar.control.factories.VacFactory;
import org.hbrs.se2.project.hellocar.dtos.UserDTO;
import org.hbrs.se2.project.hellocar.dtos.VacDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManageVacControl {

    @Autowired
    private VacRepository repository;


    public void createVacancy( VacDTO vacDTO , UserDTO userDTO ) {
        // Hier könnte man noch die Gültigkeit der Daten überprüfen
        // check( carDTO );

        //Erzeuge ein neues Car-Entity konsistent über eine Factory
        Vacancy vacEntity = VacFactory.createVac(  vacDTO , userDTO  );

        // Abspeicherung des Entity in die DB
        this.repository.save( vacEntity );
    }

    public List<VacDTO> readAllCars() {
        return repository.findCarsByDateIsNotNull();
    }

}
