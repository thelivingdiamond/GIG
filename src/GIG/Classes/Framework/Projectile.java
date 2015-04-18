package GIG.Classes.Framework;

import java.awt.Image;

import java.awt.Rectangle;

import javax.swing.ImageIcon;



public class Projectile
{
    protected int x, y;
    protected Image image;
    public boolean visible;
    protected int width, height;
    protected int damage;

    public Image getImage() {
        return image;
    }
    
    public void setX(int i)
    {
        x =i;
    }
    
    public void setY(int i)
    {
        y = i;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width/2, height/2);
    }
}
