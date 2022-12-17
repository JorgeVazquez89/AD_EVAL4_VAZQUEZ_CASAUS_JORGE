/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import classes.Product;
import classes.User;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import resources.en_translations.Translations;
import resources.style.Style;
import services.ProductService;

/**
 *
 * @author Kai
 */
public class ModifyProductsPanel extends javax.swing.JPanel {

    private ProductService productService;
    private User user;
    private ArrayList<Product> productList;
    private DefaultTableModel productTableModel;

    /**
     * Creates new form LoginPanel. ModifyProductsPanel class Constructor.
     *
     * @param workPanel WorkPanel, its the work area of the APP.
     * @param user Its object that references a user row in DB. It matches with
     * the product with the same name.
     */
    public ModifyProductsPanel(JPanel workPanel, User user) {
        try {
            this.productService = new ProductService();
        } catch (Exception exception) {
            setErrorLabel();
            this.errorLabel.setText(exception.getMessage());
        }
        this.user = user;
        this.productList = new ArrayList<>();
        initComponents();
        setComponents();
        getAll();
        enableAdminPanel();
        setComboBox();
        print();

    }

    public void setComponents() {
        this.productTableModel = (DefaultTableModel) this.productTable.getModel();
        this.errorLabel.setVisible(false);
        this.successLabel.setVisible(false);
        this.logOutButton.setBorder(BorderFactory.createEmptyBorder());
        this.logOutButton.setOpaque(false);
        this.logOutButton.setContentAreaFilled(false);
        this.logOutButton.setBorderPainted(false);
        this.buyButton.setBorder(BorderFactory.createEmptyBorder());
        this.buyButton.setOpaque(false);
        this.buyButton.setContentAreaFilled(false);
        this.buyButton.setBorderPainted(false);
        this.searchTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        this.searchTextField.setBackground(new java.awt.Color(0, 0, 0, 1));
        this.notLogedYet.setText(Translations.HI_USERNAME_LABEL + this.user.getUserName() + Translations.POINT);
        this.adminPanelLabel.setVisible(false);
        this.adminPanelSepataror.setVisible(false);
        this.addProductButton.setVisible(false);
        this.modifyProductsButton.setVisible(false);
        this.showProductsButton.setVisible(false);
        this.descriptionTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        this.descriptionTextField.setBackground(new java.awt.Color(0, 0, 0, 1));
    }

    public void setErrorLabel() {
        this.errorLabel.setVisible(true);
        this.successLabel.setVisible(false);
    }

    public void setSuccessLabel() {
        this.errorLabel.setVisible(false);
        this.successLabel.setVisible(true);
    }

    public void getAll() {
        try {
            this.productList = this.productService.getAll();
        } catch (Exception exception) {
            setErrorLabel();
            this.errorLabel.setText(exception.getMessage());
        }
    }

    public void clearProductTable() {
        this.productTable.setModel(this.productTableModel);
        productTableModel.setRowCount(0);
    }

    public void print() {
        clearProductTable();
        for (Product product : this.productList) {
            String id = String.valueOf(product.getId());
            String description = product.getDescription();
            String price = String.valueOf(product.getPrice());
            String weight = String.valueOf(product.getWeight());
            String stock = String.valueOf(product.getStock());
            String entryDate = String.valueOf(product.getEntryDate());
            String modificationDate = String.valueOf(product.getModificationDate());
            String[] productData = {id, description, price, weight, stock, entryDate, modificationDate};
            productTableModel.addRow(productData);
        }
    }

    public void enableAdminPanel() {
        if (this.user.getUserName().equals(Translations.ADMIN_USERNAME)) {
            this.adminPanelLabel.setVisible(true);
            this.adminPanelSepataror.setVisible(true);
            this.addProductButton.setVisible(true);
            this.modifyProductsButton.setVisible(true);
            this.showProductsButton.setVisible(true);
        }
    }

    public void setComboBox() {
        if (this.productList.isEmpty()) {
            disableInputItems();
            setErrorLabel();
            this.errorLabel.setText(Translations.EMPTY_PRODUCT_TABLE_EXCEPTION);
            return;
        }
        this.productComboBox.removeAllItems();
        for (Product product : this.productList) {
            String description = product.getDescription();
            this.productComboBox.addItem(description);
        }
    }

    public void disableInputItems() {
        this.productComboBox.setEnabled(false);
        this.descriptionTextField.setEnabled(false);
        this.priceSpinner.setEnabled(false);
        this.weightSpinner.setEnabled(false);
        this.stockSpinner.setEnabled(false);
        this.confirmButton.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        workPanel = new javax.swing.JPanel();
        headerSeparator = new javax.swing.JSeparator();
        headerLabel = new javax.swing.JLabel();
        inputPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();
        componentsPanel = new javax.swing.JPanel();
        descriptionLabel = new javax.swing.JLabel();
        descriptionTextField = new javax.swing.JTextField();
        descriptionSeparator = new javax.swing.JSeparator();
        priceLabel = new javax.swing.JLabel();
        priceSpinner = new javax.swing.JSpinner();
        priceSeparator = new javax.swing.JSeparator();
        weightLabel = new javax.swing.JLabel();
        weightSpinner = new javax.swing.JSpinner();
        weightSeparator = new javax.swing.JSeparator();
        stockLabel = new javax.swing.JLabel();
        stockSpinner = new javax.swing.JSpinner();
        stockSeparator = new javax.swing.JSeparator();
        tipLabel = new javax.swing.JLabel();
        confirmButton = new javax.swing.JButton();
        selectProductLabel = new javax.swing.JLabel();
        productComboBox = new javax.swing.JComboBox<>();
        errorLabel = new javax.swing.JLabel();
        successLabel = new javax.swing.JLabel();
        actionBarPanel = new javax.swing.JPanel();
        searchPanel = new javax.swing.JPanel();
        searchTextField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        searchSeparator = new javax.swing.JSeparator();
        userInfoPanel = new javax.swing.JPanel();
        notLogedYet = new javax.swing.JLabel();
        userNameInfoLabel = new javax.swing.JLabel();
        logOutButton = new javax.swing.JButton();
        buyPanel = new javax.swing.JPanel();
        buyButton = new javax.swing.JButton();
        placeAnOrderLabel = new javax.swing.JLabel();
        adminPanel = new javax.swing.JPanel();
        adminPanelLabel = new javax.swing.JLabel();
        adminPanelSepataror = new javax.swing.JSeparator();
        addProductButton = new javax.swing.JButton();
        modifyProductsButton = new javax.swing.JButton();
        showProductsButton = new javax.swing.JButton();

        setName("mainPanel"); // NOI18N
        setOpaque(false);

        workPanel.setName("workPanel"); // NOI18N
        workPanel.setOpaque(false);
        workPanel.setLayout(null);

        headerSeparator.setBackground(new java.awt.Color(0, 0, 0));
        headerSeparator.setForeground(new java.awt.Color(0, 0, 0));
        workPanel.add(headerSeparator);
        headerSeparator.setBounds(20, 130, 1230, 10);

        headerLabel.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        headerLabel.setForeground(new java.awt.Color(0, 0, 0));
        headerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerLabel.setText("ADMIN PANEL: MODIFY PRODUCTS");
        workPanel.add(headerLabel);
        headerLabel.setBounds(0, 90, 1260, 40);

        inputPanel.setForeground(new java.awt.Color(255, 153, 51));
        inputPanel.setOpaque(false);
        inputPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        productTable.setForeground(new java.awt.Color(0, 0, 0));
        productTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Description", "Price", "Weight", "Stock", "Entry Date", "Modification Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        productTable.setOpaque(false);
        jScrollPane1.setViewportView(productTable);

        inputPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 1240, 250));

        componentsPanel.setOpaque(false);
        componentsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        descriptionLabel.setBackground(new java.awt.Color(0, 0, 0));
        descriptionLabel.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        descriptionLabel.setForeground(new java.awt.Color(0, 0, 0));
        descriptionLabel.setText("Description:");
        componentsPanel.add(descriptionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(392, 68, -1, -1));

        descriptionTextField.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        descriptionTextField.setForeground(new java.awt.Color(153, 153, 153));
        descriptionTextField.setText("Enter here the description of the new product.");
        descriptionTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                descriptionTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                descriptionTextFieldFocusLost(evt);
            }
        });
        componentsPanel.add(descriptionTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(497, 60, 392, -1));
        componentsPanel.add(descriptionSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(497, 92, 392, 10));

        priceLabel.setBackground(new java.awt.Color(0, 0, 0));
        priceLabel.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        priceLabel.setForeground(new java.awt.Color(0, 0, 0));
        priceLabel.setText("Price:");
        componentsPanel.add(priceLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 123, -1, -1));

        priceSpinner.setModel(new javax.swing.SpinnerNumberModel(0.0f, null, 9999.0f, 1.0f));
        componentsPanel.add(priceSpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(409, 120, 89, -1));
        componentsPanel.add(priceSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 152, 145, 10));

        weightLabel.setBackground(new java.awt.Color(0, 0, 0));
        weightLabel.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        weightLabel.setForeground(new java.awt.Color(0, 0, 0));
        weightLabel.setText("Weight:");
        componentsPanel.add(weightLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(525, 123, -1, -1));

        weightSpinner.setModel(new javax.swing.SpinnerNumberModel(0.0f, null, 9999.0f, 1.0f));
        componentsPanel.add(weightSpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(592, 120, 89, -1));
        componentsPanel.add(weightSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(525, 152, 156, 10));

        stockLabel.setBackground(new java.awt.Color(0, 0, 0));
        stockLabel.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        stockLabel.setForeground(new java.awt.Color(0, 0, 0));
        stockLabel.setText("Stock:");
        componentsPanel.add(stockLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(706, 123, -1, -1));

        stockSpinner.setModel(new javax.swing.SpinnerNumberModel(0, null, 9999, 1));
        componentsPanel.add(stockSpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(761, 120, 89, -1));
        componentsPanel.add(stockSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(712, 152, 138, 10));

        tipLabel.setBackground(new java.awt.Color(102, 102, 102));
        tipLabel.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        tipLabel.setForeground(new java.awt.Color(153, 153, 153));
        tipLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tipLabel.setText("* Use the separator \",\" for decimal numbers.");
        componentsPanel.add(tipLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 168, 536, -1));

        confirmButton.setBackground(new java.awt.Color(255, 153, 0));
        confirmButton.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        confirmButton.setForeground(new java.awt.Color(0, 0, 0));
        confirmButton.setText("CONFIRM");
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });
        componentsPanel.add(confirmButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 236, 536, -1));

        selectProductLabel.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        selectProductLabel.setForeground(new java.awt.Color(0, 0, 0));
        selectProductLabel.setText("Select a product:");
        componentsPanel.add(selectProductLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 15, -1, -1));

        componentsPanel.add(productComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(497, 12, 392, -1));

        errorLabel.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        errorLabel.setForeground(new java.awt.Color(204, 0, 0));
        errorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errorLabel.setText("<<ERROR HERE>>");
        componentsPanel.add(errorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 200, 1260, -1));

        successLabel.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        successLabel.setForeground(new java.awt.Color(0, 204, 51));
        successLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        successLabel.setText("Product was modified successfully.");
        componentsPanel.add(successLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 200, 500, 20));

        inputPanel.add(componentsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 1240, 270));

        workPanel.add(inputPanel);
        inputPanel.setBounds(0, 130, 1270, 600);

        actionBarPanel.setBackground(new java.awt.Color(51, 51, 51));
        actionBarPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        actionBarPanel.setName("actionBarPanel"); // NOI18N
        actionBarPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        searchPanel.setOpaque(false);

        searchTextField.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        searchTextField.setForeground(new java.awt.Color(255, 255, 255));
        searchTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        searchTextField.setText("Enter here the product to search.");
        searchTextField.setOpaque(false);

        searchButton.setBackground(new java.awt.Color(255, 153, 0));
        searchButton.setForeground(new java.awt.Color(0, 0, 0));
        searchButton.setText("Search:");
        searchButton.setName("searchButton"); // NOI18N

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchPanelLayout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchSeparator)
                    .addComponent(searchTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(searchButton)
                .addGap(14, 14, 14))
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        actionBarPanel.add(searchPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 1, 460, -1));

        userInfoPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        userInfoPanel.setOpaque(false);
        userInfoPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        notLogedYet.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        notLogedYet.setForeground(new java.awt.Color(255, 255, 255));
        notLogedYet.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        notLogedYet.setText("Hi: Not logged yet.");
        notLogedYet.setName("userNameLabel"); // NOI18N
        userInfoPanel.add(notLogedYet, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 190, 20));

        userNameInfoLabel.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        userNameInfoLabel.setForeground(new java.awt.Color(255, 255, 255));
        userNameInfoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/icons/user_icon_40x40.png"))); // NOI18N
        userNameInfoLabel.setName("userIconLabel"); // NOI18N
        userInfoPanel.add(userNameInfoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 40, 40));

        logOutButton.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        logOutButton.setForeground(new java.awt.Color(255, 153, 0));
        logOutButton.setText("Logout");
        logOutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logOutButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logOutButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                logOutButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                logOutButtonMouseReleased(evt);
            }
        });
        logOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutButtonActionPerformed(evt);
            }
        });
        userInfoPanel.add(logOutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 190, 30));

        actionBarPanel.add(userInfoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 1, 270, -1));

        buyPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        buyPanel.setOpaque(false);
        buyPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/buttons/shopping_car_70x40.png"))); // NOI18N
        buyButton.setName("buyButton"); // NOI18N
        buyButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buyButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buyButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                buyButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                buyButtonMouseReleased(evt);
            }
        });
        buyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyButtonActionPerformed(evt);
            }
        });
        buyPanel.add(buyButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 70, 40));

        placeAnOrderLabel.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        placeAnOrderLabel.setForeground(new java.awt.Color(255, 255, 255));
        placeAnOrderLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        placeAnOrderLabel.setText("Place an order");
        placeAnOrderLabel.setName("placeAnOrderLabel"); // NOI18N
        buyPanel.add(placeAnOrderLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, 130, 20));

        actionBarPanel.add(buyPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 1, -1, 80));

        adminPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        adminPanel.setOpaque(false);
        adminPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        adminPanelLabel.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        adminPanelLabel.setForeground(new java.awt.Color(255, 153, 0));
        adminPanelLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        adminPanelLabel.setText("ADMIN PANEL");
        adminPanel.add(adminPanelLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 420, -1));
        adminPanel.add(adminPanelSepataror, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 400, 10));

        addProductButton.setBackground(new java.awt.Color(255, 153, 0));
        addProductButton.setForeground(new java.awt.Color(0, 0, 0));
        addProductButton.setText("Add Product");
        addProductButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProductButtonActionPerformed(evt);
            }
        });
        adminPanel.add(addProductButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 120, -1));

        modifyProductsButton.setBackground(new java.awt.Color(255, 153, 0));
        modifyProductsButton.setForeground(new java.awt.Color(0, 0, 0));
        modifyProductsButton.setText("Modify Product");
        modifyProductsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyProductsButtonActionPerformed(evt);
            }
        });
        adminPanel.add(modifyProductsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 140, -1));

        showProductsButton.setBackground(new java.awt.Color(255, 153, 0));
        showProductsButton.setForeground(new java.awt.Color(0, 0, 0));
        showProductsButton.setText("Show Products");
        showProductsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showProductsButtonActionPerformed(evt);
            }
        });
        adminPanel.add(showProductsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 120, -1));

        actionBarPanel.add(adminPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 80));

        workPanel.add(actionBarPanel);
        actionBarPanel.setBounds(0, 0, 1270, 83);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(workPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1270, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(workPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void logOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutButtonActionPerformed
        LoadPanels loadPanels = new LoadPanels(this.workPanel);
        loadPanels.loadLoginPanel();
    }//GEN-LAST:event_logOutButtonActionPerformed

    private void logOutButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutButtonMouseEntered
        this.logOutButton.setForeground(Color.decode(Style.SOFT_ORANGE_CODE_COLOR));
    }//GEN-LAST:event_logOutButtonMouseEntered

    private void logOutButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutButtonMouseExited
        this.logOutButton.setForeground(Color.decode(Style.ORANGE_CODE_COLOR));
    }//GEN-LAST:event_logOutButtonMouseExited

    private void logOutButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutButtonMousePressed
        this.logOutButton.setForeground(Color.RED);
    }//GEN-LAST:event_logOutButtonMousePressed

    private void logOutButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutButtonMouseReleased
        this.logOutButton.setForeground(Color.decode(Style.ORANGE_CODE_COLOR));
    }//GEN-LAST:event_logOutButtonMouseReleased

    private void buyButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buyButtonMouseEntered
        buyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(Style.SHOP_HOVER_BUTTON)));
    }//GEN-LAST:event_buyButtonMouseEntered

    private void buyButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buyButtonMouseExited
        buyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(Style.SHOP_BUTTON)));
    }//GEN-LAST:event_buyButtonMouseExited

    private void buyButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buyButtonMousePressed
        buyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(Style.SHOP_CLICKED_BUTTON)));
    }//GEN-LAST:event_buyButtonMousePressed

    private void buyButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buyButtonMouseReleased
        buyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(Style.SHOP_BUTTON)));
    }//GEN-LAST:event_buyButtonMouseReleased

    private void showProductsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showProductsButtonActionPerformed
        LoadPanels loadPanels = new LoadPanels(this.workPanel);
        loadPanels.loadAvabibleProductsPanel(this.user);
    }//GEN-LAST:event_showProductsButtonActionPerformed

    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmButtonActionPerformed
        String description = this.descriptionTextField.getText();
        try {
            this.productService.isCorrectDescriptionField(description);
            float price = (float) this.priceSpinner.getValue();
            float weight = (float) this.weightSpinner.getValue();
            float stock = (int) this.stockSpinner.getValue();
            Product product = (Product) this.productService.findOneByDescription(this.productComboBox.getSelectedItem().toString());
            product = this.productService.updateByDescriptionPriceWeightAndStock(product, description, price, weight, (int) stock);
            this.productService.update(product);
        } catch (Exception exception) {
            setErrorLabel();
            this.errorLabel.setText(exception.getMessage());
            return;
        }
        setSuccessLabel();
        getAll();
        setComboBox();
        print();
    }//GEN-LAST:event_confirmButtonActionPerformed

    private void descriptionTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_descriptionTextFieldFocusGained
        this.descriptionTextField.setText(Translations.EMPTY_STRING);
        this.descriptionTextField.setForeground(Color.BLACK);
    }//GEN-LAST:event_descriptionTextFieldFocusGained

    private void descriptionTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_descriptionTextFieldFocusLost
        if (this.descriptionTextField.getText().equals(Translations.EMPTY_STRING)) {
            this.descriptionTextField.setText(Translations.DEFAULT_DESCRIPTION_TEXT);
            this.descriptionTextField.setForeground(Color.decode(Style.SOFT_GRAY_CODE_COLOR));
        }
    }//GEN-LAST:event_descriptionTextFieldFocusLost

    private void modifyProductsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyProductsButtonActionPerformed
        LoadPanels loadPanels = new LoadPanels(this.workPanel);
        loadPanels.loadModifyProductsPanel(this.user);
    }//GEN-LAST:event_modifyProductsButtonActionPerformed

    private void addProductButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProductButtonActionPerformed
        LoadPanels loadPanels = new LoadPanels(this.workPanel);
        loadPanels.loadAddProductsPanel(this.user);
    }//GEN-LAST:event_addProductButtonActionPerformed

    private void buyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyButtonActionPerformed
        LoadPanels loadPanels = new LoadPanels(this.workPanel);
        loadPanels.loadBuyProductsPanel(user);
    }//GEN-LAST:event_buyButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel actionBarPanel;
    private javax.swing.JButton addProductButton;
    private javax.swing.JPanel adminPanel;
    private javax.swing.JLabel adminPanelLabel;
    private javax.swing.JSeparator adminPanelSepataror;
    private javax.swing.JButton buyButton;
    private javax.swing.JPanel buyPanel;
    private javax.swing.JPanel componentsPanel;
    private javax.swing.JButton confirmButton;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JSeparator descriptionSeparator;
    private javax.swing.JTextField descriptionTextField;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JSeparator headerSeparator;
    private javax.swing.JPanel inputPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logOutButton;
    private javax.swing.JButton modifyProductsButton;
    private javax.swing.JLabel notLogedYet;
    private javax.swing.JLabel placeAnOrderLabel;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JSeparator priceSeparator;
    private javax.swing.JSpinner priceSpinner;
    private javax.swing.JComboBox<String> productComboBox;
    private javax.swing.JTable productTable;
    private javax.swing.JButton searchButton;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JSeparator searchSeparator;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JLabel selectProductLabel;
    private javax.swing.JButton showProductsButton;
    private javax.swing.JLabel stockLabel;
    private javax.swing.JSeparator stockSeparator;
    private javax.swing.JSpinner stockSpinner;
    private javax.swing.JLabel successLabel;
    private javax.swing.JLabel tipLabel;
    private javax.swing.JPanel userInfoPanel;
    private javax.swing.JLabel userNameInfoLabel;
    private javax.swing.JLabel weightLabel;
    private javax.swing.JSeparator weightSeparator;
    private javax.swing.JSpinner weightSpinner;
    private javax.swing.JPanel workPanel;
    // End of variables declaration//GEN-END:variables
}
