/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventu_prototype;

import com.sun.jndi.cosnaming.IiopUrl.Address;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.swing.JOptionPane;

/**
 *
 * @author jah6080
 */
public class LoginScreen {
    
    public LoginScreen(){
        System.out.println("--Login backend instantiated");
    }
    
    boolean authenticate(String email, String password){
        
        boolean authenticated = false;
        
        try {
            
            //find file and read user info
            FileInputStream fiStream = new FileInputStream(new File("users/" + email + ".ser"));
            ObjectInputStream oiStream = new ObjectInputStream(fiStream);

            // Read objects
            User userFile = (User) oiStream.readObject();

            //authenticate credentials
            if(userFile.getEmail().equals(email) && userFile.getPassword().equals(password)){
                
                authenticated = true;
                System.out.println("**User: " + "'" + userFile.getEmail() + "'" + " logged in.**");
                
                //open separate menu type depending on account type (individual or club)------------------------------
                
                if(userFile.getProfileType() == 0){
                    IndivMenuFrame soloMenu = new IndivMenuFrame(userFile);
                }
                else if(userFile.getProfileType() == 1){
                    ClubMenuFrame clubMenu = new ClubMenuFrame(userFile);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Something went wrong :(");
                }
                
                oiStream.close();
                fiStream.close();
            }

        //catch potential errors-----------------------------------------------
        
	} catch (FileNotFoundException e) {
            
		System.out.println("File not found");
                
	} catch (IOException e) {
            
                JOptionPane.showMessageDialog(null, "Error: Something went wrong. Please contact support.");
		System.out.println("Error initializing stream");
                
	} catch (ClassNotFoundException e) {
            
		e.printStackTrace();
		}
        return authenticated;
    }
}
