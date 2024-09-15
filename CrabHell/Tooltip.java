import greenfoot.*;

// A simple tooltip which displays a message to the user
public class Tooltip extends Actor
{
    private boolean intro = false;

    public Tooltip(String dialog, int score){
        switch (dialog){
            case "defeat":
                gameOver(score);
            case "intro":
                intro = true;
        }
    }

    public void act(){
        // So it's the game isn't started during the defeat screen
        if (!intro){
            return;
        }
        if (Greenfoot.isKeyDown("enter")){
            getWorldOfType(Manager.class).startGame();
            getWorld().removeObject(this);
        }
    }

    // Shown upon losing a game
    public void gameOver(int score)
    {
        // Dark magic I stole from asteroids
        GreenfootImage image = new GreenfootImage(400, 300);
        image.setColor(new Color(255,255,255, 128));
        image.fillRect(0, 0, 400, 300);
        image.setColor(new Color(0, 0, 0, 128));
        image.fillRect(5, 5, 400-10, 300-10);
        Font font = image.getFont();
        font = font.deriveFont(49.0f);
        image.setFont(font);
        image.setColor(Color.WHITE);
        image.drawString("Game over!", 60, 100);
        image.drawString("Score: " + score, 60, 200);
        setImage(image); 
    }
}
