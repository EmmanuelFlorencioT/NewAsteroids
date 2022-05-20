import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{
    private GifImage background = new GifImage("backgroundMenu.gif");
    private Button start = new ButtonStart();
    private Button skin = new ButtonSkin();
    private GreenfootSound backgroundMusic = new GreenfootSound("MenuAudio.mp3");
    private Logo logo = new Logo();
    /**
     * Constructor for objects of class Menu.
     * 
     */
    public Menu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600,400,1);
        Addoptions();
    }
    public void Addoptions(){
        addObject(start,300,200);
        addObject(skin,300,270);
        addObject(logo,300,100);
    }
    
    public void act(){
        setBackground(background.getCurrentImage());
        backgroundMusic.playLoop();
        start.getPressButton();
        stop();
    }
    public void stop(){
        if(Greenfoot.mousePressed(start) == true){
            backgroundMusic.stop();
        }
    }
}
