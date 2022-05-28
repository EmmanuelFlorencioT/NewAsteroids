import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Message here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Message extends Actor
{
    private int score;
    /**
     * Act - do whatever the Message wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        updateMessage();
    }
    
    public Message(int score){
        this.score = score;
    }
    
    public void updateMessage(){
        String formattedScore = String.format("%05d", this.score);
        setImage(new GreenfootImage("Score: " + formattedScore, 20, Color.CYAN, Color.BLACK));
    }
}
