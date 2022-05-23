import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Burst here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Burst extends PowerUp
{
    protected SimpleTimer shotCool = new SimpleTimer(); //Timer to launch the next projectile
    protected SimpleTimer shotCool1 = new SimpleTimer(); //Timer for the time the projectiles are launched
    private int SHOT_INT = 5; // Time it takes to launch the next project
    private int direction = 0;
    
    /**
     * Act - do whatever the Burst wants to do. This method is called whenever
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
        
        //Start the timers
        shotCool.mark();
        shotCool1.mark();
        
        if(player != null){
            while(shotCool1.millisElapsed() < 200){
                if(shotCool.millisElapsed() > SHOT_INT){
                    this.direction = direction + 2;
                    Projectile p = new Projectile(5,this.direction);
                    GreenfootSound shootSound = new GreenfootSound("shootSpaceShip.mp3");
                    shootSound.play();
                    getWorld().addObject(p, player.getX(), player.getY());
                    //Reset the timer
                    shotCool.mark();
                }
            }
            this.subLife();
        }
    }
}
