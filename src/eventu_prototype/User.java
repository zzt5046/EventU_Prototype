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
public class User {
    
    private String email;
    private String password;
    private int profileType;
    
    //default, used for general function
    public User(){
        
        System.out.println("**User instantiated.**");
    }
    
    //secondary, use for creating
    public User(String email, String password, int profileType){
        
        setEmail(email);
        setPassword(password);
        setProfileType(profileType);
        
        System.out.println("**New user created.**");
    }

    //set methods--------------------------------------
    
    void setEmail(String email) {
        this.email = email;
    }

    void setPassword(String password) {
        this.password = password;
    }

    void setProfileType(int profileType) {
        this.profileType = profileType;
    }
    
    //get methods--------------------------------------
    
    String getEmail() {
        return email;
    }

    String getPassword() {
        return password;
    }

    int getProfileType() {
        return profileType;
    }
    
    void postDB(){
        
    }
}
