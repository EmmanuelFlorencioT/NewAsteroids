import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the second slide in the story telling of the game.
 * 
 */
public class Slide2 extends Story
{

    /**
     * Constructor for objects of class Slide2.
     * 
     */
    public Slide2(String skinRec)
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
            Slide3 nextSlide = new Slide3(getSkinName());
            Greenfoot.setWorld(nextSlide);
        }
    }
}
