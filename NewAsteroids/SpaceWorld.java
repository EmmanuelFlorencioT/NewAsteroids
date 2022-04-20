import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SpaceWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpaceWorld extends World
{
    private SimpleTimer astCall = new SimpleTimer();
    private SimpleTimer invCall = new SimpleTimer();
    private int numOfAsteroids, maxNumOfAsteroids;
    private int numOfInvaders, maxNumOfInvaders;
    private int ASTEROID_INT = 20; /*Interval for possible spawn of Asteroids*/
    private int INVADER_INT = 500; /*Interval for possible spawn of Invader*/
    /**
     * Constructor for objects of class SpaceWorld.
     * 
     */
    public SpaceWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        numOfAsteroids = 0;
        maxNumOfAsteroids = 1;
        numOfInvaders = 0;
        maxNumOfInvaders = 3;
        astCall.mark(); //Start the timer
        invCall.mark();
        prepare();
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Spaceship player = new Spaceship();
        addObject(player, 300, 300);
    }
    
    public void act(){
        spawnAsteroids();
        spawnInvaders();
    }
    
    private void spawnAsteroids(){
        if(astCall.millisElapsed() > ASTEROID_INT){
            if(numOfAsteroids < maxNumOfAsteroids && Greenfoot.getRandomNumber(1000) < 20){
                numOfAsteroids++;
                int location = Greenfoot.getRandomNumber(4);
                int direction = Greenfoot.getRandomNumber(178);
                int offsetX = Greenfoot.getRandomNumber(getWidth()-20) + 10;
                int offsetY = Greenfoot.getRandomNumber(getHeight() - 20) + 10;
                AsteroidMed a = new AsteroidMed();
                switch(location){
                    case 0: //Superior edge
                        a.setRotation(direction + 1);
                        addObject(a, offsetX, 25);
                        break;
                    case 1: //Inferior edge
                        a.setRotation(direction + 181);
                        addObject(a, offsetX, getHeight() - 25);
                        break;
                    case 2: //Right edge
                        a.setRotation(direction + 91);
                        addObject(a, getWidth() - 25, offsetY);
                        break;
                    case 3: //Left edge
                        a.setRotation(direction + 270);
                        addObject(a, 25, offsetY);
                        break;
                }
            }
            astCall.mark(); //Reset Timer
        }
    }

    public void spawnInvaders(){
        if(invCall.millisElapsed() > INVADER_INT){
            if(numOfInvaders < maxNumOfInvaders && Greenfoot.getRandomNumber(1000) < 50){
                numOfInvaders++;
                int location = Greenfoot.getRandomNumber(4);
                int direction = Greenfoot.getRandomNumber(178);
                int offsetX = Greenfoot.getRandomNumber(getWidth()-20) + 10;
                int offsetY = Greenfoot.getRandomNumber(getHeight() - 20) + 10;
                Invader inv = new Invader(4); //Speed of invader will be 4
                switch(location){
                    case 0: //Superior edge
                        inv.setRotation(direction + 1);
                        addObject(inv, offsetX, 25);
                        break;
                    case 1: //Inferior edge
                        inv.setRotation(direction + 181);
                        addObject(inv, offsetX, getHeight() - 25);
                        break;
                    case 2: //Right edge
                        inv.setRotation(direction + 91);
                        addObject(inv, getWidth() - 25, offsetY);
                        break;
                    case 3: //Left edge
                        inv.setRotation(direction + 270);
                        addObject(inv, 25, offsetY);
                        break;
                }
            }
            invCall.mark(); //Reset Timer
        }
        
    }
}
