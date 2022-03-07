/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.EventController.selectedItemm;
import entite.Evenement;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import service.EvenementCRUD;
import utils.MyDB;

/**
 * FXML Controller class
 *
 * @author pc
 */
public class ParticipantController implements Initializable {

    @FXML
    private ListView<String> tfliste;
    @FXML
    private ListView<String> tfevent;
    
    static Evenement selectedItemm;
    @FXML
    private Button ajout;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MyDB ds = new MyDB();
        Connection cnx = ds.getConnection();
        String req = "SELECT * from events";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                int ID = rs.getInt("idEven");
                String Nom = rs.getString("nom");
                String list = "       " + ID + "                  " + Nom;
                tfevent.getItems().add(list);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());;

        }

    }

    @FXML
    private void ajouteven(ActionEvent event) {
       int idEven = Integer.parseInt(tfevent.getText());
       
        e.setIdEvent(idEvent);
        EvenementCRUD ed = new EvenementCRUD();
        ed.ajouterEvenement2(e);
       tfliste.getItems().add(e);
    }
     @FXML
   private void index3(MouseEvent event) {
        selectedItemm = tfevent.getSelectionModel().getSelectedItem();
        tfevent.setText(int.valueOf(tfliste.getIdEven()));
        
    }
}
