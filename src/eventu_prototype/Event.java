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
public class Event {
    
    User user;
    String name;
    String timeStart;
    String timeEnd;
    String location;
    String date;
    String description;
    float price;
    
    //general use
    public Event(){
        
        System.out.println("**Event instantiated**");
    }
    
    //used for creating new Events
    public Event(User user, String name, String timeStart, String timeEnd, String location, String date, String description, float price){
        
        this.user = user;
        this.name = name;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.location = location;
        this.date = date;
        this.description = description;
        this.price = price;
        
        System.out.println("**New Event created**");
    }
    
    //setter methods-------------------------------------
    
    void setUser(User user){
        this.user = user;
    }
    
    void setName(String name) {
        this.name = name;
    }

    void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }
    
    void setLocation(String location){
        this.location = location;
    }
    
    void setDate(String date){
        this.date = date;
    }
    
    void setDescription(String description){
        this.description = description;
    }
    
    void setPrice(float price){
        this.price = price;
    }
    
    //getter methods-------------------------------------
    
    User getUser(){
        return user;
    }
    
    String getName() {
        return name;
    }

    String getTimeStart() {
        return name;
    }

    String getTimeEnd() {
        return timeEnd;
    }
    
    String getLocation(){
        return location;
    }
    
    String getDate(){
        return date;
    }
    
    String getDescription(){
        return description;
    }
    
    float getPrice(){
        return price;
    }
}
