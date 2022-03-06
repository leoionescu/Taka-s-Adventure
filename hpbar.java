import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class hpbar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class hpbar extends NoScrollObjects
{
    private GreenfootImage hpbar0 = new GreenfootImage("hpbar0.png");
    private GreenfootImage hpbar10 = new GreenfootImage("hpbar10.png");
    private GreenfootImage hpbar20 = new GreenfootImage("hpbar20.png");
    private GreenfootImage hpbar30 = new GreenfootImage("hpbar30.png");
    private GreenfootImage hpbar40 = new GreenfootImage("hpbar40.png");
    private GreenfootImage hpbar50 = new GreenfootImage("hpbar50.png");
    private GreenfootImage hpbar60 = new GreenfootImage("hpbar60.png");
    private GreenfootImage hpbar70 = new GreenfootImage("hpbar70.png");
    private GreenfootImage hpbar80 = new GreenfootImage("hpbar80.png");
    private GreenfootImage hpbar90 = new GreenfootImage("hpbar90.png");
    private GreenfootImage hpbar100 = new GreenfootImage("hpbar100.png");
    /**
     * Act - do whatever the hpbar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void started()
    {
        if(ninja.health != 100) ninja.health = 100;
    }
    public void act() 
    {
        if(ninja.health == 0)
        {setImage(hpbar0); 
        }
        if(ninja.health == 10)
        setImage(hpbar10);
        if(ninja.health == 20)
        setImage(hpbar20);
        if(ninja.health == 30)
        setImage(hpbar30);
        if(ninja.health == 40)
        setImage(hpbar40);
        if(ninja.health == 50)
        setImage(hpbar50);
        if(ninja.health == 60)
        setImage(hpbar60);
        if(ninja.health == 70)
        setImage(hpbar70);
        if(ninja.health == 80)
        setImage(hpbar80);
        if(ninja.health == 90)
        setImage(hpbar90);
        if(ninja.health == 100)
        setImage(hpbar100);
    }    
}
