import java.awt.image.BufferedImage;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.imageio.*;
import java.io.*;
 
public class Farm extends JFrame //main farm stuff
{
    Inventory inventory = new Inventory();
    Carrot carrot = new Carrot();
    Radish radish = new Radish();
    Melon melon = new Melon();
    Pumpkin pumpkin = new Pumpkin();
    Plot carrotPlot = new Plot(carrot);
    Plot radishPlot = new Plot(radish);
    Plot melonPlot = new Plot(melon);
    Plot pumpkinPlot = new Plot(pumpkin);
    JPanel content = new JPanel (new CardLayout());  
    CardLayout cl = (CardLayout) content.getLayout(); 
    DrawPlant plotScreen = new DrawPlant(600,600); 
    DrawBackground farmScreen = new DrawBackground(600,600, "farm");
    DrawBackground barnScreen = new DrawBackground(600,600, "barn");
    DrawBackground marketScreen = new DrawBackground(600, 600, "market");
    DrawBackground instructionScreen = new DrawBackground(600, 600, "instructions");
    Image Instructions, Farm, Barn, Market, Logo, vegetablePlot, bugspray, fertilizer, watercan, cover;
    Image grownCarrot, grownRadish, grownMelon, grownPumpkin, harvest, sickle;
    Image spump, scar, srad, smel;
    ImageIcon rain;
    JLabel moneyNum, fertilizerNum1, fertilizerNum2, bugSprayNum2, carrotNum2, radishNum2, melonNum2, pumpkinNum2;
    int dayCount = 1, rainChance;
    Insets insets1;
    Insets insets2;
    Insets insets3;
    Insets insets4;
    Insets insets5;
 
    public Farm() //farm
    {
        //read images for above
        try
        {
            Instructions = ImageIO.read (new File ("Images/Instructions.png"));
        }
        catch (IOException e)
        {
            System.out.println ("File not found");
        }
        try
        {
            Farm = ImageIO.read (new File ("Images/Farm.jpg"));
        }
        catch (IOException e)
        {
            System.out.println ("File not found");
        }    
        try
        {
            vegetablePlot = ImageIO.read (new File ("Images/Plot.png"));
        }
        catch (IOException e)
        {
            System.out.println ("File not found");
        } 
        try
        {
            fertilizer = ImageIO.read (new File ("Images/fertilizer.png"));
        }
        catch (IOException e)
        {
            System.out.println ("File not found");
        }
        try
        {
            bugspray = ImageIO.read (new File ("Images/bugspray.png"));
        }
        catch (IOException e)
        {
            System.out.println ("File not found");
        }
        try
        {
            watercan = ImageIO.read (new File ("Images/wateringcan.png"));
        }
        catch (IOException e)
        {
            System.out.println ("File not found");
        }
        try
        {
            Barn = ImageIO.read (new File ("Images/Barn.png"));
        }
        catch (IOException e)
        {
            System.out.println ("File not found");
        }
        try
        {
            Market = ImageIO.read (new File ("Images/Market.png"));
        }
        catch (IOException e)
        {
            System.out.println ("File not found");
        }
        try
        {
            Logo = ImageIO.read (new File ("Images/Logo.png"));
        }
        catch (IOException e)
        {
            System.out.println ("File not found");
        }
        try
        {
            cover = ImageIO.read (new File ("Images/Capture3.png"));
        }
        catch (IOException e)
        {
            System.out.println ("File not found");
        }
        try
        {
            grownCarrot = ImageIO.read (new File ("Images/grownCarrot.png"));
        }
        catch (IOException e)
        {
            System.out.println ("File not found");
        }
        try
        {
            grownRadish = ImageIO.read (new File ("Images/grownRadish.png"));
        }
        catch (IOException e)
        {
            System.out.println ("File not found");
        }
        try
        {
            grownMelon = ImageIO.read (new File ("Images/grownMelon.png"));
        }
        catch (IOException e)
        {
            System.out.println ("File not found");
        }
        try
        {
            grownPumpkin = ImageIO.read (new File ("Images/grownPumpkin.png"));
        }
        catch (IOException e)
        {
            System.out.println ("File not found");
        }
        try
        {
            harvest = ImageIO.read (new File ("Images/harvest.png"));
        }
        catch (IOException e)
        {
            System.out.println ("File not found");
        }
        try
        {
            sickle = ImageIO.read (new File ("Images/sickle.png"));
        }
        catch (IOException e)
        {
            System.out.println ("File not found");
        }
        try
        {
            spump = ImageIO.read (new File ("Images/shoppumpkin.png"));
        }
        catch (IOException e)
        {
            System.out.println ("File not found");
        }
        try
        {
            smel = ImageIO.read (new File ("Images/shopmelon.png"));
        }
        catch (IOException e)
        {
            System.out.println ("File not found");
        }
        try
        {
            srad = ImageIO.read (new File ("Images/shopradish.png"));
        }
        catch (IOException e)
        {
            System.out.println ("File not found");
        }
        try
        {
            scar = ImageIO.read (new File ("Images/shopcarrot.png"));
        }
        catch (IOException e)
        {
            System.out.println ("File not found");
        }
        rain = new ImageIcon(getClass().getResource("Images/rain.gif")); 
        
        //add jpanels to content pane
        content.add (instructionScreen, "Instructions");
        content.add (plotScreen, "Vegetables");
        content.add (farmScreen, "Farm");
        content.add (barnScreen, "Barn");
        content.add (marketScreen, "Market");
        cl.show(content, "Instructions"); //main card
 
        BtnListener btnListener = new BtnListener();
             
        //layout setup of cards
        farmScreen.setLayout (null);
        insets1 = farmScreen.getInsets();
        plotScreen.setLayout (null);
        insets2 = plotScreen.getInsets();
        barnScreen.setLayout (null);
        insets3 = barnScreen.getInsets();
        marketScreen.setLayout (null);
        insets4 = marketScreen.getInsets();
        instructionScreen.setLayout (null);
        insets5 = instructionScreen.getInsets();
        
        //set of buttons for navigation
        JButton startBtn = new JButton ("I understand, start game");
        startBtn.addActionListener (btnListener);
        Dimension size = startBtn.getPreferredSize();
        startBtn.setBounds(700 + insets5.left, 550 + insets5.top, size.width, size.height);
        instructionScreen.add(startBtn);
        
        JButton toPlotBtn = new JButton ("Go to plot");
        toPlotBtn.addActionListener (btnListener);
        Dimension size1 = toPlotBtn.getPreferredSize();
        toPlotBtn.setBounds(400 + insets1.left, 460 + insets1.top, size1.width, size1.height);
        farmScreen.add(toPlotBtn);
        
        JButton toMarketBtn = new JButton ("Go to market");
        toMarketBtn.addActionListener (btnListener);
        Dimension size2 = toMarketBtn.getPreferredSize();
        toMarketBtn.setBounds(775 + insets1.left, 350 + insets1.top, size2.width, size2.height);
        farmScreen.add(toMarketBtn);
        
        JButton toBarnBtn = new JButton ("Go to barn");
        toBarnBtn.addActionListener (btnListener);
        Dimension size3 = toBarnBtn.getPreferredSize();
        toBarnBtn.setBounds(10 + insets1.left, 250 + insets1.top, size3.width, size3.height);
        farmScreen.add(toBarnBtn);
        
        JButton toBarnBtn2 = new JButton ("Go to barn");
        toBarnBtn2.addActionListener (btnListener);
        Dimension size31 = toBarnBtn2.getPreferredSize();
        toBarnBtn2.setBounds(800 + insets3.left, 250 + insets3.top, size31.width, size31.height);
        plotScreen.add(toBarnBtn2);
        
        JButton endDayBtn = new JButton ("End day");
        endDayBtn.addActionListener (btnListener);
        Dimension size4 = endDayBtn.getPreferredSize();
        endDayBtn.setBounds(10 + insets1.left, 550 + insets1.top, size4.width, size4.height);
        farmScreen.add(endDayBtn);
 
        JButton returnBtn2 = new JButton ("Go back to farm");
        returnBtn2.addActionListener (btnListener);
        Dimension size6 = returnBtn2.getPreferredSize();
        returnBtn2.setBounds(10 + insets3.left, 10 + insets3.top, size6.width, size6.height);
        plotScreen.add(returnBtn2);
       
        JButton returnBtn1 = new JButton ("Go back to farm");
        returnBtn1.addActionListener (btnListener);
        Dimension size5 = returnBtn1.getPreferredSize();
        returnBtn1.setBounds(10 + insets2.left, 10 + insets2.top, size5.width, size5.height);
        barnScreen.add(returnBtn1);
        
        JButton returnBtn3 = new JButton ("Go back to farm");
        returnBtn3.addActionListener (btnListener);
        Dimension size7 = returnBtn3.getPreferredSize();
        returnBtn3.setBounds(10 + insets4.left, 10 + insets4.top, size7.width, size7.height);
        marketScreen.add(returnBtn3);
        
        JButton returnBtn4 = new JButton ("Go back to plot");
        returnBtn4.addActionListener (btnListener);
        Dimension size8 = returnBtn4.getPreferredSize();
        returnBtn4.setBounds(150 + insets4.left, 10 + insets4.top, size8.width, size8.height);
        barnScreen.add(returnBtn4);
        
        //JLABELS FOR PLOT INVENTORY
        Font arial = new Font("Arial", Font.BOLD, 14);
        JLabel fertilizerNum = new JLabel ("Left: " + inventory.getFertilizer());
        fertilizerNum.setFont(arial);
        Dimension size9 = fertilizerNum.getPreferredSize();
        fertilizerNum.setBounds(70 + insets2.left, 150 + insets2.top, size9.width, size9.height);
        plotScreen.add(fertilizerNum);
        
        JLabel bugSprayNum = new JLabel ("Left: " + inventory.getBugSpray());
        bugSprayNum.setFont(arial);
        Dimension size10 = bugSprayNum.getPreferredSize();
        bugSprayNum.setBounds(70 + insets2.left, 200 + insets2.top, size10.width, size10.height);
        plotScreen.add(bugSprayNum);
        
        //Market stuff
        JLabel inventoryLabel = new JLabel ("Inventory");
        inventoryLabel.setFont(new Font("Arial", Font.BOLD, 24));
        Dimension size11 = inventoryLabel.getPreferredSize();
        inventoryLabel.setBounds(20 + insets4.left, 400 + insets4.top, size11.width, size11.height);
        marketScreen.add(inventoryLabel);
        
        fertilizerNum2 = new JLabel ("Left: " + inventory.getFertilizer());
        fertilizerNum2.setFont(arial);
        fertilizerNum2.setBounds(70 + insets4.left, 470 + insets4.top, size9.width, size9.height);
        marketScreen.add(fertilizerNum2);
        
        bugSprayNum2 = new JLabel ("Left: " + inventory.getBugSpray());
        bugSprayNum2.setFont(arial);
        bugSprayNum2.setBounds(70 + insets4.left, 520 + insets4.top, size10.width, size10.height);
        marketScreen.add(bugSprayNum2);
        
        carrotNum2 = new JLabel ("Owned: " + inventory.getCarrot());
        carrotNum2.setFont(arial);
        Dimension sizea = carrotNum2.getPreferredSize();
        carrotNum2.setBounds(400 + insets4.left, 155 + insets4.top, sizea.width, sizea.height);
        marketScreen.add(carrotNum2);
        
        radishNum2 = new JLabel ("Owned: " + inventory.getRadish());
        radishNum2.setFont(arial);
        Dimension sizeb = radishNum2.getPreferredSize();
        radishNum2.setBounds(400 + insets4.left, 255 + insets4.top, sizeb.width, sizeb.height);
        marketScreen.add(radishNum2);
        
        melonNum2 = new JLabel ("Owned: " + inventory.getMelon());
        melonNum2.setFont(arial);
        Dimension sizec = melonNum2.getPreferredSize();
        melonNum2.setBounds(400 + insets4.left, 355 + insets4.top, sizec.width, sizec.height);
        marketScreen.add(melonNum2);
        
        pumpkinNum2 = new JLabel ("Owned: " + inventory.getPumpkin());
        pumpkinNum2.setFont(arial);
        Dimension sized =  pumpkinNum2.getPreferredSize();
        pumpkinNum2.setBounds(400 + insets4.left, 455 + insets4.top, sized.width, sized.height);
        marketScreen.add(pumpkinNum2);
        
        moneyNum = new JLabel ("$" + inventory.getMoney());
        moneyNum.setFont (new Font("Arial", Font.BOLD, 24));
        Dimension size12 = moneyNum.getPreferredSize();
        moneyNum.setBounds(97 + insets4.left, 318 + insets4.top, size12.width, size12.height);
        marketScreen.add(moneyNum);
        
        JLabel seedLabel = new JLabel ("Seeds:");
        seedLabel.setFont (new Font("Arial", Font.BOLD, 30));
        Dimension size17 = seedLabel.getPreferredSize();
        seedLabel.setBounds(400 + insets4.left, 10 + insets4.top, size17.width, size17.height);
        marketScreen.add(seedLabel);
        
        JButton buyCarrot = new JButton ("Buy carrot seed $100");
        buyCarrot.addActionListener (btnListener);
        Dimension size13 = buyCarrot.getPreferredSize();
        buyCarrot.setBounds(400 + insets4.left, 100 + insets4.top, size13.width, size13.height);
        marketScreen.add(buyCarrot);
        
        JButton buyRadish = new JButton ("Buy radish seed $200");
        buyRadish.addActionListener (btnListener);
        Dimension size14 = buyRadish.getPreferredSize();
        buyRadish.setBounds(400 + insets4.left, 200 + insets4.top, size14.width, size14.height);
        marketScreen.add(buyRadish);
        
        JButton buyMelon = new JButton ("Buy melon seed $300");
        buyMelon.addActionListener (btnListener);
        Dimension size15 = buyMelon.getPreferredSize();
        buyMelon.setBounds(400 + insets4.left, 300 + insets4.top, size15.width, size15.height);
        marketScreen.add(buyMelon);
        
        JButton buyPumpkin = new JButton ("Buy pumpkin seed $400");
        buyPumpkin.addActionListener (btnListener);
        Dimension size16 = buyPumpkin.getPreferredSize();
        buyPumpkin.setBounds(400 + insets4.left, 400 + insets4.top, size16.width, size16.height);
        marketScreen.add(buyPumpkin);
        
        JLabel miscLabel = new JLabel ("Miscellaneous:");
        miscLabel.setFont (new Font("Arial", Font.BOLD, 30));
        Dimension size18 = miscLabel.getPreferredSize();
        miscLabel.setBounds(650 + insets4.left, 10 + insets4.top, size18.width, size18.height);
        marketScreen.add(miscLabel);
        
        JButton buyFertilizer = new JButton ("Buy fertilizer $200");
        buyFertilizer.addActionListener (btnListener);
        Dimension size19 = buyFertilizer.getPreferredSize();
        buyFertilizer.setBounds(650 + insets4.left, 100 + insets4.top, size19.width, size19.height);
        marketScreen.add(buyFertilizer);
        
        JButton buyBugSpray = new JButton ("Buy bug spray $200");
        buyBugSpray.addActionListener (btnListener);
        Dimension size20 = buyBugSpray.getPreferredSize();
        buyBugSpray.setBounds(650 + insets4.left, 200 + insets4.top, size20.width, size20.height);
        marketScreen.add(buyBugSpray);
        
        //plot buttons
        JButton fertilizeBtn = new JButton ("  ");
        fertilizeBtn.addActionListener (btnListener);
        Dimension size21 = fertilizeBtn.getPreferredSize();
        fertilizeBtn.setBounds(20 + insets2.left, 130 + insets2.top, size21.width, size21.height);
        /*fertilizeBtn.setOpaque(false);
        fertilizeBtn.setContentAreaFilled(false);
        fertilizeBtn.setBorderPainted(false);*/
        plotScreen.add(fertilizeBtn);
        
        JButton sprayBtn = new JButton ("  ");
        sprayBtn.addActionListener (btnListener);
        sprayBtn.setBounds(20 + insets2.left, 190 + insets2.top, size21.width, size21.height);
        /*sprayBtn.setOpaque(false);
        sprayBtn.setContentAreaFilled(false);
        sprayBtn.setBorderPainted(false);*/
        plotScreen.add(sprayBtn);
        
        JButton waterBtn = new JButton ("  ");
        waterBtn.addActionListener (btnListener);
        waterBtn.setBounds(20 + insets2.left, 250 + insets2.top, size21.width, size21.height);
        /*waterBtn.setOpaque(false);
        waterBtn.setContentAreaFilled(false);
        waterBtn.setBorderPainted(false);*/
        plotScreen.add(waterBtn);
        
        //64 planting buttons
        JButton Btn1 = new JButton ("  ");
        Btn1.addActionListener (btnListener);
        Btn1.setBounds(150 + insets2.left, 420 + insets2.top, size21.width, size21.height);
        /*Btn1.setOpaque(false);
        Btn1.setContentAreaFilled(false);
        Btn1.setBorderPainted(false);*/
        plotScreen.add(Btn1);
        
        JButton Btn2 = new JButton ("  ");
        Btn2.addActionListener (btnListener);
        Btn2.setBounds(195 + insets2.left, 420 + insets2.top, size21.width, size21.height);
        /*Btn2.setOpaque(false);
        Btn2.setContentAreaFilled(false);
        Btn2.setBorderPainted(false);*/
        plotScreen.add(Btn2);
        
        JButton Btn3 = new JButton ("  ");
        Btn3.addActionListener (btnListener);
        Btn3.setBounds(240 + insets2.left, 420 + insets2.top, size21.width, size21.height);
        /*Btn3.setOpaque(false);
        Btn3.setContentAreaFilled(false);
        Btn3.setBorderPainted(false);*/
        plotScreen.add(Btn3);
        
        JButton Btn4 = new JButton ("  ");
        Btn4.addActionListener (btnListener);
        Btn4.setBounds(285 + insets2.left, 420 + insets2.top, size21.width, size21.height);
        /*Btn4.setOpaque(false);
        Btn4.setContentAreaFilled(false);
        Btn4.setBorderPainted(false);*/
        plotScreen.add(Btn4);
        
        JButton Btn5 = new JButton ("  ");
        Btn5.addActionListener (btnListener);
        Btn5.setBounds(120 + insets2.left, 450 + insets2.top, size21.width, size21.height);
        /*Btn5.setOpaque(false);
        Btn5.setContentAreaFilled(false);
        Btn5.setBorderPainted(false);*/
        plotScreen.add(Btn5);
        
        JButton Btn6 = new JButton ("  ");
        Btn6.addActionListener (btnListener);
        Btn6.setBounds(165 + insets2.left, 450 + insets2.top, size21.width, size21.height);
        /*Btn6.setOpaque(false);
        Btn6.setContentAreaFilled(false);
        Btn6.setBorderPainted(false);*/
        plotScreen.add(Btn6);
        
        JButton Btn7 = new JButton ("  ");
        Btn7.addActionListener (btnListener);
        Btn7.setBounds(210 + insets2.left, 450 + insets2.top, size21.width, size21.height);
        /*Btn7.setOpaque(false);
        Btn7.setContentAreaFilled(false);
        Btn7.setBorderPainted(false);*/
        plotScreen.add(Btn7);
        
        JButton Btn8 = new JButton ("  ");
        Btn8.addActionListener (btnListener);
        Btn8.setBounds(255 + insets2.left, 450 + insets2.top, size21.width, size21.height);
        /*Btn8.setOpaque(false);
        Btn8.setContentAreaFilled(false);
        Btn8.setBorderPainted(false);*/
        plotScreen.add(Btn8);
        
        JButton Btn9 = new JButton ("  ");
        Btn9.addActionListener (btnListener);
        Btn9.setBounds(90 + insets2.left, 480 + insets2.top, size21.width, size21.height);
        /*Btn9.setOpaque(false);
        Btn9.setContentAreaFilled(false);
        Btn9.setBorderPainted(false);*/
        plotScreen.add(Btn9);
        
        JButton Btn10 = new JButton ("  ");
        Btn10.addActionListener (btnListener);
        Btn10.setBounds(135 + insets2.left, 480 + insets2.top, size21.width, size21.height);
        /*Btn10.setOpaque(false);
        Btn10.setContentAreaFilled(false);
        Btn10.setBorderPainted(false);*/
        plotScreen.add(Btn10);
        
        JButton Btn11 = new JButton ("  ");
        Btn11.addActionListener (btnListener);
        Btn11.setBounds(180 + insets2.left, 480 + insets2.top, size21.width, size21.height);
        /*Btn11.setOpaque(false);
        Btn11.setContentAreaFilled(false);
        Btn11.setBorderPainted(false);*/
        plotScreen.add(Btn11);
        
        JButton Btn12 = new JButton ("  ");
        Btn12.addActionListener (btnListener);
        Btn12.setBounds(225 + insets2.left, 480 + insets2.top, size21.width, size21.height);
        /*Btn12.setOpaque(false);
        Btn12.setContentAreaFilled(false);
        Btn12.setBorderPainted(false);*/
        plotScreen.add(Btn12);
        
        JButton Btn13 = new JButton ("  ");
        Btn13.addActionListener (btnListener);
        Btn13.setBounds(60 + insets2.left, 510 + insets2.top, size21.width, size21.height);
        /*Btn13.setOpaque(false);
        Btn13.setContentAreaFilled(false);
        Btn13.setBorderPainted(false);*/
        plotScreen.add(Btn13);
        
        JButton Btn14 = new JButton ("  ");
        Btn14.addActionListener (btnListener);
        Btn14.setBounds(105 + insets2.left, 510 + insets2.top, size21.width, size21.height);
        /*Btn14.setOpaque(false);
        Btn14.setContentAreaFilled(false);
        Btn14.setBorderPainted(false);*/
        plotScreen.add(Btn14);
        
        JButton Btn15 = new JButton ("  ");
        Btn15.addActionListener (btnListener);
        Btn15.setBounds(150 + insets2.left, 510 + insets2.top, size21.width, size21.height);
        /*Btn15.setOpaque(false);
        Btn15.setContentAreaFilled(false);
        Btn15.setBorderPainted(false);*/
        plotScreen.add(Btn15);
        
        JButton Btn16 = new JButton ("  ");
        Btn16.addActionListener (btnListener);
        Btn16.setBounds(195 + insets2.left, 510 + insets2.top, size21.width, size21.height);
        /*Btn16.setOpaque(false);
        Btn16.setContentAreaFilled(false);
        Btn16.setBorderPainted(false);*/
        plotScreen.add(Btn16);
        
        JButton Btn17 = new JButton ("  ");
        Btn17.addActionListener (btnListener);
        Btn17.setBounds(460 + insets2.left, 420 + insets2.top, size21.width, size21.height);
        /*Btn17.setOpaque(false);
        Btn17.setContentAreaFilled(false);
        Btn17.setBorderPainted(false);*/
        plotScreen.add(Btn17);
        
        JButton Btn18 = new JButton ("  ");
        Btn18.addActionListener (btnListener);
        Btn18.setBounds(505 + insets2.left, 420 + insets2.top, size21.width, size21.height);
        /*Btn18.setOpaque(false);
        Btn18.setContentAreaFilled(false);
        Btn18.setBorderPainted(false);*/
        plotScreen.add(Btn18);
        
        JButton Btn19 = new JButton ("  ");
        Btn19.addActionListener (btnListener);
        Btn19.setBounds(550 + insets2.left, 420 + insets2.top, size21.width, size21.height);
        /*Btn19.setOpaque(false);
        Btn19.setContentAreaFilled(false);
        Btn19.setBorderPainted(false);*/
        plotScreen.add(Btn19);
        
        JButton Btn20 = new JButton ("  ");
        Btn20.addActionListener (btnListener);
        Btn20.setBounds(595 + insets2.left, 420 + insets2.top, size21.width, size21.height);
        /*Btn2.setOpaque(false);
        Btn2.setContentAreaFilled(false);
        Btn2.setBorderPainted(false);*/
        plotScreen.add(Btn20);
        
        JButton Btn21 = new JButton ("  ");
        Btn21.addActionListener (btnListener);
        Btn21.setBounds(430 + insets2.left, 450 + insets2.top, size21.width, size21.height);
        /*Btn21.setOpaque(false);
        Btn21.setContentAreaFilled(false);
        Btn21.setBorderPainted(false);*/
        plotScreen.add(Btn21);
        
        JButton Btn22 = new JButton ("  ");
        Btn22.addActionListener (btnListener);
        Btn22.setBounds(475 + insets2.left, 450 + insets2.top, size21.width, size21.height);
        /*Btn22.setOpaque(false);
        Btn22.setContentAreaFilled(false);
        Btn22.setBorderPainted(false);*/
        plotScreen.add(Btn22);
        
        JButton Btn23 = new JButton ("  ");
        Btn23.addActionListener (btnListener);
        Btn23.setBounds(520 + insets2.left, 450 + insets2.top, size21.width, size21.height);
        /*Btn23.setOpaque(false);
        Btn23.setContentAreaFilled(false);
        Btn23.setBorderPainted(false);*/
        plotScreen.add(Btn23);
        
        JButton Btn24 = new JButton ("  ");
        Btn24.addActionListener (btnListener);
        Btn24.setBounds(565 + insets2.left, 450 + insets2.top, size21.width, size21.height);
        /*Btn24.setOpaque(false);
        Btn24.setContentAreaFilled(false);
        Btn24.setBorderPainted(false);*/
        plotScreen.add(Btn24);
        
        JButton Btn25 = new JButton ("  ");
        Btn25.addActionListener (btnListener);
        Btn25.setBounds(400 + insets2.left, 480 + insets2.top, size21.width, size21.height);
        /*Btn25.setOpaque(false);
        Btn25.setContentAreaFilled(false);
        Btn25.setBorderPainted(false);*/
        plotScreen.add(Btn25);
        
        JButton Btn26 = new JButton ("  ");
        Btn26.addActionListener (btnListener);
        Btn26.setBounds(445 + insets2.left, 480 + insets2.top, size21.width, size21.height);
        /*Btn26.setOpaque(false);
        Btn26.setContentAreaFilled(false);
        Btn26.setBorderPainted(false);*/
        plotScreen.add(Btn26);
        
        JButton Btn27 = new JButton ("  ");
        Btn27.addActionListener (btnListener);
        Btn27.setBounds(490 + insets2.left, 480 + insets2.top, size21.width, size21.height);
        /*Btn27.setOpaque(false);
        Btn27.setContentAreaFilled(false);
        Btn27.setBorderPainted(false);*/
        plotScreen.add(Btn27);
        
        JButton Btn28 = new JButton ("  ");
        Btn28.addActionListener (btnListener);
        Btn28.setBounds(535 + insets2.left, 480 + insets2.top, size21.width, size21.height);
        /*Btn28.setOpaque(false);
        Btn28.setContentAreaFilled(false);
        Btn28.setBorderPainted(false);*/
        plotScreen.add(Btn28);
        
        JButton Btn29 = new JButton ("  ");
        Btn29.addActionListener (btnListener);
        Btn29.setBounds(370 + insets2.left, 510 + insets2.top, size21.width, size21.height);
        /*Btn29.setOpaque(false);
        Btn29.setContentAreaFilled(false);
        Btn29.setBorderPainted(false);*/
        plotScreen.add(Btn29);
        
        JButton Btn30 = new JButton ("  ");
        Btn30.addActionListener (btnListener);
        Btn30.setBounds(415 + insets2.left, 510 + insets2.top, size21.width, size21.height);
        /*Btn30.setOpaque(false);
        Btn30.setContentAreaFilled(false);
        Btn30.setBorderPainted(false);*/
        plotScreen.add(Btn30);
        
        JButton Btn31 = new JButton ("  ");
        Btn31.addActionListener (btnListener);
        Btn31.setBounds(460 + insets2.left, 510 + insets2.top, size21.width, size21.height);
        /*Btn31.setOpaque(false);
        Btn31.setContentAreaFilled(false);
        Btn31.setBorderPainted(false);*/
        plotScreen.add(Btn31);
        
        JButton Btn32 = new JButton ("  ");
        Btn32.addActionListener (btnListener);
        Btn32.setBounds(505 + insets2.left, 510 + insets2.top, size21.width, size21.height);
        /*Btn32.setOpaque(false);
        Btn32.setContentAreaFilled(false);
        Btn32.setBorderPainted(false);*/
        plotScreen.add(Btn32);
        
        JButton Btn33 = new JButton ("  ");
        Btn33.addActionListener (btnListener);
        Btn33.setBounds(260 + insets2.left, 280 + insets2.top, size21.width, size21.height);
        /*Btn33.setOpaque(false);
        Btn33.setContentAreaFilled(false);
        Btn33.setBorderPainted(false);*/
        plotScreen.add(Btn33);
        
        JButton Btn34 = new JButton ("  ");
        Btn34.addActionListener (btnListener);
        Btn34.setBounds(305 + insets2.left, 280 + insets2.top, size21.width, size21.height);
        /*Btn34.setOpaque(false);
        Btn34.setContentAreaFilled(false);
        Btn34.setBorderPainted(false);*/
        plotScreen.add(Btn34);
        
        JButton Btn35 = new JButton ("  ");
        Btn35.addActionListener (btnListener);
        Btn35.setBounds(350 + insets2.left, 280 + insets2.top, size21.width, size21.height);
        /*Btn35.setOpaque(false);
        Btn35.setContentAreaFilled(false);
        Btn35.setBorderPainted(false);*/
        plotScreen.add(Btn35);
        
        JButton Btn36 = new JButton ("  ");
        Btn36.addActionListener (btnListener);
        Btn36.setBounds(395 + insets2.left, 280 + insets2.top, size21.width, size21.height);
        /*Btn36.setOpaque(false);
        Btn36.setContentAreaFilled(false);
        Btn36.setBorderPainted(false);*/
        plotScreen.add(Btn36);
        
        JButton Btn37 = new JButton ("  ");
        Btn37.addActionListener (btnListener);
        Btn37.setBounds(230 + insets2.left, 310 + insets2.top, size21.width, size21.height);
        /*Btn37.setOpaque(false);
        Btn37.setContentAreaFilled(false);
        Btn37.setBorderPainted(false);*/
        plotScreen.add(Btn37);
        
        JButton Btn38 = new JButton ("  ");
        Btn38.addActionListener (btnListener);
        Btn38.setBounds(275 + insets2.left, 310 + insets2.top, size21.width, size21.height);
        /*Btn38.setOpaque(false);
        Btn38.setContentAreaFilled(false);
        Btn38.setBorderPainted(false);*/
        plotScreen.add(Btn38);
        
        JButton Btn39 = new JButton ("  ");
        Btn39.addActionListener (btnListener);
        Btn39.setBounds(325 + insets2.left, 310 + insets2.top, size21.width, size21.height);
        /*Btn39.setOpaque(false);
        Btn39.setContentAreaFilled(false);
        Btn39.setBorderPainted(false);*/
        plotScreen.add(Btn39);
        
        JButton Btn40 = new JButton ("  ");
        Btn40.addActionListener (btnListener);
        Btn40.setBounds(370 + insets2.left, 310 + insets2.top, size21.width, size21.height);
        /*Btn40.setOpaque(false);
        Btn40.setContentAreaFilled(false);
        Btn40.setBorderPainted(false);*/
        plotScreen.add(Btn40);
        
        JButton Btn41 = new JButton ("  ");
        Btn41.addActionListener (btnListener);
        Btn41.setBounds(200 + insets2.left, 340 + insets2.top, size21.width, size21.height);
        /*Btn41.setOpaque(false);
        Btn41.setContentAreaFilled(false);
        Btn41.setBorderPainted(false);*/
        plotScreen.add(Btn41);
        
        JButton Btn42 = new JButton ("  ");
        Btn42.addActionListener (btnListener);
        Btn42.setBounds(245 + insets2.left, 340 + insets2.top, size21.width, size21.height);
        /*Btn42.setOpaque(false);
        Btn42.setContentAreaFilled(false);
        Btn42.setBorderPainted(false);*/
        plotScreen.add(Btn42);
        
        JButton Btn43 = new JButton ("  ");
        Btn43.addActionListener (btnListener);
        Btn43.setBounds(290 + insets2.left, 340 + insets2.top, size21.width, size21.height);
        /*Btn43.setOpaque(false);
        Btn43.setContentAreaFilled(false);
        Btn43.setBorderPainted(false);*/
        plotScreen.add(Btn43);
        
        JButton Btn44 = new JButton ("  ");
        Btn44.addActionListener (btnListener);
        Btn44.setBounds(335 + insets2.left, 340 + insets2.top, size21.width, size21.height);
        /*Btn44.setOpaque(false);
        Btn44.setContentAreaFilled(false);
        Btn44.setBorderPainted(false);*/
        plotScreen.add(Btn44);
        
        JButton Btn45 = new JButton ("  ");
        Btn45.addActionListener (btnListener);
        Btn45.setBounds(170 + insets2.left, 370 + insets2.top, size21.width, size21.height);
        /*Btn45.setOpaque(false);
        Btn45.setContentAreaFilled(false);
        Btn45.setBorderPainted(false);*/
        plotScreen.add(Btn45);
        
        JButton Btn46 = new JButton ("  ");
        Btn46.addActionListener (btnListener);
        Btn46.setBounds(215 + insets2.left, 370 + insets2.top, size21.width, size21.height);
        /*Btn46.setOpaque(false);
        Btn46.setContentAreaFilled(false);
        Btn46.setBorderPainted(false);*/
        plotScreen.add(Btn46);
        
        JButton Btn47 = new JButton ("  ");
        Btn47.addActionListener (btnListener);
        Btn47.setBounds(260 + insets2.left, 370 + insets2.top, size21.width, size21.height);
        /*Btn47.setOpaque(false);
        Btn47.setContentAreaFilled(false);
        Btn47.setBorderPainted(false);*/
        plotScreen.add(Btn47);
        
        JButton Btn48 = new JButton ("  ");
        Btn48.addActionListener (btnListener);
        Btn48.setBounds(305 + insets2.left, 370 + insets2.top, size21.width, size21.height);
        /*Btn48.setOpaque(false);
        Btn48.setContentAreaFilled(false);
        Btn48.setBorderPainted(false);*/
        plotScreen.add(Btn48);
                
        JButton Btn49 = new JButton ("  ");
        Btn49.addActionListener (btnListener);
        Btn49.setBounds(580 + insets2.left, 280 + insets2.top, size21.width, size21.height);
        /*Btn49.setOpaque(false);
        Btn49.setContentAreaFilled(false);
        Btn49.setBorderPainted(false);*/
        plotScreen.add(Btn49);
        
        JButton Btn50 = new JButton ("  ");
        Btn50.addActionListener (btnListener);
        Btn50.setBounds(625 + insets2.left, 280+ insets2.top, size21.width, size21.height);
        /*Btn50.setOpaque(false);
        Btn50.setContentAreaFilled(false);
        Btn50.setBorderPainted(false);*/
        plotScreen.add(Btn50);
        
        JButton Btn51 = new JButton ("  ");
        Btn51.addActionListener (btnListener);
        Btn51.setBounds(670 + insets2.left, 280 + insets2.top, size21.width, size21.height);
        /*Btn51.setOpaque(false);
        Btn51.setContentAreaFilled(false);
        Btn51.setBorderPainted(false);*/
        plotScreen.add(Btn51);
        
        JButton Btn52 = new JButton ("  ");
        Btn52.addActionListener (btnListener);
        Btn52.setBounds(715 + insets2.left, 280 + insets2.top, size21.width, size21.height);
        /*Btn52.setOpaque(false);
        Btn52.setContentAreaFilled(false);
        Btn52.setBorderPainted(false);*/
        plotScreen.add(Btn52);
        
        JButton Btn53 = new JButton ("  ");
        Btn53.addActionListener (btnListener);
        Btn53.setBounds(550 + insets2.left, 310 + insets2.top, size21.width, size21.height);
        /*Btn53.setOpaque(false);
        Btn53.setContentAreaFilled(false);
        Btn53.setBorderPainted(false);*/
        plotScreen.add(Btn53);
        
        JButton Btn54 = new JButton ("  ");
        Btn54.addActionListener (btnListener);
        Btn54.setBounds(595 + insets2.left, 310 + insets2.top, size21.width, size21.height);
        /*Btn54.setOpaque(false);
        Btn54.setContentAreaFilled(false);
        Btn54.setBorderPainted(false);*/
        plotScreen.add(Btn54);
        
        JButton Btn55 = new JButton ("  ");
        Btn55.addActionListener (btnListener);
        Btn55.setBounds(640 + insets2.left, 310 + insets2.top, size21.width, size21.height);
        /*Btn55.setOpaque(false);
        Btn55.setContentAreaFilled(false);
        Btn55.setBorderPainted(false);*/
        plotScreen.add(Btn55);
        
        JButton Btn56 = new JButton ("  ");
        Btn56.addActionListener (btnListener);
        Btn56.setBounds(685 + insets2.left, 310 + insets2.top, size21.width, size21.height);
        /*Btn56.setOpaque(false);
        Btn56.setContentAreaFilled(false);
        Btn56.setBorderPainted(false);*/
        plotScreen.add(Btn56);
        
        JButton Btn57 = new JButton ("  ");
        Btn57.addActionListener (btnListener);
        Btn57.setBounds(520 + insets2.left, 340 + insets2.top, size21.width, size21.height);
        /*Btn57.setOpaque(false);
        Btn57.setContentAreaFilled(false);
        Btn57.setBorderPainted(false);*/
        plotScreen.add(Btn57);
        
        JButton Btn58 = new JButton ("  ");
        Btn58.addActionListener (btnListener);
        Btn58.setBounds(565 + insets2.left, 340 + insets2.top, size21.width, size21.height);
        /*Btn58.setOpaque(false);
        Btn58.setContentAreaFilled(false);
        Btn58.setBorderPainted(false);*/
        plotScreen.add(Btn58);
        
        JButton Btn59 = new JButton ("  ");
        Btn59.addActionListener (btnListener);
        Btn59.setBounds(610 + insets2.left, 340 + insets2.top, size21.width, size21.height);
        /*Btn59.setOpaque(false);
        Btn59.setContentAreaFilled(false);
        Btn59.setBorderPainted(false);*/
        plotScreen.add(Btn59);
        
        JButton Btn60 = new JButton ("  ");
        Btn60.addActionListener (btnListener);
        Btn60.setBounds(655 + insets2.left, 340 + insets2.top, size21.width, size21.height);
        /*Btn60.setOpaque(false);
        Btn60.setContentAreaFilled(false);
        Btn60.setBorderPainted(false);*/
        plotScreen.add(Btn60);
        
        JButton Btn61 = new JButton ("  ");
        Btn61.addActionListener (btnListener);
        Btn61.setBounds(490 + insets2.left, 370 + insets2.top, size21.width, size21.height);
        /*Btn61.setOpaque(false);
        Btn61.setContentAreaFilled(false);
        Btn61.setBorderPainted(false);*/
        plotScreen.add(Btn61);
        
        JButton Btn62 = new JButton ("  ");
        Btn62.addActionListener (btnListener);
        Btn62.setBounds(535 + insets2.left, 370 + insets2.top, size21.width, size21.height);
        /*Btn62.setOpaque(false);
        Btn62.setContentAreaFilled(false);
        Btn62.setBorderPainted(false);*/
        plotScreen.add(Btn62);
        
        JButton Btn63 = new JButton ("  ");
        Btn63.addActionListener (btnListener);
        Btn63.setBounds(580 + insets2.left, 370 + insets2.top, size21.width, size21.height);
        /*Btn63.setOpaque(false);
        Btn63.setContentAreaFilled(false);
        Btn63.setBorderPainted(false);*/
        plotScreen.add(Btn63);
        
        JButton Btn64 = new JButton ("  ");
        Btn64.addActionListener (btnListener);
        Btn64.setBounds(625 + insets2.left, 370 + insets2.top, size21.width, size21.height);
        /*Btn64.setOpaque(false);
        Btn64.setContentAreaFilled(false);
        Btn64.setBorderPainted(false);*/
        plotScreen.add(Btn64);
        
        JButton harvestBtn = new JButton ("  ");
        harvestBtn.addActionListener (btnListener);
        harvestBtn.setBounds(20 + insets2.left, 310 + insets2.top, size21.width, size21.height);
        /*harvestBtn.setOpaque(false);
        harvestBtn.setContentAreaFilled(false);
        harvestBtn.setBorderPainted(false);*/
        plotScreen.add(harvestBtn);
        
        JButton cullBtn = new JButton ("  ");
        cullBtn.addActionListener (btnListener);
        cullBtn.setBounds(20 + insets2.left, 370 + insets2.top, size21.width, size21.height);
        /*cullBtn.setOpaque(false);
        cullBtn.setContentAreaFilled(false);
        cullBtn.setBorderPainted(false);*/
        plotScreen.add(cullBtn);
        
        JButton plantCarrot = new JButton ("  ");
        plantCarrot.addActionListener (btnListener);
        plantCarrot.setBounds(650 + insets2.left, 510 + insets2.top, size21.width, size21.height);
        /*plantCarrot.setOpaque(false);
        plantCarrot.setContentAreaFilled(false);
        plantCarrot.setBorderPainted(false);*/
        plotScreen.add(plantCarrot);
        
        JButton plantRadish = new JButton ("  ");
        plantRadish.addActionListener (btnListener);
        plantRadish.setBounds(700 + insets2.left, 510 + insets2.top, size21.width, size21.height);
        /*plantRadish.setOpaque(false);
        plantRadish.setContentAreaFilled(false);
        plantRadish.setBorderPainted(false);*/
        plotScreen.add(plantRadish);
        
        JButton plantMelon = new JButton ("  ");
        plantMelon.addActionListener (btnListener);
        plantMelon.setBounds(750 + insets2.left, 510 + insets2.top, size21.width, size21.height);
        /*plantMelon.setOpaque(false);
        plantMelon.setContentAreaFilled(false);
        plantMelon.setBorderPainted(false);*/
        plotScreen.add(plantMelon);
        
        JButton plantPumpkin = new JButton ("  ");
        plantPumpkin.addActionListener (btnListener);
        plantPumpkin.setBounds(800 + insets2.left, 510 + insets2.top, size21.width, size21.height);
        /*plantPumpkin.setOpaque(false);
        plantPumpkin.setContentAreaFilled(false);
        plantPumpkin.setBorderPainted(false);*/
        plotScreen.add(plantPumpkin);
        
        setContentPane (content);
        pack ();
        setTitle ("FarmTown");
        setSize (1000, 638);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo (null);
    }
    
    class BtnListener implements ActionListener //cardlayout navigation actions
    {
        public void actionPerformed (ActionEvent e)
        {
            if (e.getActionCommand ().equals ("I understand, start game"))
                cl.show(content, "Farm");
            else if (e.getActionCommand ().equals ("Go to plot"))
                cl.show(content, "Vegetables");
            else if (e.getActionCommand ().equals ("Go to barn"))
                cl.show(content, "Barn");
            else if (e.getActionCommand ().equals ("Go to market"))
                cl.show(content, "Market");
            else if (e.getActionCommand ().equals ("Go back to farm"))
                cl.show(content, "Farm");
            else if (e.getActionCommand ().equals ("Go back to plot"))
                cl.show(content, "Vegetables");
            else if (e.getActionCommand ().equals ("End day"))
            {
                dayCount++;
                System.out.print(dayCount);
                rainChance = (int)(Math.random()*5)+1;
            }
            else if (e.getActionCommand ().equals ("Buy fertilizer $200"))
            {
                if (inventory.getMoney() >= 200)
                {
                inventory.buyFertilizer();
                fertilizerNum2.setText("Left: " + inventory.getFertilizer());                             
                inventory.subtractMoney(200);
                moneyNum.setText("$" + inventory.getMoney());
                }
            }
            else if (e.getActionCommand ().equals ("Buy bug spray $200"))
            {
                if (inventory.getMoney() >= 200)
                {
                inventory.buyBugSpray();
                bugSprayNum2.setText("Left: " + inventory.getBugSpray());                             
                inventory.subtractMoney(200);
                moneyNum.setText("$" + inventory.getMoney());
                }
            }
            else if (e.getActionCommand ().equals ("Buy carrot seed $100"))
            {
                if (inventory.getMoney() >= 100)
                {
                inventory.buyCarrot();
                carrotNum2.setText("Owned: " + inventory.getCarrot());                             
                inventory.subtractMoney(100);
                moneyNum.setText("$" + inventory.getMoney());
                }
            }
            else if (e.getActionCommand ().equals ("Buy radish seed $200"))
            {
                if (inventory.getMoney() >= 200)
                {
                inventory.buyRadish();
                radishNum2.setText("Owned: " + inventory.getRadish());                             
                inventory.subtractMoney(200);
                moneyNum.setText("$" + inventory.getMoney());
                }
            }
            else if (e.getActionCommand ().equals ("Buy melon seed $300"))
            {
                if (inventory.getMoney() >= 300)
                {
                inventory.buyMelon();
                melonNum2.setText("Owned: " + inventory.getMelon());                             
                inventory.subtractMoney(300);
                moneyNum.setText("$" + inventory.getMoney());
                }
            }
            else if (e.getActionCommand ().equals ("Buy pumpkin seed $400"))
            {
                if (inventory.getMoney() >= 400)
                {
                inventory.buyPumpkin();
                pumpkinNum2.setText("Owned: " + inventory.getPumpkin());                             
                inventory.subtractMoney(400);
                moneyNum.setText("$" + inventory.getMoney());
                }
            }
                
            repaint();
        }
    }
    
    class DrawBackground extends JPanel //farm jpanel
    {
        String back;
        public DrawBackground (int width, int height, String b)
        {
            this.setPreferredSize (new Dimension (width, height));
            back = b;
        }
        
        public void paintComponent (Graphics g)
        {
            if (back == "farm")
            {
                g.drawImage (Farm, 0, 0, null);
                if (rainChance == 1)
                rain.paintIcon (this, g, 0, 0);
            }
            else if (back == "barn")
            {       
                g.drawImage (Barn, 0, 0, null);
                if (rainChance == 1)
                    rain.paintIcon (this, g, 0, 0);
            }
                
            
            else if (back == "market")
            {
                g.drawImage (Market, 0, 0, null);
                if (rainChance == 1)
                    rain.paintIcon (this, g, 0, 0);
                g.drawImage (Logo, 25, 200, null);
                g.drawImage (fertilizer, 20, 450, null);
                g.drawImage (bugspray, 20, 500, null);
                g.drawImage (cover, 93, 314, null);
                g.drawImage (fertilizer, 700, 145, null);
                g.drawImage (bugspray, 700, 245, null);
                g.drawImage(scar, 500, 140, null);
                g.drawImage(srad, 500, 240, null);
                g.drawImage(smel, 500, 340, null);
                g.drawImage(spump, 500, 440, null);
            }
            else if (back == "instructions")
                g.drawImage (Instructions, 0, 0, null);
        }
    }   
    
    class DrawPlant extends JPanel //plot jpanel
    {
        public DrawPlant (int width, int height)
        {
            this.setPreferredSize (new Dimension (width, height)); // size
        }
 
        public void paintComponent (Graphics g)
        {
            g.drawImage (vegetablePlot, 0, 0, null);
            g.drawImage (fertilizer, 20, 120, null);
            g.drawImage (bugspray, 20, 180, null);
            g.drawImage (watercan, 20, 240, null);
            g.drawImage (harvest, 20, 300, null);
            g.drawImage (sickle, 20, 360, null);
            g.drawImage (grownCarrot, 650, 500, null);
            g.drawImage (grownRadish, 700, 500, null);
            g.drawImage (grownMelon, 750, 500, null);
            g.drawImage (grownPumpkin, 800, 500, null);
            
            melonPlot.show(g);
            pumpkinPlot.show(g);
            carrotPlot.show(g);
            radishPlot.show(g);

            if (rainChance == 1)
                rain.paintIcon (this, g, 0, 0);
        }
    }
    
    public static void main (String[] args)
    {
        Farm window = new Farm ();
        window.setVisible (true);
    }
}
 
 
 
 
