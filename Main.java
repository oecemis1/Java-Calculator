import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Main {

    Calculator calculator;

    public Main(){
        System.out.println("====================================");
        System.out.println("Would you like to enable dark mode?(yes/no)");
        System.out.println("====================================");

        Scanner in = new Scanner(System.in);
        String ans = in.nextLine();
        if(ans.toLowerCase().contains("yes")){
            calculator = new Calculator(true);
        }
        else{
            calculator = new Calculator(false);
        }


    }

    public static void main(String[] args) {
        new Main(); //I don't know what more I could put in the main method
    }

}
