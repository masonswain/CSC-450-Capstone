/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import application.Main;
import static application.Main.xOffset;
import static application.Main.yOffset;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Polygon;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Joel
 */
public class ViewTicketHistoryController implements Initializable {

    @FXML
    private Button btnViewTickets;
    @FXML
    private Button btnCancel;
    @FXML
    private Polygon btnCollapse;
    @FXML
    private Button btnBack;
    @FXML
    private Label lblMessagesWaiting;
    @FXML
    private Label lblTicketsOpen;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        lblTicketsOpen.setText(Main.activeTicketCount);
    }    


    @FXML
    private void CollapseWidget(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/WidgetCollapsed.fxml")); // loads main fxml class
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
            
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void gotoReplyToTicket(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/ReplyToTicket.fxml")); // loads main fxml class
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
            
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void gotoViewTickets(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/ViewTickets.fxml")); // loads main fxml class
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
            
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void gotoWidgetExpanded(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/WidgetExpanded.fxml")); // loads main fxml class
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
            
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void gotoViewTicketComment(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/ViewTicketComment.fxml")); // loads main fxml class
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
          
        window.setScene(scene);
        window.show();
    }
    
}
