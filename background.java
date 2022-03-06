import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class background here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class background extends Scrollworld
{
    private int groundy;
    private int groundx;
    /**
     * Constructor for objects of class background.
     * 
     */
    public background()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(3200,800,600,400,10,10,1);
        newBackground("background.png");
        addObject(new controls(),400,160);
        
        addObject(new platform(),80,325);
        addObject(new platform(),240,325);
        addObject(new platform(),400,325);
        addObject(new platform(),560,250);
        addObject(new platform(),720,340);
        addObject(new platform(),880,340);
        addObject(new platform(),820,250);
        addObject(new platform(),1040,340);
        addObject(new platform(),1200,320);
        addObject(new platform(),1360,320);
        addObject(new platform(),1520,320);
        addObject(new platform(),1150,160);
        addObject(new platform(),1600,110);
        addObject(new platform(),1680,360);
        addObject(new platform(),1840,360);
        addObject(new platform(),2000,360);
        addObject(new platform(),2160,220);
        addObject(new platform(),2320,360);
        addObject(new platform(),2320,100);
        addObject(new platform(),2480,220);
        addObject(new platform(),2640,220);
        addObject(new platform(),2800,325);
        addObject(new platform(),2960,325);
        addObject(new platform(),3120,325);
        addObject(new platform(),3280,325);
        
        
        createground(80,325,500);
        createground(560,250,600);
        createground(720,340,1100);
        createground(1200,320,1610);
        createground(1680,360,2010);
        createground(2160,220,2170);
        createground(2320,360,2330);
        createground(2480,220,2650);
        createground(2800,325,3300);
        
        addObject(new hpbar(),80,40);
        addObject(new clouds(),200,60);
        addObject(new clouds(),500,100);
        addObject(new clouds(),300,160);
        addObject(new clouds(),650,50);
        addObject(new clouds(),810,120);
        addObject(new clouds(),1100,90);
        addObject(new clouds(),1350,40);
        addObject(new clouds(),1600,40);
        addObject(new clouds(),1800,140);
        addObject(new clouds(),1900,40);
        addObject(new clouds(),2100,50);
        addObject(new clouds(),2600,80);
        addObject(new clouds(),3000,70);
        
        
        ninja ninja = new ninja();
        addObject(ninja,300,300);
        
        addObject(new skeleton(),400,298);
        addObject(new skeleton(),600,223);
        addObject(new skeleton(),1000,313);
        addObject(new skeleton(),760,223);
        addObject(new skeleton(),880,223);
        addObject(new skeleton(),655,313);
        addObject(new skeleton(),750,313);
        addObject(new skeleton(),1140,293);
        addObject(new skeleton(),1190,293);
        addObject(new skeleton(),1240,293);
        addObject(new skeleton(),1290,293);
        addObject(new skeleton(),1340,293);
        addObject(new skeleton(),1390,293);
        addObject(new skeleton(),1440,293);
        addObject(new skeleton(),1490,293);
        addObject(new skeleton(),1540,293);
        addObject(new skeleton(),1590,293);
        addObject(new skeleton(),1800,333);
        addObject(new skeleton(),1900,333);
        addObject(new skeleton(),2260,333);
        addObject(new skeleton(),2290,333);
        addObject(new skeleton(),2320,333);
        addObject(new skeleton(),2350,333);
        addObject(new skeleton(),2380,333);
        addObject(new skeleton(),2480,193);
        addObject(new skeleton(),2640,193);
        
        addObject(new diamond(),1140,135);
        addObject(new diamond(),1620,85);
        addObject(new diamond(),2340,75);
        
        addObject(new destination(),3190,260);
        setInScreenMiddle(ninja);
        setPaintOrder(ninja.class,destination.class);
        setPaintOrder(gameover.class,ninja.class);
        
    }
    public void createground(int x,int y, int end)
    {
        int counter = 0;
        for(groundx = x-1; groundx < end ;groundx += 158)
        {
        for(groundy = y + 20 ; groundy  < 410 ; groundy += 7)
       { 
           addObject(new ground(),groundx,groundy);
        }
        counter++;
    }
    for(groundy = y + 20 ; groundy < 410 ; groundy += 7)
    {
        addObject(new ground(),groundx-158+2*counter,groundy);
    }
    }
}
