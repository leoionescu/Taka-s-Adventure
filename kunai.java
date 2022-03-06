import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class kunai here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class kunai extends ScrollObjects
{
    private GreenfootImage kunail = new GreenfootImage("kunail.png");
    private GreenfootImage kunair = new GreenfootImage("kunair.png");
    public static int x;
    public static int y;
    public static int z = -10000;
    private boolean ismovingright;
    private boolean remove = false;
    /**
     * Act - do whatever the kunai wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(remove) 
        {
            getWorld().removeObject(this);
            x=z; 
            y=z;
        }
        else
        {
        x = getX();
        y = getY();
        if(isTouching(skeleton.class))
        {dealdamage();}
        
        if(ninja.currentx<getX())
        {
            if(!isTouching(ground.class) && !isTouching(platform.class)) kunaithrowright();
    
    }
    else {
        if(!isTouching(ground.class) && !isTouching(platform.class)) kunaithrowleft();
        }
}
}
    public void dealdamage()
    {
        removeTouching(skeleton.class);
        remove = true;
    }
    public void kunaithrowright()
    {
        ismovingright = true;
        setImage(kunair);
        setLocation(getX()+5,getY());
        if(getX() - ninja.currentx > 400 || getX() - ninja.currentx < -400 || getX() == 3199) 
        {getWorld().removeObject(this); x=z; y=z;}
    }
    public void kunaithrowleft()
    {
        ismovingright = false;
        setImage(kunail);
            setLocation(getX()-5,getY());
            if(isAtEdge() == true) 
        {getWorld().removeObject(this);  x=z; y=z;}
    }
}
