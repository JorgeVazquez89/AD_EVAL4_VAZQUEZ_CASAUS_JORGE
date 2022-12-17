package controller;

import classes.User;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import resources.style.Style;

/**
 * LoadPanels Class.
 *
 * Class that load all the panels of the APP.
 *
 * @author Jorge Vázquez Casaus.
 * @version 1.0.
 * @see AddProductsPanel
 * @see AvabibleProductsPanel
 * @see BuyProductsPanel
 * @see DashBoard
 * @see LoginPanel
 * @see ModifyProductsPanel
 * @see RegisterPanel
 * @since 16/12/2022.
 */
public class LoadPanels {

    private JPanel workPanel;

    /**
     * Creates, load an paint all GUI panels into DashBoard workPanel.
     *
     * @param workPanel Workpanel of GUI.
     */
    public LoadPanels(JPanel workPanel) {
        this.workPanel = workPanel;
    }

    /**
     * Creates, load an paint LoginPanel as Main GUI into DashBoard workPanel.
     * LoadLoginPanel class Constructor.
     */
    public void loadLoginPanel() {
        LoginPanel loginPanel = new LoginPanel(this.workPanel);
        loginPanel.setSize(Style.LOGIN_REGISTER_PANEL_WIDTH, Style.WORK_PANEL_HEIGHT);
        loginPanel.setLocation(Style.DEFAULT_COORD, Style.DEFAULT_COORD);
        workPanel.removeAll();
        workPanel.add(loginPanel, BorderLayout.CENTER);
        workPanel.revalidate();
        workPanel.repaint();
    }

    /**
     * Creates, load an paint RegisterPanel as Main GUI into DashBoard
     * workPanel.
     */
    public void loadRegisterPanel() {
        RegisterPanel registerPanel = new RegisterPanel(this.workPanel);
        registerPanel.setSize(Style.LOGIN_REGISTER_PANEL_WIDTH, Style.WORK_PANEL_HEIGHT);
        registerPanel.setLocation(Style.DEFAULT_COORD, Style.DEFAULT_COORD);
        workPanel.removeAll();
        workPanel.add(registerPanel, BorderLayout.CENTER);
        workPanel.revalidate();
        workPanel.repaint();
    }

    /**
     * Creates, load an paint AvabibleProductsPanel as Main GUI into DashBoard
     * workPanel.

     * @param user Its object that references a user row in DB. It matches with
     * the product with the same name.
     */
    public void loadAvabibleProductsPanel(User user) {
        AvabibleProductsPanel avabibleProductsPanel = new AvabibleProductsPanel(this.workPanel, user);
        avabibleProductsPanel.setSize(Style.LOGIN_REGISTER_PANEL_WIDTH, Style.WORK_PANEL_HEIGHT);
        avabibleProductsPanel.setLocation(Style.DEFAULT_COORD, Style.DEFAULT_COORD);
        workPanel.removeAll();
        workPanel.add(avabibleProductsPanel, BorderLayout.CENTER);
        workPanel.revalidate();
        workPanel.repaint();
    }

    /**
     * Creates, load an paint AddproductsPanel as Main GUI into DashBoard
     * workPanel.
     * 
     * @param user Its object that references a user row in DB. It matches with
     * the product with the same name.
     */
    public void loadAddProductsPanel(User user) {
        AddProductsPanel addproductsPanel = new AddProductsPanel(this.workPanel, user);
        addproductsPanel.setSize(Style.LOGIN_REGISTER_PANEL_WIDTH, Style.WORK_PANEL_HEIGHT);
        addproductsPanel.setLocation(Style.DEFAULT_COORD, Style.DEFAULT_COORD);
        workPanel.removeAll();
        workPanel.add(addproductsPanel, BorderLayout.CENTER);
        workPanel.revalidate();
        workPanel.repaint();
    }

    /**
     * Creates, load an paint ModifyProductsPanel as Main GUI into DashBoard
     * workPanel.
     * 
     * @param user Its object that references a user row in DB. It matches with
     * the product with the same name.
     */
    public void loadModifyProductsPanel(User user) {
        ModifyProductsPanel modifyProductsPanel = new ModifyProductsPanel(this.workPanel, user);
        modifyProductsPanel.setSize(Style.LOGIN_REGISTER_PANEL_WIDTH, Style.WORK_PANEL_HEIGHT);
        modifyProductsPanel.setLocation(Style.DEFAULT_COORD, Style.DEFAULT_COORD);
        workPanel.removeAll();
        workPanel.add(modifyProductsPanel, BorderLayout.CENTER);
        workPanel.revalidate();
        workPanel.repaint();
    }

    /**
     * Creates, load an paint BuyProductsPanel as Main GUI into DashBoard
     * workPanel.
     * 
     * @param user Its object that references a user row in DB. It matches with
     * the product with the same name.
     */
    public void loadBuyProductsPanel(User user) {
        BuyProductsPanel buyProductsPanel = new BuyProductsPanel(this.workPanel, user);
        buyProductsPanel.setSize(Style.LOGIN_REGISTER_PANEL_WIDTH, Style.WORK_PANEL_HEIGHT);
        buyProductsPanel.setLocation(Style.DEFAULT_COORD, Style.DEFAULT_COORD);
        workPanel.removeAll();
        workPanel.add(buyProductsPanel, BorderLayout.CENTER);
        workPanel.revalidate();
        workPanel.repaint();
    }
}
