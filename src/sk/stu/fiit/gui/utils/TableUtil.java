/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.stu.fiit.gui.utils;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ixenr
 */
public final class TableUtil {
    
    public static void deleteRows(JTable table){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int numRows = table.getSelectedRows().length;
        for(int i = 0; i < numRows; i++) {
            model.removeRow(table.getSelectedRow());
        }
    }
    
    public static boolean assertSingleRowSelected(JTable table){
        int[] selectedRows = table.getSelectedRows();
        
        return selectedRows.length == 1;
    }
    
    public static Object getObjectFromTableSelection(JTable table, int column){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int row_idx = table.getSelectedRow();
        
        return model.getValueAt(row_idx, column);
    }
    
    public static Object getObjectFromTableIndex(JTable table, int row, int column){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        
        return model.getValueAt(row, column);
    }
    
    public static int getTableSelectionIndex(JTable table){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        return table.getSelectedRow();
    }
    
}
