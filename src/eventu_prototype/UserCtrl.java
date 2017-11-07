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
public class UserCtrl {
    
    User currentUser;
    
    //sets current user given and logs activity
    public UserCtrl(User user){
        
        this.currentUser = user;
        System.out.println("User controller instantiated");
    }
    
    //requests to model---------------------------
    
    void setEmail(String email) {
        
        currentUser.setEmail(email);
    }

    void setPassword(String password) {
        
        currentUser.setPassword(password);
    }

    void setProfileType(int profileType) {
        
        currentUser.setProfileType(profileType);
    }
}
