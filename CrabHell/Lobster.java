import greenfoot.*;

public class Lobster extends Entity
{
    private int speedBoost = 0;

    public void act()
    {
        movement();
        searchForCrabs();
        warp(); // Inherited from a custom method in Animal
    }

    // Allows the lobster to move and turn sometimes 20 degrees 
    // left or right
    public void movement()
    {
        move((5+speedBoost)/2);
        // getRand is for the games pacing and
        // cap is to prevent unfair gameplay
        if (isAtEdge() && Greenfoot.getRandomNumber(3)<1 && speedBoost <11) {
            speedBoost++;
        }
        if (Greenfoot.getRandomNumber(5) < 1)
        {
            turn(Greenfoot.getRandomNumber(41)-20);
        }
    }

    // Makes the lobster eat the crab then end the game if it touches it
    public void searchForCrabs()
    {
        // Prevents lobster from eating a crab with a shield
        if (getWorldOfType(Manager.class).crabState != "shield"){
            if ( attemptToEat(Crab.class))
            {
                Greenfoot.playSound("au.wav");
                Greenfoot.delay(120);
            }
        }
    }
}