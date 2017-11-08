/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventu_prototype;

import java.io.IOException;

/**
 *
 * @author jah6080
 */
public class CreateAccount {
   
    User user;
    UserCtrl ctrl;
    
    public CreateAccount(String email, String password, int accountType) throws IOException{
        
        //pass immediatly
        createUser(email, password, accountType);
    }
    
    void createUser(String email, String password, int accountType) throws IOException{
        
        System.out.println("New user created: " + email);
        
        //declare user params and save to file in /users
        user = new User(email, password, accountType);
        ctrl = new UserCtrl(user);
        ctrl.saveCredentials();
        
    }
}
