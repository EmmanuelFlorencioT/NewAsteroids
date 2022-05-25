import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Spaceship here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spaceship extends SpaceObject
{
    private SimpleTimer shotCool = new SimpleTimer();
    private final int SHOT_INT = 300; //Shot interval
    private final int ACTIVE_PWRUP = 200; //Number of cycles power up will be active
    private int powerupTimeLeft = ACTIVE_PWRUP;
    private boolean shotReady, powerActive = false;
    private String nameSkin;
    //private GameOver gameover = new GameOver();
    /**
     * Act - do whatever the Spaceship wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(getLife() > 0){
            moveSpaceship();
            handleEdgeMovement();
            shoot();
            checkForCollision();
            
            if(powerActive){
                speedBoostTimer();
            }
        } else {
            getWorld().removeObject(this);
            GameOver gameover = new GameOver(getSkin());
            Greenfoot.setWorld(gameover);
            //Greenfoot.stop(); /*We will stop the execution of the game (for now)*/
        }
    }
    
    public Spaceship(){
        this.setRotation(-90);
        shotReady = true;
    }
    
    public Spaceship(String skin){
        this.setRotation(-90);
        shotReady = true;
        nameSkin = skin;
        setImage(skin);
    }
    
    public void moveSpaceship(){
        if(Greenfoot.isKeyDown("up")){
            move(getSpeed());
        }
        if(Greenfoot.isKeyDown("right")){
            turn(5);
        }
        if(Greenfoot.isKeyDown("left")){
            turn(-5);
        }
    }
    
    @Override
    public void handleEdgeMovement(){
        World w = getWorld();
        /*Check for inferior edge*/ //Error
        if(getY() > (w.getHeight() - 2)  ){
            setLocation(getX(), 3);
        }
        /*Check for supetior edge*/
        if( getY() < 0 + 1){
            setLocation(getX(), (w.getHeight() - 2));
        }
        /*Check for right edge*/
        if( getX() > (w.getWidth() - 2)){
            setLocation(3, getY());
        }
        /*Chech for the left edge*/
        if( getX() < 0 + 1){
            setLocation((w.getWidth() - 2), getY()); 
        }
    }
    
    public void shoot(){
        if(Greenfoot.isKeyDown("space") && shotReady == true && shotCool.millisElapsed() > SHOT_INT){
            Projectile p = new Projectile(5, this.getRotation());
            GreenfootSound shootSound = new GreenfootSound("shootSpaceShip.mp3");
            shootSound.play();
            getWorld().addObject(p, getX(), getY());
            getWorld().addObject(p, getX(), getY());
            shotReady = false;
            //Reset the timer
            shotCool.mark();
        }
        /*Check when the space key is depressed*/
        if(!Greenfoot.isKeyDown("space"))
            shotReady = true;
    }
    
    public void checkForCollision(){
        /*We are looking for an intersection with an asteroid killer(astKiller)*/
        Actor astKiller = getOneObjectAtOffset(0, 0, Asteroid.class);
        /*We are looking for a collision(intersection) with an asteroid invader*/
        Actor invKiller = getOneObjectAtOffset(0, 0, Invader.class);
        
        if(astKiller != null){
            /*We check if the AsteroidSmall is not ready to kill, then we return*/
            if(astKiller instanceof AsteroidSmall && !((AsteroidSmall)astKiller).isReadyToKill()){
                    return;
            } else {
                ((Asteroid)astKiller).subLife();
                this.subLife();
                changeInvensible();
            }
        }
        if(invKiller != null){
            ((Invader)invKiller).subLife();
            this.subLife();
            changeInvensible();
        }
    }
    
    /*Speed Power Up*/
    public void increaseSpeed(){
        this.powerActive = true;
        setSpeed(6);
    }
    public void speedBoostTimer(){
        powerupTimeLeft--;
        if(powerupTimeLeft <= 0){
            this.powerActive = false;
            setSpeed(3);
            powerupTimeLeft = ACTIVE_PWRUP; //Reset timer
        }
    }
    
    public void changeInvensible(){
        if(nameSkin == "SpaceShip_Model1_Static.png"){
            
            GifImage invensible = new GifImage("SpaceShip_Model1_AnimationInvensible.gif");
            this.setImage(invensible.getCurrentImage());
        }else if(nameSkin == "SpaceShip_Model2_Static.png"){
            GifImage invensible = new GifImage("SpaceShip_Model2_AnimationInvensible.gif");
            this.setImage(invensible.getCurrentImage());
        }else if(nameSkin == "SpaceShip_Model3_Static.png"){
            GifImage invensible = new GifImage("SpaceShip_Model3_AnimationInvensible.gif");
            this.setImage(invensible.getCurrentImage());
        }else if(nameSkin == "SpaceShip_Model4_Static.png"){
            GifImage invensible = new GifImage("SpaceShip_Model4_AnimationInvensible.gif");
            this.setImage(invensible.getCurrentImage());
        }else if(nameSkin == "SpaceShip_Model5_Static.png"){
            GifImage invensible = new GifImage("SpaceShip_Model5_AnimationInvensible.gif");
            this.setImage(invensible.getCurrentImage());
        }else if(nameSkin == "SpaceShip_Model6_Static.png"){
            GifImage invensible = new GifImage("SpaceShip_Model6_AnimationInvensible.gif");
            this.setImage(invensible.getCurrentImage());
        }else if(nameSkin == "SpaceShip_Model7_Static.png"){
            GifImage invensible = new GifImage("SpaceShip_Model7_AnimationInvensible.gif");
            this.setImage(invensible.getCurrentImage());
        }
    }
    
    public String getSkin(){
        return this.nameSkin;
    }
}
