package org.hbrs.se2.project.collhbrs.repository;

import org.hbrs.se2.project.collhbrs.dtos.VacDTO;
import org.hbrs.se2.project.collhbrs.entities.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VacancyRepository extends JpaRepository<Vacancy,Integer> {
//JPA Repository für die Verwaltung von Stellenanzeigen
    VacDTO findVacancyByVacId(int vac_id);

    List<VacDTO> findVacancyByVacIdIsNotNull();
    VacDTO findVacancyByTitleAndDescription(String title, String description);
    void deleteVacancyByDescriptionAndTitle(String description, String title);

}




