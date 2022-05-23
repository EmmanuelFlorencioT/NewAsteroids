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
//<<<<<<< HEAD
    private Button skin = new ButtonSkin();
    private GreenfootSound backgroundMusic = new GreenfootSound("MenuAudio.mp3");
    private Logo logo = new Logo();
////=======
    private Button return_menu = new ButtonReturn();
    //add the skin from spaceship
    private ArrayList <Aspect> skins = new ArrayList<Aspect>();
    private boolean check_init_game = false;
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
                addObject(getSkins(i), 150+(100*aum), 75+75*j);
                aum+=1;
            }
        }
    }
    
    public void Addoptions(){
        addObject(start,300,200);
        addObject(skin,300,270);
        addObject(logo,300,100);
    }
    
    public void Addcharacters(){
        addObject(return_menu,500,300);
        AddOptionsSkin();
    }
    
    public void act(){ 
        setBackground(background.getCurrentImage());
        backgroundMusic.playLoop();
        SelectOptionsMenu();
        StartGame();
        //stop();
    }
    public void SelectOptionsMenu(){
        if(start.getPressButton() == true){
            removeObjects(getObjects(Button.class));
            removeObjects(getObjects(Logo.class));
            Addcharacters();
        }
        if(return_menu.getPressButton() == true){
            removeObject(return_menu);
            removeObjects(getObjects(Aspect.class));
            Addoptions();
        }
    }
    public void StartGame(){
        for(Aspect skin : skins){
            skin.Init_Game();
            stop(skin);
        }
    }
    public void stop(Aspect skin){
        if(Greenfoot.mousePressed(skin) == true){
            backgroundMusic.stop();
        }
    }
}
