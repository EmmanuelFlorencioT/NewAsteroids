import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AsteroidSmall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AsteroidSmall extends Asteroid
{
    /**
     * Act - do whatever the AsteroidSmall wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        if(getLife() > 0){
            move(getSpeed());
            handleEdgeMovement();
        } else {
            getWorld().removeObject(this);
        }
    }
    
    public AsteroidSmall(){
        setRotation(0);
    }
    public AsteroidSmall(int rotation){
        setRotation(rotation);
    }
}
