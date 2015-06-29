package GIG.Classes.Framework;

import GIG.Classes.Projectiles.PlasmaRocketProjectile;

import java.awt.event.*;

import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;

public class PhysicsSim extends JFrame implements MouseMotionListener, MouseListener{
public Board board;
    public PhysicsSim() {
        board = new Board();
    	add(new Board());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setLocationRelativeTo(null);
        setTitle("Galapagos' Gold");
        setResizable(false);
        setVisible(true);


        //board.addMouseMotionListener(board);
        //addMouseMotionListener(this);
        addMouseListener(this);
         //board.addMouseListener(board);
         //board.addMouseMotionListener(board);
    }

    public static void main(String[] args) {
        PhysicsSim pn = new PhysicsSim();


    }
    public void mouseMoved(MouseEvent e) {
        //System.out.println("Mouse moved " + e.getX() + " " + e.getY());
    }

	@Override
	public void mouseDragged(MouseEvent arg0) {

		
	}
	public void mousePressed(MouseEvent e) {

    }
    public void mouseReleased(MouseEvent e) {

    }
    public void mouseEntered(MouseEvent e) {
        
    }
    public void mouseExited(MouseEvent e) {
        
    }
    @SuppressWarnings("unchecked")
	public void mouseClicked(MouseEvent e) {
       System.out.println("Mouse Clicked");
       ArrayList<PlasmaRocketProjectile> poop;
       //poop;
        board.craft.GetMiscles().add(new PlasmaRocketProjectile(board.craft.getX(), board.craft.getY(),
    			 e.getX(), e.getY(), 0));
    	
    }
}