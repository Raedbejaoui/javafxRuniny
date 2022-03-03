/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import utils.MyDB;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
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
    private Button botaj;
    @FXML
    private Button botmo;
    @FXML
    private Button botsup;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
           MyDB ds = new MyDB();
        Connection cnx = ds.getConnection();
        String req = "SELECT * from participant";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                int id_parti = rs.getInt("id_parti");
                int idEvent = rs.getInt("idEvent");
                int id_user = rs.getInt("id_user");
                String list ="           "+ id_parti + "                           " + idEvent + "                   " + id_user ;
                tfliste.getItems().add(list);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
    }    
    }
    @FXML
      private void supprimer(ActionEvent event) {
        int Nom=tfliste.getSelectionModel().getSelectedIndex();
        tfliste.getItems().remove(Nom);
      }

   @FXML
    private void event(ActionEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("Event.fxml"));
        Scene scene3 = new Scene(fxml);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene3);
        window.show(); 
    }
    }

