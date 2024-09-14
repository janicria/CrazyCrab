import greenfoot.*;

public class Crab extends Entity
{
    public int animFrame = 0;

    public void act()
    {
        checkForInput();
        checkWorms();
        warp(); // Inherited from a custom method in Animal
        getWorldOfType(Manager.class).nextFrame();
    }

    // Checks for user input (wasd/arrow keys) 
    private void checkForInput()
    {
        if ( Greenfoot.isKeyDown("left") || ( Greenfoot.isKeyDown("a")))
        {
            updateAnimations(180);
            move(5);
        }
        else if ( Greenfoot.isKeyDown("right") || ( Greenfoot.isKeyDown("d")))
        {
            updateAnimations(0);
            move(5);
        }
        else if ( Greenfoot.isKeyDown("up") || ( Greenfoot.isKeyDown("w")))
        {
            updateAnimations(-90);
            move(5);
        }
        else if ( Greenfoot.isKeyDown("down") || ( Greenfoot.isKeyDown("s")))
        {
            updateAnimations(90);
            move(5);
        }
    }

    // Allows the crab to eat worms if it is touching any
    // and ends the game if it has eaten all 6 
    private void checkWorms()
    {
        if ( attemptToEat(Worm.class) )
        {
            getWorldOfType(Manager.class).score++;
            Greenfoot.playSound("slurp.wav");
            getWorld().addObject( new Worm(), Greenfoot.getRandomNumber(500)+20, Greenfoot.getRandomNumber(500)+20);
        }
    }

    // Updates the crab's animations 
    public void updateAnimations(int rotation)
    { 
        // So that Manager can remove the shield
        // if the crab isn't calling this method
        if (rotation != -1){
            setRotation(rotation);
        }
        // Prevents the animation from spamming every frame
        if ((getWorldOfType(Manager.class).frame) % 3 == 0)
        {
            animFrame++;
            if (animFrame % 2 == 0)
            {
                setImage("crab_"+ getWorldOfType(Manager.class).crabState +"1.png");
            }
            else
            {
                setImage("crab_"+ getWorldOfType(Manager.class).crabState +"2.png");
            }
        }
    }
}

