/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanager.ui.addbook;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import librarymanager.Database.DatabaseHandler;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author Kwesi-Welbred
 */
public class AddbookController implements Initializable {

    @FXML
    private StackPane rootPane;
    @FXML
    private AnchorPane mainContainer;
    @FXML
    private JFXTextField title;
    @FXML
    private JFXTextField id;
    @FXML
    private JFXTextField author;
    @FXML
    private JFXTextField publisher;
    @FXML
    private JFXButton saveButton;
    @FXML
    private JFXButton cancelButton;
    
    DatabaseHandler databasehandler;//Object of the Database
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        databasehandler = new DatabaseHandler();
        checData();
    }

    @FXML
    private void addBook(ActionEvent event) {
        String BookID = id.getText();
        String BookTitle = title.getText();
        String BookAuthor = author.getText();
        String BookPublisher = publisher.getText();

        if(BookID.isEmpty()||BookTitle.isEmpty()||BookAuthor.isEmpty()||BookPublisher.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please fill all fields");
            alert.showAndWait();
        }
        
        String qu = "insert into BOOK values("+
                "'"+BookID+"',"+
                 "'"+BookTitle+"',"+
                 "'"+BookAuthor+"',"+
                 "'"+BookPublisher+"',"+
                 ""+true+""+
                ")";
        System.out.println(qu);
        if(databasehandler.execAction(qu)){
              Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("sucess");
            alert.showAndWait();
        }else{
          Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Failed");
            alert.showAndWait();
        }
    }

    @FXML
    private void cancel(ActionEvent event) {
        Stage stage = (Stage) rootPane.getScene().getWindow();
        stage.close();
    }

    private void checData() {
    String qu = "select title form BOOK";
    ResultSet rs = databasehandler.execQuery(qu);
        try {
            while(rs.next()){
                String Title = rs.getString("title");
            }   } catch (SQLException ex) {
            Logger.getLogger(AddbookController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
