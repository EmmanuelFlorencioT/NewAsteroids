import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{
    MouseInfo mouse = Greenfoot.getMouseInfo();
    private GifImage background = new GifImage("backgroundMenu.gif");
    private Button start = new ButtonStart();
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
        addObject(start,300,150);
    }
    
    public void act(){
        setBackground(background.getCurrentImage());
        start.getPressButton();
    }
}
