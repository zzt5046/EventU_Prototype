/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventu_prototype;

//import com.sun.jndi.cosnaming.IiopUrl.Address;
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
    
    GUIController ctrl;
    
    public LoginScreen(){
        System.out.println("--Login backend instantiated");
    }
    
    boolean authenticate(String username, String password){
        
        boolean authenticated = false;
        
        try {
            
            //find file and read user info
            FileInputStream fiStream = new FileInputStream(new File("users/" + username + ".ser"));
            ObjectInputStream oiStream = new ObjectInputStream(fiStream);

            // Read objects
            User userFile = (User) oiStream.readObject();

            //authenticate credentials
            if(userFile.getUsername().equals(username) && userFile.getPassword().equals(password)){
                
                authenticated = true;
                System.out.println("**User: " + "'" + userFile.getUsername() + "'" + " logged in.**");
                
                //open separate menu type depending on account type (individual or club)------------------------------
                switch (userFile.getProfileType()) {
                    case 0:
                        ctrl.openIndivMenu(username);
                        break;
                    case 1:
                        ctrl.openClubMenu(username);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Something went wrong :(");
                        break;
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
