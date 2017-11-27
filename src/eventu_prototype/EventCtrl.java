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
    static String parentDirectory = "events/";
    
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

       /* File folder = new File("events/" + user.getUsername());
        String mockName = name + ".ev";
        Event eventFile = null;
        
        
        try{
            File[] listOfFiles = folder.listFiles();
        
        for (File file : listOfFiles) {
            if (file.isFile() && mockName.equals(file.getName())) {
                
                //find file and read object info
                FileInputStream fiStream = new FileInputStream(folder + "/" +file.getName());
                ObjectInputStream oiStream = new ObjectInputStream(fiStream);
                
                //Cast object
                eventFile = (Event) oiStream.readObject();
                
                fiStream.close();
                oiStream.close();
        
                break;
            }
        }
        }catch(NullPointerException ex){
            System.out.println("**System found no events for user**");
        }*/
        
        ArrayList<Event> events = getAllEvents();
        Event chosenEvent = null;
        
        for(Event event : events){
            if(event.getUser().equals(user) && event.getName().equals(name)){
                chosenEvent = event;
            }
        }
       
        return chosenEvent;
    }
    
    void saveEvent() throws FileNotFoundException, IOException{
        
        try{
            
            //saving object data to file
            File saveFile = new File("events/" + currentEvent.user.getUsername() + "/" + currentEvent.getName() + ".ev");
            saveFile.getParentFile().mkdirs();
            
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(saveFile));
            out.writeObject(currentEvent);
            
            System.out.println(currentEvent.user.getUsername() + "'s event info stored: " + currentEvent.getName());
            
            out.close();
            
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
        
        for (File file : listOfFiles) {
            if (file.isFile()) {
                
                //find file and read object info

                FileInputStream fiStream = new FileInputStream(folder + "/" +file.getName());
                ObjectInputStream oiStream = new ObjectInputStream(fiStream);
                
                //Cast object and add to arraylist
                Event eventFile = (Event) oiStream.readObject();
                events.add(eventFile);
                
                fiStream.close();
                oiStream.close();
            }
        }
        }catch(NullPointerException ex){
            System.out.println("**System found no events for user**");
        }
        
        return events;
    }
    
    ArrayList<Event> getAllEvents() throws FileNotFoundException, IOException, ClassNotFoundException{
        
        ArrayList<Event> events = new ArrayList<>();
        Event eventFile;
        
        File directory = new File(parentDirectory);
        
        //get all the files from a directory
        File[] listFiles = directory.listFiles();
        for (File file : listFiles){
            if (file.isFile()){
                
                //find file and read object info
                FileInputStream fiStream = new FileInputStream(file.getAbsolutePath());
                ObjectInputStream oiStream = new ObjectInputStream(fiStream);
                
                //Cast object
                //eventFile = (Event) oiStream.readObject();
                events.add((Event) oiStream.readObject());
                //events.add(eventFile);
                
                fiStream.close();
                oiStream.close();
                
            } else if (file.isDirectory()){
                
                File subDirectory = new File(file.getAbsolutePath());
                File[] listSubFiles = subDirectory.listFiles();
                
                for (File subFile : listSubFiles){
                    if (subFile.isFile()){
                
                    //find file and read object info
                    FileInputStream fiStream = new FileInputStream(subFile.getAbsolutePath());
                    ObjectInputStream oiStream = new ObjectInputStream(fiStream);
                
                    //Cast object
                    //eventFile = (Event) oiStream.readObject();
                    events.add((Event) oiStream.readObject());
                    
                    fiStream.close();
                    oiStream.close();
                    }
                }
            }
        }
        
        System.out.println(events.size() + " events found.");
        return events;
    }
    
    void deleteEvent(User user, String name) throws FileNotFoundException, IOException{
        
        File eventFile = new File("events/" + user.getUsername() + "/" + name + ".ev");
          
        try{
            
            if(eventFile.exists() && eventFile.delete()){  
                System.out.println("File deleted successfully");
            }
            else {
                System.out.println("Failed to delete the file");
            }
            
        }catch(NullPointerException ex){
            System.out.println("**System found no events for user**");
        }
        
    }
}
