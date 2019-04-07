/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.commandcenter;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Joel
 */
public class TechCommandCenterOpenTicketFormController implements Initializable {

    @FXML
    private TextField txtRoomNum;
    @FXML
    private TextField txtPhone;
    @FXML
    private TextArea txtProblemSubject;
    @FXML
    private TextArea txtProblemDescription;
    @FXML
    private Button btnSubmit;
    @FXML
    private Button btnCancel;
    @FXML
    private ComboBox cbBuilding;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cbBuilding.getItems().addAll("CLC","District Office","Kaposia","Lincoln Center","Secondary");
    }    
    
}
