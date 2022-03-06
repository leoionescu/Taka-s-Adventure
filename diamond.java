import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class diamond here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class diamond extends ScrollObjects
{
    /**
     * Act - do whatever the diamond wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage diamond1 = new GreenfootImage("diamond1.png");
    private GreenfootImage diamond2 = new GreenfootImage("diamond2.png");
    private GreenfootImage diamond3 = new GreenfootImage("diamond3.png");
    private GreenfootImage diamond4 = new GreenfootImage("diamond4.png");
    private GreenfootImage diamond5 = new GreenfootImage("diamond5.png");
    private int animationcounter = 0;
    private int frame = 1;
    public static int diamondscollected =0;
    public void act() 
    {
        if(animationcounter % 20 == 0)
        if(frame == 1) {setImage(diamond1); frame++;}
        else if(frame == 2) {setImage(diamond2); frame++;}
            else if(frame == 3) {setImage(diamond3); frame++;}
            else if(frame ==4) {setImage(diamond4); frame++;}
            else if(frame == 5) {setImage(diamond5); frame = 1;}
        animationcounter++;
        if(isTouching(ninja.class))
        {
            diamondscollected++;
            getWorld().removeObject(this);
            
        }
    }    
}
