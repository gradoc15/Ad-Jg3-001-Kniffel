/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.util.Random;

/**
 *
 * @author User
 */
public class Dice
{
    Random rand = new Random();
    
    private int coll;
    private int num = -1;
    private boolean selected = false;
    
    public Dice(int coll)
    {
        this.coll = coll;
    }

    public int getColl()
    {
        return coll;
    }

    public void setColl(int coll)
    {
        this.coll = coll;
    }

    
    public int getNum()
    {
        return num;
    }

    public void setNum(int num)
    {
        this.num = num;
    }

    public boolean isSelected()
    {
        return selected;
    }

    public void setSelected(boolean selected)
    {
        this.selected = selected;
    }
    
    public void reroll()
    {
        if(!selected)
          num = rand.nextInt(6)+1;
    }
}
