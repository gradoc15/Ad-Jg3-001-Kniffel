/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

/**
 *
 * @author User
 */
public class KniffelRow
{
    private static int bonus;

    
    private String bez;
    private boolean used = false;
    private int points = 0;
    private int id;

    public KniffelRow(String bez, int id)
    {
        this.bez = bez;
        this.id = id;
    }

    public int getId()
    {
        return id;
    }

    
    public String getBez()
    {
        return bez;
    }

    public void setBez(String bez)
    {
        this.bez = bez;
    }

    public boolean isUsed()
    {
        return used;
    }

    public void setUsed(boolean used)
    {
        this.used = used;
    }

    public int getPoints()
    {
        return points;
    }

    public void setPoints(int points)
    {
        this.points = points;
    }
    
    
    public static int getBonus()
    {
        return bonus;
    }

    public static void setBonus(int bonus)
    {
        KniffelRow.bonus = bonus;
    }
    
}
