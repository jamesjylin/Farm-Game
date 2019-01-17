import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.imageio.*;
import java.io.*;

class Plot //array of plants
{
    private Seedling plot[];
    private Seedling seed;
    public Plot(Seedling s)
    {
        seed = s;
        plot = new Seedling [16];
        if (seed instanceof Carrot)
        {
            for (int x = 0; x < 16; x++)
            {
                plot[x] = new Carrot();
            }
        }  
        else if (seed instanceof Radish)
        {
            for (int x = 0; x < 16; x++)
            {
                plot[x] = new Radish();
            }
        }
        else if (seed instanceof Melon)
        {
            for (int x = 0; x < 16; x++)
            {
                plot[x] = new Seedling();
            }
        }
        else if (seed instanceof Pumpkin)
        {
            for (int x = 0; x < 16; x++)
            {
                plot[x] = new Seedling();
            }
        }
    }
    
    public void show (Graphics g) //draw array of plants
    {
        if (seed instanceof Carrot)
        {
            for (int x = 0; x < 16; x++)
            {
                plot[x].show (g, x % 4 * 50 + 170, x / 4 * 30 + 390);
            }
        }
        else if (seed instanceof Radish)
        {
            for (int x = 0; x < 16; x++)
            {
                plot[x].show (g, x % 4 * 50 + 470, x / 4 * 30 + 190);
            }
        }
        else if (seed instanceof Melon)
        {
            for (int x = 0; x < 16; x++)
            {
                plot[x].show (g, x % 4 * 50 + 170, x / 4 * 30 + 190);
            }
        }
        else if (seed instanceof Pumpkin)
        {
            for (int x = 0; x < 16; x++)
            {
                plot[x].show (g, x % 4 * 50 + 470, x / 4 * 30 + 390);
            }
        }
    }
}