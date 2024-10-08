import greenfoot.*;  

// Manages events, frames and score
public class Manager extends World
{
    public int frame = 1;
    public int score = 0;
    public String crabState = "shield";
    private Crab crab = new Crab();

    public Manager() 
    {
        super(560, 560, 1);
        addObject(new Tooltip("intro", -1), getWidth()/2, getHeight()/2);
    }
    
    // Called by Tooltip after enter is pressed
    public void startGame(){
        addObject(crab, 150, 420);
        addObject(new Score(), 60, 60);
        for (int i = 0; i < 3; i++){
            addObject( new Worm(), Greenfoot.getRandomNumber(500)+20, Greenfoot.getRandomNumber(500)+20);
            if (i < 2) {
                addObject( new Lobster(), Greenfoot.getRandomNumber(500)+20, Greenfoot.getRandomNumber(500)+20);
            }
        }
    }

    public void nextFrame() {   
        // Timer to spawn a new lobster (8.3s)
        if (frame % 500 == 0) {
            addObject( new Lobster(), 0, 0);
            // There's no need for it to increase infinitely
            frame = 501;
        }
        // Timer from crabs safety buffer (5s)
        if (frame == 300){
            crabState = "regular";
            crab.updateAnimations(-1);
        }

        frame++;
    }

    public void endGame(){
        Greenfoot.playSound("youdiedlmao.mp3");
        addObject(new Tooltip("defeat", score), getWidth()/2, getHeight()/2);
    }
}