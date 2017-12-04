/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventu_prototype;

import java.io.Serializable;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Zach
 */
public class Event implements Serializable{
    
    User user;
    String name;
    String timeStart;
    String timeEnd;
    String location;
    String date;
    int category;
    String description;
    double price;
    
    public StringProperty eventName;
    
    //general use
    public Event(){
        
        System.out.println("**Event instantiated**");
    }
    
    //used for creating new Events
    public Event(User user, String name, String timeStart, String timeEnd, String location, String date, int category, String description, double price){
        
        this.user = user;
        this.name = name;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.location = location;
        this.date = date;
        this.category = category;
        this.description = description;
        this.price = price;
        eventName.setValue(name);
        
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
    
    void setCategory(int category){
        //Social-0, Sports-1, Fundraising-2, Other-3
        this.category = category;
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
        return timeStart;
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
    
    int getCategory(){
        //Social-0, Sports-1, Fundraising-2, Other-3
        return category;
    }
    
    String getCategoryName(int num){
        
        String category = "";
        
         switch (num) {
         case 0:
             category = "Social";
             break;
         case 1:
             category = "Sports";
             break;
         case 2:
             category = "Fundraising";
             break;
         case 3:
             category = "Other";
             break;
         default:
             throw new IllegalArgumentException("Invalid integer value: " + num);
     }

        return category;
    }
    
    String getDescription(){
        return description;
    }
    
    double getPrice(){
        return price;
    }
}
