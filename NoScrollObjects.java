import greenfoot.*;

public abstract class NoScrollObjects  extends Actor
{
    /** returns the World */
    public Scrollworld getWorld()
    {
        return (Scrollworld)super.getWorld();
    }
}
