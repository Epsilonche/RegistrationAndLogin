package org.hbrs.se2.project.collhbrs.control.factories;

import org.hbrs.se2.project.collhbrs.dtos.VacDTO;
import org.hbrs.se2.project.collhbrs.dtos.UserDTO;
import org.hbrs.se2.project.collhbrs.entities.Vacancy;

public class VacFactory {
    public static Vacancy createVac(VacDTO vacDTO, UserDTO userDTO) {
        //erzeuge eine neue Vacancy (Stellenausschreibung)
        //ID wird automatisch hochgezählt
        Vacancy vac = new Vacancy();

        //Grundparameter werden aus vacDTO übernommen
        vac.setStatus( 1  );
        vac.setWorkplace(  vacDTO.getWorkplace() );
        vac.setHomeoffice( vacDTO.getHomeoffice() );
        vac.setSalary( vacDTO.getSalary() );
        vac.setTitle(  vacDTO.getTitle() );
        vac.setDescription( vacDTO.getDescription() );

       //Company noch nicht vollständig erzeugt, daher keine Zuweisung zu einer companyid
        //vac.setCompanyId( CompanyDTO.getId() );

        return vac;
    }
}