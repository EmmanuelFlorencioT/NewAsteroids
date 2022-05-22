import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Skin7 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Skin7 extends Aspect
{
    /**
     * Act - do whatever the Skin7 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    @Override
    public void Init_Game(){
        if(Greenfoot.mousePressed(this) == true){
            SpaceWorldEasy Level1 = new SpaceWorldEasy("SpaceShip_Model7_Static.png");
            Greenfoot.setWorld(Level1);
        }
    }
}
