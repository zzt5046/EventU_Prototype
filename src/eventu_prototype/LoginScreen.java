/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventu_prototype;

import com.sun.jndi.cosnaming.IiopUrl.Address;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 *
 * @author jah6080
 */
public class LoginScreen {
    
    public LoginScreen(){
        
        System.out.println("--Login backend instantiated");
    }
    
    boolean authenticate(String email, String password){
        
        String filepath = "users/" + email + ".ser";
        
         LoginScreen objectIO = new LoginScreen();

        //Read object from file
        User user = (User) objectIO.ReadFromFile(filepath);
        System.out.println(user);
        return true;
    }
        
        public Object ReadFromFile(String filepath){
        
        try{    
            FileInputStream fileIn = new FileInputStream(filepath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            
            Object obj = objectIn.readObject();
            objectIn.close();
            System.out.println("File read successfully.");
            return obj;
            
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
