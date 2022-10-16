import java.awt.*;
import java.awt.event.ActionListener;

public class customButton extends Button {
    public customButton(String label, boolean darkMode, ActionListener e){//Subclass of button created to de-clutter the Calculator class
        if(darkMode) {
            this.setFont(new Font("Arial", Font.BOLD, 40));
            this.setLabel(label);
            setSize(70, 50);
            setBackground(Color.DARK_GRAY);
            setForeground(Color.WHITE);
        }
        else{
            this.setFont(new Font("Arial", Font.BOLD, 40));
            this.setLabel(label);
            setSize(70, 50);
            setBackground(Color.BLUE);
            setForeground(Color.WHITE);
        }
        addActionListener(e);
    }
}
