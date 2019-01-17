class Inventory //amount of stuff in inventory
{
    private int carrotSeeds, radishSeeds, melonSeeds, pumpkinSeeds;
    private int fertilizer;
    private int bugSpray;
    private int chickenFeed;
    private int money;
    
    public Inventory ()
    {
        carrotSeeds = 0;
        radishSeeds = 0;
        melonSeeds = 0;
        pumpkinSeeds = 0;
        fertilizer = 0;
        bugSpray = 0;
        chickenFeed = 0;
        money = 500;
    }
    
    public int buyCarrot()
    {
           carrotSeeds = carrotSeeds + 1;
           return carrotSeeds;
    }
    
    public int buyRadish()
    {
        radishSeeds = radishSeeds + 1;
        return radishSeeds;
    }
    
    public int buyMelon()
    {
        melonSeeds = melonSeeds + 1;
        return melonSeeds;
    }
    
    public int buyPumpkin()
    {
        pumpkinSeeds = pumpkinSeeds + 1;
        return pumpkinSeeds;
    }
    
    public int buyFertilizer()
    {
        fertilizer = fertilizer + 1;
        return fertilizer;
    }
    
    public int buyBugSpray()
    {
       bugSpray = bugSpray + 1;
       return bugSpray;
    }
    
    public int buyChickenFeed()
    {
        chickenFeed = chickenFeed + 1;
        return chickenFeed;
    }
    
    public int addMoney(int x)
    {
        money = money + x;
        return money;
    }
    
    public int subtractMoney(int x)
    {
        money = money - x;
        return money;
    }
}
 
