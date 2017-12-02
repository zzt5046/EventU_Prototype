/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventu_prototype;

import java.awt.event.ActionEvent;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Zach
 */
public class GUIController {
    
    //login elements
    @FXML
    private TextField usernameLoginField;
    @FXML
    private TextField passwordLoginField;
    
    //register elements
    @FXML
    private TextField usernameRegisterField;
    @FXML
    private TextField passwordRegisterField;
    @FXML
    private TextField confirmRegisterField;

    
    //login button - login
    public void loginButtonPress(){

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
    
    //register button - login
    @FXML
    public void loginRegisterButtonPress(ActionEvent event) throws IOException{
        System.out.println("Register pressed");
        
        Stage stageTheEventSourceNodeBelongs = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("CreateAccountFrameFX.fxml"));
       // primaryStage.setScene(new Scene(root, 305, 500));
       // Stage.setScene(new Scene(new Pane()));
    }
    
    //register button - register
    public void registerButtonPress(){

    }
    
    public void openIndivMenu(String user){
        
    }
    
    public void openClubMenu(String user){
        
    }
}
