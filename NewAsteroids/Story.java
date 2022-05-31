import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Story is the abstraction of all stroy slides that come with the game.
 * 
 */
public abstract class Story extends World
{
    protected SimpleTimer timerToSkip = new SimpleTimer();
    private final int COOL_TO_SKIP = 2000; //2 seconds
    private String nameSkin = " SpaceShip_Model1_Static.png"; //Skin by default
    public static GreenfootSound intro = new GreenfootSound("StoryMusic.mp3");
    /**
     * Constructor for objects of class Story.
     * 
     */
    public Story()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        Story.intro.setVolume(40);
    }
    
    public int getCooldownToSkip(){
        return this.COOL_TO_SKIP;
    }
    
    public void setSkinName(String skinName){
        this.nameSkin = skinName;
    }
    public String getSkinName(){
        return this.nameSkin;
    }
    
    public abstract void changeSlide();
}
