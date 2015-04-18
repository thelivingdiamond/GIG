package GIG.Classes.Framework;

import GIG.Classes.Mobs.Carb;
import GIG.Classes.Mobs.EyeBallz;
import GIG.Classes.Projectiles.PlasmaRocketProjectile;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.Timer;
import javax.swing.*;

public class Board extends JPanel implements MouseListener, MouseMotionListener, ActionListener {
	
	private int counter;
	private String WinMessage;
	private String DeathPun;
	private boolean WinCheck;
    private boolean InGame;
	private String board = "FrameWorkTextures/Background.gif";
    private ImageIcon ii = new ImageIcon(this.getClass().getResource(board));
    private Timer timer;
    public Craft craft;
    public static int B_WIDTH;
    public static int B_HEIGHT;
    @SuppressWarnings("rawtypes")
	private ArrayList carbs = new ArrayList();
    private ArrayList eyeBallz = new ArrayList();
    //private ArrayList things;
    @SuppressWarnings("rawtypes")
	private ArrayList actors;
    private JButton SpawnCarb;
    private enum STATE{
        MENU,
        PAUSE,
        GAME
    };
    private STATE STATES = STATE.GAME;


    private int counter_1; //Enegy Regen

    private int counter_2; //Enegy Delay
 

    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public Board() {

        WinCheck = false;
        InGame = true;
    	setFocusable(true);
        setBackground(Color.WHITE);
        setDoubleBuffered(true);
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        addNotify();
        // Board a = this;
        //addMouseListener(this);
		//addMouseMotionListener(this);
        actors = new ArrayList();
        craft = new Craft();
        actors.add(craft);
        timer = new Timer(5, this);
        timer.start();
        EyeBallzSpawn();
        CarbSpawn();
        //CarbSpawn();
        EyeBallzSpawn();
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("pressed W"), "pressedWAction");
        getActionMap().put("pressedWAction", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    if (craft.canJump == true)
                    craft.isJumping = true;
                }
            });
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released W"), "releasedWAction");  
        getActionMap().put("releasedWAction", new AbstractAction()
            {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    craft.setDY(0);
                }
            });    
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("pressed UP"), "pressedWAction");
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released UP"), "releasedWAction");  
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("pressed S"), "pressedSAction");
        getActionMap().put("pressedSAction", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    craft.setDY(5);
                }
            });
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released S"), "releasedWAction");  
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("pressed DOWN"), "pressedSAction");    
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released DOWN"), "releasedWAction");     
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("pressed A"), "pressedAAction");
        getActionMap().put("pressedAAction", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    craft.setDX(-5);
                }
            });
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released A"), "releasedAAction");  
        getActionMap().put("releasedAAction", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    craft.setDX(0);
                }
            });
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("pressed LEFT"), "pressedAAction");
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released LEFT"), "releasedAAction");      
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("pressed D"), "pressedDAction");
        getActionMap().put("pressedDAction", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    craft.setDX(5);
                }
            });
        
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released D"), "releasedAAction");   
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("pressed RIGHT"), "pressedDAction");     
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released RIGHT"), "releasedAAction");
        
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("pressed SPACE"), "pressedSPACEAction");
        getActionMap().put("pressedSPACEAction", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    if (craft.ENEGY>=8 && craft.canFire) {

                        craft.Fire();

                        counter_2 = 0;

                           craft.ENEGY -= 8;
                          // System.out.println("You Fired");
        }  else if (craft.ENEGY<=8 && craft.ENEGY>= 0 && craft.canFire) {
        craft.Fire();
        craft.canFire=false;
        counter_2 = 40;
        //System.out.println("You Fired(Overheat)");
        craft.ENEGY -= 8;
        }
                    
                	
                }
            
        });

        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released SPACE"), "releasedSPACEAction");  
        getActionMap().put("releasedSPACEAction", new AbstractAction()
            {
                @Override
                public void actionPerformed(ActionEvent ae) {

 



                }
            });
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("pressed ESCAPE"), "pressedESCAction");
        getActionMap().put("pressedESCAction", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(STATES == STATE.MENU){
                    STATES = STATE.GAME;
                } else if (STATES == STATE.GAME){
                    STATES = STATE.MENU;
                }
            }
        });
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("pressed E"), "pressedEAction");
        getActionMap().put("pressedEAction", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                EyeBallzSpawn();
            }
        });
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("pressed C"), "pressedCAction");
        getActionMap().put("pressedCAction", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                CarbSpawn();
            }
        });
    }

     

		
	

	public void addNotify() {
        super.addNotify();
        B_WIDTH = getWidth();
        B_HEIGHT = getHeight();   
    }

    public void paint(Graphics g) {
    	super.paint(g);
    	if (InGame == true && STATES==STATE.GAME) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(ii.getImage(),0,0,getWidth()+20,getHeight(),this);
        if (craft.isVisible()){
                g2d.drawImage(craft.getImage(), craft.getX(), craft.getY(),this);
                for(int i = 0; i<carbs.size(); i++) {
                    Carb c = (Carb) carbs.get(i);
                    if (c.isVisible()){
                    g2d.drawImage(c.getImage(), c.getX(), c.getY(), this);
                    }
                }
            for(int i = 0; i<eyeBallz.size(); i++) {
                EyeBallz e = (EyeBallz) eyeBallz.get(i);
                if (e.isVisible()){
                    g2d.drawImage(e.getImage(), e.getX(), e.getY(), this);
                }
            }
                for(int i = 0; i<craft.GetMiscles().size(); i++) {
                    PlasmaRocketProjectile RP = (PlasmaRocketProjectile) craft.GetMiscles().get(i);
                    g2d.drawImage(RP.getImage(), RP.getX(), RP.getY(), this);
                }
                g2d.setColor(Color.BLUE);
                Rectangle r;
                r = new Rectangle(craft.ENEGY, 10);
                r.setLocation(0, 10);
                g2d.fill(r);
                g2d.draw(r);
                g2d.drawString("" + craft.ENEGY, 0, 35);
                if (craft.canFire) {
                	g2d.setColor(Color.GREEN);
                } else {
                	g2d.setColor(Color.RED);
                }
                Rectangle r2;
                r2 = new Rectangle(10,10);
                r2.setLocation(110, 10);
                g2d.fill(r2);
                g2d.draw(r2);
        
               
        g2d.setColor(Color.WHITE);
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    	
        }} else if(InGame == false && WinCheck == true) {
        	
        } else if(InGame == false && WinCheck == false) {
        	Font DP = new Font("Impact", Font.PLAIN, 36);
        	FontMetrics DPM = this.getFontMetrics(DP);
        	g.setColor(Color.PINK);
        	g.setFont(DP);
        	g.drawString(DeathPun, (this.getWidth()-this.getWidth() + 20), (this.getHeight() / 2));
        } else if (InGame == true && STATES == STATE.MENU){
            Font DP = new Font("Impact", Font.PLAIN, 36);
            FontMetrics DPM = this.getFontMetrics(DP);
            g.setColor(Color.PINK);
            g.setFont(DP);
            g.drawString("Menu", (this.getWidth()-this.getWidth() + 20), (this.getHeight() / 2));
        }
    }


    public void actionPerformed(ActionEvent e) {        
        
    	craft.move();
        for (int i = 0; i < actors.size(); i++) {
            Thing t = (Thing) actors.get(i);
            t.setY(t.getY() + 3);
        }
        
        if (craft.isJumping == true && craft.jumpCounter <= 20)
        {
            craft.setY(craft.getY() - 17);
            craft.jumpCounter ++;
            craft.canJump = false;
        }
        if (craft.isJumping == false || craft.jumpCounter > 20)
        {
            craft.isJumping = false;
            craft.jumpCounter = 0;
        }
        for(int i = 0; i<carbs.size(); i++) {
                   
        	Carb c = (Carb) carbs.get(i);
        	if (c.isVisible()) {
                    c.move();
        	} else {
        		carbs.remove(i);
        	}
                }
        for(int i = 0; i<eyeBallz.size(); i++) {

            EyeBallz eb = (EyeBallz) eyeBallz.get(i);
            if (eb.isVisible()) {
                eb.move();
            } else {
                eyeBallz  .remove(i);
            }
        }
        for(int i = 0; i<craft.GetMiscles().size(); i++) {
            PlasmaRocketProjectile RP = (PlasmaRocketProjectile) craft.GetMiscles().get(i);
            if (RP.isVisible()){
            RP.move();
            } else {
            	craft.GetMiscles().remove(i);
            	RP = null;
            }
        }
        counter++;
        if (counter == 10){
        	//CarbSpawn();
            //EyeBallzSpawn();
        	counter = 0;
        }

counter_1++;
counter_2++; 
	
	if (counter_1 >= craft.regenSpeed) {

	if (craft.ENEGY < craft.maxEnegy) {

	if (counter_2 >= 80){
craft.ENEGY++;

counter_1 = 0;

}
}
}
if (craft.ENEGY == craft.maxEnegy) {craft.canFire = true;} 

       
        checkCollisions();
        repaint();  
    }

    public void checkCollisions() {
        Rectangle r3 = craft.getBounds();
        
        for(int i = 0; i<carbs.size(); i++) {
                    Carb c = (Carb) carbs.get(i);
                    Rectangle r4 = c.getBounds();
                    //System.out.println("Apple Sauce");
                    if (r3.intersects(r4)) {
                        DeathPun = "You got Carbed up by a Carb!";
                        InGame = false;
                        WinCheck = false;
                        //Carb cb = new Carb();
                        //cb.visible = false;
                        //EyeBallz eb = new EyeBallz();
                       // eb.visible = false;
                        /**for (int l =0; l<=carbs.size(); l++) {
                            if(carbs.size() == 0){
                                carbs = null;
                                return;
                            }
                            if(carbs.size() >= 1)continue;
                            carbs.remove(l);
                         */
                            //if(l == 1)System.out.println("2 carbs removed");

                        /**for (int l =0; l<=eyeBallz.size(); l++) {
                            if (eyeBallz.size() == 0) {
                                eyeBallz = null;
                                return;
                            }
                            if (eyeBallz.size() >= 1) continue;
                            eyeBallz.remove(l);
                            //if(l == 1)System.out.println("2 carbs removed");

                        }*/

                        
                    }
                   
                    }
        for(int i = 0; i<eyeBallz.size(); i++) {
            EyeBallz eb = (EyeBallz) eyeBallz.get(i);
            Rectangle r5 = eb.getBounds();
            //System.out.println("Apple Sauce");
            if (r3.intersects(r5)) {
                DeathPun = "The EyeBallz were watching and stalking you... then they killed you";
                InGame = false;
               // Carb cb = new Carb();
              //  cb.visible = false;
              //  EyeBallz e = new EyeBallz();
           //     eb.visible = false;
                /**for (int l =0; l<=carbs.size(); l++) {

                    if(carbs.size() == 0){
                        carbs = null;
                        return;
                    }
                    if(carbs.size() >= 1)continue;
                    carbs.remove(l);

                */}

                /**for (int l =0; l<=eyeBallz.size(); l++) {
                    if(eyeBallz.size() == 0){
                        eyeBallz = null;
                        return;
                    }
                    if(eyeBallz.size() >= 1)continue;
                    eyeBallz.remove(l);
                }*/

            }


        for(int l = 0; l<craft.GetMiscles().size(); l++){
        	PlasmaRocketProjectile RP = (PlasmaRocketProjectile) craft.GetMiscles().get(l);
            Rectangle r1 = RP.getBounds();
            for(int i = 0; i<carbs.size(); i++) {
            Carb c = (Carb) carbs.get(i);
            
            Rectangle r4 = c.getBounds();
            
            //System.out.println("Apple Sauce");
            if (r1.intersects(r4)) {
            	c.setVisible(false);
            	c = null;
            	//System.out.println("Apple Sauce2");
            }
            
            }
            for(int i = 0; i<eyeBallz.size(); i++) {
                EyeBallz eb = (EyeBallz) eyeBallz.get(i);

                Rectangle r5 = eb.getBounds();

                //System.out.println("Apple Sauce");
                if (r1.intersects(r5)) {
                    eb.setVisible(false);
                    eb = null;
                    //System.out.println("Apple Sauce2");
                }

            }
                }
}

    @SuppressWarnings("unchecked")
	public void CarbSpawn(){
        if(InGame && !WinCheck) {
            carbs.add(new Carb());
            Carb c = (Carb) carbs.get(carbs.size() - 1);
            actors.add(c);
        }
    }
    public void EyeBallzSpawn(){
        if(InGame && !WinCheck) {
            eyeBallz.add(new EyeBallz());
            EyeBallz eb = (EyeBallz) eyeBallz.get(eyeBallz.size() - 1);
            actors.add(eb);
        }
    }
   

    public void mouseMoved(MouseEvent e) {
        System.out.println("Mouse moved " + e.getX() + " " + e.getY());
    }

    public void mouseDragged(MouseEvent e) {

    }
    public void mousePressed(MouseEvent e) {

    }
     
    public void mouseReleased(MouseEvent e) {

    }
     
    public void mouseEntered(MouseEvent e) {
        
    }
     
    public void mouseExited(MouseEvent e) {
        
    }
     
    public void mouseClicked(MouseEvent e) {
       System.out.println("Mouse Clicked on diareah");
    }
}
