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
            case 6: points = calcPasch(3); break;
            case 7: points = calcPasch(4); break;
            default: points = -1;
        }
        
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
    
//    public int calcOnlyX()
//    {
//        
//    }
//    
//    public int calcStreet()
//    {
//        
//    }
//    
//    public int calcKniffel()
//    {
//        
//    }
//    
//    public int calcFullHouse()
//    {
//        
//    }
         
}
