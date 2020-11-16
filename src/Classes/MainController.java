package Classes;

import javafx.fxml.Initializable;

import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources){
        //2Do
    }




    //Takes a textfield parameter, returns the contents of that textfield as integer (WILL BREAK UPON ANYTHING NOT INTEGER)
    public int textFieldToInteger(TextField myTf){
        int thyNumber;
        thyNumber = Integer.parseInt(String.valueOf(myTf.getText()));
        return(thyNumber);
    }




}
