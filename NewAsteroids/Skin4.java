import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Skin4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Skin4 extends Aspect
{
    /**
     * Act - do whatever the Skin4 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    @Override
    public void Init_Game(){
        if(Greenfoot.mousePressed(this) == true){
            SpaceWorldEasy Level1 = new SpaceWorldEasy("SpaceShip_Model4_Static.png");
            Greenfoot.setWorld(Level1);
        }
    }
}
