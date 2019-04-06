/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import application.setWidgetPosition;
import static application.Main.xOffset;
import static application.Main.yOffset;
import application.communicate;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.geometry.Rectangle2D;
import javafx.scene.shape.Circle;

/**
 * FXML Controller class
 *
 * @author Joel
 */
public class WidgetCollapsedController implements Initializable {

    @FXML
    private Circle statusLight;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Update status light
        statusLight.setFill(communicate.updateStatusLight());
    }    

    @FXML
    private void gotoWidgetExpanded(MouseEvent event) throws IOException {
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
    
}
