package Classes;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.web.HTMLEditorSkin;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import static javafx.application.Application.launch;

public class Tutorial_1 extends MainController{
    @FXML
    public TextField TF_ISBN, TF_CREDIT, TF_Num1, TF_Num2;
    @FXML
    public Label LB_ISBN, LB_Credit, LB_Calculations;

    public void validateISBNNumber(){
        String Number = TF_ISBN.getText();
        int totalNumber = 0;
        int currentNumber = 0;

        /*Test ISBN Numbers:
        * 9992158107, 9604250590, 1843560283, 0943396042, 097522980X
        */
        //Inputted number must be 10 digits long, allowing an x or X
        if (Number.length() != 10 ){
            LB_ISBN.setText("Invalid. Must be 10 digits long");
        }else{
            //For each digit, if it's an x, add 10 to the current total, else parse it to an integer and multiply by its current position then add to total
            for (int i = 0; i < Number.length(); i++){
                if ((Number.charAt(i) == 'x')|(Number.charAt(i) == 'X')){
                    currentNumber += 10;
                }
                else{
                    currentNumber = Integer.parseInt(String.valueOf(Number.charAt(i)));
                }
                currentNumber = currentNumber * (i+1);
                totalNumber += currentNumber;
            }

            System.out.println("Summed ISBN numbers: " + totalNumber + " Under Mod 11:  " + totalNumber%11);

            if(totalNumber%11 == 0){
                LB_ISBN.setText("ISBN is Valid");
            }
            else{
                LB_ISBN.setText("ISBN is NOT Valid");
            }
        }
    }


    public void validateCreditCardNumber(){
        int summedTotal = 0;
        String creditCardNumberAsNumberAsString = TF_CREDIT.getText();
        int currentNumber;

        //has to be 16 digits long
        for(int i = creditCardNumberAsNumberAsString.length()-1; i >=0; i--){
            currentNumber = Integer.parseInt(String.valueOf(creditCardNumberAsNumberAsString.charAt(i)));
            summedTotal += currentNumber;
            i--;
            currentNumber = Integer.parseInt(String.valueOf(creditCardNumberAsNumberAsString.charAt(i)))*2;

            if(currentNumber >= 10){
                currentNumber -= 9;
                summedTotal += currentNumber;
            }
            else {
                summedTotal += currentNumber;
            }
        }
        System.out.println("Summed total is " + summedTotal);
        System.out.println("Remainder is " + summedTotal%10);
        if (summedTotal%10 != 0){
            System.out.println("Number NOT valid");
        } else{
            System.out.println("Number is valid");
        }

    }

        int num1;
        int num2;
        int mod = 11;

        public void getNumbers(){
            this.num1 = getTextBoxContentToInteger(TF_Num1);
            this.num2 = getTextBoxContentToInteger(TF_Num2);
        }

        public void plusCalculation(){
            getNumbers();
            System.out.println((num1+num2)%mod);
            LB_Calculations.setText("The answer: " + (num1+num2)%mod);
        }

        public void minuCalculation(){
            getNumbers();
            System.out.println((num1-num2)%mod);
            LB_Calculations.setText("The answer: " + (num1-num2)%mod);
        }

        public void multiplyCalculation(){
            getNumbers();
            int result = (num1*num2)%mod;
            result = result+mod;
            System.out.println(result);
            LB_Calculations.setText("The answer: " + result);
        }

        public void divideCalculation(){
            getNumbers();
            num1 = num1%mod;
            num2 = num2%mod;
            int inverseNumbers[] = {1,6,4,3,9,2,8,7,5,10};
            num2 = inverseNumbers[num2-1];

            System.out.println((num1*num2)%mod);
            LB_Calculations.setText("The answer: " + (num1*num2)%mod);
        }

        public int getTextBoxContentToInteger(TextField textBoxToGetFrom){
            //Get the contents of the textbox and parse/store it to the variable
            int numberAsInt = Integer.parseInt(String.valueOf(textBoxToGetFrom.getText()));
            //numberAsInt = verifyIntegerToPositive(numberAsInt);
            return numberAsInt;
    }





    //Take in an integer, if it's lower than 0, make it positive
    public int verifyIntegerToPositive(int num){
        if (num < 0){
            num = -(num);
        }
        return  num;
    }


    //@Override
    public void start(Stage primaryStage) throws Exception{
    }

    public static void main(String[] args) { launch(args); }
}
