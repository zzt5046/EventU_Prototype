/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventu_prototype;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 *
 * @author Zach
 */
public class SearchEvent {
    
    //Social-0, Sports-1, Fundraising-2, Other-3
    
    User currentUser;
    EventCtrl ctrl = new EventCtrl();
    ArrayList<Event> events = ctrl.getAllEvents();
    ArrayList<Event> results;
    
    //search by keyword/name
    public SearchEvent(User user, String searchTerm) throws IOException, FileNotFoundException, ClassNotFoundException{
        
        currentUser = user;
        
        
        
        for (Event event : events) {
            System.out.println(event.getName());
            if (event.getName().contains(searchTerm) || event.getName().equals(searchTerm)) {
                results.add(event);
            }
        }
        
        sendResults();
    }
    
    //search by category
    public SearchEvent(User user, int category) throws IOException, FileNotFoundException, ClassNotFoundException{
        
        currentUser = user;
        
        for (Event event : events) {
            if (event.getCategory() == category) {
                results.add(event);
            }
        }
        
        sendResults();
    }
    
    void sendResults(){
        IndivMenuFrame resultsFrame = new IndivMenuFrame(currentUser, results);
    }
}
