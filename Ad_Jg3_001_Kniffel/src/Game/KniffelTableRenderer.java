package Game;

import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class KniffelTableRenderer implements TableCellRenderer
{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
        KniffelRow r = (KniffelRow) value;
        JLabel l = new JLabel();
        JCheckBox cb = new JCheckBox();
        
        if(table.getSelectedColumn() == 1 && isSelected)
        {
            r.setUsed(true);
        }
        
        if(column == 0)
            l.setText(r.getBez());
        else if(column == 1)
            cb.setSelected(r.isUsed());
        else if(column == 2)
            l.setText(""+r.getPoints());
        
        
            
        
        return column == 1 ? cb : l;
    }
    
}
