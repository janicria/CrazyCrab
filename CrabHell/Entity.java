import greenfoot.*;

/**
 * Contains some methods to be shared between 
 * classes Crab and Lobster
 * (also is now called 'Entity' instead of 'Animal'
 * because worms are animals and it doesn't make sense
 * for them to not be a class named 'Animal')
 */
public class Entity extends Actor
{
    // Warps the entity to the other side of
    // the screen once reaching the end
    public void warp () {
        // Because we don't want entities constantly warping
        if (!isAtEdge()) {
            return;
        }
        int x = getX();
        int y = getY();
        if (x >= getWorld().getWidth() -1) {
            x = 0;
        }
        else if (x <= 0) {
            x = getWorld().getWidth() - 1;
        }
        if (y >= getWorld().getHeight() -1) {
            y = 0;
        }
        else if (y <= 0) {
            y = getWorld().getHeight() - 1;
        }
        setLocation(x, y);
    }

    // Returns true if at the edge of the world
    public boolean atWorldEdge()
    {
        if(getX() < 20 || getX() > getWorld().getWidth() - 20)
            return true;
        if(getY() < 20 || getY() > getWorld().getHeight() - 20)
            return true;
        else
            return false;
    }

    // Removes the object with the specified class from the
    // world and returns true if it has an offset of (0, 0) 
    // relative to the caller
    public boolean attemptToEat(Class clss)
    {
        Actor actor = getOneObjectAtOffset(0, 0, clss);
        if(actor != null) {
            getWorld().removeObject(actor);
            return true;
        }
        return false;
    }
}