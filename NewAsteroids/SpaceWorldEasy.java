import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class SpaceWorldEasy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpaceWorldEasy extends Level
{
    /**
     * Constructor for objects of class SpaceWorld.
     * 
     */
    private Spaceship player;
    private String nameSkin;
    private int newLife;
    private int oldLife;
    
    private ArrayList <Life> lifes = new ArrayList<Life>();
    public SpaceWorldEasy()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        setGameMode(true); //Infinite game mode
        nameSkin = "SpaceShip_Model1_Static.png";
        setMaxNumOfAsteroids(3);
        setMaxNumOfInvaders(1);
        setMaxNumOfPowerUp(1);
        setAsteroidInterval(20);
        setInvaderInterval(1000);
        setPowerUpInterval(1500);
        astCall.mark(); //Start the timer
        invCall.mark();
        powCall.mark();
        prepare();
    }
    
    public SpaceWorldEasy(String skin)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        setGameMode(true); //Infinite game mode
        setMaxNumOfAsteroids(3);
        
        nameSkin = skin;
        setMaxNumOfInvaders(1);
        setMaxNumOfPowerUp(1);
        setAsteroidInterval(20);
        setInvaderInterval(1000);
        setPowerUpInterval(1500);
        astCall.mark(); //Start the timer
        invCall.mark();
        powCall.mark();
        prepare(skin);
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    
    public void addLifes(){
        for(int i=0; i < player.getLife(); i++){
            lifes.add(new Life());
            if(oldLife < player.getLife()){
                oldLife = player.getLife();
            }
            
        }
    }
    public void deleteLifes(){
        if(oldLife - player.getLife() > 0){
            //showText("Si entre " + lifes.size(),100,250);
            removeObject(lifes.get(player.getLife()));
            lifes.remove(player.getLife());
            //showText("" + lifes.size(),100,250);
            oldLife = player.getLife();
        }
        
        
    }
    public Life getSkinLife(int typeskin){
        return lifes.get(typeskin);
    }

    public void printLifes(){
        int aum=0;
        for(int i=0; i < player.getLife(); i++){
            addObject(getSkinLife(i),400+(i*25),40);
            
        }
    }
    
    private void prepare()
    {
        player = new Spaceship();
        addObject(player, 300, 300);
    }
    
    private void prepare(String skin)
    {
        player = new Spaceship(skin);
        addObject(player, 300, 300);
        addObject(scoreCounter, 80, 40);
        //addObject(lifes,500,40);
    }
    
    public void act(){
        spawnAsteroids();
        spawnInvaders();
        spawnPowerUp();
        addLifes();
        
        printLifes();
        deleteLifes();
        //showText("Life: " + player.getLife(),50,100);
        //showText("LifeOld: " + oldLife,50,150);
        //showText("LifeNew: " + newLife,50,200);
        
    }
    
    private void spawnAsteroids(){
        if(astCall.millisElapsed() > getAsteroidInterval()){
            if(getNumOfAsteroids() < getMaxNumOfAsteroids() && Greenfoot.getRandomNumber(1000) < 20){
                addAsteroid();
                int bandSprite = Greenfoot.getRandomNumber(3) + 1;
                AsteroidMed a = new AsteroidMed();
                a.asteroidsSpritesMed(bandSprite);
                spawnInLocation(a);
            }
            astCall.mark(); //Reset Timer
        }
    }

    public void spawnInvaders(){
        if(invCall.millisElapsed() > getInvaderInterval()){
            if(getNumOfInvaders() < getMaxNumOfInvaders() && Greenfoot.getRandomNumber(1000) < 25){
                addInvader();
                Invader inv = new Invader(4); //Speed of invader will be 4
                spawnInLocation(inv);
            }
            invCall.mark(); //Reset Timer
        }
    }
    
    public void spawnPowerUp(){
        if(powCall.millisElapsed() > getPowerUpInterval()){
            if(getNumOfPowerUp() < getMaxNumOfPowerUp() && Greenfoot.getRandomNumber(1000) < 40){
                addPowerUp();
                int typeOfPowerUp = Greenfoot.getRandomNumber(4);
                
                //int typeOfPowerUp = 0;
                PowerUp pUp = null;
                switch(typeOfPowerUp){
                    case 0: //ExtraLife
                    
                        pUp = new ExtraLife();
                        break;
                    case 1: //Speed
                        pUp = new Speed();
                        break;
                    case 2: //Shield
                        pUp = new Weapon();
                        break;
                    case 3: //Burst
                        pUp = new Burst();
                        break;
                }
                spawnInLocation(pUp);
            }
            powCall.mark();
        }
    }
    
    private void spawnInLocation(Actor a){
        int edge = Greenfoot.getRandomNumber(4);
        int direction = Greenfoot.getRandomNumber(178);
        int offsetX = Greenfoot.getRandomNumber(getWidth()-20) + 10;
        int offsetY = Greenfoot.getRandomNumber(getHeight() - 20) + 10;
        switch(edge){
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
