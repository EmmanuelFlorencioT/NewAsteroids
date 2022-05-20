import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AsteroidMed here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AsteroidMed extends Asteroid
{
    /**
     * Act - do whatever the AsteroidMed wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        if(getLife() > 0){
            move(getSpeed());
            handleEdgeMovement();
        } else {
            getWorld().removeObject(this);
        }
    }
    
    public AsteroidMed(){
        setRotation(0);
    }
    public AsteroidMed(int rotation){
        setRotation(rotation);
    }
    public void asteroidsSpritesMed(int band){
        if(band == 1){
            setImage("BigAsteroid_Model1.png");
        }else if(band == 2){
            setImage("BigAsteroid_Model2.png");
        }else if(band == 3){
            setImage("BigAsteroid_Model3.png");
        }
    }
}
