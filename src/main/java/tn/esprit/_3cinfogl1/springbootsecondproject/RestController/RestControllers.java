package tn.esprit._3cinfogl1.springbootsecondproject.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit._3cinfogl1.springbootsecondproject.DAO.Entities.Cinema;
import tn.esprit._3cinfogl1.springbootsecondproject.DAO.Entities.Film;
import tn.esprit._3cinfogl1.springbootsecondproject.DAO.Entities.Salle;
import tn.esprit._3cinfogl1.springbootsecondproject.Services.IServices;

import java.util.List;

   @RestController
   @RequestMapping("Exercice_Rest")
public class RestControllers {

   @Autowired
   private IServices iServicesRest;

   //Methodes de Cinema


    @PostMapping("Ajouter_Cinema")
    Cinema ajouterCinema(@RequestBody Cinema c){

        return iServicesRest.addCinema(c);
    }
     @PutMapping("Modifier_Cinema")
    Cinema modifierCinema(@RequestBody Cinema c){

        return iServicesRest.updateCinema(c);
  }

  @GetMapping("Afficher_tous_les_Cinemas")
   List<Cinema> getAllCinemas()
    {
      return iServicesRest.findAllCinema();
    }
    @GetMapping("Afficher_le_Cinema_By_ID ")
    Cinema findCinemaById(@RequestParam Long id){
        return iServicesRest.findCinemaById(id);
    }
     @DeleteMapping("Supprimer_un_Cinema_By_ID/{id}")
    void supprimerCinemaById(@PathVariable Long id){
        iServicesRest.deleteCinema(id);

  }
    @DeleteMapping("Supprimer_un_Cinema_By_Objet")
    void deleteCinema(@RequestBody Cinema cine){
        iServicesRest.deleteCinema(cine);
    }



    //Méthode avec KEY WORDS
    @GetMapping("Afficher_Cinema_By_Nom_Contains")
    List<Cinema> getCinemaByNomContains(@RequestParam String nom){
        return  iServicesRest.getCinemaByNomContains(nom);
    }

    //Méthode avec SQL


      @GetMapping("Afficher_Cinema_By_Adresse_SQL")
     List<Cinema> getCinemaByAdresseSQL(@RequestParam String adresse){
        return iServicesRest.getCinemaByAdresseSQL(adresse);
     }
       //Methodes de Film

    @PostMapping("Ajouter_Film")
    Film ajouterFilm(@RequestBody Film film) {
    return iServicesRest.addFilm(film);
    }
    @PutMapping("Modifier_Film")
    Film modifierCinema(@RequestBody Film film){
        return iServicesRest.updateFilm(film);
    }
    @GetMapping("Afficher_tous_les_Films")
     List<Film> getAllFilms(){

        return iServicesRest.findAllFilms();
    }

    @GetMapping("Afficher_le_Film_By_ID ")
    Film findFilmById(@RequestParam Long id) {
    return iServicesRest.findFilmById(id);
    }
    @DeleteMapping("Supprimer_un_Film_By_ID/{id}")
    void supprimerFilmById(@PathVariable Long id) {

      iServicesRest.deleteFilm(id);
    }
       @DeleteMapping("Supprimer_un_Film_By_Objet")
       void deleteFilm(@RequestBody Film film){
        iServicesRest.deleteFilm(film);
       }
       //Méthodes de Salle

    @PostMapping("Ajouter_Salle")
    Salle ajouterSalle(@RequestBody Salle salle) {
        return iServicesRest.addSalle(salle);
    }
    @PutMapping("Modifier_Salle")
    Salle modifierCinema(@RequestBody Salle salle){
        return iServicesRest.updateSalle(salle);
    }
    @GetMapping("Afficher_toutes_les_Salles")
     List<Salle> getAllSalles(){

        return iServicesRest.findAllSalles();
    }

    @GetMapping("Afficher_la_Salle_By_ID ")
    Salle findSalleById(@RequestParam Long id) {
        return iServicesRest.findSalleById(id);
    }
    @DeleteMapping("Supprimer_une_Salle_By_ID/{id}")
    void supprimerSalleById(@PathVariable Long id) {

        iServicesRest.deleteSalle(id);
    }
       @DeleteMapping("Supprimer_une_Salle_By_Objet")
       void deleteSalle(@RequestBody Salle salle) {
        iServicesRest.deleteSalle(salle);
       }

    //Méthodes d'affectation et de désaffectation

    @PutMapping("Affecter_une_salle_au_Cinema")
    void affecterSalleToCinema(@RequestParam Long idCinema,@RequestParam Long idSalle){
        iServicesRest.affecterSalleToCinema(idCinema,idSalle);

    }

    @PutMapping("Affecter_un_Film_à_une_salle")
    void affecterFilmToSalle(@RequestParam Long idFilm,@RequestParam Long idSalle) {
     iServicesRest.affecterFilmToSalle(idFilm,idSalle);

    }


    @PutMapping("Desaffecter_une_salle_de_Cinema")
    void desaffecterSalleFromCinema(@RequestParam Long idSalle){
        iServicesRest.desaffecterSalleFromCinema(idSalle);

    }
    @PutMapping("Desaffecter_une_Film_d'une_Salle")
    void desaffecterFilmFromSalle(@RequestParam Long idFilm,@RequestParam Long idSalle){
       iServicesRest.desaffecterFilmFromSalle(idFilm,idSalle);
    }

}
