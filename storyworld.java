import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class story here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class storyworld extends World
{

    /**
     * Constructor for objects of class story.
     * 
     */
    public storyworld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        setBackground("background.png");
        addObject(new story(),300,160);
        addObject(new start(),300,350);
    }
}
