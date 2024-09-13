import greenfoot.*;  

// Manages events, frames and score
public class Manager extends World
{
    public int frame = 0;
    public int score = 0;
    public String crabState = "shield";
    
    public Manager() 
    {
        super(560, 560, 1);
        addObject(new Crab(), 150, 420);
        for (int i = 0; i < 3; i++){
            addObject( new Worm(), Greenfoot.getRandomNumber(500)+20, Greenfoot.getRandomNumber(500)+20);
            if (i < 2) {
                addObject( new Lobster(), Greenfoot.getRandomNumber(500)+20, Greenfoot.getRandomNumber(500)+20);
            }
        }
    }

    public void nextFrame() {   
        // Timer to spawn a new lobster
        if (frame % 500 == 0) {
            addObject( new Lobster(), 0, 0);
        }
        // Timer from crabs safety buffer
        if (frame > 300){
            crabState = "regular";
        }
        frame++;
    }
}