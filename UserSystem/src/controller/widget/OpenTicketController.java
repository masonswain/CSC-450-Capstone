/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.widget;

import application.Internal;
import application.setWidgetPosition;
import application.Main;
import static application.Main.xOffset;
import static application.Main.yOffset;
import application.communicate;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Joel
 */
public class OpenTicketController implements Initializable {

    @FXML
    private Label lblTicketsOpen;
    @FXML
    private Label lblMessagesWaiting;
    @FXML
    private ComboBox cbBuilding;
    @FXML
    private TextField txtRoomNum;
    @FXML
    private TextField txtPhone;
    @FXML
    private TextArea txtProblemDescription;
    @FXML
    private TextArea txtProblemSubject;
    @FXML
    private Circle statusLight;
    @FXML
    private Button btnSubmit;
    @FXML
    private Button btnCancel;
    
    boolean timerStop=false;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        updateStatus();
        
        //Update Ticket List
        try {
            Main.ticketList = communicate.updateAllActiveUserTickets(Main.currentUser.uName);
        } catch (IOException ex) {
            Logger.getLogger(WidgetExpandedController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        cbBuilding.getItems().addAll("CLC","District Office","Kaposia","Lincoln Center","Secondary");
        
         //Create a runnable that is capable of updating JavaFX elements
        Runnable updater = new Runnable(){
            @Override
            public void run() {
                updateStatus();
            }
        
        };
    
        //Create a thread to loop until the timerStop is set to true
        new Thread(()->{
        int i=0;
        while(!timerStop){
        try{
            Thread.sleep(Main.refreshTimer);
                    
        }catch(InterruptedException e){
            e.printStackTrace();
        }
            i++;
            System.out.println("Updating Status...");
            Platform.runLater(updater);
        }
        }).start();
        
    }    

    
    @FXML
    private void CollapseWidget(MouseEvent event) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/widget/WidgetCollapsed.fxml")); // loads main fxml class
            Scene scene = new Scene(root);
	    scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();             
            double nextStageHeight = 40.0;
            window.setY(setWidgetPosition.setWidgetY(window.getY(), primaryScreenBounds, nextStageHeight));
            
            /////////  Allow undecorated window be dragged     ////////////// 
            root.setOnMousePressed(new EventHandler<MouseEvent>() {       	
                @Override
                public void handle(MouseEvent event) {
                   xOffset = event.getSceneX();
                   yOffset = event.getSceneY();
                } 
            });
        
            // User Screen is able to moved by Mouse.
            root.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                   window.setX(event.getScreenX() - xOffset);
                   window.setY(event.getScreenY() - yOffset);
                }
            });
        
            ////////////////////        END      //////////////////////////// 
            timerStop=true;
            window.setScene(scene);
            window.show();
    }

    @FXML
    private void gotoWidgetExpanded(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/widget/WidgetExpanded.fxml")); // loads main fxml class
            Scene scene = new Scene(root);
	    scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();             
            double nextStageHeight = 100.0;
            window.setY(setWidgetPosition.setWidgetY(window.getY(), primaryScreenBounds, nextStageHeight));
            
            /////////  Allow undecorated window be dragged     ////////////// 
            root.setOnMousePressed(new EventHandler<MouseEvent>() {       	
                @Override
                public void handle(MouseEvent event) {
                   xOffset = event.getSceneX();
                   yOffset = event.getSceneY();
                } 
            });
        
            // User Screen is able to moved by Mouse.
            root.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                   window.setX(event.getScreenX() - xOffset);
                   window.setY(event.getScreenY() - yOffset);
                }
            });
        
            ////////////////////        END      //////////////////////////// 
            timerStop=true;
            window.setScene(scene);
            window.show();
    }

    @FXML
    private void openNewTicket(ActionEvent event) throws IOException {
        //System.out.println("New ticket created");
        //System.out.println(cbBuilding.getValue().toString());
        System.out.println("Assigning variables");
        String building = cbBuilding.getValue().toString();
        
        String room=txtRoomNum.getText();
        //System.out.println(room);
        String phone=txtPhone.getText();
        //System.out.println(phone);
        String description=txtProblemDescription.getText();
        String subject=txtProblemSubject.getText();
        System.out.println("Communicate()");
        communicate.createTicket(building, room, phone, description, subject);
        
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/widget/ViewTickets.fxml")); // loads main fxml class
        Scene scene = new Scene(root);
	scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();             
        double nextStageHeight = 400.0;
        window.setY(setWidgetPosition.setWidgetY(window.getY(), primaryScreenBounds, nextStageHeight));

        /////////  Allow undecorated window be dragged     ////////////// 

        root.setOnMousePressed(new EventHandler<MouseEvent>() {       	
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            } 
        });

        // User Screen is able to moved by Mouse.
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                window.setX(event.getScreenX() - xOffset);
                window.setY(event.getScreenY() - yOffset);
            }
        });

        ////////////////////        END      //////////////////////////// 
        timerStop=true;
        window.setScene(scene);
        window.show();
    }
    
    private void updateStatus(){
        
        Internal.intializeWidgetStatus();
        lblTicketsOpen.setText(Main.activeTicketCount);
        lblMessagesWaiting.setText(Main.unreadMessageCount);
        //Update status light
        statusLight.setFill(Main.statusLightColor);
        
    }
    
}
