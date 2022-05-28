import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Actor
{
    private int score;
    /**
     * Act - do whatever the Score wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        updateScore();
    }
    
    public Score(){
        this.score = 0;
    }
    
    public void updateScore(){
        String formattedScore = String.format("%05d", this.score);
        setImage(new GreenfootImage("Score: " + formattedScore, 20, Color.CYAN, Color.BLACK));
    }
    
    public void increaseScore(int score){
        this.score += score;
    }
    
    public int getCurrScore(){
        return this.score;
    }
}
