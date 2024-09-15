import greenfoot.*;

// A simple score counter
public class Score extends Actor
{
    public void act()
    {
        GreenfootImage image= getImage();
        image.clear();
        image.drawString("score: " + getWorldOfType(Manager.class).score, 1, 12);
    }
}
