package GIG.Classes.Mobs;


import GIG.Classes.Framework.Board;
import GIG.Classes.Framework.Emeny;

import javax.swing.*;
import java.awt.*;

public class EyeBallz extends Emeny {
    private String Eyeballzz = "MobTextures/EyeBALLZ.gif";
    private int moveSwitch = 1;
    private int leftBound = 0;
    private int rightBound = 0;
    public EyeBallz() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(Eyeballzz));
        image = ii.getImage();

        width = image.getWidth(null);
        height = image.getHeight(null);
        visible = true;
        x = Board.B_WIDTH/2;
        y = height;
        leftBound=300;
        rightBound=1000;
        dx = -5;
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