/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventu_prototype;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;

/**
 *
 * @author Zach
 */
public class UserCtrl {
    
    User currentUser;
    
    //sets current user given and logs activity
    public UserCtrl(User user){
        
        this.currentUser = user;
        System.out.println("--User controller instantiated");
    }
    
    //requests to model---------------------------
    
    void setUsername(String username) {
        
        currentUser.setUsername(username);
    }

    void setPassword(String password) {
        
        currentUser.setPassword(password);
    }

    void setProfileType(int profileType) {
        
        currentUser.setProfileType(profileType);
    }
    
    //serializes and saves user object data to file system
    void saveCredentials() throws FileNotFoundException, IOException{
        
        try{
            
            //saving object data to file
            File saveFile = new File("users/" + currentUser.getUsername() + ".ser");
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(saveFile));
            out.writeObject(currentUser);
            
            System.out.println(currentUser.getUsername() + "'s user info stored.");
            
        }catch(FileNotFoundException missingFile){
            
            JOptionPane.showMessageDialog(null, "Error regarding save file.","Error",JOptionPane.ERROR_MESSAGE);
            
        }catch(IOException ioExcept){
            
            JOptionPane.showMessageDialog(null, "Something went wrong.","Error",JOptionPane.ERROR_MESSAGE);
            
        }
    }
    
    void editUser(){
        
        EditUserFrame editUser = new EditUserFrame(currentUser);
    }
    
    void deleteUser(){
        
        File saveFile = new File("users/" + currentUser.getUsername() + ".ser");
        
        try{
            if(saveFile.delete() && saveFile.exists()){
    		System.out.println(saveFile.getName() + " is deleted!");
            }else{
    		System.out.println("Delete operation failed.");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
