import greenfoot.*;
import java.util.List;
import java.awt.Color;

public abstract class Scrollworld  extends World
{
    private int Width;
    private int Height;
    private int ScreenLeft=0;
    private int ScreenUp=0;
    private GreenfootImage Background;
    private boolean BackgroundMove=true;
    private int CellSize;

    /**
     * Primii 2 parametri: Latimea si Inaltimea intregii lumi(World)
     * Parametrii 3 si 4: Latimea si Inaltimea ecranului ce este aratat jucatorului
     * Parametrul 5: Marimea celulei(Cellsize)
     * Pozitia coltului stang de sus este 0,0
     * Fundalul se misca
     */
    public Scrollworld(int Width, int Height,int ScreenWidth,int ScreenHeight,int CellSize)
    {
        this(Width,Height,ScreenWidth,ScreenHeight,0,0,CellSize,true);
    }

    /**
     * Primii 2 parametri: Latimea si Inaltimea intregii lumi(World)
     * Parametrii 3 si 4: Latimea si Inaltimea ecranului ce este aratat jucatorului
     * Parametrii 5 si 6 : Pozitia coltului stang de sus
     * Parametrul 7: Marimea celulei(CellSize)
     * Fundalul se misca
     */
    public Scrollworld(int Width, int Height,int ScreenWidth,int ScreenHeight,int CellSize,boolean BackgroundMove)
    {
        this(Width,Height,ScreenWidth,ScreenHeight,0,0,CellSize,BackgroundMove);
    }

    /**
     * Primii 2 parametri: Latimea si Inaltimea intregii lumi(World)
     * Parametrii 3 si 4: Latimea si Inaltimea ecranului ce este aratat jucatorului
     * Parametrii 5 si 6 : Pozitia coltului stang de sus
     * Parametrul 7: Marimea celulei(CellSize)
     * Fundalul se misca
     */
    public Scrollworld(int Width, int Height,int ScreenWidth,int ScreenHeight,int ScreenLeft,int ScreenUp,int CellSize)
    {
        this(Width,Height,ScreenWidth,ScreenHeight,ScreenLeft,ScreenUp,CellSize,true);
    }

    /**
     * Primii 2 parametri: Latimea si Inaltimea intregii lumi (World)
     * Parametrii 3 si 4: Latimea si Inaltimea ecranului ce este aratat jucatorului
     * 5 Parametrii 5 si 6 : Pozitia coltului stang de sus
     * Parametrul 7: Marimea celulei(CellSize)
     * Parametrul 8 : Fundalul se misca
     */
    public Scrollworld(int Width, int Height,int ScreenWidth, int ScreenHeight,int ScreenLeft,int ScreenUp, int CellSize, boolean BackgroundMove)
    {
        super(ScreenWidth, ScreenHeight, CellSize, false);
        if(ScreenWidth>Width)
            ScreenWidth=Width;
        if(ScreenHeight>Height)
            ScreenWidth=Height;
        this.Width=Width;
        this.Height=Height;
        this.BackgroundMove=BackgroundMove;
        this.CellSize=CellSize;
        if(BackgroundMove)
        {
            Background=new GreenfootImage(Width,Height);
            //Background.setColor(Color.WHITE);
            Background.fillRect(0,0,Width,Height);
        }
        ShowWorld(ScreenLeft, ScreenUp);
    }

    /** Se poate vedea lumea cu ajutorul sagetilor*/
    public void act()
    {
        if(Greenfoot.isKeyDown("left") && ninja.checkleft)
            ShowWorld(getScreenLeft()-4,getScreenUp());
        if(Greenfoot.isKeyDown("right") && ninja.checkright)
            ShowWorld(getScreenLeft()+4,getScreenUp());
        /*if(Greenfoot.isKeyDown("up"))
            ShowWorld(getScreenLeft(),getScreenUp()-2);
        if(Greenfoot.isKeyDown("down"))
            ShowWorld(getScreenLeft(),getScreenUp()+2);*/
    }

    /** returneaza o parte mai mica din imaginea data , cu latimea "Width" si inaltimea "Height" din pozitia fromX, fromY, pe imagine */
    public GreenfootImage ShowPartOfImage(GreenfootImage Image, int fromX, int fromY, int Width, int Height)
    {
        GreenfootImage I = new GreenfootImage(Width, Height);
        I.drawImage(Image,-fromX,-fromY);
        return I;
    }

    /** Arata o parte din lume. Este pozitia din coltul stang de sus */
    public void ShowWorld(int ShowLeft, int ShowRight)
    {
        int x = ShowLeft;
        int y = ShowRight;
        if(x<0)
            x=0;
        if(y<0)
            y=0;
        if(x>Width-super.getWidth())
            x=Width-super.getWidth();
        if(y>Height-super.getHeight())
            y=Height-super.getHeight();
        ScreenLeft=x;
        ScreenUp=y;
        List<ScrollObjects> S = getObjects(ScrollObjects.class);
        for(ScrollObjects s : S)
        {
            s.setLocation(s.getX(),s.getY());
        }
        if(BackgroundMove)
        {
            RightBackgroundPosition();
        }
    }

    /**latimea si inaltimea lumii*/
    public void scale(int Width, int Height)
    {
        this.Width=Width;
        this.Height=Height;
        newBackground(returnBackground());
    }

    /**pune obiectul in mijlocul lumii*/
    public void setInScreenMiddle(Actor A)
    {
        ShowWorld(A.getX()-getScreenWidth()/2,A.getY()-getScreenHeight());
    }

    /** Creeaza un nou "Scroll-Background" */
    public void newBackground(String Background)
    {
        newBackground(new GreenfootImage(Background));
    }

    /** Creeaza un nou "Scroll-Background" */
    public void newBackground(GreenfootImage background)
    {
        GreenfootImage i=new GreenfootImage(getWidth(),getHeight());
        int x=getWidth()/background.getWidth();
        while(x>=0)
        {
            int y=getHeight()/background.getHeight();
            while(y>=0)
            {
                i.drawImage(background,x*background.getWidth(),y*background.getHeight());
                y--;
            }
            x--;
        }
        Background=i;
        RightBackgroundPosition();
    }

    /** Returneaza "Scroll-Background" */
    public GreenfootImage returnBackground()
    {
        return Background;
    }

    /** Acum fundalul nu va mai fi mutat */
    public void DontScrollBackground()
    {
        BackgroundMove=false;
    }

    /** Acum fundalul va putea fi mutat */
    public void ScrollBackground()
    {
        BackgroundMove=true;
        RightBackgroundPosition();
    }

    /** Adauga un obiect in lume , care poate fi mutat */
    public void addObject(ScrollObjects S, int x, int y)
    {
        super.addObject(S,0,0);
        S.setLocation(x,y);
    }

    /** Adauga un obiect in lume , care nu poate fi mutat */
    public void addObject(NoScrollObjects A, int x, int y)
    {
        super.addObject(A,x,y);
    }

    /** Returneaza  pozitia in partea stanga a ecranului */
    public int getScreenLeft()
    {
        return ScreenLeft;
    }

    /** Returneaza  pozitia in partea dreapta a ecranului */
    public int getScreenRight()
    {
        return ScreenLeft+super.getWidth()-1;
    }

    /** Returneaza  pozitia in partea de sus a ecranului */
    public int getScreenUp()
    {
        return ScreenUp;
    }

    /** Returneaza  pozitia in partea de jos a ecranului */
    public int getScreenDown()
    {
        return ScreenUp+super.getHeight()-1;
    }

    /** Returneaza latimea ecranului  */
    public int getScreenWidth()
    {
        return super.getWidth();
    }

    /** Returneaza inaltimea ecranului */
    public int getScreenHeight()
    {
        return super.getHeight();
    }

    /** Returneaza latimea lumii care este aratata jucatorului */
    public int getWidth()
    {
        return Width;
    }

    /** Returneaza inaltimea lumii care este aratata jucatorului */
    public int getHeight()
    {
        return Height;
    }

    private int CellSize()
    {
        return CellSize;
    }

    private void RightBackgroundPosition()
    {
        setBackground(ShowPartOfImage(Background,getScreenLeft()*CellSize(),getScreenUp()*CellSize(),getScreenWidth(),getScreenHeight()));
    }
}
