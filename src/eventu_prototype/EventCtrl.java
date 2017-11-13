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
public class EventCtrl {
    
    Event currentEvent;
    
    public EventCtrl(Event event){
        
        this.currentEvent = event;
        System.out.println("--Event controller instantiated");
    }
    
    //relay info to model
    
    void setUser(User user){
        currentEvent.setUser(user);
    }
    
    void setName(String name) {
        currentEvent.setName(name);
    }

    void setTimeStart(String timeStart) {
        currentEvent.setTimeStart(timeStart);
    }

    void setTimeEnd(String timeEnd) {
        currentEvent.setTimeEnd(timeEnd);
    }
    
    void setLocation(String location){
        currentEvent.setLocation(location);
    }
    
    void setDate(String date){
        currentEvent.setDate(date);
    }
    
    void setDescription(String description){
        currentEvent.setDescription(description);
    }
    
    void setPrice(float price){
        currentEvent.setPrice(price);
    }
    
    void saveEvent() throws FileNotFoundException, IOException{
        
        try{
            
            //saving object data to file
            File saveFile = new File("events/" + currentEvent.user.getEmail() + "/" + currentEvent.getName() + ".ev");
            saveFile.getParentFile().mkdirs();
            
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(saveFile));
            out.writeObject(currentEvent);
            
        }catch(FileNotFoundException missingFile){
            
            JOptionPane.showMessageDialog(null, "Error regarding save file.","Error", JOptionPane.ERROR_MESSAGE);
            
        }catch(IOException ioExcept){
            
            JOptionPane.showMessageDialog(null, "Something went wrong.","Error", JOptionPane.ERROR_MESSAGE);
            
        }
    }
}
