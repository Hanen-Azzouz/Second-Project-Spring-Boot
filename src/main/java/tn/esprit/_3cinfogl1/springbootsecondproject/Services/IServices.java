package tn.esprit._3cinfogl1.springbootsecondproject.Services;

import tn.esprit._3cinfogl1.springbootsecondproject.DAO.Entities.Cinema;
import tn.esprit._3cinfogl1.springbootsecondproject.DAO.Entities.Film;
import tn.esprit._3cinfogl1.springbootsecondproject.DAO.Entities.Salle;

import java.util.List;

public interface IServices {

    //Crud Cinema
   Cinema addCinema(Cinema cine);
   Cinema updateCinema(Cinema cine);
   void deleteCinema(Cinema cine);
   void deleteCinema(Long id);
   Cinema findCinemaById(Long id);
   List<Cinema> findAllCinema();
    //Crud Salle
    Salle addSalle(Salle s);
    Salle updateSalle(Salle s);
    void deleteSalle(Salle s);
    void deleteSalle(Long id);
    Salle findSalleById(Long id);
    List<Salle> findAllSalles();
    //Crud Film
    Film addFilm(Film f);
    Film updateFilm(Film f);
    void deleteFilm(Film f);
    void deleteFilm(Long id);
    Film findFilmById(Long id);
    List<Film> findAllFilms();


//Methodes avec KEYWORDS - SQL-JPQL

   // Avec KEY WORD
    List<Cinema> getCinemaByNomContains(String nom);

    // Avec SQL
   List<Cinema> getCinemaByAdresseSQL(String adresse);

   //Methodes des affections

   //affecter une salle à un Cinema

    void affecterSalleToCinema(Long idCinema,Long idSalle);


    //Affecter un film à une salle
      void affecterFilmToSalle(Long idFilm,Long idSalle);

    //Désaffecter une salle à un Cinema
    void desaffecterSalleFromCinema(Long idSalle);

    //DésAffecter un film à une salle
    void desaffecterFilmFromSalle(Long idFilm,Long idSalle);

    //Travail à faire
    //Afficher la liste des films par salle
    List<Film> recupererFilmParSalle(Long idSalle);

    //Ajouter un film et l'affecter à une salle
    Film ajouterFilmEtAffecterAuneSalle(Film f,String nom);



}
