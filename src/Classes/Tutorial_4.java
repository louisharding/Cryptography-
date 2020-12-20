//SHA-1
package Classes;

import javafx.fxml.FXML;
import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
//Comment testing Git...


public class Tutorial_4 extends MainController {

    @FXML
    public TextField tf_InputString;
    @FXML
    public Label lb_Result;


    public void generateHash() throws NoSuchAlgorithmException {
            MessageDigest myMd = MessageDigest.getInstance("SHA-1");
            String textAsString = tf_InputString.getText();

            myMd.update(textAsString.getBytes());

            byte[] digest = myMd.digest();
            System.out.println(digest);

            StringBuffer myHexString = new StringBuffer();

            for(int i = 0; i < digest.length; i++){
                myHexString.append(Integer.toHexString(0xFF & digest[i]));
            }

            lb_Result.setText("" + myHexString);
            myHexString.delete(0, myHexString.length());
    }


}
