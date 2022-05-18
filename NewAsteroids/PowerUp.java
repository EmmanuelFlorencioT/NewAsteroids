import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PowerUp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class PowerUp extends SpaceObject
{    
    /**
     * Act - do whatever the PowerUp wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
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
        /*Check for right edge*/
        if( getX() > (w.getWidth() - 2)){
            setLocation(3, getY());
        }
        /*Chech for the left edge*/
        if( getX() < 0 + 1){
            setLocation((w.getWidth() - 2), getY()); 
        }
    }
    
    public abstract void checkForCollision();
}
