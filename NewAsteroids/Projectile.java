import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Projectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Projectile extends SpaceObject
{
    /**
     * Act - do whatever the Projectile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        move(super.getSpeed());
        handleEdgeMovement();
    }
    
    public Projectile(){
    }
    public Projectile(int speed, int rotation){
        super.setSpeed(speed);
        setRotation(rotation);
    }
    
    @Override
    public void handleEdgeMovement(){
        /*Check for edge*/
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
    }
}
