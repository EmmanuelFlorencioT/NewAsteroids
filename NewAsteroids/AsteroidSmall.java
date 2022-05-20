import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AsteroidSmall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AsteroidSmall extends Asteroid
{
    /*The asteroid when created should not be a threat to the player*/
    private SimpleTimer killCool = new SimpleTimer();
    private boolean readyKill;
    private int KILL_INT = 315;
    /*-------------------------------------------------------------*/
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
            isReadyToKill();
        } else {
            getWorld().removeObject(this);
        }
    }
    
    public AsteroidSmall(){
        setRotation(0);
    }
    public AsteroidSmall(int speed, int rotation){
        setSpeed(speed);
        setRotation(rotation);
        readyKill = false;
        killCool.mark();//Start the timer.
    }
    
    public boolean isReadyToKill(){
        if(killCool.millisElapsed() > KILL_INT)
            readyKill = true;
        return readyKill;
    }
    
    public void asteroidsSpriteSmall(int band){
        if(band == 1){
            setImage("SmallAsteroid_Model1.png");
        }else if(band == 2){
            setImage("SmallAsteroid_Model2.png");
        }else if(band == 3){
            setImage("SmallAsteroid_Model3.png");
        }
    }
}
