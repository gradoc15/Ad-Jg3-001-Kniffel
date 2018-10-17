/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author User
 */
public class DiceTableRenderer implements TableCellRenderer
{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
        Dice d = (Dice) value;
        JLabel l = new JLabel();
        Color bc = l.getBackground();
        l.setOpaque(true);
        
        String str  = this.getClass().getResource("/Images/"+d.getNum()+".png").getPath();
        l.setIcon(new ImageIcon(str));
        
        if(d.getNum() != 0)
        {
            if(isSelected && table.getSelectedColumn() == d.getColl())
            {
                d.setSelected(!d.isSelected());  
            }


            if(d.isSelected())
                l.setBackground(Color.red);
            else
                l.setBackground(bc);

            System.out.println("Dice: "+column+""+d.getColl()+" selected= "+d.isSelected());


            
        }
        return l;
    }
    
    
}
