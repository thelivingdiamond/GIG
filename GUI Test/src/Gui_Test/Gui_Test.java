package Gui_Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.geom.Arc2D;

/**
 * Created by theli_000 on 3/26/2015.
 */
public class Gui_Test extends JFrame implements ActionListener{
    private JPanel panel1;
    private JTextField yourCircleSRadiusTextField;
    private JButton calculateButton;
    private JComboBox comboBox1;
    private JProgressBar progressBar1;
    private JLabel output;

        public static Gui_Test gt;
        public Gui_Test(){
            panel1.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("pressed ESCAPE"), "pressedESCAction");
            panel1.getActionMap().put("pressedESCAction", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    if(panel1.isEnabled()){
                        panel1.disable();
                    } else if (!(panel1.isEnabled())){
                        panel1.enable();
                    }
                }
            });
            output = new JLabel("The Radius of Your Circle!");
            buttonHandler h = new buttonHandler();
            //add(new Gui_Test());
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(Toolkit.getDefaultToolkit().getScreenSize());
            setLocationRelativeTo(null);
            setTitle("Collision");
            setResizable(false);
            setVisible(true);
            add(panel1);
            panel1.add(yourCircleSRadiusTextField);
            panel1.add(comboBox1);
            panel1.add(calculateButton);
            panel1.add(progressBar1);
            panel1.add(output);
            calculateButton.addActionListener(h);
            comboBox1.addItemListener(h);
            setBounds(0, 0, 500, 500);
            System.out.println();

        }
        public static void main(String[] args) {


            new Gui_Test();
        }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    private class buttonHandler implements ActionListener,ItemListener{
        public void actionPerformed (ActionEvent e){
            if(e.getSource().equals(calculateButton)){

                output.setText("" + calculateCircle(Double.parseDouble(yourCircleSRadiusTextField.getText())));
                panel1.disable();

            }
        }



        private double calculateCircle(double l) {

            if(comboBox1.getSelectedItem().equals("Area"))return Math.PI * (l*l);
            if(comboBox1.getSelectedItem().equals("Circufrence"))return Math.PI * (2*l);
            if(comboBox1.getSelectedItem().equals("Diameter"))return 2 * l;
            if(comboBox1.getSelectedItem().equals(0));

            return 0;
        }

        @Override
        public void itemStateChanged(ItemEvent e) {

        }
    }
}
