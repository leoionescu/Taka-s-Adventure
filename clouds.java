import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class clouds here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class clouds extends ScrollObjects
{
    private int animationcounter = 0;
    /**
     * Act - do whatever the clouds wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       if(animationcounter % 50 == 0)
        if(Greenfoot.getRandomNumber(10) % 2 == 1)
        setLocation(getX()+1,getY());
        else setLocation(getX()-1,getY());
        animationcounter++;
    }    
}
