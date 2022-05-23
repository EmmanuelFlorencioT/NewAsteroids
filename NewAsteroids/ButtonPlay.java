import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ButtonPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ButtonPlay extends Button
{
    private GifImage buttonPlay = new GifImage("PlayButton.gif");
    /**
     * Act - do whatever the ButtonStart wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act()
    {
        // Add your action code here.
        setImage(buttonPlay.getCurrentImage());
    }
    @Override
    public boolean getPressButton(){
        return Greenfoot.mousePressed(this);
    }
}
