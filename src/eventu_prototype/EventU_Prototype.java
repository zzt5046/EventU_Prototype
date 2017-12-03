/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventu_prototype;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Zach
 */
public class EventU_Prototype extends Application{

    /**
     * @param args the command line arguments
     */
    
    /* TEST ACCOUNTS
    -------------------
    
        -email          -pass           -desc
        -------         ------          ------
        test            test            general test (made first)
        indiv           test            acct with individual param
        club            test            acct with club param
    */
    public static void main(String[] args) {
        
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("LoginScreenFrameFX.fxml"));
        Parent root = loader.load();
        
        primaryStage.setScene(new Scene(root, 305, 500));
        primaryStage.show();
    }
    
}
