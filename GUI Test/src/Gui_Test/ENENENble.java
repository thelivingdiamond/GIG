package Gui_Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by theli_000 on 4/16/2015.
 */
public class ENENENble extends JPanel implements ActionListener{
    public ENENENble(){
        setFocusable(true);
        setBackground(Color.PINK);
        setDoubleBuffered(true);
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("pressed E"), "pressedEAction");
        getActionMap().put("pressedEAction", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {

            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
