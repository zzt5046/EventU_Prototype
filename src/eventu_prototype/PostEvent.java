/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventu_prototype;

import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author jah6080
 */
public class PostEvent {
    
    public PostEvent(){
        
    }
    
    void addEvent(User user, String name, String startTime, String endTime, String location, String date, int category, String desc, double price){
                
    
        try{
                
        Event event = new Event(user, name, startTime, endTime, location, date, category, desc, price);   
        EventCtrl eventCtrl = new EventCtrl(event);
                
        try {
                eventCtrl.saveEvent();
        } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Something went wrong.");
        }
                
        } catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Please enter a valid currency amount.");
        }
    }
}
