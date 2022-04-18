import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SpaceWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpaceWorld extends World
{
    private int numOfAsteroids, maxNumOfAsteroids;
    /**
     * Constructor for objects of class SpaceWorld.
     * 
     */
    public SpaceWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        numOfAsteroids = 0;
        maxNumOfAsteroids = 5;
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
        spawnEnemies();
    }
    
    private void spawnEnemies(){
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
    }

}
