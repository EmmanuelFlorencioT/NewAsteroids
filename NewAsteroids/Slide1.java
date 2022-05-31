import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the first slide in the story telling of the game.
 * 
 */
public class Slide1 extends Story
{

    /**
     * Constructor for objects of class Slide1.
     * 
     */
    public Slide1(String skinRec)
    {
        setSkinName(skinRec);
        timerToSkip.mark(); //Reset the timer
    }
    
    public void act(){
        intro.playLoop();
        changeSlide();
    }
    
    @Override
    public void changeSlide(){
        if(Greenfoot.isKeyDown("space") && timerToSkip.millisElapsed() > getCooldownToSkip()){
            Slide2 nextSlide = new Slide2(getSkinName());
            Greenfoot.setWorld(nextSlide);
        }
    }
}
