import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class lowerButtons extends JPanel {

    boolean darkMode = false;

    Button[] buttons;

    private customButton[] createButtons(ActionListener e){
        customButton[] buttonArray = new customButton[16];
        buttonArray[0] = new customButton("7",darkMode,e);
        buttonArray[1] = new customButton("8",darkMode,e);
        buttonArray[2] = new customButton("9",darkMode,e);
        buttonArray[3] = new customButton("+",darkMode,e);

        buttonArray[4] =new customButton("4",darkMode,e);
        buttonArray[5] =new customButton("5",darkMode,e);
        buttonArray[6] =new customButton("6",darkMode,e);
        buttonArray[7] =new customButton("-",darkMode,e);

        buttonArray[8] = new customButton("1",darkMode,e);
        buttonArray[9] = new customButton("2",darkMode,e);
        buttonArray[10] = new customButton("3",darkMode,e);
        buttonArray[11] = new customButton("x",darkMode,e);

        buttonArray[12] = new customButton("0",darkMode,e);
        buttonArray[13] = new customButton(".",darkMode,e);
        buttonArray[14] = new customButton("=",darkMode,e);
        buttonArray[15] = new customButton("÷",darkMode,e);

        return buttonArray;
    }

    public lowerButtons(boolean darkMode, ActionListener e){ //Class for the creation of the lower panel consisting of the 16 buttons used to do operations
        this.darkMode = darkMode;
        this.setBounds(0,500,800,700);
        this.setLayout(new GridLayout(4,4,50,50));
        this.setOpaque(true);
        this.setBackground(Color.WHITE);
        customButton[] buttons = createButtons(e);

        for (int i = 0; i < buttons.length; i++) {
            this.add(buttons[i]);
        }
        this.buttons = buttons;
    }

    public Button[] returnButtonArray(){
        return this.buttons;
    }


}
