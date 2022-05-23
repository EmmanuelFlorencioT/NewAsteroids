import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shield here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shield extends SpaceObject
{
    Spaceship s;
    private int astOrInv;
    /**
     * Act - do whatever the Shield wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        if(getLife() > 0){
            moveShield(s);
            checkForCollision();
            handleEdgeMovement();
        } else {
            //Allow another Asteroid or Invader to spawn and remove Shield
            if(astOrInv == 1)
                ((Level)getWorld()).subAsteroid();
            else
                if(astOrInv == 2)
                    ((Level)getWorld()).subInvader();
            getWorld().removeObject(this);
        }
    }
    public Shield(Spaceship s){
        this.s = s;
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
    public void checkForCollision(){
        /*We are looking for an intersection with an asteroid killer(astKiller)*/
        Actor astKiller = getOneIntersectingObject(Asteroid.class);
        /*We are looking for a collision(intersection) with an Invader*/
        Actor invKiller = getOneIntersectingObject(Invader.class);
        /*We are looking for a collision(intersection) with an HostileProjectile*/
        Actor proKiller = getOneIntersectingObject(HostileProjectile.class);
        
        if(astKiller != null){
            ((Asteroid)astKiller).subLife();
            this.subLife();
            astOrInv = 1;
        }
        if(invKiller != null){
            ((Invader)invKiller).subLife();
            this.subLife();
            astOrInv = 2;
        }
        if(proKiller != null){
            ((HostileProjectile)proKiller).subLife();
            this.subLife();
        }
    }
    //Allows the shield to move along with the spaceship
    private void moveShield(Spaceship s){
        setLocation(s.getX(), s.getY());
    }
}
