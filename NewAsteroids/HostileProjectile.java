import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HostileProjectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HostileProjectile extends SpaceObject
{
    /**
     * Act - do whatever the HostileProjectile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        if(getLife() > 0){
            move(getSpeed());
            checkCollision();
            handleEdgeMovement();
        } else {
            getWorld().removeObject(this);
        }
    }
    
    public HostileProjectile(){
    }
    public HostileProjectile(int speed){
        setSpeed(speed);
    }
    
    @Override
    public void handleEdgeMovement(){
        /*Check for edge*/
        if(isAtEdge()){
            this.subLife();
        }
    }
    
    public void checkCollision(){
        Actor player = getOneObjectAtOffset(0, 0, Spaceship.class);
        
        if(player != null){
            ((Spaceship)player).subLife();
            this.subLife();
        }
    }
}
