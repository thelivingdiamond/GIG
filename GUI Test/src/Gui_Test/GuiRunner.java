package Gui_Test;
import java.awt.event.*;

        import javax.swing.*;

        import java.awt.*;
        import java.util.ArrayList;
/**
 * Created by theli_000 on 3/26/2015.
 */
public class GuiRunner extends JFrame implements ActionListener{
    public Gui_Test gt;
    public GuiRunner(){
        gt = new Gui_Test();
        add(new Gui_Test());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setLocationRelativeTo(null);
        setTitle("Collision");
        setResizable(false);
        setVisible(true);

    }
    public static void main(String[] args) {
        new GuiRunner();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
