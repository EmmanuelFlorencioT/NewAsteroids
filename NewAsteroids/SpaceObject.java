import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SpaceObject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class SpaceObject extends Actor
{
    private int life;
    private int speed;
    /**
     * Act - do whatever the SpaceObject wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    
    public SpaceObject(){
        this.life = 1;
        this.speed = 3;
    }
    
    public abstract void earnLife();
    public abstract void loseLife();
    
    public void addLife(){
        life++;
    }
    public void subLife(){
        life--;
    }
    public int getLife(){
        return this.life;
    }
    
    public int getSpeed(){
        return this.speed;
    }
    public void setSpeed(int speed){
        this.speed = speed;
    }
    
    public abstract void handleEdgeMovement();
}
