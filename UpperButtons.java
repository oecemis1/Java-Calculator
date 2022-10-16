import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class UpperButtons extends JPanel {

    Button clear;

    public UpperButtons(boolean darkMode, ActionListener e){ //Class for the creation of the upper panel consisting of the clear button and a place holder for the display numbers are printed on

        this.setLayout(new GridLayout(0,1,20,0));
        this.setSize(800,300);
        this.setOpaque(true);
        this.setBackground(Color.WHITE);

        JLabel display = new JLabel();
        display.setBackground(Color.LIGHT_GRAY);
        display.setOpaque(true);

        JLabel space = new JLabel();
        space.setBackground(Color.LIGHT_GRAY);
        space.setOpaque(true);

        JLabel space1 = new JLabel();
        space1.setBackground(Color.WHITE);
        space1.setOpaque(true);

        clear = new Button("C");
        if(darkMode) {
            clear.setFont(new Font("Arial", Font.BOLD, 40));
            clear.setSize(700, 50);
            clear.setBackground(Color.DARK_GRAY);
            clear.setForeground(Color.WHITE);
            clear.addActionListener(e);
        }
        else{
            clear.setFont(new Font("Arial", Font.BOLD, 40));
            clear.setSize(700, 50);
            clear.setBackground(Color.BLUE);
            clear.setForeground(Color.WHITE);
        }
        this.add(display);
        this.add(space);
        this.add(space1);
        this.add(clear);
    }

    public Button returnClear(){
        return this.clear;
    }

}
