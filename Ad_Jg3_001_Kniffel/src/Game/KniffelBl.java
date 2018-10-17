/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class KniffelBl
{
    KniffelRow row;
    ArrayList<Dice> dice;
    
    /*
        dataRow.add(new KniffelRow("NurEineser",0));
        dataRow.add(new KniffelRow("NurZweier",1));
        dataRow.add(new KniffelRow("NurDreier",2));
        dataRow.add(new KniffelRow("NurVierer",3));
        dataRow.add(new KniffelRow("NurFuenfer",4));
        dataRow.add(new KniffelRow("NurSechser",5));
        dataRow.add(new KniffelRow("Pasch3",6));
        dataRow.add(new KniffelRow("Pasch4",7));
        dataRow.add(new KniffelRow("FullHouee",8));
        dataRow.add(new KniffelRow("StrasseKlein",9));
        dataRow.add(new KniffelRow("StrasseGroß",10));
        dataRow.add(new KniffelRow("Kniffel",11));
    */
    public void calc(KniffelRow row, ArrayList<Dice> dice)
    {
        this.row = row; 
        this.dice = dice;
        
        int points;
        
        int id = row.getId();
        
        switch(id)
        {
            case 0: points = calcOnlyX(1); break;
            case 1: points = calcOnlyX(2)*2; break;
            case 2: points = calcOnlyX(3)*3; break;
            case 3: points = calcOnlyX(4)*4; break;
            case 4: points = calcOnlyX(5)*5; break;
            case 5: points = calcOnlyX(6)*6; break;
            case 6: points = calcPasch(3); break;
            case 7: points = calcPasch(4); break;
            case 8: points = calcFullHouse(); break;
            case 9: points = calcStreet(true); break;
            case 10: points = calcStreet(false); break;
            case 11: points = calcKniffel(); break;
            default: points = -1;
        }
        
        if(calcKniffel() > 0 && id >= 0 && id < 6)
            KniffelRow.setBonus(KniffelRow.getBonus()+50);
        
        System.out.println("points: "+points);
        row.setPoints(points);
    }
    
    public int calcPasch(int kind)
    {
        int p = 0;
        int c = 0;
         
        for(int i = 0; i < dice.size()-(kind-1); i++)
        {
            c = 0;
            for(int j = i; j < dice.size(); j++)
            {
                if(dice.get(i).getNum() == dice.get(j).getNum())
                    c++;
            }
            
            if(c == kind)
                break;
        }
        System.out.println("###");
        System.out.println(c);
        System.out.println(kind);
        if(c == kind)
        {
            for(int i = 0; i < dice.size(); i++)
            {
                p += dice.get(i).getNum();
            }
        }
        
        System.out.println("here");
        return p;
    }
    
    public int calcOnlyX(int z)
    {
        int count = 0;
        
        for(int i = 0; i < dice.size(); i++)
        {
            if(dice.get(i).getNum() == z)
                count++;
        }
        
        return count;
    }
    
    public int calcStreet(boolean klein)
    {
        int c = 0;
        
                
                for(int i = 0; i < dice.size(); i++)
                {
                    for(int j = i+1; j < dice.size(); j++)
                    {
                        if(dice.get(i).getNum() == dice.get(j).getNum())
                            c++;
                    }
                    
                    if(c>1)
                        break;
                }
                
                
                if(klein)
                {
                    if(c<=1)
                        return 30;
                }
                else
                {
                    if(c < 1)
                        return 40;
                }
                
                return 0;
    }
    
    public int calcKniffel()
    {
      boolean kniffel = true;
      
      for(int i = 0; i < dice.size(); i++)
      {
          if(!(dice.get(0).getNum() == dice.get(i).getNum()))
              kniffel = false;
      }
      
      if(kniffel)
          return 50;
      else
          return 0;
    }
    
    public int calcFullHouse()
    {
        int z1 = dice.get(0).getNum(), z2 = 0;
        int c1=0, c2= 0;
        
        for(int i = 0; i < dice.size(); i++)
        {
            if(dice.get(i).getNum() == z1)
                c1++;
            else if(z2 == 0)
            {
                z2 = dice.get(i).getNum();
                c2++;
            }
            else if(z2 == dice.get(i).getNum())
                c2++;
        }
        
        if(c2 == 2 && c1 == 3 || c2 == 3 && c1 == 2)
            return 25;
        return 0;
    }
    
    public int getSumOben()
    {
        int sum = 0;
        
        for(int i = 0; i < 5; i++)
        {
            sum += dice.get(i).getNum();
        }
        
        return sum;
    }
    
    public int getSumUnten()
    {
        int sum = 0;
        
        for(int i = 6; i < 12; i++)
        {
            sum += dice.get(i).getNum();
        }
        
        return sum;
    }
    
    public int  getSumBonusOben()
    {
        if(getSumOben() > 63)
            return 35;
        return 0;
    }
    
    public int getSum()
    {
        int sum = 0;
        
        sum += getSumOben();
        sum += getSumUnten();
        sum+= getSumBonusOben();
        sum+= KniffelRow.getBonus();
        
        return sum;
    }
         
}

