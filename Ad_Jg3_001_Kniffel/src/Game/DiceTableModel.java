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
public class DiceTableModel extends AbstractTableModel
{
    private ArrayList<Dice> diceData = new ArrayList();
    
    public DiceTableModel()
    {
        for(int i = 0; i < 5; i++)
        {
            diceData.add(new Dice(i));
        }
        
        reroll();
    }
    
    public void reroll()
    {
        for(Dice d: diceData)
        {
            d.reroll();
        }
        
        fireTableRowsUpdated(0, 0);
    }

    @Override
    public int getRowCount()
    {
        return 1;
    }

    @Override
    public int getColumnCount()
    {
        return diceData.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        return diceData.get(columnIndex);
    }
    
}
