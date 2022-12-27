package tn.esprit._3cinfogl1.springbootsecondproject.DAO.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit._3cinfogl1.springbootsecondproject.DAO.Entities.Cinema;

import java.util.List;

@Repository
public interface CinemaRepository extends CrudRepository<Cinema,Long> {
    //Avec Key words

    //Afficher liste cinema dont le nom contient le string en paramétre
    List<Cinema> getCinemaByNomContains(String name);



    //SQL
   //Afficher la liste de Cinema dont l'adresse est celui qui est pasé en paramétre (SQL)

    @Query(value = "select * FROM cinema where adresse like %?1% ",nativeQuery = true)
      List<Cinema> afficherCinemaByAdressSQL(String adress);




}
