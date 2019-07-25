/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanager.ui.listmember;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Kwesi-Welbred
 */
public class ListmemberController implements Initializable {

    @FXML
    private TableView<Member> tableView;
    @FXML
    private TableColumn<Member, String> nameCol;
    @FXML
    private TableColumn<Member, String> idCol;
    @FXML
    private TableColumn<Member, String> mobCol;
    @FXML
    private TableColumn<Member, String> emailCol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        initCol();
    }    
    
    private void initCol() {
          nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));//datafileds
          idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
          mobCol.setCellValueFactory(new PropertyValueFactory<>("mobile"));
          emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
    }
    public static class Member{
        
    private final SimpleStringProperty name;
    private final SimpleStringProperty id;
    private final SimpleStringProperty mobile;
    private final SimpleStringProperty email;
    
    //constructor
    Member(String name, String id, String mobile, String email ){
    this.name= new SimpleStringProperty(name);
    this.id = new SimpleStringProperty(id);
    this.mobile = new SimpleStringProperty(mobile);
    this.email = new SimpleStringProperty(email);
   
    }
    //Getters
        public String getTitle() {
            return name.get();
        }

        public String getId() {
            return id.get();
        }

        public String getAuthor() {
            return mobile.get();
        }

        public String getPublisher() {
            return email.get();
        }

       
    
    
    
    }
}
