import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class afterimage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class afterimage extends ScrollObjects
{
    /**
     * Act - do whatever the afterimage wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int frame = 0;
    public void act() 
    {
        frame++;
        if(frame == 5)
        getWorld().removeObject(this);// Add your action code here.
    }    
}
