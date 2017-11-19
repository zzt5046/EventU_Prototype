/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventu_prototype;

import java.io.Serializable;

/**
 *
 * @author Zach
 */
public class User implements Serializable{
    
    private String username;
    private String password;
    private int profileType;
    
    //default, used for general function
    public User(){
        
        System.out.println("**User instantiated.**");
    }
    
    //secondary, use for creating
    public User(String username, String password, int profileType){
        
        this.username = username;
        this.password = password;
        this.profileType = profileType;
        
        System.out.println("**New user created.**");
    }

    //set methods--------------------------------------
    
    void setUsername(String username) {
        this.username = username;
    }

    void setPassword(String password) {
        this.password = password;
    }

    void setProfileType(int profileType) {
        this.profileType = profileType;
    }
    
    //get methods--------------------------------------
    
    String getUsername() {
        return username;
    }

    String getPassword() {
        return password;
    }

    int getProfileType() {
        return profileType;
    }
    
}
