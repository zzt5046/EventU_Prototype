/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventu_prototype;

import java.io.IOException;

/**
 *
 * @author Zach
 */
public class EventU_Prototype {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        LoginScreenFrame login = new LoginScreenFrame();
       
        //test creds
        User zach = new User("zzt5046@psu.edu", "test", 0);
        UserCtrl ctrl = new UserCtrl(zach);
        ctrl.saveCredentials();
    }
    
}
