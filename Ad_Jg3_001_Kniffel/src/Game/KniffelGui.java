package Game;

import javax.swing.JOptionPane;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class KniffelGui extends javax.swing.JFrame
{

    private int rerollCount = 0;
    
    public KniffelGui()
    {
        initComponents();
        taCube.setRowHeight(84);
        taCube.setModel(diceBl);
        taCard.setModel(kniffelModel);
        taCube.setDefaultRenderer(Object.class, new DiceTableRenderer());
        taCard.setDefaultRenderer(Object.class, new KniffelTableRenderer());
        
    }

    private DiceTableModel diceBl = new DiceTableModel();
    private KniffelTableModel kniffelModel = new KniffelTableModel();
    private KniffelBl kniffelBl = new KniffelBl();
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        plO = new javax.swing.JPanel();
        taCube = new javax.swing.JTable();
        btPlay = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taCard = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfSummeOben = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfBonusOben = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfSummeUnten = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfPunkteGes = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        plO.setMaximumSize(new java.awt.Dimension(500, 500));
        plO.setPreferredSize(new java.awt.Dimension(73, 150));
        plO.setLayout(new java.awt.GridLayout(2, 1));

        taCube.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String []
            {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        taCube.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                onClickedCube(evt);
            }
        });
        plO.add(taCube);

        btPlay.setText("würfeln");
        btPlay.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btPlayActionPerformed(evt);
            }
        });
        plO.add(btPlay);

        getContentPane().add(plO, java.awt.BorderLayout.PAGE_START);

        jPanel6.setMaximumSize(new java.awt.Dimension(500, 500));
        jPanel6.setPreferredSize(new java.awt.Dimension(450, 400));
        jPanel6.setLayout(new java.awt.GridLayout(2, 1));

        jPanel4.setLayout(new java.awt.BorderLayout());

        taCard.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String []
            {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        taCard.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                onClickCard(evt);
            }
        });
        jScrollPane2.setViewportView(taCard);

        jPanel4.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel6.add(jPanel4);

        jPanel3.setLayout(new java.awt.GridLayout(4, 2));

        jLabel1.setText("Obere Summe: ");
        jPanel3.add(jLabel1);

        tfSummeOben.setEditable(false);
        jPanel3.add(tfSummeOben);

        jLabel2.setText("Oberer Bonus: ");
        jPanel3.add(jLabel2);

        tfBonusOben.setEditable(false);
        jPanel3.add(tfBonusOben);

        jLabel3.setText("Untere Summe: ");
        jPanel3.add(jLabel3);

        tfSummeUnten.setEditable(false);
        jPanel3.add(tfSummeUnten);

        jLabel4.setText("Gesamt-Punkte");
        jPanel3.add(jLabel4);

        tfPunkteGes.setEditable(false);
        jPanel3.add(tfPunkteGes);

        jPanel6.add(jPanel3);

        getContentPane().add(jPanel6, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btPlayActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btPlayActionPerformed
    {//GEN-HEADEREND:event_btPlayActionPerformed
        
        if(rerollCount < 3)
        {
            taCube.clearSelection();
            diceBl.reroll();
            rerollCount++;

            System.out.println(taCube.getSelectedColumn());
            System.out.println(taCube.getSelectedRow());
        }
        else
            JOptionPane.showMessageDialog(null, "Bitte wähle zuerst ein Feld aus","Information",1);
        
    }//GEN-LAST:event_btPlayActionPerformed

    private void onClickedCube(java.awt.event.MouseEvent evt)//GEN-FIRST:event_onClickedCube
    {//GEN-HEADEREND:event_onClickedCube
        taCube.clearSelection();
        
    }//GEN-LAST:event_onClickedCube

    private void onClickCard(java.awt.event.MouseEvent evt)//GEN-FIRST:event_onClickCard
    {//GEN-HEADEREND:event_onClickCard
        KniffelRow r = (KniffelRow) kniffelModel.getValueAt(taCard.getSelectedRow(), taCard.getSelectedColumn());
        System.out.println(r.isUsed());
        
        if(!r.isUsed())
        {
            kniffelBl.calc(((KniffelRow) kniffelModel.getValueAt(taCard.getSelectedRow(), 0)),diceBl.getDice());
            r.setUsed(true);
            
            kniffelModel.update(taCard.getSelectedRow());
            tfBonusOben.setText(""+kniffelBl.getSumBonusOben());
            tfSummeOben.setText(""+kniffelBl.getSumOben());
            tfSummeUnten.setText(""+kniffelBl.getSumUnten());
            tfPunkteGes.setText(""+kniffelBl.getSum());
            rerollCount  = 0;
        }
    }//GEN-LAST:event_onClickCard

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(KniffelGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(KniffelGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(KniffelGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(KniffelGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new KniffelGui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btPlay;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel plO;
    private javax.swing.JTable taCard;
    private javax.swing.JTable taCube;
    private javax.swing.JTextField tfBonusOben;
    private javax.swing.JTextField tfPunkteGes;
    private javax.swing.JTextField tfSummeOben;
    private javax.swing.JTextField tfSummeUnten;
    // End of variables declaration//GEN-END:variables
}
