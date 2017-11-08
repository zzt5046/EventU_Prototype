/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventu_prototype;

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
}
