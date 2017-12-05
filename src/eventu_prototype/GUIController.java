/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventu_prototype;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class GUIController implements Initializable{
    
    User selected;
    
    //login screen elements
    @FXML
    private TextField usernameLoginField;
    @FXML
    private TextField passwordLoginField;
    
    public static User currentUser = null;
    
    //register screen elements
    @FXML
    private TextField usernameRegisterField;
    @FXML
    private PasswordField passwordRegisterField;
    @FXML
    private PasswordField confirmRegisterField;
    ObservableList<String> categoryList = FXCollections.observableArrayList("Individual", "Club");
    @FXML
    private ComboBox accountCategory = new ComboBox();
    
    //indiv menu elements
    @FXML
    private TableView<String> indivTable = new TableView<>();
    @FXML
    private Button viewEventIndiv = new Button();
    
    //club menu elements
    @FXML
    private Button viewEventClub = new Button();
    @FXML
    private Button deleteEventButton = new Button();
    @FXML
    private TableView<Event> clubTable = new TableView<Event>();
    
    //add event screen elements
    @FXML
    private TextField eventNameField;
    @FXML
    private TextField startTimeField;
    @FXML
    private TextField endTimeField;
    @FXML
    private TextField locationField;
    @FXML
    private TextField dateField;
    @FXML
    private TextArea descField;
    @FXML
    private TextField priceField;
    @FXML
    private ComboBox addEventCategory = new ComboBox();
    
    //view event screen elements
    
    //search event screen elements
    @FXML
    private ComboBox searchEventCategory = new ComboBox();
    @FXML
    private RadioButton keywordRadio = new RadioButton();
    @FXML
    private RadioButton categoryRadio = new RadioButton();
    @FXML
    private ToggleGroup searchGroup = new ToggleGroup();
    
    //login screen------------------------------------------------------------------------------
    @FXML
    public void loginButtonPress(ActionEvent event) throws IOException, FileNotFoundException, ClassNotFoundException{

        //LoginScreen logic = new LoginScreen();
        String un = usernameLoginField.getText();
        String pw = passwordLoginField.getText(); 
        
        if(un.equals("") || pw.equals("")){
            JOptionPane.showMessageDialog(null, "Please fill out all fields.");
        }else{
            if(authenticate(un, pw, event)){
                System.out.println("**Authenticated");
            }else{
                JOptionPane.showMessageDialog(null, "Wrong username/password.");
            }
        }
    }
    
    @FXML
    public void loginRegisterButtonPress(ActionEvent event) throws IOException{
        
        changeScene("CreateAccountFrameFX.fxml", event); 
    }
    
    //register screen-----------------------------------------------------------------------------
    @FXML
    public void registerButtonPress(ActionEvent event) throws IOException{
        
        String un = usernameRegisterField.getText();
        String pw = passwordRegisterField.getText();
        String conf = confirmRegisterField.getText();
        
        int category = 2;
        if(accountCategory.getValue().equals("Individual")){
            category = 0;
        }
        else if(accountCategory.getValue().equals("Club")){
            category = 1;
        }
        
        if(un.equals("") || pw.equals("") || conf.equals("") || category == 2){
            JOptionPane.showMessageDialog(null, "Please fill out all fields.");
        }else{
            if(pw.equals(conf)){
                CreateAccount backend = new CreateAccount(un, pw, category);
                backend.createUser(un, pw, category);
                changeScene("LoginScreenFrameFX.fxml", event); 
            }else{
                JOptionPane.showMessageDialog(null, "Wrong username/password.");
            }
        }
    }
     
    @FXML
    public void registerCancelPress(ActionEvent event) throws IOException{
        changeScene("LoginScreenFrameFX.fxml", event);
    }
    
    //individual menu screen-----------------------------------------------------------------------
    @FXML
    public void searchPressed(ActionEvent event) throws IOException{
        changeScene("SearchEventFrameFX.fxml", event);
    }
    
    @FXML
    public void enableDetailsIndiv(ActionEvent event){
        viewEventIndiv.setDisable(false);
    }
     
    //club menu screen-----------------------------------------------------------------------------
    @FXML
    public void addEventScreen(ActionEvent event) throws IOException{
        changeScene("AddEventFrameFX.fxml", event);
    }
    
    @FXML
    public void deleteEvent(ActionEvent event) throws IOException{
        
        EventCtrl eventCtrl = new EventCtrl();
        eventCtrl.deleteEvent(currentUser, "insert value from table here");
    }
    
    public void populateClubPane(Stage stage) throws IOException, FileNotFoundException, ClassNotFoundException{
        
        EventCtrl backend = new EventCtrl();
        ArrayList<Event> events = backend.getClubEvents(currentUser);
        System.out.println(events.size() + " events found.");
        Event eventTemp = null;
        
        ObservableList<Event> eventList = FXCollections.observableArrayList(events);
        clubTable.setItems(eventList);
        
        final TableColumn<Event, String> col = new TableColumn<Event, String>();
	col.setCellValueFactory(new PropertyValueFactory("eventName"));
        
        clubTable.getColumns().setAll(col);
        stage.setScene(new Scene(clubTable));
        stage.show();
        
      
        
    }
    
    @FXML
    public void enableDetailsClub(ActionEvent event){
        viewEventClub.setDisable(false);
    }
    
    @FXML
    public void enableDelete(ActionEvent event){
        deleteEventButton.setDisable(false);
    }

    //add event screen-----------------------------------------------------------------------------
    @FXML
    public void addEvent(ActionEvent clickEvent) throws IOException, FileNotFoundException, ClassNotFoundException{
        
        String name = eventNameField.getText();
        String start = startTimeField.getText();
        String end = endTimeField.getText();
        String location = locationField.getText();
        String date = dateField.getText();
        String category = addEventCategory.getSelectionModel().getSelectedItem().toString();
        String desc = descField.getText();
        String priceString = priceField.getText();
        //Social-0, Sports-1, Fundraising-2, Other-3
        int categoryNum = 0;
        switch(category){
            case "Social":
                categoryNum = 0;
                break;
            case "Sports":
                categoryNum = 1;
                break;
            case "Fundraising":
                categoryNum = 2;
                break;
            case "Other":
                categoryNum = 3;
                break;
        }
        
        if(name.equals("") || start.equals("") || end.equals("") || location.equals("") || date.equals("") || desc.equals("")){
            JOptionPane.showMessageDialog(null, "Please fill out all fields.");
        }else{
            Stage stage = null;
            if(isDouble(priceString)){
                System.out.println(currentUser + " " + name + " " + start + " " + end + " " + location + " " + date + " " + categoryNum + " " + desc + " " + Double.parseDouble(priceString));
                Event event = new Event(currentUser, name, start, end, location, date, categoryNum, desc, Double.parseDouble(priceString));
                EventCtrl backend = new EventCtrl(event);
                backend.saveEvent();
                
                JOptionPane.showMessageDialog(null, "Event added!");
                populateClubPane(stage);
                changeScene("ClubMenuFrameFX.fxml", clickEvent); 
            }else{
                JOptionPane.showMessageDialog(null, "Please enter a number for price.");
            }
        } 
    }
    
    @FXML
    public void eventCancel(ActionEvent event) throws IOException{
        changeScene("ClubMenuFrameFX.fxml", event);
    }
    
    //search screen--------------------------------------------------------------------------------
    @FXML
    public void startSearch(ActionEvent event){
        
        //SearchEvent search = new SearchEvent();
        populateIndivPane();
    }
    
    @FXML
    public void searchCancel(ActionEvent event) throws IOException{
        changeScene("IndivMenuFrameFX.fxml", event);
    }
    
    public void populateIndivPane(){
        
    }
    
    //view event screen----------------------------------------------------------------------------
    @FXML
    public void cancelView(ActionEvent event) throws IOException{
        if(currentUser.getProfileType() == 0){
            cancelViewIndiv(event);
        }
        else{
            cancelViewClub(event);
        }
    }
    
    @FXML
    public void cancelViewIndiv(ActionEvent event) throws IOException{
        changeScene("IndivMenuFrameFX.fxml", event);
    }
    
    @FXML
    public void cancelViewClub(ActionEvent event) throws IOException{
        changeScene("ClubMenuFrameFX.fxml", event);
    }
    
    //standalone methods---------------------------------------------------------------------------
    @FXML
    public void viewEvent(ActionEvent event) throws IOException{
        changeScene("ViewEventFrameFX.fxml", event);
    }
    
    @FXML
    public void logout(ActionEvent event) throws IOException{
        changeScene("LoginScreenFrameFX.fxml", event);
    }
    
    public void changeScene(String file, ActionEvent event) throws IOException{
        Parent register_parent = FXMLLoader.load(getClass().getResource(file));
        Scene registerScene = new Scene(register_parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(registerScene);
        window.show();
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        //config register combobox------------------------------------------------------------------
        accountCategory.setValue("Individual");
        accountCategory.setItems(categoryList);
        
        //config search info------------------------------------------------------------------------
        searchEventCategory.setValue("Individual");
        searchEventCategory.setItems(categoryList);
        keywordRadio.setToggleGroup(searchGroup);
        keywordRadio.setSelected(true);
        categoryRadio.setToggleGroup(searchGroup);
        
        //config add event info--------------------------------------------------------------------
        ObservableList<String> eventCategoryList = FXCollections.observableArrayList("Social", "Sports", "Fundraising", "Other");
        addEventCategory.setValue("Social");
        addEventCategory.setItems(eventCategoryList);
        
        //config view event info-------------------------------------------------------------------- 
    }
    
    //Authenticate login
    //<editor-fold>
    boolean authenticate(String username, String password, ActionEvent event){
        
        boolean authenticated = false;
        
        try {
            
            //find file and read user info
            FileInputStream fiStream = new FileInputStream(new File("users/" + username + ".ser"));
            ObjectInputStream oiStream = new ObjectInputStream(fiStream);

            // Read objects
            User userFile = (User) oiStream.readObject();

            //authenticate credentials
            if(userFile.getUsername().equals(username) && userFile.getPassword().equals(password)){
                Stage stage = null;
                authenticated = true;
                
                UserCtrl ctrl = new UserCtrl();
                currentUser = (User) (ctrl.getUser(username));
                
                System.out.println("**User: " + "'" + userFile.getUsername() + "'" + " logged in.**");
                
                //open separate menu type depending on account type (individual or club)------------------------------
                switch (userFile.getProfileType()) {
                    case 0:
                        viewEventIndiv.setDisable(true);
                        changeScene("IndivMenuFrameFX.fxml", event);
                        break;
                    case 1:
                        populateClubPane(stage);
                        viewEventClub.setDisable(true);
                        deleteEventButton.setDisable(true);
                        changeScene("ClubMenuFrameFX.fxml", event);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Something went wrong :(");
                        break;
                }
                
                oiStream.close();
                fiStream.close();
            }

        //catch potential errors-----------------------------------------------
        
	} catch (FileNotFoundException e) {
                e.printStackTrace();
		System.out.println("File not found");
                
	} catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: Something went wrong. Please contact support.");
		System.out.println("Error initializing stream");
                
	} catch (ClassNotFoundException e) {
            
		e.printStackTrace();
		}
        return authenticated;
    }
    //</editor-fold>
    
    //<editor-fold>
    boolean isDouble(String x){
        
        boolean ret = false;
        try{
            Double.parseDouble(x);
            ret = true;
        }catch(NumberFormatException e){
        }
        return ret;
    }
    //</editor-fold>
}
