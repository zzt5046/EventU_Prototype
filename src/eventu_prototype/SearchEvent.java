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
    
    EventCtrl ctrl;
    ArrayList<Event> results = new ArrayList<>();
    
    //search by keyword/name
    public SearchEvent(String searchTerm) throws IOException, FileNotFoundException, ClassNotFoundException{
        
        ctrl = new EventCtrl();
        
        ArrayList<Event> events = ctrl.getAllEvents();
        
        for (Event event : events) {
            System.out.println(event.getName());
            if (event.getName().contains(searchTerm) || event.getName().equals(searchTerm)) {
                results.add(event);
            }
        }
    }
    
    //search by category
    public SearchEvent(int category) throws IOException, FileNotFoundException, ClassNotFoundException{

        ctrl = new EventCtrl();

        ArrayList<Event> events = ctrl.getAllEvents();
        
        for (Event event : events) {
            if (event.getCategory() == category) {
                results.add(event);
            }
        }
    }
    
    ArrayList<Event> getResults(){
        return results;
    }
}
