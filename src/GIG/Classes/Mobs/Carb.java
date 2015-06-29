package GIG.Classes.Mobs;

import GIG.Classes.Framework.Board;
import GIG.Classes.Framework.Emeny;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Carb extends Emeny {
    private String carb = "MobTextures/Carb2.gif";
    private int moveSwitch = 1;
    private int leftBound = 0;
    private int rightBound = 0;
    public Carb() {

        ImageIcon ii = new ImageIcon(this.getClass().getResource(carb));
        image = ii.getImage();
        
        width = image.getWidth(null);
        height = image.getHeight(null);
        visible = true;
        x = Board.B_WIDTH/2;
        y = height;
        leftBound=300;
        rightBound=1000;
        dx = -3;
        SetHealth(10);

    }
    public void move() {
        if (moveSwitch == 0) {
            x -= dx;
        }
        if (moveSwitch == 1) {
            x += dx;
        }
        //x += dx;
        
        if (x < leftBound) {
            moveSwitch = 0;
        }
        if (x > rightBound) {
            moveSwitch = 1;
        }
        if (y > Board.B_HEIGHT - height) {
            y = Board.B_HEIGHT - height;
        }
    }
     public Image getImage() {
        return image;
    }
}