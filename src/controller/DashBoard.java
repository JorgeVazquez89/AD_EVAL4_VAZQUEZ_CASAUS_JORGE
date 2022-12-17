package controller;

import java.awt.Color;
import java.awt.Frame;
import resources.style.Style;

/**
 * DashBoard Class.
 *
 * Class that load the first GUI of the APP.
 *
 * @author Jorge Vázquez Casaus.
 * @version 1.0.
 * @see AddProductsPanel
 * @see AvabibleProductsPanel
 * @see BuyProductsPanel
 * @see LoadPanels
 * @see LoginPanel
 * @see ModifyProductsPanel
 * @see RegisterPanel
 * @since 16/12/2022.
 */
public class DashBoard extends javax.swing.JFrame {

    private int x;
    private int y;

    /**
     * Creates new form DashBoard. DashBoard class Constructor.
     */
    public DashBoard() {
        initComponents();
        setComponents();
        setLoginPanel();

    }

    /**
     * Sets the componets with specific behaviour.
     */
    public void setComponents() {
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
        this.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
    }

    /**
     * Sets Login Panel GUI when start the APP as main panel.
     */
    public void setLoginPanel() {
        LoadPanels loadPanels = new LoadPanels(this.workPanel);
        loadPanels.loadLoginPanel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        appBar = new javax.swing.JPanel();
        minimizeButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        hibernateLogoLabel = new javax.swing.JLabel();
        appBarLabel = new javax.swing.JLabel();
        workPanel = new javax.swing.JPanel();
        mainBackgroundLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        mainPanel.setOpaque(false);
        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        appBar.setOpaque(false);
        appBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        minimizeButton.setBackground(new java.awt.Color(204, 102, 0));
        minimizeButton.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        minimizeButton.setText("-");
        minimizeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimizeButtonActionPerformed(evt);
            }
        });
        appBar.add(minimizeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 10, 50, 30));

        exitButton.setBackground(new java.awt.Color(204, 51, 0));
        exitButton.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        exitButton.setText("X");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        appBar.add(exitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 10, 50, 30));

        hibernateLogoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/icons/hibernate_logo.png"))); // NOI18N
        appBar.add(hibernateLogoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 160, 50));

        appBarLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/layout/app_bar_layout.png"))); // NOI18N
        appBarLabel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                appBarLabelMouseDragged(evt);
            }
        });
        appBarLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                appBarLabelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                appBarLabelMouseReleased(evt);
            }
        });
        appBar.add(appBarLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        mainPanel.add(appBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 50));

        workPanel.setOpaque(false);
        mainPanel.add(workPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1280, 740));

        mainBackgroundLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/layout/dashboard_background.png"))); // NOI18N
        mainPanel.add(mainBackgroundLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 800));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Exit the app.
     *
     * @param evt Default event for Action Performed.
     */
    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

    /**
     * Allows minimze the form.
     *
     * @param evt Default event for Action Performed.
     */
    private void minimizeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimizeButtonActionPerformed
        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_minimizeButtonActionPerformed

    /**
     * Make a hover when clicks in the APP bar. Also, get the axis of the click.
     *
     * @param evt Default event for Mouse Pressed.
     */
    private void appBarLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appBarLabelMousePressed
        x = evt.getX();
        y = evt.getY();
        this.appBarLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(Style.APP_BAR)));
    }//GEN-LAST:event_appBarLabelMousePressed

    /**
     * Allows to move the frame when click and drag the mouse.
     *
     * @param evt Default event for Mouse Dragged.
     */
    private void appBarLabelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appBarLabelMouseDragged
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
        this.appBarLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(Style.APP_BAR_CLICKED)));
    }//GEN-LAST:event_appBarLabelMouseDragged

    /**
     * Recover the original icon of the APP bar when the mouse releasedthe bar.
     *
     * @param evt Default event for Mouse Released.
     */
    private void appBarLabelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appBarLabelMouseReleased
        this.appBarLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(Style.APP_BAR)));
    }//GEN-LAST:event_appBarLabelMouseReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashBoard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel appBar;
    private javax.swing.JLabel appBarLabel;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel hibernateLogoLabel;
    private javax.swing.JLabel mainBackgroundLabel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton minimizeButton;
    private javax.swing.JPanel workPanel;
    // End of variables declaration//GEN-END:variables
}
