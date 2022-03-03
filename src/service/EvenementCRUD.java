/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import entite.Evenement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.MyDB;

/**
 *
 * @author pc
 */
public class EvenementCRUD {
        public void ajouterEvenement2(Evenement e) {
        String requete2 = "INSERT INTO events (prix,descri,nom,dateEven) VALUES(?,?,?,?)";

        try {
            PreparedStatement pst = new MyDB().getConnection().prepareStatement(requete2);
            pst.setInt(1, e.getPrix());
            pst.setString(2, e.getDescri());
             pst.setString(3, e.getNom());
             pst.setDate(4, e.getDateEvent());
           
           
            pst.executeUpdate();
            System.out.println("votre evenement est ajouté");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
      
}
          public List<Evenement> afficherEvenements() {
        List<Evenement> myList = new ArrayList<>();
        try {
            String requete3 = "SELECT * FROM events";
            Statement st = new MyDB().getConnection().createStatement();
            ResultSet rs = st.executeQuery(requete3);
            while (rs.next()) {
                Evenement e = new Evenement();
                e.setDateEvent(rs.getDate("dateEven"));
                e.setNom(rs.getString("nom"));
                e.setDescri("descri");
                e.setPrix(rs.getInt("prix"));
                myList.add(e);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return myList;
    }
 public void modifierEvenement() {
        try {
            String requete5 = "Update Events SET nom='SPORT' Where idEven='1'";
            Statement st = new MyDB().getConnection().createStatement();
            st.executeUpdate(requete5);
            System.out.println("evenement modifier avec succÃ©s");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
}
 }
    public void supprimerEvenement() {
        try {
            String requete4 = "DELETE FROM Events WHERE idEven='1'";
            Statement st = new MyDB().getConnection().createStatement();
            st.executeUpdate(requete4);
            System.out.println("Evenement supprimer avec succÃ©s");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
}