/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventu_prototype;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
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
    
    void setEmail(String email) {
        
        currentUser.setEmail(email);
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
            File saveFile = new File("users/" + currentUser.getEmail() + ".ser");
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(saveFile));
            out.writeObject(currentUser);
            
            System.out.println(currentUser.getEmail() + "'s user info stored.");
            
        }catch(FileNotFoundException missingFile){
            
            JOptionPane.showMessageDialog(null, "Error regarding save file.","Error",JOptionPane.ERROR_MESSAGE);
            
        }catch(IOException ioExcept){
            
            JOptionPane.showMessageDialog(null, "Something went wrong.","Error",JOptionPane.ERROR_MESSAGE);
            
        }
    }
    
    //a club user can view their created events
    ArrayList<Event> getClubEvents(User user) throws FileNotFoundException, IOException, ClassNotFoundException{
        
        ArrayList<Event> events = new ArrayList<Event>();
        
        File folder = new File("events/" + user.getEmail() + "/");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
          
                //find file and read object info
                FileInputStream fiStream = new FileInputStream(new File(folder + listOfFiles[i].getName()));
                ObjectInputStream oiStream = new ObjectInputStream(fiStream);

                //Cast object and add to arraylist
                Event eventFile = (Event) oiStream.readObject();
                events.add(eventFile);
            }
        }
        
        return events;
    }
}
