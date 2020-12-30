/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author Microsoft Windows
 */
public class MainController {
    public void showPanel(JPanel panel,JPanel prsPanel){
        JPanel view = new JPanel();
        view = panel;
        prsPanel.removeAll();
        prsPanel.setLayout(new BorderLayout());
        prsPanel.add(view);
        prsPanel.validate();
        prsPanel.repaint();
    }
}
