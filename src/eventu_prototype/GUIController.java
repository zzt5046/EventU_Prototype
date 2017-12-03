/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventu_prototype;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Zach
 */
public class GUIController implements Initializable{
    
    ObservableList<String> categoryList = FXCollections.observableArrayList("Individual", "Club");
    
    //login screen elements
    @FXML private TextField usernameLoginField;
    @FXML private TextField passwordLoginField;
    
    //register screen elements
    @FXML private TextField usernameRegisterField;
    @FXML private PasswordField passwordRegisterField;
    @FXML private PasswordField confirmRegisterField;
    @FXML private ComboBox accountCategory = new ComboBox();
    
    //indiv menu elements
    
    //club menu elements
    
    //add event screen elements
    
    //view event screen elements
    
    //search event screen elements

    //login button - login--------------------------------------------------------------------------
    @FXML public void loginButtonPress(){

        LoginScreen logic = new LoginScreen();
        String un = usernameLoginField.getText();
        String pw = passwordLoginField.getText();
        
        
        if(un.equals("") || pw.equals("")){
            JOptionPane.showMessageDialog(null, "Please fill out all fields.");
        }else{
            if(logic.authenticate(un, pw)){
                System.out.print("authenticated");
            }else{
                JOptionPane.showMessageDialog(null, "Wrong username/password.");
            }
        }
    }
    
    //register button - login------------------------------------------------------------------------
    @FXML public void loginRegisterButtonPress(ActionEvent event) throws IOException{
        
        changeScene("CreateAccountFrameFX.fxml", event); 
    }
    
    //register button - register---------------------------------------------------------------------
    @FXML public void registerButtonPress(ActionEvent event) throws IOException{
        
        String un = usernameRegisterField.getText();
        String pw = passwordRegisterField.getText();
        String conf = confirmRegisterField.getText();
        
        int category = 2;
        if(accountCategory.getValue().equals("Individual")){
            category = 0;
        }
        else if(accountCategory.getValue().equals("Club")){
            category = 1;
        }
        
        if(un.equals("") || pw.equals("") || conf.equals("") || category == 2){
            JOptionPane.showMessageDialog(null, "Please fill out all fields.");
        }else{
            if(pw.equals(conf)){
                CreateAccount backend = new CreateAccount(un, pw, category);
                backend.createUser(un, pw, category);
                changeScene("LoginScreenFrameFX.fxml", event); 
            }else{
                JOptionPane.showMessageDialog(null, "Wrong username/password.");
            }
        }
    }
     
    //register screen cancel
    @FXML public void registerCancelPress(ActionEvent event) throws IOException{
        changeScene("LoginScreenFrameFX.fxml", event);
    }
    
    public void openIndivMenu(String user){
        
    }
    
    public void openClubMenu(String user){
        
    }

    public void changeScene(String file, ActionEvent event) throws IOException{
        
        Parent register_parent = FXMLLoader.load(getClass().getResource(file));
        Scene registerScene = new Scene(register_parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(registerScene);
        window.show();
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        accountCategory.setValue("Individual");
        accountCategory.setItems(categoryList);
    }
}
