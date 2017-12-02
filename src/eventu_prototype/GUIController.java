/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventu_prototype;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
    
    public void registerButtonPress(){
        System.out.println("Register pressed");
    }
    
    public void openIndivMenu(String user){
        
    }
    
    public void openClubMenu(String user){
        
    }
}
