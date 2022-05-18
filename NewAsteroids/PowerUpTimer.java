import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PowerUpTimer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PowerUpTimer extends Actor
{
    protected SimpleTimer powerUpActive = new SimpleTimer();
    private final int DURATION = 3000;
    private int powerUpInvoked;
    private boolean readyToErase;
    Spaceship player = null;
    
    /**
     * Act - do whatever the PowerUpTimer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        switch(powerUpInvoked){
            case 1:
                SpeedTimer();
                break;
        }
        getWorld().removeObject(this);
    }
    
    public PowerUpTimer(Actor playerPtr, int pwrUpInvoked){
        powerUpActive.mark();
        this.player = (Spaceship)playerPtr;
        this.powerUpInvoked = pwrUpInvoked;
        this.readyToErase = false;
    }
    
    public void SpeedTimer(){
        powerUpActive.mark(); //Set the timer to 0
        player.setSpeed(10); //Increase the speed of the player
        if(powerUpActive.millisElapsed() > DURATION)
            player.setSpeed(3); //Decrease the speed of the player
    }
}
