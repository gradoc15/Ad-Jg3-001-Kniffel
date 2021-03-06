/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author User
 */
public class KniffelTableModel extends AbstractTableModel
{
    private ArrayList<KniffelRow> dataRow = new ArrayList();
    private final String[] COLNMNAME = {"Spiel","Wahl","Punkte"};
    
    public KniffelTableModel()
    {
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
        
    }
    
    public void update(int row)
    {
        fireTableRowsUpdated(row, row);
    }

    @Override
    public int getRowCount()
    {
        return dataRow.size();
    }

    @Override
    public int getColumnCount()
    {
        return COLNMNAME.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        return dataRow.get(rowIndex);
    }
    
    @Override
    public String getColumnName(int col)
    {
        return COLNMNAME[col];
    }
    
    public int getSumO()
    {
        int sum = 0;
        
        for(int i = 0; i < 6; i++)
        {
            sum += dataRow.get(i).getPoints();
        }
        
        return sum;
    }
    
    public int getSumU()
    {
        int sum = 0;
        
        for(int i = 6; i < dataRow.size(); i++)
        {
            sum+= dataRow.get(i).getPoints();
        }
        
        return sum;
    }
    
    public int getBonus()
    {
        if(getSumO() > 63)
            return 35;
        else
            return 0;
    }
    
    public int getSum()
    {
        return getBonus()+getSumO()+getSumU();
    }
    
    
    public boolean isUseAbleRow()
    {
        boolean useAble = false;
        
        for(KniffelRow row : dataRow)
        {
            if(!row.isUsed())
                useAble = true;
            
            if(useAble)
                break;
        }
        
        return useAble;
    }
    
}
