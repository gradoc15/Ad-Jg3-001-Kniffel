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
    String bez;
    boolean used = false;
    int points = 0;

    public KniffelRow(String bez)
    {
        this.bez = bez;
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

    
}
