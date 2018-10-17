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
        dataRow.add(new KniffelRow("NurEineser"));
        dataRow.add(new KniffelRow("NurZweier"));
        dataRow.add(new KniffelRow("NurDreier"));
        dataRow.add(new KniffelRow("NurVierer"));
        dataRow.add(new KniffelRow("NurFuenfer"));
        dataRow.add(new KniffelRow("NurSechser"));
        dataRow.add(new KniffelRow("Pasch3"));
        dataRow.add(new KniffelRow("Pasch4"));
        dataRow.add(new KniffelRow("FullHouee"));
        dataRow.add(new KniffelRow("StrasseKlein"));
        dataRow.add(new KniffelRow("StrasseGroß"));
        dataRow.add(new KniffelRow("Kniffel"));
        
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
    
}
