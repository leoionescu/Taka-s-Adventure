import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ScrollObjects here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class ScrollObjects  extends Actor
{
    private int ScrollPositionX;
    private int ScrollPositionY;

    /** The act Method */
    public void act() 
    {}

    /** returns the World */
    public Scrollworld getWorld()
    {
        return (Scrollworld)super.getWorld();
    }

    /** sets the Location on the whole World */
    public void setLocation(int x, int y)
    {
        if(x>getWorld().getWidth()-1)
            x=getWorld().getWidth()-1;
        if(y>getWorld().getHeight()-1)
            y=getWorld().getHeight()-1;
        if(x<0)
            x=0;
        if(y<0)
            y=0;
        ScrollPositionX=x;
        ScrollPositionY=y;
        super.setLocation(x-getWorld().getScreenLeft(),y-getWorld().getScreenUp());
    }

    /** return the X Position on the screen */
    public int getScreenX()
    {
        return super.getX();
    }

    /** return the Y Position on the screen */
    public int getScreenY()
    {
        return super.getY();
    }

    /** return the X Position on the world */
    public int getX()
    {
        return ScrollPositionX;
    }

    /** return the Y Position on the world */
    public int getY()
    {
        return ScrollPositionY;
    }
    
    /** Turns an object for the given degrees */
    public void turn(int angle)
    {setRotation(getRotation()+angle);}
}
