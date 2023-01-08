package tn.esprit._3cinfogl1.springbootsecondproject.DAO.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit._3cinfogl1.springbootsecondproject.DAO.Entities.Film;

import java.util.List;

@Repository
public interface FilmRepository extends CrudRepository<Film,Long> {


    @Query(value = "select  f from film" +
            "join salle_films_list sf on f.id=sf.films_list_id" +
            "join salle s on s.id=sf.salle_id" +
            "where s.id=?1 ",nativeQuery = true)
    List<Film> recuprerFilmsBySalleSQL(Long idsalle);






}
