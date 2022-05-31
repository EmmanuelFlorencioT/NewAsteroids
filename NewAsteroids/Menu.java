import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{
    private GifImage background = new GifImage("backgroundMenu.gif");
    private Button start = new ButtonStart();
    private Button play = new ButtonPlay();
    private Button return_menu = new ButtonReturn();
//<<<<<<< HEAD
    private SelectionSquare square = new SelectionSquare();
    private GreenfootSound backgroundMusic = new GreenfootSound("MenuAudio.mp3");
    private Logo logo = new Logo();
    private SelectSpaceship textSelect = new SelectSpaceship();
////=======
    //player skins added in an array
    private ArrayList <Aspect> skins = new ArrayList<Aspect>();
//<<<<<<< HEAD
    //location of the 1st skin
    private int bandX=75,bandY=100;
//=======
//>>>>>>> 8d11c3110caf481785bb0cdeee72f29f9c649bb4
//>>>>>>> main
    /**
     * Constructor for objects of class Menu.
     * 
     */
    public Menu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600,400,1);
        Addoptions();
        addSkinsArray();
    }
    public void addSkinsArray(){
        skins.add(new Skin1());
        skins.add(new Skin2());
        skins.add(new Skin3());
        skins.add(new Skin4());
        skins.add(new Skin5());
        skins.add(new Skin6());
        skins.add(new Skin7());
    }
    
    public Aspect getSkins(int typeskin){
        return skins.get(typeskin);
    }

    public void AddOptionsSkin(){
        int location=0; //variable to set location the skin
        int enterRow=0; //variable to set a new row for the skins
        int num_index_skins=0; //variable to know what type the skin is into array
        while(num_index_skins != skins.size()){
            location=0;
            while(location != 4 && num_index_skins < skins.size()){
                addObject(getSkins(num_index_skins), 75+(150*location), 100+(100*enterRow));
                location+=1;
                num_index_skins+=1;
            }
            enterRow+=1;
        }
    }
    
    public void Addoptions(){
        addObject(play,300,250);
        addObject(logo,300,100);
    }
    
    public void Addcharacters(){
        addObject(return_menu,500,300);
        addObject(square,75,100);
        addObject(textSelect,300,25);
        addObject(start,300,300);
        AddOptionsSkin();
    }
    
    public void act(){ 
        setBackground(background.getCurrentImage());
        backgroundMusic.playLoop();
        SelectOptionsMenu();
        selectSkin();
        StartGame();
    }
    
    public void SelectOptionsMenu(){
        if(play.getPressButton() == true){
            removeObjects(getObjects(Button.class));
            removeObjects(getObjects(Logo.class));
            Addcharacters();
        }
        if(return_menu.getPressButton() == true){
            removeObjects(getObjects(Button.class));
            removeObjects(getObjects(Aspect.class));
            removeObject(textSelect);
            removeObject(square);
            Addoptions();
        }
    }
    
    public void selectSkin(){
        for(Aspect skin : skins){
            if(Greenfoot.mousePressed(skin) == true){
                bandX = skin.getX();
                bandY = skin.getY();
                square.setLocation(skin.getX(),skin.getY());                
            }
        }        
    }
    
    public void StartGame(){
        if(start.getPressButton() == true){
            if(bandX == 75 && bandY == 100){
                Slide1 story = new Slide1("SpaceShip_Model1_Static.png");
                backgroundMusic.stop();
                Greenfoot.setWorld(story);
            }else if(bandX == 225 && bandY == 100){
                Slide1 story = new Slide1("SpaceShip_Model2_Static.png");
                backgroundMusic.stop();
                Greenfoot.setWorld(story);
            }else if(bandX == 375 && bandY == 100){
                Slide1 story = new Slide1("SpaceShip_Model3_Static.png");
                backgroundMusic.stop();
                Greenfoot.setWorld(story);
            }else if(bandX == 525 && bandY == 100){
                Slide1 story = new Slide1("SpaceShip_Model4_Static.png");
                backgroundMusic.stop();
                Greenfoot.setWorld(story);
            }else if(bandX == 75 && bandY == 200){
                Slide1 story = new Slide1("SpaceShip_Model5_Static.png");
                backgroundMusic.stop();
                Greenfoot.setWorld(story);
            }else if(bandX == 225 && bandY == 200){
                Slide1 story = new Slide1("SpaceShip_Model6_Static.png");
                backgroundMusic.stop();
                Greenfoot.setWorld(story);
            }else if(bandX == 375 && bandY == 200){
                Slide1 story = new Slide1("SpaceShip_Model7_Static.png");
                backgroundMusic.stop();
<<<<<<< HEAD
                Greenfoot.setWorld(Level1);
            }    
=======
                Greenfoot.setWorld(story);
            }
            //SpaceWorldEasy Level1 = new SpaceWorldEasy("SpaceShip_Model1_Static.png");
            
        }
    }
    public void stop(Aspect skin){
        if(Greenfoot.mousePressed(skin) == true){
            backgroundMusic.stop();
>>>>>>> origin
        }
    }
}
