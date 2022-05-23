import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Invader here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Invader extends SpaceObject
{
    /*Invader needs reference to the player*/
    
    private SimpleTimer shotTimer = new SimpleTimer();
    private int SHOT_INT = 7500;
    /**
     * Act - do whatever the Invader wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        if(getLife() > 0){
            moveInvader();
            handleEdgeMovement();
            shoot();
        } else {
            getWorld().removeObject(this);
        }
    }
    
    public Invader(){
    }
    public Invader(int speed){
        setSpeed(speed);
    }
    
    public void moveInvader(){
        move(getSpeed());
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
        if(shotTimer.millisElapsed() > SHOT_INT){
            if(getWorld().getObjects(Spaceship.class).isEmpty()){
                shotTimer.mark();
                return; /*If the list of objects is empty*/
            }

        
            /*Get the 1st and only item in the list*/
            Actor player = getWorld().getObjects(Spaceship.class).get(0);
            HostileProjectile h = new HostileProjectile(5); /*The speed of the projectile*/
            getWorld().addObject(h, this.getX(), this.getY());
            h.turnTowards(player.getX(), player.getY());
            shotTimer.mark();
        }
    }
}
