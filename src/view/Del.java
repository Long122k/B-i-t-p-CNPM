/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import controller.DelController;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ChildModel;

/**
 *
 * @author Microsoft Windows
 */
public class Del extends javax.swing.JPanel {
    DefaultTableModel model;
    
    DelController controller;
    ArrayList<ChildModel> list;
    /** Creates new form Home */
    public Del() throws SQLException, ClassNotFoundException {
        initComponents();
        model = (DefaultTableModel) DelTb.getModel();
        model.setColumnIdentifiers(new Object[]{"STT","ID","Tên trẻ","Ngày sinh","Giới tính","Phụ huynh","Địa chỉ","Trường","Lớp","Học lực","Trạng thái"});
        list = new DelController().getList();
        controller = new DelController();
        controller.CreatAll(list, model);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DelTb = new javax.swing.JTable();
        BtnClr = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("CHỌN THÔNG TIN CẦN XÓA:");

        DelTb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(DelTb);

        BtnClr.setText("Xóa");
        BtnClr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnClrActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel1)
                        .addGap(66, 66, 66)
                        .addComponent(BtnClr)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(BtnClr))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BtnClrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnClrActionPerformed
        // TODO add your handling code here:
        int  change = DelTb.getSelectedRow();
        if (change == -1) 
        { JOptionPane.showMessageDialog(null,"Chọn 1 dòng để nhấn");}
         else if (JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn Xóa ?","Comfirm",JOptionPane.YES_NO_OPTION) == 0) {
            controller = new DelController();
            try {
                if (controller.delChild(list.get(change))) {
                    JOptionPane.showMessageDialog(null, "Xóa thành công!!");                    
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "Có lỗi xảy ra. Vui long kiểm tra lại!!", "Warning", JOptionPane.WARNING_MESSAGE);
            }
            try {
                list = new DelController().getList();
            } catch (SQLException ex) {
                Logger.getLogger(Del.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Del.class.getName()).log(Level.SEVERE, null, ex);
            }
            controller.CreatAll(list, model);}
    }//GEN-LAST:event_BtnClrActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnClr;
    private javax.swing.JTable DelTb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}