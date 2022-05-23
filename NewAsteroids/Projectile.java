import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Projectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Projectile extends SpaceObject
{
    /**
     * Act - do whatever the Projectile wants to do. This method is called whenever
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
    
    public Projectile(){
    }
    public Projectile(int speed, int rotation){
        super.setSpeed(speed);
        setRotation(rotation);
    }
    
    @Override
    public void handleEdgeMovement(){
        /*Check for edge*/
        if(isAtEdge()){
            this.subLife();
        }
    }
    
    public void checkCollision(){
        Actor asteroid = getOneObjectAtOffset(0, 0, Asteroid.class);
        Actor invader = getOneObjectAtOffset(0, 0, Invader.class);
        
        if(asteroid != null){
            ((Asteroid)asteroid).subLife();
            if(asteroid instanceof AsteroidMed){
                /*Two new asteroids are spawned with slightly less speed than the normal*/
                int bandSprite;
                bandSprite = Greenfoot.getRandomNumber(3) + 1;
                AsteroidSmall ast1 = new AsteroidSmall(2, Greenfoot.getRandomNumber(360));
                ast1.asteroidsSpriteSmall(bandSprite);
                bandSprite = Greenfoot.getRandomNumber(3) + 1;
                AsteroidSmall ast2 = new AsteroidSmall(2, Greenfoot.getRandomNumber(360));
                ast1.asteroidsSpriteSmall(bandSprite);
                getWorld().addObject(ast1, this.getX() + Greenfoot.getRandomNumber(5), 
                                           this.getY() + Greenfoot.getRandomNumber(5));
                getWorld().addObject(ast2, this.getX() + Greenfoot.getRandomNumber(5), 
                                           this.getY() + Greenfoot.getRandomNumber(5));
            }
            this.subLife();
        }
        
        if(invader != null){
            ((Invader)invader).subLife();
            this.subLife();
        }
    }
}
