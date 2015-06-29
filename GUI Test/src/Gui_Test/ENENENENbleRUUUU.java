package Gui_Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by theli_000 on 4/16/2015.
 */
public class ENENENENbleRUUUU extends JFrame implements ActionListener{
    private ENENENble e;
    public JButton j2;
    private ENENENble2 e2;
    public ENENENENbleRUUUU(){
        add(e = new ENENENble());
        add(e2 = new ENENENble2());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setLocationRelativeTo(null);
        setTitle("ENENENNENENEN");
        setResizable(false);
        setVisible(true);
        e2.setVisible(true);
        e.setVisible(false);
        if(!e2.isVisible()){
            e.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("pressed E"), "pressedEAction");
            e.getActionMap().put("pressedEAction", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    //e2 = new ENENENble2();
                    if (e.isVisible()) {
                        e.setVisible(false);
                        e2.setVisible(true);
                    } else if (!(e.isVisible())) {
                        e.setVisible(true);
                        e2.setVisible(false);
                    }
                    //JButton j2;
                    j2  = new JButton("CoolBeans");

                    e.add(j2);
                    repaint();
                }
            });
        } else if(e2.isVisible()){
            e2.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("pressed E"), "pressedEAction");
            e2.getActionMap().put("pressedEAction", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    //e2 = new ENENENble2();
                    if (e.isVisible()) {
                        e.setVisible(false);
                        e2.setVisible(true);
                    } else if (!(e.isVisible())) {
                        e.setVisible(true);
                        e2.setVisible(false);
                    }
                    //JButton j2;
                    j2  = new JButton("CoolBeans");

                    e2.add(j2);
                    repaint();
                }
            });
        }
    }

    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
    }
    public static void main(String[] args){
        new ENENENENbleRUUUU();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
