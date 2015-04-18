package GIG.Classes.Framework;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Thing
{
    protected int x;
    protected int y;
    protected int mass;
    protected int width;
    protected int height;
    protected boolean visible;
    protected Image image;
    protected int dx;
    protected int dy;
    
     public int getX() {
        return x;
    }    
    public void setX(int i) {
        y = i;
    }

    public int getY() {
        return y;
    }    
    public void setY(int i) {
        y = i;
    }
    
    public Image getImage() {
        return image;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isVisible() {
        return visible;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
    
    public int getDY() {
        return dy;
    }
    public void setDY(int y) {
        dy = y;
    }
    
    public int getDX() {
        return dx;
    }
    public void setDX(int x) {
        dx = x;
    }    
}
