import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Spaceship here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spaceship extends SpaceObject
{
    private SimpleTimer shotCool = new SimpleTimer();
    private int SHOT_INT = 300; //Shot interval
    private boolean shotReady;
    /**
     * Act - do whatever the Spaceship wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        moveSpaceship();
        handleEdgeMovement();
        shoot();
    }
    
    public Spaceship(){
        this.setRotation(-90);
        shotReady = true;
    }
    
    public void moveSpaceship(){
        if(Greenfoot.isKeyDown("up")){
            move(super.getSpeed());
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
        /*Check for right edge*/
        if( getX() > (w.getWidth() - 2)){
            setLocation(3, getY());
        }
        /*Chech for the left edge*/
        if( getX() < 0 + 1){
            setLocation((w.getWidth() - 2), getY()); 
        }
    }
    
    public void shoot(){
        if(Greenfoot.isKeyDown("space") && shotReady == true && shotCool.millisElapsed() > SHOT_INT){
            Projectile p = new Projectile(5, this.getRotation());
            getWorld().addObject(p, getX(), getY());
            shotReady = false;
            //Reset the timer
            shotCool.mark();
        }
        /*Check when the space key is depressed*/
        if(!Greenfoot.isKeyDown("space"))
            shotReady = true;
    }
}
