import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Level extends World
{
    protected SimpleTimer astCall = new SimpleTimer();
    protected SimpleTimer invCall = new SimpleTimer();
    protected SimpleTimer powCall = new SimpleTimer();
    private int numOfAsteroids, maxNumOfAsteroids;
    private int numOfInvaders, maxNumOfInvaders;
    private int numOfPowerUp, maxNumOfPowerUp;
    private int ASTEROID_INT; /*Interval for possible spawn of Asteroids*/
    private int INVADER_INT; /*Interval for possible spawn of Invader*/
    private int POWERUP_INT; /*Interval for possible spawn of PowerUp*/
    
    /**
     * Constructor for objects of class Level.
     * 
     */
    public Level()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        numOfAsteroids = numOfInvaders = numOfPowerUp = 0;
    }
    
    /*Asteroid Handling*/
    public void setMaxNumOfAsteroids(int maxAst){
        this.maxNumOfAsteroids = maxAst;
    }
    public int getMaxNumOfAsteroids(){
        return this.maxNumOfAsteroids;
    }
    public void addAsteroid(){
        this.numOfAsteroids++;
    }
    public int getNumOfAsteroids(){
        return this.numOfAsteroids;
    }
    public void setAsteroidInterval(int interval){
        this.ASTEROID_INT = interval;
    }
    public int getAsteroidInterval(){
        return this.ASTEROID_INT;
    }
    
    /*Invader Handling*/
    public void setMaxNumOfInvaders(int maxInv){
        this.maxNumOfInvaders = maxInv;
    }
    public int getMaxNumOfInvaders(){
        return this.maxNumOfInvaders;
    }
    public void addInvader(){
        this.numOfInvaders++;
    }
    public int getNumOfInvaders(){
        return this.numOfInvaders;
    }
    public void setInvaderInterval(int interval){
        this.INVADER_INT = interval;
    }
    public int getInvaderInterval(){
        return this.INVADER_INT;
    }
    
    /*PowerUp Handling*/
    public void setMaxNumOfPowerUp(int maxPow){
        this.maxNumOfPowerUp = maxPow;
    }
    public int getMaxNumOfPowerUp(){
        return this.maxNumOfPowerUp;
    }
    public void addPowerUp(){
        this.numOfPowerUp++;
    }
    public void subPowerUp(){
        this.numOfPowerUp--;
    }
    public int getNumOfPowerUp(){
        return this.numOfPowerUp;
    }
    public void setPowerUpInterval(int interval){
        this.POWERUP_INT = interval;
    }
    public int getPowerUpInterval(){
        return this.POWERUP_INT;
    }
}
