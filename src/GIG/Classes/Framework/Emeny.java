package GIG.Classes.Framework;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Emeny extends Thing{
    protected int Health;
    public int GetHealth() {
        return Health;
    }
    public void SetHealth(int appplez) {
        Health = appplez;
    }
}