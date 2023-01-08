package tn.esprit._3cinfogl1.springbootsecondproject.DAO.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit._3cinfogl1.springbootsecondproject.DAO.Entities.Salle;
@Repository
public interface SalleRepository extends CrudRepository<Salle,Long> {


    Salle getSalleByNom(String nom);


}
