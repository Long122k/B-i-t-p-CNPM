/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Microsoft Windows
 */
public class XoaBang {
    public void clear(DefaultTableModel model){
        int rows = model.getRowCount(); 
        for(int i = rows - 1; i >=0; i--)
        {
           model.removeRow(i); 
        }
    }
}
