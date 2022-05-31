
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends World
{
    private Message displayScore;
    private Button retry = new ButtonRetry();
    private Button buttonReturn = new ButtonReturn();
    private String nameSkin;
    private GreenfootSound backgroundMusicGameOver = new GreenfootSound("gameover.mp3");
    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public GameOver()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        options();
        nameSkin = "SpaceShip_Model1_Static.png";
        //Select the default SpaceShip
    }
    
    public GameOver(String nameSkin, int finScore)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        //Selection Skin
        this.nameSkin = nameSkin;
        displayScore = new Message(finScore);
        options();
    }
    
    public void act(){
        backgroundMusicGameOver.playLoop();
        selectOption();
    }
    
    public void selectOption(){
        if(retry.getPressButton() == true){
            backgroundMusicGameOver.stop();
            removeObjects(getObjects(Button.class));
            SpaceWorldEasy world = new SpaceWorldEasy(nameSkin);
            Greenfoot.setWorld(world);
        }
        if(buttonReturn.getPressButton() == true){
            backgroundMusicGameOver.stop();
            removeObjects(getObjects(Button.class));
            Menu world = new Menu();
            Greenfoot.setWorld(world);
        }
    }
    
    public void options(){
        addObject(displayScore, 300, 35);
        addObject(retry,300,250);
        addObject(buttonReturn,300,350);
        addObject(displayScore, 300, 35);
    }
}
