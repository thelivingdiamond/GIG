package GIG.Classes.Framework;

import GIG.Classes.Projectiles.PlasmaRocketProjectile;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Craft extends Thing {
    private String craft = "FrameworkTextures/GIG_Player.gif";
    public boolean isJumping = false;
    public boolean canJump = true;
    public int jumpCounter;
    public int ENEGY = 100;
    public int maxEnegy = 100;
    public int regenSpeed = 1;
    public boolean canFire = true;


    ArrayList MISCLES = new ArrayList();

    public Craft() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(craft));
        image = ii.getImage();
        
        width = image.getWidth(null);
        height = image.getHeight(null);
        visible = true;
        x = Board.B_WIDTH/8;
        y = Board.B_HEIGHT - 300;
    }
    
    public void Fire(){
    	if (0 < 1){
    	MISCLES.add(new PlasmaRocketProjectile((this.x + 230), (this.y + ((height / 2)-32)), 0));
    	}
    }
    
    public ArrayList GetMiscles(){
    	return MISCLES;
    }
    
    public void move() {
        x += dx;
        y += dy;
        
        
        if (x < 0) {
            x = 0;
        }
        if (y < 0) {
            y = 0;
        }
        if (x > Board.B_WIDTH - width) {
            x = Board.B_WIDTH - width;
        }
        if (y > Board.B_HEIGHT - height - 50) {
            y = Board.B_HEIGHT - height - 50;
            canJump = true;
        }
        
    }
    
}