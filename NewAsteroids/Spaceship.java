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
        if(getLife() > 0){
            moveSpaceship();
            handleEdgeMovement();
            shoot();
            checkForCollision();
        } else {
            getWorld().removeObject(this);
            Greenfoot.stop(); /*We will stop the execution of the game (for now)*/
        }
    }
    
    public Spaceship(){
        this.setRotation(-90);
        shotReady = true;
    }
    
    public void moveSpaceship(){
        if(Greenfoot.isKeyDown("up")){
            move(getSpeed());
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
            GreenfootSound shootSound = new GreenfootSound("shootSpaceShip.mp3");
            shootSound.play();
            getWorld().addObject(p, getX(), getY());
            shotReady = false;
            //Reset the timer
            shotCool.mark();
        }
        /*Check when the space key is depressed*/
        if(!Greenfoot.isKeyDown("space"))
            shotReady = true;
    }
    
    public void checkForCollision(){
        /*We are looking for an intersection with an asteroid killer(astKiller)*/
        Actor astKiller = getOneObjectAtOffset(0, 0, Asteroid.class);
        /*We are looking for a collision(intersection) with an asteroid invader*/
        Actor invKiller = getOneObjectAtOffset(0, 0, Invader.class);
        
        if(astKiller != null){
            /*We check if the AsteroidSmall is not ready to kill, then we return*/
            if(astKiller instanceof AsteroidSmall && !((AsteroidSmall)astKiller).isReadyToKill()){
                    return;
            } else {
                ((Asteroid)astKiller).subLife();
                this.subLife();
            }
        }
        if(invKiller != null){
            ((Invader)invKiller).subLife();
            this.subLife();
        }
    }
}
