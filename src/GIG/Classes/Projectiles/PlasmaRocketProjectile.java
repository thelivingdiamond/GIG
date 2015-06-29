package GIG.Classes.Projectiles;

import javax.swing.ImageIcon;

import GIG.Classes.Framework.Board;
import GIG.Classes.Framework.Projectile;

public class PlasmaRocketProjectile extends Projectile
{
    private String missile2 = "ProjectileTextures/godzilla_01.gif";
    private String explode  = "Textures/Explosion.gif";
    private int moveType;
    boolean isExploded;
    private int burnTimer;
    private int explodeY;
    private int explodeX;
    private boolean GodBulletnesszilla;
    //private int Health;

    private int SPEED;
private int Ity;
private int IgunX;
private int IgunY;
private int ImX;
private int ImY;
    public PlasmaRocketProjectile(int x, int y, int ty, boolean GodBulletness) {
        GodBulletnesszilla = GodBulletness;
        if (!GodBulletnesszilla){
            missile2 = "ProjectileTextures/Plasma Bolt.gif";
            SPEED = 4;
        } else if (GodBulletnesszilla){
            missile2 = "ProjectileTextures/IMAFIRINMAHLAZOR.gif";
            SPEED = 3;
        }

        
        ImageIcon ii = new ImageIcon(this.getClass().getResource(missile2));
        image = ii.getImage();
        visible = true;
        width = image.getWidth(null);
        height = image.getHeight(null);
        this.x = x;
        this.y = y;
        isExploded = false;
        Ity = ty;
        
        
    }
  public PlasmaRocketProjectile( int gunX, int gunY, int mX, int mY, int ty) {
        
        
        ImageIcon ii = new ImageIcon(this.getClass().getResource(missile2));
        image = ii.getImage();
        visible = true;
        width = image.getWidth(null);
        height = image.getHeight(null);
        x = gunX;
        y = gunY;
        isExploded = false;
        IgunX = gunX;
        IgunY = gunY;
        ImX = mX;
        ImY = mY;
        Ity = ty;
    }

    public void explode()
    {
        isExploded = true;
        burnTimer ++;
        ImageIcon ii = new ImageIcon(this.getClass().getResource(explode));
        image = ii.getImage();
        x = explodeX;
        y = explodeY;
    }

    public int getBurnTimer()
    {
        return burnTimer;
    }

    public boolean getIsExploded()
    {
        return isExploded;
    }

    public int getMoveType()
    {
        return moveType;
    }

    public void move() {
        if (Ity == 0) {
                x += SPEED;
                if (x > Board.B_WIDTH)
                    visible = false;
        } else if (Ity == 1) {
        	//x += ((ImX - IgunX)/100 );
        	//y += ((IgunY - ImY)/100 );
            x += 1;
        	//if (x > Board.B_WIDTH)
                //visible = false;
        	visible = true;
        	if (visible == true);
        			//System.out.println("Burrito");
        	//System.out.println("Diareah");
        	//System.out.println("Your ballistic Diareah moved to " + this.x + " " + this.y);
        }
           
   
            
            
        }
    public boolean getGodBulletness(){
        return GodBulletnesszilla;

    }
    }

