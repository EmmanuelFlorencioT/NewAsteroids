import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ButtonReturn here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ButtonReturn extends Button
{
    
    
    private GifImage buttonReturn = new GifImage("ReturnButton.gif");
    /**
     * Act - do whatever the ButtonReturn wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        setImage(buttonReturn.getCurrentImage());
    }
    @Override
    public boolean getPressButton(){
        return Greenfoot.mousePressed(this);
    }
}
