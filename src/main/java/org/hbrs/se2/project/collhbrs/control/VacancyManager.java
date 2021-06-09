package org.hbrs.se2.project.collhbrs.control;

import org.hbrs.se2.project.collhbrs.dtos.UserDTO;
import org.hbrs.se2.project.collhbrs.control.factories.VacFactory;
import org.hbrs.se2.project.collhbrs.dtos.VacDTO;
import org.hbrs.se2.project.collhbrs.entities.Vacancy;
import org.hbrs.se2.project.collhbrs.repository.VacancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VacancyManager {
    @Autowired
    //Erstellung vacancy repository
    private VacancyRepository repository;
    public void createVac(VacDTO vacDTO, UserDTO userDTO){

        //Erzeuge new Vacancy-Entity konsistent über eine Factory
        Vacancy vacEntity = VacFactory.createVac(vacDTO, userDTO);
        //Abspeichern in DB
        this.repository.save(vacEntity);
    }

    public VacDTO readVacByVacId(int jid){
        return repository.findVacancyByVacId(jid);
    }

}
