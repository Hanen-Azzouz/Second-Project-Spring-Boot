package tn.esprit._3cinfogl1.springbootsecondproject.Services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit._3cinfogl1.springbootsecondproject.DAO.Entities.Cinema;
import tn.esprit._3cinfogl1.springbootsecondproject.DAO.Entities.Film;
import tn.esprit._3cinfogl1.springbootsecondproject.DAO.Entities.Salle;
import tn.esprit._3cinfogl1.springbootsecondproject.DAO.Repositories.CinemaRepository;
import tn.esprit._3cinfogl1.springbootsecondproject.DAO.Repositories.FilmRepository;
import tn.esprit._3cinfogl1.springbootsecondproject.DAO.Repositories.SalleRepository;

import java.lang.annotation.Annotation;
import java.util.List;

@Service
@Slf4j
public class Services implements IServices{

    @Autowired
    private CinemaRepository cinerepo;
    @Autowired
    private FilmRepository filmrepo;
    @Autowired
    private SalleRepository sallerepo;

    // Implementation de CRUD De Cinema
    @Override
    public Cinema addCinema(Cinema cine){
        log.info("Cinema ajouté avec sucées");
        return cinerepo.save(cine);
    }
    @Override
    public Cinema updateCinema(Cinema cine) {
        return cinerepo.save(cine);
    }
    @Override
    public void deleteCinema(Cinema cine) {
      cinerepo.delete(cine);
    }
    @Override
    public void deleteCinema(Long id) {
        cinerepo.deleteById(id);
    }
    @Override
    public Cinema findCinemaById(Long id) {
        return cinerepo.findById(id).get();
    }
    @Override
    public List<Cinema> findAllCinema() {
        return (List<Cinema>) cinerepo.findAll();
    }
   // Implementation de CRUD De Salle
    @Override
    public Salle addSalle(Salle s) {
        return sallerepo.save(s);
    }

    @Override
    public Salle updateSalle(Salle s) {
        return sallerepo.save(s);
    }

    @Override
    public void deleteSalle(Salle s) {
       sallerepo.delete(s);
    }

    @Override
    public void deleteSalle(Long id) {
     sallerepo.deleteById(id);
    }

    @Override
    public Salle findSalleById(Long id) {
        return sallerepo.findById(id).get();
    }

    @Override
    public List<Salle> findAllSalles() {
        return (List<Salle>) sallerepo.findAll();
    }

    // Implémentation de CRUD De Film
    @Override
    public Film addFilm(Film f) {
        return filmrepo.save(f);
    }

    @Override
    public Film updateFilm(Film f) {
        return filmrepo.save(f);
    }

    @Override
    public void deleteFilm(Film f) {
     filmrepo.delete(f);
    }

    @Override
    public void deleteFilm(Long id) {
     filmrepo.deleteById(id);
    }

    @Override
    public Film findFilmById(Long id) {
        return filmrepo.findById(id).get();
    }

    @Override
    public List<Film> findAllFilms() {
        return (List<Film>) filmrepo.findAll();
    }



     // Implementation de methode Avec KEY WORDS
    @Override
    public List<Cinema> getCinemaByNomContains(String nom) {
        return cinerepo.getCinemaByNomContains(nom);
    }

    @Override
    public List<Cinema> getCinemaByAdresseSQL(String adresse) {
        return cinerepo.afficherCinemaByAdressSQL(adresse);
    }

    @Override
    public void affecterSalleToCinema(Long idCinema, Long idSalle) {
        //Récupération des objets
        Salle salleAffectee = sallerepo.findById(idSalle).get();//Parent
        Cinema cinemaAffecte=cinerepo.findById(idCinema).get();//child
        //On affecte le child au parent
        salleAffectee.setCine(cinemaAffecte);
        sallerepo.save(salleAffectee);

    }

    @Override
    public void affecterFilmToSalle(Long idFilm, Long idSalle) {


        Salle salleAffectee=sallerepo.findById(idSalle).get();
        Film filmAffecte=filmrepo.findById(idFilm).get();
        salleAffectee.getFilmsList().add(filmAffecte);
        sallerepo.save(salleAffectee);

    }

    @Override
    public void desaffecterSalleFromCinema(Long idSalle) {
   //Puisque la salle est le parent donc on videra la clée étrangére (id de cinema) seulemnt
        Salle salleDesaffectee=sallerepo.findById(idSalle).get();
        salleDesaffectee.setCine(null);
        sallerepo.save(salleDesaffectee);

      }

    @Override
    public void desaffecterFilmFromSalle(Long idFilm,Long idSalle) {
        Salle salleAffectee=sallerepo.findById(idSalle).get();
        Film filmAffecte=filmrepo.findById(idFilm).get();
        salleAffectee.getFilmsList().remove(filmAffecte);
        sallerepo.save(salleAffectee);
    }

    @Override
    public List<Film> recupererFilmParSalle(Long idSalle) {

        /* Premiere solution
        Salle s=sallerepo.findById(idSalle).get();
        return s.getFilmsList();*/
        //----------------------------------------------------------------------------------------------

        //  Deuxieme solution avec SQL
        return filmrepo.recuprerFilmsBySalleSQL(idSalle);
        //----------------------------------------------------------------------------------------------
        /* on ne peut pas implementer avec keyword ou JPQL car on n'a pas un attribut qui nous relie
        avec la classe salle */
    }

    @Override
    public Film ajouterFilmEtAffecterAuneSalle(Film f, String nom) {

        //Apres récuperation de l'objet on identifie le parent
       Salle salleAaffectee=sallerepo.getSalleByNom(nom);// parent salle

        /* Affectation du child film a la salle ,on a utilisé cette façon car on utilise cascade on affecte un film
        //à la salle  il sera ajouté automatiquement  dans table film */

        salleAaffectee.getFilmsList().add(f);
        sallerepo.save(salleAaffectee);
        return f;

    }


}
