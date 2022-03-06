import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ninja here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ninja extends ScrollObjects
{
    /**
     * Act - do whatever the ninja wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int speed = 4;
    public static int health = 100;
    private GreenfootImage run1r = new GreenfootImage("run1r.png");
    private GreenfootImage run2r = new GreenfootImage("run2r.png");
    private GreenfootImage run3r = new GreenfootImage("run3r.png");
    private GreenfootImage run4r = new GreenfootImage("run4r.png");
    private GreenfootImage run5r = new GreenfootImage("run5r.png");
    private GreenfootImage run1l = new GreenfootImage("run1l.png");
    private GreenfootImage run2l = new GreenfootImage("run2l.png");
    private GreenfootImage run3l = new GreenfootImage("run3l.png");
    private GreenfootImage run4l = new GreenfootImage("run4l.png");
    private GreenfootImage run5l = new GreenfootImage("run5l.png");
    private GreenfootImage jumpl = new GreenfootImage("jumpl.png");
    private GreenfootImage jumpr = new GreenfootImage("jumpr.png");
    private GreenfootImage melee1r = new GreenfootImage("melee1r.png");
    private GreenfootImage melee2r = new GreenfootImage("melee2r.png");
    private GreenfootImage melee3r = new GreenfootImage("melee3r.png");
    private GreenfootImage melee1l = new GreenfootImage("melee1l.png");
    private GreenfootImage melee2l = new GreenfootImage("melee2l.png");
    private GreenfootImage melee3l = new GreenfootImage("melee3l.png");
    private GreenfootImage meleejumpr = new GreenfootImage("meleejumpr.png");
    private GreenfootImage meleejumpl = new GreenfootImage("meleejumpl.png");
    private GreenfootImage kunaithrowl = new GreenfootImage("kunaithrowl.png");
    private GreenfootImage kunaithrowr = new GreenfootImage("kunaithrowr.png");
    private GreenfootImage teleportr = new GreenfootImage("teleportr.png");
    public static GreenfootImage teleportl = new GreenfootImage("teleportl.png");
    private GreenfootImage death = new GreenfootImage("death.png");
    private int frame = 1;
    private int idleframe = 1;
    private int animationcounterr = 0;
    private int animationcounterl = 0;
    private int idleanimationcounter = 0;
    private int jumpheight = 0;
    private int vspeed = 4;
    private int acceleration = 1; 
    public static boolean ismovingright = true;
    private boolean firstjump = true;
    private boolean idle = true;
    private int kunaiframecounter = 0;
    private int teleportframecounter = 0;
    public static int currentx;
    public static int currenty;
    public static boolean checkright;
    public static boolean checkleft;
   
    public void started()
    {
        health = 100;
        diamond.diamondscollected = 0;
        kunai.x = kunai.z;
        kunai.y = kunai.z;
    }
    
    
    public void act() 
    {
        if(health <= 0 || (diamond.diamondscollected == 3 && isTouching(destination.class)))
        gameover();
        else 
        {
        checkright = checkright();
        checkleft = checkleft();
        currentx = getX();
        currenty = getY();
        if(checkfall())
        fall();
        else jumpheight = 0;
        if(Greenfoot.isKeyDown("v") && !checkfall())
        kick();
        if(Greenfoot.isKeyDown("v") && checkfall())
        jumpkick();
        if(Greenfoot.isKeyDown("c") && kunaiframecounter > 20 && getOneObjectAtOffset(30,0,ground.class) == null)
        {kunaithrow(); kunaiframecounter = 0;}
        if(Greenfoot.isKeyDown("x") && teleportframecounter > 20 && kunai.x > 0) 
        {teleport();
         teleportframecounter = 0;
         getWorld().setInScreenMiddle(this);
        }
        if(Greenfoot.isKeyDown("up") && jumpheight<18)
        {
            if(ismovingright) setImage(jumpr);
            else setImage(jumpl);
            jump(); 
            jumpheight += 1;
        }
       if(Greenfoot.isKeyDown("right") && checkright)
     {
         if(jumpheight == 0)
         moveright();
         else setLocation(getX()+speed,getY());
         animationcounterr++;
         ismovingright = true;
         animationcounterl = 0;
         getWorld().setInScreenMiddle(this);
     }
        if(Greenfoot.isKeyDown("left") && checkleft)
        {
            if(jumpheight == 0)
            moveleft();
            else setLocation(getX()-speed,getY());
            animationcounterl++;
            ismovingright = false;
            animationcounterr= 0;
            getWorld().setInScreenMiddle(this);
        }
        
        if(!Greenfoot.isKeyDown("right") && !Greenfoot.isKeyDown("left") && !Greenfoot.isKeyDown("up") && !Greenfoot.isKeyDown("down") && idle)
        {
            idle(); 
            animationcounterr = 0;
            animationcounterl = 0;
            frame = 1;
        idleanimationcounter++;
    }
     kunaiframecounter++;
     teleportframecounter++;// Add your action code here.
    } 
}
    public boolean checkright()
    {
        Actor ground = getOneObjectAtOffset(12,0,ground.class);
        if(ground == null)
        {
            Actor platform = getOneObjectAtOffset(12,0,platform.class);
            if(platform == null)
       return true;
       else return false;
    }
       else return false;
    }
    public boolean checkleft()
    {
        Actor ground = getOneObjectAtOffset(-12,0,ground.class);
        if(ground == null)
        {
            Actor platform = getOneObjectAtOffset(-12,0,platform.class);
            if(platform == null)
            return true;
            else return false;
        }
       else return false;
    }
    public void attack()
    {
        if(getNeighbours(10 , false , skeleton.class) != null)
        if(ismovingright && getObjectsAtOffset(10,0,skeleton.class)!=null)
        {
        getWorld().removeObject(getOneObjectAtOffset(10,0,skeleton.class)); 
    }
        if(!ismovingright && getObjectsAtOffset(10,0,skeleton.class)!=null)
        {  
        getWorld().removeObject(getOneObjectAtOffset(10,0,skeleton.class)); 
    }
    }
    public  void teleport()
    {
        
        if(ismovingright) {setImage(teleportr); getWorld().addObject(new afterimage(),getX(),getY());}
        else  {setImage(teleportl); getWorld().addObject(new afterimage(),getX(),getY());}
        
        setLocation(kunai.x,kunai.y);
    }
    public void kunaithrow()
    {
        if(ismovingright)
        {setImage(kunaithrowr); 
        getWorld().addObject(new kunai(),getX()+30,getY()-7);
        }
        else {
            setImage(kunaithrowl);
        getWorld().addObject(new kunai(),getX()-30,getY()-7);
        
        
        }
        
    }
    public void jumpkick()
    {
        if(ismovingright)
        setImage(meleejumpr);
        else setImage(meleejumpl);
    }
    public void kick()
    {
        
        if(ismovingright)
        {
            setImage(melee3r);
        }     
        else {
        setImage(melee3l);
        }
        attack();
        
    }
    public void jump()
    {
        setLocation(getX(),getY()-18+jumpheight);
    }
    public boolean checkfall()
    {
       int height = getImage().getHeight();
       int platformheight = 10;
       Actor ground = getOneObjectAtOffset(0,platformheight,platform.class);
       if(ground == null)
       return true;
       else return false;
    }
    public void fall()
    {
        setLocation(getX(),getY()+vspeed);
        if(ismovingright)
        setImage(jumpr);
        else setImage(jumpl);
    }
    public void idle()
    {
        if(idleanimationcounter % 22 == 0)
        {
        if(ismovingright)
        if(idleframe == 1)
        setImage(run1r);
        else {setImage(run2r); idleframe = 0;}
        else if(idleframe == 1)
        setImage(run1l);
        else {setImage(run2l); idleframe = 0;}
        idleframe++;
    }
    }
    public void moveright()
    {
        setLocation(getX()+speed,getY());
        if(animationcounterr % 10 == 0)
        {
        if(frame == 1)
            setImage(run3r);
            else if(frame == 2)
            setImage(run4r);
            else if(frame == 3)
            {
                setImage(run5r);
                frame = 0;
            }
            frame++;
        }
    }
    public void moveleft()
    {
        setLocation(getX()-speed,getY());
        if(animationcounterl % 10 == 0)
        {
            if(frame == 1)
            setImage(run3l);
            else if(frame == 2)
            setImage(run4l);
            else if(frame == 3)
            {
                setImage(run5l);
                frame = 0;
            }
            frame++;
        }
    }
    public void gameover()
    {
        if(health == 0) {
            setImage(death); getWorld().addObject(new gameover(),300,200);
            }
        else if(diamond.diamondscollected == 3){getWorld().addObject(new win(),300,200);}
        
    }
}
