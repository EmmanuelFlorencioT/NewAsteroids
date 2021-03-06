import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ButtonStart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ButtonStart extends Button
{
    private GifImage buttonStart = new GifImage("StartButton.gif");
    /**
     * Act - do whatever the ButtonStart wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act()
    {
        // Add your action code here.
        setImage(buttonStart.getCurrentImage());
    }
    @Override
    public boolean getPressButton(){
        return Greenfoot.mousePressed(this);
    }
}
