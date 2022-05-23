import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ButtonSkin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ButtonSkin extends Button
{
    /**
     * Act - do whatever the ButtonSkin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GifImage buttonSkin = new GifImage("SkinButton.gif");
    public void act()
    {
        // Add your action code here.
        setImage(buttonSkin.getCurrentImage());
    }
    @Override
    public boolean getPressButton(){
        if(Greenfoot.mousePressed(this) == true){
            //SpaceWorldEasy level1 = new SpaceWorldEasy();
            //Greenfoot.setWorld(level1);
        }
        return true;
    }
}
