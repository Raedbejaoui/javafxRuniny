/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import entite.Evenement;
import java.io.IOException;
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
public class EventController implements Initializable {

    @FXML
    private ListView<String> tflist;
    @FXML
    private TextField tfprix;
    @FXML
    private TextField tfdesc;
    @FXML
    private TextField tfnom;
    @FXML
    private DatePicker tfdate;

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
                String nom = rs.getString("nom");
                int Prix = rs.getInt("Prix");
                String descri = rs.getString("descri");
                Date dateEven = rs.getDate("dateEven");
                String list = nom + "  /  " + Prix + "  /  "  + descri + "  /  "  + dateEven ;
                tflist.getItems().add(list);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }    

    @FXML
    private void abo(ActionEvent event) {
    }
   
    @FXML
    private void ajouter(ActionEvent event) {
        int prix = Integer.parseInt(tfprix.getText());
        String descri = tfdesc.getText();
        String nom = tfnom.getText();
        LocalDate dateEven = tfdate.getValue();
        Evenement e = new Evenement();
        e.setNom(nom);
        e.setDescri(descri);
        e.setDateEvent(new Date (2022,03,03));
        e.setPrix(prix);
        EvenementCRUD ed = new EvenementCRUD();
        ed.ajouterEvenement2(e);
       tflist.getItems().add(e.toString());
    }

    @FXML
    private void modifier(ActionEvent event) {
 
    }
    
    @FXML
    private void supprimer(ActionEvent event) {
        int Nom=tflist.getSelectionModel().getSelectedIndex();
        tflist.getItems().remove(Nom);
    }

    @FXML
    private void participant(ActionEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("Participant.fxml"));
        Scene scene3 = new Scene(fxml);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene3);
        window.show(); 
    }
    }

  
    