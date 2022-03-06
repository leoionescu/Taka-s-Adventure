import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class skeleton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class skeleton extends ScrollObjects
{
    private int speed = 2;
    private int vspeed = 4;
    private int frame = 0;
    private int x;
    private int y;
    private boolean ismovingright = true;
    private int animationcounterr = 0;
    private int animationcounterl = 0;
    private int attackcounter = 0;
    private SimpleTimer timer = new SimpleTimer();
    GifImage walkr = new GifImage("SkeletonWalkr.gif");
    GifImage walkl = new GifImage("SkeletonWalkl.gif");
    GifImage idler = new GifImage("SkeletonIdler.gif");
    GifImage idlel = new GifImage("SkeletonIdlel.gif");
    GifImage attackr = new GifImage("SkeletonAttackr.gif");
    GifImage attackl = new GifImage("SkeletonAttackl.gif");
    /**
     * Act - do whatever the skeleton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void started()
    {
        timer.mark();
    }
    public void act() 
    {
        if(getX()-ninja.currentx < 100 && getX() - ninja.currentx > -100)
        if((getY() - ninja.currenty > -5 && getY() - ninja.currenty < 5) && (ninja.currentx-getX() > 25 || getX() - ninja.currentx > 25))
        {
            if(getX() - ninja.currentx > 0)
            {
                ismovingright = false;
                moveleft();
                animationcounterl++;
                animationcounterr = 0;
            }
            else 
            {
                ismovingright = true;
                moveright();
                animationcounterr++;
                animationcounterl = 0;
            }
        }
        else if((ninja.currentx-getX() <= 25 || getX() - ninja.currentx <= 25) && (getY() - ninja.currenty > -5 && getY() - ninja.currenty < 5)) 
        attack();
        else idle();
        else idle(); 
}
   public void attack()
    {
        if(attackcounter == 0) {timer.mark(); attackcounter++;}
        if(ismovingright) setImage(attackr.getCurrentImage());
        else setImage(attackl.getCurrentImage());
        if(timer.millisElapsed() > 790 && timer.millisElapsed() < 810)
        {ninja.health = ninja.health - 10;}
        if(timer.millisElapsed() > 1790 && timer.millisElapsed() < 1810) attackcounter = 0;
    }
    public void idle()
    {
        attackcounter = 0;
        if(ismovingright) 
        setImage(idler.getCurrentImage());
        else setImage(idlel.getCurrentImage());
    }
    public void moveright()
    {
        setLocation(getX()+speed,getY());
        setImage(walkr.getCurrentImage());
        attackcounter = 0;
    }
    public void moveleft()
    {
        setLocation(getX()-speed,getY());
        setImage(walkl.getCurrentImage());
        attackcounter = 0;
    }
}
