/**
 * 
 */
package ipsTeamwork.util;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * @author Sergio Arroni
 * 
 *         Clase para repintar las celdas de un JTable
 *
 */
public class MiRenderer extends DefaultTableCellRenderer {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
	    int row, int column) {

	if (row % 2 == 0) {
	    setBackground(Color.GREEN);
	    setForeground(Color.BLACK);
	} else {
	    setBackground(Color.RED);
	    setForeground(Color.BLACK);
	}
	if (row == 4) {
	    setBackground(Color.YELLOW);
	    setForeground(Color.BLACK);
	}

	return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }

}