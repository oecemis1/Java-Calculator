import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Calculator extends JFrame implements ActionListener {

    final int numberWidth = 47;

    int gapSize = 24;

    boolean darkMode;

    boolean dotPlaced = false; //Checks for dot placement and adjusts the coordinates of the next number that is going to be printed
    int dotCount = 0; //Used for the placement of dots and numbers when there is more dots than one(for some reason unknown)
    final int defaultY = 100; //Default values for y, heigh and half the height of the number. Implemented this way for ease of change
    final int height = 170;
    final int halfHeight = 85;

    lowerButtons buttonGrid;
    Button clear;

    boolean clearEnable = false; //When this is enabled the next printed number will not be appened to the end of the current number displayed but will be shown on a cleared display

    calculatorFunctions functionInterface = new calculatorFunctions();

    ArrayList<Integer> inputNumbers = new ArrayList<>(0); //ArrayList to hold button inputs in reverse order for ease of printing them

    public void actionPerformed(ActionEvent e) {
        System.out.println("=====debug=screen====="); //Data printed to the console to show that the result printed is accurate to the actual calculations
        System.out.println(functionInterface.number1 + " -> previous number 1");
        System.out.println(functionInterface.number2 + " -> previous number 2");
        System.out.println(functionInterface.operator + " -> previous selected operator");
        System.out.println("======================");

        Button[] buttonsLocal = buttonGrid.returnButtonArray();

        if(e.getSource()!=clear) {

            for (int i = 0; i < buttonsLocal.length; i++) {

                if (e.getSource() == buttonsLocal[i]) {

                    if(clearEnable && !(buttonsLocal[i].getLabel().equals("+") || buttonsLocal[i].getLabel().equals("-") || buttonsLocal[i].getLabel().equals("x") || buttonsLocal[i].getLabel().equals("÷"))){ //clears the inputNumbers array, clearing the displayed numbers
                        inputNumbers = new ArrayList<>(0);
                        repaint();
                        clearEnable = false;
                    }

                    int DetroitRockC = functionInterface.setInputArray(inputNumbers,buttonsLocal[i]); // weird variable name with a reference because why not ¯\_(ツ)_/¯

                    if(DetroitRockC == 1){
                        //this makes it so that when any operator is used except = the display will be clear once the second number
                        //starts to get entered
                        clearEnable = true;
                    }
                    else if(DetroitRockC == 2){
                        //This condition is reached when the = operator is used
                        functionInterface.calculate();
                        String result = functionInterface.returnResult();

                        inputNumbers = new ArrayList<>(0); //deletes current displayed number in oder to display the result

                        System.out.println(result + " -> result before adjustments to length");
                        for (int u = 0; u < result.length(); u++) {
                            switch (result.charAt(u)){ //insertion of the result into inputNumbers ArrayList
                                case '0':
                                    inputNumbers.add(0,0);
                                    break;
                                case '1':
                                    inputNumbers.add(0,1);
                                    break;
                                case '2':
                                    inputNumbers.add(0,2);
                                    break;
                                case '3':
                                    inputNumbers.add(0,3);
                                    break;
                                case '4':
                                    inputNumbers.add(0,4);
                                    break;
                                case '5':
                                    inputNumbers.add(0,5);
                                    break;
                                case '6':
                                    inputNumbers.add(0,6);
                                    break;
                                case '7':
                                    inputNumbers.add(0,7);
                                    break;
                                case '8':
                                    inputNumbers.add(0,8);
                                    break;
                                case '9':
                                    inputNumbers.add(0,9);
                                    break;
                                case '.':
                                    inputNumbers.add(0,10);
                                    break;
                                case '-':
                                    inputNumbers.add(0,11);
                                    break;
                            }
                        }
                        repaint();
                    }
                    functionInterface.appendToInputs(buttonsLocal[i]);
                }
                repaint();
            }
        }
        else{
            //Implementation of the clear button
            functionInterface.appendToInputs(clear);
            inputNumbers = new ArrayList<>(0);
            repaint();
            System.out.println(functionInterface.number2);
            System.out.println(functionInterface.operator);
            System.out.println(functionInterface.number1);
        }
        System.out.println("======================");
        System.out.println(functionInterface.number1 + " -> current number 1");
        System.out.println(functionInterface.number2 + " -> current number 2");
        System.out.println(functionInterface.operator + " -> current selected operator");
        System.out.println("======================");
    }



    private void drawZero(int x1, int x2, Graphics g){
        g.drawLine(x1,defaultY,x2,defaultY);
        g.drawLine(x1,defaultY,x1,defaultY+height);
        g.drawLine(x2,defaultY,x2,defaultY+height);
        g.drawLine(x1,defaultY+height,x2,defaultY+height);
    }

    private void drawOne(int x1, int x2, Graphics g){
        g.drawLine(x2, defaultY, x2, defaultY+height);
    }

    private void drawTwo(int x1, int x2, Graphics g){
        g.drawLine(x1,defaultY, x2,defaultY);
        g.drawLine(x2,defaultY, x2,defaultY+halfHeight);
        g.drawLine(x2,defaultY+halfHeight, x1,defaultY+halfHeight);
        g.drawLine(x1,defaultY+halfHeight, x1,defaultY+height);
        g.drawLine(x1,defaultY+height, x2,defaultY+height);
    }

    private void drawThree(int x1, int x2, Graphics g){
        g.drawLine(x1,defaultY, x2,defaultY);
        g.drawLine(x2,defaultY, x2,defaultY+halfHeight);
        g.drawLine(x2,defaultY+halfHeight, x1,defaultY+halfHeight);
        g.drawLine(x2,defaultY+halfHeight, x2,defaultY+height);
        g.drawLine(x2,defaultY+height, x1,defaultY+height);
    }

    private void drawFour(int x1, int x2, Graphics g){
        g.drawLine(x1,defaultY, x1,defaultY+halfHeight);
        g.drawLine(x2,defaultY, x2,defaultY+height);
        g.drawLine(x1,defaultY+halfHeight, x2,defaultY+halfHeight);
    }

    private void drawFive(int x1, int x2, Graphics g){
        g.drawLine(x1,defaultY, x2,defaultY);
        g.drawLine(x1,defaultY, x1,defaultY+halfHeight);
        g.drawLine(x1,defaultY+halfHeight, x2,defaultY+halfHeight);
        g.drawLine(x2,defaultY+halfHeight, x2,defaultY+height);
        g.drawLine(x1,defaultY+height, x2,defaultY+height);
    }

    private void drawSix(int x1, int x2, Graphics g){
        g.drawLine(x1,defaultY, x2,defaultY);
        g.drawLine(x1,defaultY, x1,defaultY+height);
        g.drawLine(x2,defaultY+halfHeight, x2,defaultY+height);
        g.drawLine(x1,defaultY+halfHeight, x2,defaultY+halfHeight);
        g.drawLine(x1,defaultY+height, x2,defaultY+height);
    }

    private void drawSeven(int x1, int x2, Graphics g){
        g.drawLine(x1,defaultY, x2,defaultY);
        g.drawLine(x2, defaultY, x2, defaultY+height);
    }

    private void drawEight(int x1, int x2, Graphics g){
        g.drawLine(x1,defaultY, x2,defaultY);
        g.drawLine(x1,defaultY, x1,defaultY+height);
        g.drawLine(x1,defaultY+halfHeight, x2,defaultY+halfHeight);
        g.drawLine(x2, defaultY, x2, defaultY+height);
        g.drawLine(x1,defaultY+height, x2,defaultY+height);
    }

    private void drawNine(int x1, int x2, Graphics g){
        g.drawLine(x1,defaultY, x2,defaultY);
        g.drawLine(x1,defaultY, x1,defaultY+halfHeight);
        g.drawLine(x2, defaultY, x2, defaultY+height);
        g.drawLine(x1,defaultY+halfHeight, x2,defaultY+halfHeight);
        g.drawLine(x1,defaultY+height, x2,defaultY+height);
    }

    private void drawDot(int x1, int x2,Graphics g){
        g.drawLine(x2,defaultY+height,x2,defaultY+height);
    }

    private void drawMinus(int x1, int x2, Graphics g){
        g.drawLine(x2-10,defaultY+halfHeight,x2-30,defaultY+halfHeight);
    }
    public void paint(Graphics g){//Method that draws the numbers on the screen
        dotPlaced = false;
        dotCount = 0;

        int Defaultx2 = 768; //Default x coordinates that will right align all numbers
        int Defaultx1 = Defaultx2-numberWidth;

        if(darkMode){
            g.setColor(Color.BLACK);
            g.fillRect(0,0,800,1000);

            ((Graphics2D) g).setStroke(new BasicStroke(2));

            g.setColor(Color.RED);
            g.drawRect(10, 40, 780, 950);

            g.setColor(Color.RED);
            g.drawRect(20,50,760,270);
            g.setColor(Color.WHITE);
        }
        else {
            g.setColor(Color.WHITE);
            g.fillRect(0,0,800,1000);

            ((Graphics2D) g).setStroke(new BasicStroke(2));

            g.setColor(Color.BLUE);
            g.drawRect(10, 40, 780, 950);

            g.setColor(Color.BLUE);
            g.drawRect(20,50,760,270);
            g.setColor(Color.BLACK);
        }



        ((Graphics2D) g).setStroke(new BasicStroke(8));


        for (int i = 0; i < inputNumbers.size(); i++) {
            int adjuster = i - dotCount; //Weird math stuff for x coordinate adjustments
            if(i!=0 && !dotPlaced){
                if(inputNumbers.get(i-1)!=10){
                    adjuster = i;
                }
            }
            if(i==0){
                adjuster = i;
            }
            int horizontalAdjust = 0;
            if(inputNumbers.get(0)==10){
                horizontalAdjust = 8;
            }
            switch (inputNumbers.get(i)){
                case 0://Just a mathematical calculation to adjust the x coordinate values
                    drawZero(Defaultx1-(adjuster *(numberWidth+gapSize) + horizontalAdjust ),Defaultx2-(adjuster *(numberWidth+gapSize) + horizontalAdjust),g);
                    break;
                case 1:
                    drawOne(Defaultx1-(adjuster *(numberWidth+gapSize) + horizontalAdjust ),Defaultx2-(adjuster *(numberWidth+gapSize) + horizontalAdjust),g);
                    break;
                case 2:
                    drawTwo(Defaultx1-(adjuster *(numberWidth+gapSize) + horizontalAdjust ),Defaultx2-(adjuster *(numberWidth+gapSize) + horizontalAdjust),g);
                    break;
                case 3:
                    drawThree(Defaultx1-(adjuster *(numberWidth+gapSize) + horizontalAdjust ),Defaultx2-(adjuster *(numberWidth+gapSize) + horizontalAdjust),g);
                    break;
                case 4:
                    drawFour(Defaultx1-(adjuster *(numberWidth+gapSize) + horizontalAdjust ),Defaultx2-(adjuster *(numberWidth+gapSize) + horizontalAdjust),g);
                    break;
                case 5:
                    drawFive(Defaultx1-(adjuster *(numberWidth+gapSize)+ horizontalAdjust),Defaultx2-(adjuster *(numberWidth+gapSize)+ horizontalAdjust),g);
                    break;
                case 6:
                    drawSix(Defaultx1-(adjuster *(numberWidth+gapSize) + horizontalAdjust ),Defaultx2-(adjuster *(numberWidth+gapSize) + horizontalAdjust),g);
                    break;
                case 7:
                    drawSeven(Defaultx1-(adjuster *(numberWidth+gapSize) + horizontalAdjust ),Defaultx2-(adjuster *(numberWidth+gapSize) + horizontalAdjust),g);
                    break;
                case 8:
                    drawEight(Defaultx1-(adjuster *(numberWidth+gapSize) + horizontalAdjust ),Defaultx2-(adjuster *(numberWidth+gapSize) + horizontalAdjust),g);
                    break;
                case 9:
                    drawNine(Defaultx1-(adjuster *(numberWidth+gapSize) + horizontalAdjust ),Defaultx2-(adjuster *(numberWidth+gapSize) + horizontalAdjust),g);
                    break;
                case 10:
                    int u = i - dotCount; //Even more weird math stuff for x coordinate adjustments
                    int modifier = 12;
                    if(i==0){
                        modifier = 20;
                    }
                    if(i==0){
                        horizontalAdjust = 0;
                    }
                    drawDot(Defaultx1 - ((u -1)*(numberWidth+gapSize)) - numberWidth - modifier - horizontalAdjust,Defaultx2-((u -1)*(numberWidth+gapSize)) - numberWidth - modifier - horizontalAdjust,g);
                    dotPlaced = true;
                    dotCount++;
                    if(i==0){ //Weird math stuff for x coordinate adjustments continued...
                        horizontalAdjust = 8;
                    }
                    break;
                case 11:
                    u = i - dotCount; //Still weird math stuff that even I forgot the formulas for after I wrote them
                    modifier = 12;
                    if(i==0){
                        modifier = 20;
                    }
                    if(i==0){
                        horizontalAdjust = 0;
                    }
                    drawMinus(Defaultx1 - ((u -1)*(numberWidth+gapSize)) - numberWidth - modifier - horizontalAdjust,Defaultx2-((u -1)*(numberWidth+gapSize)) - numberWidth - modifier - horizontalAdjust,g);
                    dotPlaced = true;
                    dotCount++;
                    if(i==0){ //I think the rest of the code is easier to read
                        horizontalAdjust = 8;
                    }
                    break;
            }

        }

    }

    public Calculator(Boolean darkMode){

        this.darkMode = darkMode;

        setSize(800,1000);
        setTitle("Fake TI-84 CE");
        setBackground(Color.WHITE);

        JPanel calculator = new JPanel(new GridLayout(0,1,10,10));
        calculator.setBorder(BorderFactory.createEmptyBorder(50,10,10,10));
        calculator.setBackground(Color.WHITE);

        UpperButtons upperButtons = new UpperButtons(darkMode,this);
        this.clear = upperButtons.returnClear();

        calculator.add(upperButtons);

        buttonGrid = new lowerButtons(darkMode,this);

        calculator.add(buttonGrid);
        add(calculator);

        //upperButtons.repaint(); This used to call the paint method, now it is unnecessary. (I think)

        setVisible(true);
    }




}
