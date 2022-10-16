import java.awt.*;
import java.util.ArrayList;

public class calculatorFunctions{


    boolean writeToNum2 = false; //When this is true, the button inputs now change number2 instead of number1

    boolean decimalEnable = false; //When this is true, the button inputs now change the decimal part of the number currently being written to

    boolean operatorEnable = false; //When this is true, the next inputted integer will be displayed by itself on a cleared display, if after this is enabled another operator's button is pressed, only the operator changes

    String operator;

    Double number1 = 0.0;

    Double number2 = 0.0;


    public int setInputArray(ArrayList<Integer> list, Button pressedButton){
        String label = pressedButton.getLabel();

        if(!(label.equals("+") || label.equals("-") || label.equals("÷") || label.equals("x") || label.equals("="))){
            //Function to display the pressed button on the screen
            // . and - are coded with integers to make it easy to implement with already existing methods
                if(label.equals(".")){
                    list.add(0,10);
                }
                else{
                    list.add(0,Integer.parseInt(label));
                }
        }
        else if(label.equals("=")){ //Use of return values explained where this method is used in Calculator class
            return 2;
        }
        else{
            System.out.println(label);
            return 1;
        }
        return 0;
    }

    public String returnResult(){ //Returns the number1 as a String value as once an algebraic operation is complete
                                  // ex. X+Y, the result is saved to number1
        return number1.toString();
    }


    public void calculate(){ //Calculation of algebraic operations
        writeToNum2 = false;
        switch (operator){
            case "+":
                number1 += number2;
                //This bit of code shaves off the decimal part of the number if the total size of the number is greater than 10 this code is the same for all operations
                if(number1.toString().split("\\.")[0].length()+number1.toString().split("\\.")[1].length()>10) {
                    if (number1.toString().split("\\.")[0].length() > 10) {
                        String temp = number1.toString().substring(0, 10);
                        number1 = Double.parseDouble(temp); //If the whole part of the number is bigger than 10 only the 10 most significant digits are displayed
                    } else if (number1.toString().split("\\.")[1].length() > 10) {
                        String temp = number1.toString().split("\\.")[1].substring(0, 2);
                        number1 = Double.parseDouble(number1.toString().split("\\.")[0] + "." + temp);
                    }
                    else{
                        String temp = number1.toString().split("\\.")[1].substring(0,10-number1.toString().split("\\.")[0].length());
                        number1 = Double.parseDouble(number1.toString().split("\\.")[0] + "." + temp);
                    }
                }
                //End of length adjustment
                number2 = 0.0;
                break;
            case "-":
                number1 -= number2;
                if(number1.toString().split("\\.")[0].length()+number1.toString().split("\\.")[1].length()>10) {
                    if (number1.toString().split("\\.")[0].length() > 10) {
                        String temp = number1.toString().substring(0, 10);
                        number1 = Double.parseDouble(temp);
                    } else if (number1.toString().split("\\.")[1].length() > 10) {
                        String temp = number1.toString().split("\\.")[1].substring(0, 2);
                        number1 = Double.parseDouble(number1.toString().split("\\.")[0] + "." + temp);
                    }
                    else{
                        String temp = number1.toString().split("\\.")[1].substring(0,10-number1.toString().split("\\.")[0].length());
                        number1 = Double.parseDouble(number1.toString().split("\\.")[0] + "." + temp);
                    }
                }
                number2 = 0.0;
                break;
            case "x":
                number1 = number1 * number2;
                if(number1.toString().split("\\.")[0].length()+number1.toString().split("\\.")[1].length()>10) {
                    if (number1.toString().split("\\.")[0].length() > 10) {
                        String temp = number1.toString().substring(0, 10);
                        number1 = Double.parseDouble(temp);
                    } else if (number1.toString().split("\\.")[1].length() > 10) {
                        String temp = number1.toString().split("\\.")[1].substring(0, 2);
                        number1 = Double.parseDouble(number1.toString().split("\\.")[0] + "." + temp);
                    }
                    else{
                        String temp = number1.toString().split("\\.")[1].substring(0,10-number1.toString().split("\\.")[0].length());
                        number1 = Double.parseDouble(number1.toString().split("\\.")[0] + "." + temp);
                    }
                }
                number2 = 0.0;
                break;
            case "÷":
                number1 = number1 / number2;
                if(number1.toString().split("\\.")[0].length()+number1.toString().split("\\.")[1].length()>10) {
                    if (number1.toString().split("\\.")[0].length() > 10) {
                        String temp = number1.toString().substring(0, 10);
                        number1 = Double.parseDouble(temp);
                    } else if (number1.toString().split("\\.")[1].length() > 10) {
                        String temp = number1.toString().split("\\.")[1].substring(0, 2);
                        number1 = Double.parseDouble(number1.toString().split("\\.")[0] + "." + temp);
                    }
                    else{
                        String temp = number1.toString().split("\\.")[1].substring(0,10-number1.toString().split("\\.")[0].length());
                        number1 = Double.parseDouble(number1.toString().split("\\.")[0] + "." + temp);
                    }
                }
                number2 = 0.0;
                break;
        }
        System.out.println(number1 + " -> result after adjustments to length"); //Extra bits to display to the terminal and use the terminal as a debug screen
    }

    public void appendToInputs(Button pressedButton){//Unlike the function name, this function's use was later changed an now it just sets first and second number and the operation that will be used
        String label = pressedButton.getLabel();
        if(label.equals(".")){
            decimalEnable = true;
        }
        else if(label.equals("+") || label.equals("-") || label.equals("÷") || label.equals("x")){
            if(!operatorEnable) {
                writeToNum2 = true;
                decimalEnable = false;
            }
            operator = label;
        }
        else if(label.equals("C")){
            number1 = 0.0;
            number2 = 0.0;
            operator =null;
            writeToNum2 = false;
        }
        else if(label.equals("=")){
            //Left empty to isolate '='
        }
        else{
            if(!writeToNum2){
                if(!decimalEnable) {
                    if (number1 != 0) {
                        number1 = 10 * number1 + Double.parseDouble(label);
                    } else {
                        number1 = Double.parseDouble(label);
                    }
                }
                else{
                    int DecimalPart = Integer.parseInt(number1.toString().split("\\.")[1])*10 + Integer.parseInt(label);
                    number1 = Double.parseDouble(number1.toString().split("\\.")[0] + "." + DecimalPart);
                }
            }
            else{
                if(!decimalEnable) {
                    if (number2 != 0) {
                        number2 = 10 * number2 + Double.parseDouble(label);
                    } else {
                        number2 = Double.parseDouble(label);
                    }
                }
                else{
                    String decimal = number2.toString().split("\\.")[1];
                    System.out.println(decimal);
                    int DecimalPart = Integer.parseInt(number2.toString().split("\\.")[1])*10 + Integer.parseInt(label);
                    number2 = Double.parseDouble(number2.toString().split("\\.")[0] + "." + DecimalPart);
                }
            }
        }
    }

}
