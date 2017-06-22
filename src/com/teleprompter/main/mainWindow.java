package com.teleprompter.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by temadk on 22.06.17.
 */
public class mainWindow extends javax.swing.JFrame {

    String filePath = null;
    private JTextArea textArea1;
    private JButton button1;
    private JButton button2;
    private JSlider jSlider1;
    private JScrollPane jScrollPanel;
    private JPanel root;

    public mainWindow() {

        super("Teleprompter");
        setPreferredSize(new Dimension(480, 320));
        setMinimumSize(new Dimension(480, 320));
        pack();
        setLocationRelativeTo(null);
        setContentPane(root);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IOFile open = new IOFile();
                open.openFunc(textArea1, filePath);
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int pnt = 1;
                while(pnt < textArea1.getHeight()){
                    jScrollPanel.getViewport().setViewPosition(new Point(0,pnt));
                    pnt++;
                    try {
                        Thread.sleep(jSlider1.getValue());
                    } catch (InterruptedException ex) {
                        Logger.getLogger(mainWindow.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
    }

    private int CaretPosition(){
        if (textArea1.getCaretPosition() + 1 < textArea1.getDocument().getLength())
            return textArea1.getCaretPosition() + 10;
        else
            return textArea1.getDocument().getLength();

    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainWindow().setVisible(true);
            }
        });
    }
}
