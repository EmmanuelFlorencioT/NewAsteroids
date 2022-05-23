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
//<<<<<<< HEAD
    private SelectionSquare square = new SelectionSquare();
    private GreenfootSound backgroundMusic = new GreenfootSound("MenuAudio.mp3");
    private Logo logo = new Logo();
    private SelectSpaceship textSelect = new SelectSpaceship();
    
////=======
    private Button return_menu = new ButtonReturn();
    //add the skin from spaceship
    //SpaceWorldEasy Level1 = new SpaceWorldEasy("SpaceShip_Model1_Static.png");
    private ArrayList <Aspect> skins = new ArrayList<Aspect>();
    private boolean check_init_game = false;
    private Character skin;
    private int bandSpaceShip;
    private boolean bandSelect = false;
    private int bandX,bandY;
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
        int aum=0;
        for(int j=0; j<=(skins.size())/4; j++){
            aum=0;
            for(int i=(4*j); i < skins.size()-3+(3*j); i++){
                addObject(getSkins(i), 75+(150*aum), 100+100*j);
                aum+=1;
            }
        }
    }
    
    public void Addoptions(){
        //addObject(start,300,250);
        addObject(play,300,250);
        addObject(logo,300,100);
    }
    
    public void Addcharacters(){
        addObject(return_menu,500,300);
        addObject(square,75,100);
        addObject(textSelect,300,25);
        addObject(start,300,300);
        AddOptionsSkin();
        selectSkin();
        
        
    }
    
    public void act(){ 
        setBackground(background.getCurrentImage());
        backgroundMusic.playLoop();
        SelectOptionsMenu();
        if(bandSelect == false){
            bandX = 75;
            bandY = 100;
        }
        selectSkin();
        StartGame();
        
        //stop();
    }
    public void SelectOptionsMenu(){
        if(play.getPressButton() == true){
            removeObjects(getObjects(Button.class));
            removeObjects(getObjects(Logo.class));
            
            Addcharacters();
        }
        if(return_menu.getPressButton() == true){
            removeObject(return_menu);
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
                //showText("x: " + bandX + " y: " + bandY,80,50);
                square.setLocation(skin.getX(),skin.getY());
                bandSelect = true;
                
                
            }
        }        
            //skin.Init_Game();
            //stop(skin);
        
    }
    public void StartGame(){
        /*for(Aspect skin : skins){
            skin.Init_Game();
            stop(skin);
        }*/
        if(start.getPressButton() == true){
            if(bandX == 75 && bandY == 100){
                SpaceWorldEasy Level1 = new SpaceWorldEasy("SpaceShip_Model1_Static.png");
                backgroundMusic.stop();
                Greenfoot.setWorld(Level1);
            }else if(bandX == 225 && bandY == 100){
                SpaceWorldEasy Level1 = new SpaceWorldEasy("SpaceShip_Model2_Static.png");
                backgroundMusic.stop();
                Greenfoot.setWorld(Level1);
            }else if(bandX == 375 && bandY == 100){
                SpaceWorldEasy Level1 = new SpaceWorldEasy("SpaceShip_Model3_Static.png");
                backgroundMusic.stop();
                Greenfoot.setWorld(Level1);
            }else if(bandX == 525 && bandY == 100){
                SpaceWorldEasy Level1 = new SpaceWorldEasy("SpaceShip_Model4_Static.png");
                backgroundMusic.stop();
                Greenfoot.setWorld(Level1);
            }else if(bandX == 75 && bandY == 200){
                SpaceWorldEasy Level1 = new SpaceWorldEasy("SpaceShip_Model5_Static.png");
                backgroundMusic.stop();
                Greenfoot.setWorld(Level1);
            }else if(bandX == 225 && bandY == 200){
                SpaceWorldEasy Level1 = new SpaceWorldEasy("SpaceShip_Model6_Static.png");
                backgroundMusic.stop();
                Greenfoot.setWorld(Level1);
            }else if(bandX == 375 && bandY == 200){
                SpaceWorldEasy Level1 = new SpaceWorldEasy("SpaceShip_Model7_Static.png");
                backgroundMusic.stop();
                Greenfoot.setWorld(Level1);
            }
            //SpaceWorldEasy Level1 = new SpaceWorldEasy("SpaceShip_Model1_Static.png");
            
        }
    }
    public void stop(Aspect skin){
        if(Greenfoot.mousePressed(skin) == true){
            backgroundMusic.stop();
        }
    }
}
