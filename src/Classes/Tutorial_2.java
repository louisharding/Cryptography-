package Classes;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import static javafx.application.Application.launch;


public class Tutorial_2 extends MainController{

    @FXML
    public TextField tf_Numbers, tf_Syndrome;
    @FXML
    public Label lb_NumberValid, lb_Syndrome, lb_TenDigits;


    //The ten digits used to make the syndrome
    int[] tenDidgits = new int[10];
    char[] tenDigitsAsChar;

    int s1;
    int s2;
    int[] s2DecodeNums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int s3;
    int[] s3DecodeNums = {1,4,9,5,3,3,5,9,4,1};
    int s4;
    int[] s4DecodeNums = {1,8,5,9,4,7,2,6,3,10};



    public void workyOutyProblemMcSolvey(){

        for (int i = 0; i < 6; i ++){
            tenDidgits[i] = Integer.parseInt(String.valueOf(tf_Numbers.getText().charAt(i)));
        }

        getNumber7();
        getNumber8();
        getNumber9();
        getNumber10();

        for (int i = 0; i < tenDidgits.length; i++){
            //lb_TenDigits.setText(Arrays.toString(tenDidgits));
        }

        checkIfArrayHasA10(tenDidgits);
    }



    public void getNumber7(){
        int[] multipliers = {4, 10, 9, 2, 1, 7};
        tenDidgits[6] = ((4*tenDidgits[0])+
                (10*tenDidgits[1])+
                (9*tenDidgits[2]) +
                (2*tenDidgits[3])+
                (tenDidgits[4])+
                (7*tenDidgits[5]))%11;
    }

    public void getNumber8(){
        tenDidgits[7] = ((7*tenDidgits[0])+
                (8*tenDidgits[1])+
                (7*tenDidgits[2]) +
                (tenDidgits[3])+
                (9*tenDidgits[4])+
                (6*tenDidgits[5]))%11;
    }

    public void getNumber9(){
        tenDidgits[8] = ((9*tenDidgits[0])+
                (tenDidgits[1])+
                (7*tenDidgits[2]) +
                (8*tenDidgits[3])+
                (7*tenDidgits[4])+
                (7*tenDidgits[5]))%11;
    }

    public void getNumber10(){
        tenDidgits[9] = ((tenDidgits[0])+
                (2*tenDidgits[1])+
                (9*tenDidgits[2]) +
                (10*tenDidgits[3])+
                (4*tenDidgits[4])+
                (tenDidgits[5]))%11;
    }


    //Create Syndromes
    public void getSyndromes(){

        s1 = 0;
        s2 = 0;
        s3 = 0;
        s4 = 0;

        for(int i = 0; i < 10; i++){
            tenDidgits[i] = Integer.parseInt(String.valueOf(tf_Syndrome.getText().charAt(i)));
        }


        for (int i = 0; i < 10; i++){
            s1 += tenDidgits[i];
            s2 += tenDidgits[i]*s2DecodeNums[i];
            s3 += tenDidgits[i]*s3DecodeNums[i];
            s4 += tenDidgits[i]*s4DecodeNums[i];
        }

        s1 = s1%11;
        s2 = s2%11;
        s3 = s3%11;
        s4 = s4%11;

        lb_Syndrome.setText(""+ s1 +""+ s2 +""+ s3 +""+ s4);
    }

    //Display each digit of the produced number, if it's 10, display an X and display message
    public void checkIfArrayHasA10(int[] arrayToCheck){

        lb_TenDigits.setText("");
        Boolean isUsableNumber = true;

        for(int i = 0; i< arrayToCheck.length; i++){
            if (arrayToCheck[i]== 10){
                isUsableNumber = false;
                lb_TenDigits.setText(lb_TenDigits.getText() + "X, ");
            }
            else {
                lb_TenDigits.setText(lb_TenDigits.getText() + arrayToCheck[i] + ", ");
            }
        }



        if (isUsableNumber == false){
            lb_NumberValid.setText("Unusable Number");
        } else {
            lb_NumberValid.setText("Number Accepted");
        }

    }



    public void display6DigitsOnLabel(){
        lb_TenDigits.setText("Entered: " + tf_Numbers.getText());
        lb_NumberValid.setText("Ths number is (valid)?");
    }

    public void start(Stage primaryStage) throws Exception{
    }

    public static void main(String[] args){launch(args);}
}
