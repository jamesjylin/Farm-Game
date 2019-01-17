import java.awt.*;
import javax.imageio.*;
import java.io.*;
 
class Seedling
{
    protected int stage; //stage of growth
    protected boolean infected; //whether show is infected or not
    protected boolean alive; //if show is dead or alive
    protected boolean watered; //if show is not watered, won't grow
    protected boolean ripe = false; //if show is not ripe, can't harvest
    protected boolean fertilized; //if show is fertilized, stage + 1
    protected Image seedling; //picture of seed
    protected Image infectedSeedling; //picture of infected seed
    protected Image dead; //picture of dead show
    
    public Seedling()
    {
        stage = 1;
        infected = false;
        alive = true;
        watered = false;
        fertilized = false;
        
        //seedling picture
        seedling = null;
        try
        {
            seedling = ImageIO.read (new File ("Images/seedling.png"));
            infectedSeedling = ImageIO.read (new File ("Images/infectedSeedling.png"));
            dead = ImageIO.read (new File ("Images/dead.png"));
        }
        catch (IOException e)
        {
            System.out.println ("File not found");
        }
    }
    
    public void show (Graphics g, int x, int y) //main show method
    {
        if (alive)
            g.drawImage (seedling, x, y, null);
        else if (infected)
            g.drawImage (infectedSeedling, x, y, null);
        else 
            g.drawImage (dead, x, y, null);
    }
    
    public void grow() //grow seedling
    {
        if (watered && fertilized)
            stage = stage + 2;
        else if(watered)
            stage = stage + 1;
        else
            death();
    }
    
    public void infect() //infect seedling
    {
        infected = true;
    }
    
    public void cure() //cure seedling of infection
    {
        infected = false;
    }
    
    public void death() //seedling dies
    {
        alive = false;
    }
    
    public void water() //water seedling
    {
        watered = true;
    }
    
    public void fertilize() //fertilize seedling
    {
        fertilized = true;
    }
}
 
//carrot subclass
class Carrot extends Seedling
{
    private Image youngCarrot; //image for carrot stage 2-3
    private Image grownCarrot; //image for carrot stage 4
    private Image infectedYoungCarrot; //infected carrot
    private Image infectedGrownCarrot;
    
    public Carrot() //carrot constructor
    {
        super();
        
        youngCarrot = null;
        try
        {
            youngCarrot = ImageIO.read (new File ("Images/youngCarrot.png"));
            grownCarrot = ImageIO.read (new File ("Images/grownCarrot.png"));
            infectedYoungCarrot = ImageIO.read (new File ("Images/infectedYoungCarrot.png"));
            infectedGrownCarrot = ImageIO.read (new File ("Images/infectedGrownCarrot.png"));
            dead = ImageIO.read (new File ("Images/dead.png"));
        }
        catch (IOException e)
        {
            System.out.println ("File not found");
        }
    }
    
    public void show (Graphics g, int x, int y) //change image as it grows
    {
        if (stage == 1)
        {
            if (alive)
            {
                if (infected)
                    g.drawImage (infectedSeedling, x, y, null);
                else
                    g.drawImage (seedling, x, y, null);
            }
            else   
                g.drawImage (dead, x, y, null);
        }
        else if (stage >= 2 && stage <= 3)
        {
            if (alive)
            {
                if (infected)
                    g.drawImage (infectedYoungCarrot, x, y, null);
                else
                    g.drawImage (youngCarrot, x, y, null);
            }
            else 
                g.drawImage (dead, x, y, null);
        }
        else
        {
            if (alive)
            {
                if (infected)
                    g.drawImage (infectedGrownCarrot, x, y, null);
                else
                    g.drawImage (grownCarrot, x, y, null);
            }
            else 
                g.drawImage (dead, x, y, null);
        }
    }
    
    public void ripe() //check if ripe
    {
        if (stage == 4)
            ripe = true;
    }
}
 
class Radish extends Seedling
{
    private Image youngRadish; //image of radish stage 2-4
    private Image grownRadish; //image of radish stage 5
    private Image infectedYoungRadish; //infected radish
    private Image infectedGrownRadish;
    
    public Radish()
    {
        super();
        
        youngRadish = null;
        try
        {
            youngRadish = ImageIO.read (new File ("Images/youngRadish.png"));
            grownRadish = ImageIO.read (new File ("Images/grownRadish.png"));
            infectedYoungRadish = ImageIO.read (new File ("Images/infectedYoungRadish.png"));
            infectedGrownRadish = ImageIO.read (new File ("Images/infectedGrownRadish.png"));
            dead = ImageIO.read (new File ("Images/dead.png"));
        }
        catch (IOException e)
        {
            System.out.println ("File not found");
        }
    }
    
    public void show (Graphics g, int x, int y) //change image as it grows
    {
        if (stage == 1)
        {
            if (alive)
            {
                if (infected)
                    g.drawImage (infectedSeedling, x, y, null);
                else
                    g.drawImage (seedling, x, y, null);
            }
            else   
                g.drawImage (dead, x, y, null);
        }
        else if (stage >= 2 && stage <= 4)
        {
            if (alive)
            {
                if (infected)
                    g.drawImage (infectedYoungRadish, x, y, null);
                else
                    g.drawImage (youngRadish, x, y, null);
            }
            else 
                g.drawImage (dead, x, y, null);
        }
        else
        {
            if (alive)
            {
                if (infected)
                    g.drawImage (infectedGrownRadish, x, y, null);
                else
                    g.drawImage (grownRadish, x, y, null);
            }
            else 
                g.drawImage (dead, x, y, null);
        }
    }
    
    public void ripe() //check if ripe
    {
        if (stage == 5)
            ripe = true;
    }
}
 
class Melon extends Seedling
{
    private Image youngMelon; //image of melon stage 2-3
    private Image midMelon; //image of melon stage 4-5
    private Image grownMelon; //image of melon stage 6
    private Image infectedYoungMelon; //infected melon
    private Image infectedMidMelon;
    private Image infectedGrownMelon;
    
    public Melon()
    {
        super();
        
        youngMelon = null;
        try
        {
            youngMelon = ImageIO.read (new File ("Images/youngMelon.png"));
            midMelon = ImageIO.read (new File ("Images/midMelon.png"));
            grownMelon = ImageIO.read (new File ("Images/grownMelon.png"));
            infectedYoungMelon = ImageIO.read (new File ("Images/infectedYoungMelon"));
            infectedMidMelon = ImageIO.read (new File ("Images/infectedMidMelon"));
            infectedGrownMelon = ImageIO.read (new File ("Images/infectedMidMelon"));
            dead = ImageIO.read (new File ("Images/dead.png"));
        }
        catch (IOException e)
        {
            System.out.println ("File not found");
        }
    }
    
    public void show (Graphics g, int x, int y) //change image as it grows
    {
        if (stage == 1)
        {
            if (alive)
            {
                if (infected)
                    g.drawImage (infectedSeedling, x, y, null);
                else
                    g.drawImage (seedling, x, y, null);
            }
            else   
                g.drawImage (dead, x, y, null);
        }
        if (stage >= 2 && stage <= 3)
        {
            if (alive)
            {
                if (infected)
                    g.drawImage (infectedYoungMelon, x, y, null);
                else
                    g.drawImage (youngMelon, x, y, null);
            }
            else 
                g.drawImage (dead, x, y, null);
        }
        else if (stage >= 4 && stage <= 5)
        {
            if (alive)
            {
                if (infected)
                    g.drawImage (infectedMidMelon, x, y, null);
                else
                    g.drawImage (midMelon, x, y, null);
            }
            else 
                g.drawImage (dead, x, y, null);
        }
        else
        {
            if (alive)
            {
                if (infected)
                    g.drawImage (grownMelon, x, y, null);
                else
                    g.drawImage (infectedGrownMelon, x, y, null);
            }
            else 
                g.drawImage (dead, x, y, null);
        }
    }
    
    public void ripe() //check if ripe
    {
        if (stage == 6)
            ripe = true;
    }
}
 
class Pumpkin extends Seedling
{
    private Image youngPumpkin; //image of pumpkin stage 2-3
    private Image midPumpkin; //image of pumpkin stage 4-5
    private Image grownPumpkin; //image of pumpkin stage 6
    private Image infectedYoungPumpkin; //infected pumpkin
    private Image infectedMidPumpkin;
    private Image infectedGrownPumpkin;
    
    public Pumpkin()
    {
        super();
        
        youngPumpkin = null;
        try
        {
            youngPumpkin = ImageIO.read (new File ("Images/youngPumpkin.png"));
            midPumpkin = ImageIO.read (new File ("Images/midPumpkin.png"));
            grownPumpkin = ImageIO.read (new File ("Images/grownPumpkin.png"));
            infectedYoungPumpkin = ImageIO.read (new File ("Images/infectedYoungPumpkin.png"));
            infectedMidPumpkin = ImageIO.read (new File ("Images/infectedMidPumpkin.png"));
            infectedGrownPumpkin = ImageIO.read (new File ("Images/infectedMidPumpkin.png"));
            dead = ImageIO.read (new File ("Images/dead.png"));
        }
        catch (IOException e)
        {
            System.out.println ("File not found");
        }
    }
    
    public void show (Graphics g, int x, int y) //change image as it grows
    {
        if (stage == 1)
        {
            if (alive)
            {
                if (infected)
                    g.drawImage (infectedSeedling, x, y, null);
                else
                    g.drawImage (seedling, x, y, null);
            }
            else   
                g.drawImage (dead, x, y, null);
        }
        else if (stage >= 2 && stage <= 4)
        {
            if (alive)
            {
                if (infected)
                    g.drawImage (infectedYoungPumpkin, x, y, null);
                else
                    g.drawImage (youngPumpkin, x, y, null);
            }
            else 
                g.drawImage (dead, x, y, null);
        }
        if (stage >= 5 && stage <= 6)
        {
            if (alive)
            {
                if (infected)
                    g.drawImage (infectedMidPumpkin, x, y, null);
                else
                    g.drawImage (midPumpkin, x, y, null);
            }
            else 
                g.drawImage (dead, x, y, null);
        }
        else
        {
            if (alive)
            {
                if (infected)
                    g.drawImage (infectedGrownPumpkin, x, y, null);
                else
                    g.drawImage (grownPumpkin, x, y, null);
            }
            else 
                g.drawImage (dead, x, y, null);
        }
    }
    
    public void ripe() //check if ripe
    {
        if (stage == 7)
            ripe = true;
    }
}
 
 
