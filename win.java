import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class youwin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class win extends NoScrollObjects
{
    /**
     * Act - do whatever the youwin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private SimpleTimer timer = new SimpleTimer();
    public void started()
    {
         timer.mark();
    }
    public void act() 
    {
        if(timer.millisElapsed() > 2000) 
        Greenfoot.setWorld(new menu());
    }    
}
