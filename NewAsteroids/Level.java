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
    protected Score scoreCounter = new Score();
    private boolean infiniteMode;
    private int numOfAsteroids, maxNumOfAsteroids;
    private int numOfInvaders, maxNumOfInvaders;
    private int numOfPowerUp, maxNumOfPowerUp;
    private int ASTEROID_INT; /*Interval for possible spawn of Asteroids*/
    private int INVADER_INT; /*Interval for possible spawn of Invader*/
    private int POWERUP_INT; /*Interval for possible spawn of PowerUp*/
    public GreenfootSound backgroundMusic = new GreenfootSound("MusicLevel.mp3");
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
    
    /*Game Mode Handling*/
    public void setGameMode(boolean mode){
        /*True for an infinite mode or False for a finite mode*/
        this.infiniteMode = mode;
    }
    public boolean getGameMode(){
        return this.infiniteMode;
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
    public void subAsteroid(){
        this.numOfAsteroids--;
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
    public void subInvader(){
        this.numOfInvaders--;
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
    
    /*Score Counter Handling*/
    public Score getScore(){
        return this.scoreCounter;
    }
}
