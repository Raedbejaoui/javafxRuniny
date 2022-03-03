/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entite.Evenement;
import entite.Participant;
import java.sql.Date;
import service.EvenementCRUD;
import service.ParticipantCRUD;
import utils.MyDB;

/**
 *
 * @author pc
 */
public class main {
          public static void main (String[] args){
     MyDB.getInstance();
       EvenementCRUD ecd = new EvenementCRUD();
       //ecd.ajouterEvenement();
     
       //  ajout d'un evenement//
      // Evenement e = new Evenement(2,"ssasa","xx",new Date(122, 3, 30));
       //ecd.ajouterEvenement2(e);
        //System.out.println(ecd.afficherEvenements());
        //ecd.supprimerEvenement();
        //ecd.modifierEvenement();
    //ajouter participant
    //ParticipantCRUD ps = new ParticipantCRUD ();
   
            
}
}
