import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Weapon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Weapon extends PowerUp
{
    /**
     * Act - do whatever the Weapon wants to do. This method is called whenever
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
        World w = getWorld();
        
        if(player != null){
            //((Spaceship)player).Method();  Do something with player
            //Create the shield
            Shield shield = new Shield((Spaceship)player);
            shield.setRotation(player.getRotation());
            w.addObject(shield, player.getX(),player.getY());
            this.subLife();
        }
    }
}
