import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the final slide in the story telling of the game.
 * 
 */
public class Slide3 extends Story
{

    /**
     * Constructor for objects of class Slide3.
     * 
     */
    public Slide3(String skinRec)
    {
        setSkinName(skinRec);
        timerToSkip.mark(); //Reset the timer
    }
    
    public void act(){
        changeSlide();
    }
    
    @Override
    public void changeSlide(){
        if(Greenfoot.isKeyDown("space") && timerToSkip.millisElapsed() > getCooldownToSkip()){
            SpaceWorldEasy Level1 = new SpaceWorldEasy(getSkinName());
            Greenfoot.setWorld(Level1);
        }
    }
}
