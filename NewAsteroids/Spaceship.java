import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Spaceship here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spaceship extends SpaceObject
{
    /**
     * Act - do whatever the Spaceship wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        moveSpaceship();
        handleEdgeMovement();
    }
    
    public Spaceship(){
        this.setRotation(-90);
    }
    
    public void moveSpaceship(){
        if(Greenfoot.isKeyDown("up")){
            move(2);
        }
        if(Greenfoot.isKeyDown("right")){
            turn(5);
        }
        if(Greenfoot.isKeyDown("left")){
            turn(-5);
        }
    }
    
    @Override
    public void handleEdgeMovement(){
        World w = getWorld();
        /*Check for inferior edge*/ //Error
        if(getY() > (w.getHeight() - 2)  ){
            setLocation(getX(), 3);
        }
        /*Check for supetior edge*/
        if( getY() < 0 + 1){
            setLocation(getX(), (w.getHeight() - 2));
        }
        /*Check for right edge*/ //Error
        if( getX() > (w.getWidth() - 2)){
            setLocation(3, getY());
        }
        if( getX() < 0 + 1){
            setLocation((w.getWidth() - 2), getY()); 
        }
        /*Chech for the left edge*/
    }
}
