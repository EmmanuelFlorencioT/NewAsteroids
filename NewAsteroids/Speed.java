import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Speed here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Speed extends PowerUp
{
    /**
     * Act - do whatever the Speed wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        if(getLife() > 0){
            move(getSpeed());
            checkForCollision();
            handleEdgeMovement();
        } else {
            //Allow another powerup to spawn
            ((Level)getWorld()).subPowerUp();
            getWorld().removeObject(this);
        }
    }
    
    @Override
    public void checkForCollision(){
        Actor player = getOneObjectAtOffset(0, 0, Spaceship.class);
        
        if(player != null){
            //((Spaceship)player).Method();  Do something with player
            ((Spaceship)player).increaseSpeed();
            this.subLife();
        }
    }
}
