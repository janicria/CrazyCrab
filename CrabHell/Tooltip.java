import greenfoot.*;

// A simple tooltip which displays a message to the user
public class Tooltip extends Actor
{
    public static final float FONT_SIZE = 48.0f;
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;
    private boolean intro = false;
    
    public void act(){
        if (!intro){
            return;
        }
        if (Greenfoot.isKeyDown("enter")){
            getWorldOfType(Manager.class).startGame();
            getWorld().removeObject(this);
        }
    }
    
    public Tooltip(String dialog, int score){
        switch (dialog){
            case "defeat":
                gameOver(score);
            case "intro":
                intro = true;
        }
    }
    
    // Shown upon losing a game
    public void gameOver(int score)
    {
        // Dark magic I stole from asteroids
        GreenfootImage image = new GreenfootImage(WIDTH, HEIGHT);
        image.setColor(new Color(255,255,255, 128));
        image.fillRect(0, 0, WIDTH, HEIGHT);
        image.setColor(new Color(0, 0, 0, 128));
        image.fillRect(5, 5, WIDTH-10, HEIGHT-10);
        Font font = image.getFont();
        font = font.deriveFont(FONT_SIZE);
        image.setFont(font);
        image.setColor(Color.WHITE);
        image.drawString("Game over!", 60, 100);
        image.drawString("Score: " + score, 60, 200);
        setImage(image); 
    }
}
