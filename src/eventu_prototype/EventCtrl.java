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
public class EventCtrl {
    
    Event currentEvent;
    
    public EventCtrl(){
        System.out.println("--Event controller instantiated");
    }
    
    public EventCtrl(Event event){
        
        this.currentEvent = event;
        System.out.println("--Event controller instantiated with event");
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
    
    Event getEvent(User user, String name) throws FileNotFoundException, IOException, ClassNotFoundException{

        File folder = new File("events/" + user.getUsername());
        String mockName = name + ".ev";
        Event eventFile = null;
        
        
        try{
            File[] listOfFiles = folder.listFiles();
        
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile() && mockName.equals(listOfFile.getName())) {
                
                //find file and read object info
                FileInputStream fiStream = new FileInputStream(folder + "/" +listOfFile.getName());
                ObjectInputStream oiStream = new ObjectInputStream(fiStream);
                
                //Cast object
                eventFile = (Event) oiStream.readObject();
                break;
            }
        }
        }catch(NullPointerException ex){
            System.out.println("**System found no events for user**");
        }
        
        return eventFile;
    }
    
    void saveEvent() throws FileNotFoundException, IOException{
        
        try{
            
            //saving object data to file
            File saveFile = new File("events/" + currentEvent.user.getUsername() + "/" + currentEvent.getName() + ".ev");
            saveFile.getParentFile().mkdirs();
            
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(saveFile));
            out.writeObject(currentEvent);
            
            System.out.println(currentEvent.user.getUsername() + "'s event info stored: " + currentEvent.getName());
            
        }catch(FileNotFoundException missingFile){
            
            JOptionPane.showMessageDialog(null, "Error regarding save file.","Error", JOptionPane.ERROR_MESSAGE);
            
        }catch(IOException ioExcept){
            
            JOptionPane.showMessageDialog(null, "Something went wrong.","Error", JOptionPane.ERROR_MESSAGE);
            
        }
    }
    
    //a club user can view their created events
    ArrayList<Event> getClubEvents(User user) throws FileNotFoundException, IOException, ClassNotFoundException{
        
        ArrayList<Event> events = new ArrayList<>();
        
        File folder = new File("events/" + user.getUsername());
        
        try{
            File[] listOfFiles = folder.listFiles();
        
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                
                //find file and read object info

                FileInputStream fiStream = new FileInputStream(folder + "/" +listOfFile.getName());
                ObjectInputStream oiStream = new ObjectInputStream(fiStream);
                
                //Cast object and add to arraylist
                Event eventFile = (Event) oiStream.readObject();
                events.add(eventFile);
            }
        }
        }catch(NullPointerException ex){
            System.out.println("**System found no events for user**");
        }
        
        return events;
    }
    
    ArrayList<Event> getAllEvents() throws FileNotFoundException, IOException, ClassNotFoundException{
        
        ArrayList<Event> events = new ArrayList<Event>();
        File parentDir = new File("events/");
        File[] listOfFiles = parentDir.listFiles();
        
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
          
                //find file and read object info
                FileInputStream fiStream = new FileInputStream(new File(parentDir + listOfFiles[i].getName()));
                System.out.println(listOfFiles[i].getName());
                ObjectInputStream oiStream = new ObjectInputStream(fiStream);

                //Cast object and add to arraylist
                Event eventFile = (Event) oiStream.readObject();
                events.add(eventFile);
            }
        }
        
        return events;
    }
}
