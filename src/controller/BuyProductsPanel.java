package controller;

import classes.Order;
import classes.OrderProduct;
import classes.Product;
import classes.User;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import resources.en_translations.Translations;
import resources.style.Style;
import services.OrderProductService;
import services.OrderService;
import services.ProductService;

/**
 * BuyProductsPanel Class.
 *
 * Class to define the GUI that allow buy products and make an order.
 *
 * @author Jorge Vázquez Casaus.
 * @version 1.0.
 * @see LoadPanels
 * @since 16/12/2022.
 */
public class BuyProductsPanel extends javax.swing.JPanel {

    private ProductService productService;
    private OrderService orderService;
    private OrderProductService orderProductService;
    private User user;
    private ArrayList<Product> productList;
    private HashMap<Product, Integer> buyedProducts;
    private DefaultTableModel productTableModel;
    private DefaultTableModel shoppingTableModel;

    /**
     * Creates new form BuyProductsPanel. 
     * BuyProductsPanel class Constructor.
     *
     * @param workPanel WorkPanel, its the work area of the APP.
     * @param user Its object that references a user row in DB. It matches with
     * the product with the same name.
     */
    public BuyProductsPanel(JPanel workPanel, User user) {
        this.productService = new ProductService();
        this.orderService = new OrderService();
        this.orderProductService = new OrderProductService();
        this.user = user;
        this.productList = new ArrayList<>();
        this.buyedProducts = new HashMap<>();
        initComponents();
        setComponents();
        getAll();
        enableAdminPanel();
        setComboBox();
        printProducts();
    }

    /**
     * Sets the componets with specific behaviour.
     */
    public void setComponents() {
        this.shoppingTableModel = (DefaultTableModel) this.shoppingTable.getModel();
        this.productTableModel = (DefaultTableModel) this.productTable.getModel();
        this.errorLabel.setVisible(false);
        this.successLabel.setVisible(false);
        this.thankYouLabel.setVisible(false);
        this.orderInfoLabel.setVisible(false);
        this.orderLabelSeparator.setVisible(false);
        this.orderIdLabel.setVisible(false);
        this.orderDescriptionLabel.setVisible(false);
        this.orderDateLabel.setVisible(false);
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
    }

    /**
     * Set the label that set an specific error message.
     */
    public void setErrorLabel() {
        this.errorLabel.setVisible(true);
        this.successLabel.setVisible(false);
        this.thankYouLabel.setVisible(false);
        this.orderInfoLabel.setVisible(false);
        this.orderLabelSeparator.setVisible(false);
        this.orderIdLabel.setVisible(false);
        this.orderDescriptionLabel.setVisible(false);
        this.orderDateLabel.setVisible(false);
    }

    /**
     * Set the label that set an specific error message.
     */
    public void setSuccessLabel() {
        this.errorLabel.setVisible(false);
        this.successLabel.setVisible(true);
        this.thankYouLabel.setVisible(true);
        this.orderInfoLabel.setVisible(true);
        this.orderLabelSeparator.setVisible(true);
        this.orderIdLabel.setVisible(true);
        this.orderDescriptionLabel.setVisible(true);
        this.orderDateLabel.setVisible(true);
    }

    /**
     * Set the label that set an specific success message.
     */
    public void getAll() {
        try {
            this.productList = this.productService.getAll();
        } catch (Exception exception) {
            setErrorLabel();
            this.errorLabel.setText(exception.getMessage());
        }
    }

    /*
     * Print the results of products in a table called producTable.
     */
    public void printProducts() {
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
            this.productTableModel.addRow(productData);
        }
    }

    /*
     * Print the results of products in a table called shoppingTable.
     */
    public void printShoppingCart() {
        clearShoppingTable();
        for (Product product : this.buyedProducts.keySet()) {
            String description = String.valueOf(product.getDescription());
            String quantity = String.valueOf(buyedProducts.get(product));
            String[] shoppingCartData = {description, quantity};
            this.shoppingTableModel.addRow(shoppingCartData);
        }
    }

    /**
     * Clear ProductTable and sets the rowcount to 0.
     */
    public void clearProductTable() {
        this.productTableModel.setRowCount(0);
    }

    /**
     * Clear ShoppingTable and sets the rowcount to 0.
     */
    public void clearShoppingTable() {
        this.shoppingTableModel.setRowCount(0);
    }

    /**
     * Clear the list elements of the shopping cart.
     */
    public void clearBuyedProductList() {
        this.buyedProducts.clear();
    }

    /**
     * Allows to enable the admin panel if login was of an admin of the app.
     */
    public void enableAdminPanel() {
        if (this.user.getUserName().equals(Translations.ADMIN_USERNAME)) {
            this.adminPanelLabel.setVisible(true);
            this.adminPanelSepataror.setVisible(true);
            this.addProductButton.setVisible(true);
            this.modifyProductsButton.setVisible(true);
            this.showProductsButton.setVisible(true);
        }
    }

    /**
     * Sets the combobox with avabible the products stored in the DB.
     */
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

    /**
     * Disable all user inputs and dont allow interact with them.
     */
    public void disableInputItems() {
        this.productComboBox.setEnabled(false);
        this.quantitySpinner.setEnabled(false);
        this.confirmButton.setEnabled(false);
        this.addButton.setEnabled(false);
        this.clearButton.setEnabled(false);
    }

    /**
     * Calls orderProductService and try to save a new product in DB.
     *
     * @param orderProductList Is a Set that contains the new objects
     * OrderProduct that will be stored in DB. This OrderProducts are the list
     * of products asociated to an order.
     */
    public void saveOrderProductList(Set<OrderProduct> orderProductList) {
        try {
            for (OrderProduct orderProduct : orderProductList) {
                this.orderProductService.save(orderProduct);
            }
        } catch (Exception exception) {
            setErrorLabel();
            this.errorLabel.setText(exception.getMessage());
        }
    }

    /**
     * Updates the stock of buyed products in DB.
     */
    public void updateProducts() {
        try {
            for (Product product : this.buyedProducts.keySet()) {
                int quantity = product.getStock() - buyedProducts.get(product);
                product.setStock(quantity);
                this.productService.update(product);
            }
        } catch (Exception exception) {
            setErrorLabel();
            this.errorLabel.setText(exception.getMessage());
        }
    }

    /**
     * Set the info labels about the order generated.
     *
     * @param order The order generated from the user who buyed products.
     */
    public void setOrderInfo(Order order) {
        this.orderIdLabel.setText(Translations.ORDER_ID_TEXT + order.getId());
        this.orderDescriptionLabel.setText(Translations.ORDER_DESCRIPTION_TEXT + order.getDescription());
        this.orderDateLabel.setText(Translations.ORDER_DATE_TEXT + order.getEntryDate().toString());
    }

    /**
     * Check if there are enoughgt stock of buyed products for the user.
     *
     * @return a boolean true/false depends
     * @throws Exception if there are no matches with the products.
     */
    public boolean enoughtStock() throws Exception {
        boolean enoughtStock = this.productService.enoughtStock(this.buyedProducts);
        if (!enoughtStock) {
            return false;
        }
        return true;
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
        errorLabel = new javax.swing.JLabel();
        componentsPanel = new javax.swing.JPanel();
        stockLabel = new javax.swing.JLabel();
        jScrollShoppingTable = new javax.swing.JScrollPane();
        shoppingTable = new javax.swing.JTable();
        quantitySpinner = new javax.swing.JSpinner();
        separator = new javax.swing.JSeparator();
        productComboBox = new javax.swing.JComboBox<>();
        selectProductLabel = new javax.swing.JLabel();
        shopIcon = new javax.swing.JLabel();
        confirmButton = new javax.swing.JButton();
        orderDeliveryPanel = new javax.swing.JPanel();
        orderDeliveryLabel = new javax.swing.JLabel();
        orderDeliveryLabelSeparator = new javax.swing.JSeparator();
        thankYouLabel = new javax.swing.JLabel();
        orderInfoLabel = new javax.swing.JLabel();
        orderIdLabel = new javax.swing.JLabel();
        orderDescriptionLabel = new javax.swing.JLabel();
        orderDateLabel = new javax.swing.JLabel();
        orderLabelSeparator = new javax.swing.JSeparator();
        addButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        availableProductsLabel = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
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
        headerLabel.setText("ONLINE MARKET");
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

        inputPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 1240, 260));

        errorLabel.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        errorLabel.setForeground(new java.awt.Color(204, 0, 0));
        errorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errorLabel.setText("<<ERROR HERE>>");
        inputPanel.add(errorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, 480, -1));

        componentsPanel.setOpaque(false);
        componentsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        stockLabel.setBackground(new java.awt.Color(0, 0, 0));
        stockLabel.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        stockLabel.setForeground(new java.awt.Color(0, 0, 0));
        stockLabel.setText("Quantity:");
        componentsPanel.add(stockLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, -1, -1));

        shoppingTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Description", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollShoppingTable.setViewportView(shoppingTable);
        if (shoppingTable.getColumnModel().getColumnCount() > 0) {
            shoppingTable.getColumnModel().getColumn(0).setResizable(false);
            shoppingTable.getColumnModel().getColumn(1).setResizable(false);
        }

        componentsPanel.add(jScrollShoppingTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 400, 120));

        quantitySpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 9999, 1));
        componentsPanel.add(quantitySpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, 89, -1));
        componentsPanel.add(separator, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 730, 10));

        componentsPanel.add(productComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 300, -1));

        selectProductLabel.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        selectProductLabel.setForeground(new java.awt.Color(0, 0, 0));
        selectProductLabel.setText("Select a product:");
        componentsPanel.add(selectProductLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        shopIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        shopIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/icons/shoppingCart.png"))); // NOI18N
        componentsPanel.add(shopIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 222, 140));

        confirmButton.setBackground(new java.awt.Color(255, 153, 0));
        confirmButton.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        confirmButton.setForeground(new java.awt.Color(0, 0, 0));
        confirmButton.setText("CONFIRM");
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });
        componentsPanel.add(confirmButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, 480, -1));

        orderDeliveryPanel.setOpaque(false);
        orderDeliveryPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        orderDeliveryLabel.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        orderDeliveryLabel.setForeground(new java.awt.Color(0, 0, 0));
        orderDeliveryLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        orderDeliveryLabel.setText("ORDER DELIVERY");
        orderDeliveryPanel.add(orderDeliveryLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 370, -1));
        orderDeliveryPanel.add(orderDeliveryLabelSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 370, 10));

        thankYouLabel.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        thankYouLabel.setForeground(new java.awt.Color(0, 204, 0));
        thankYouLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        thankYouLabel.setText("Thanks for shopping with us!");
        orderDeliveryPanel.add(thankYouLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 370, 30));

        orderInfoLabel.setBackground(new java.awt.Color(0, 0, 0));
        orderInfoLabel.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        orderInfoLabel.setForeground(new java.awt.Color(0, 0, 0));
        orderInfoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        orderInfoLabel.setText("Your order:");
        orderDeliveryPanel.add(orderInfoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 350, -1));

        orderIdLabel.setBackground(new java.awt.Color(0, 0, 0));
        orderIdLabel.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        orderIdLabel.setForeground(new java.awt.Color(0, 0, 0));
        orderIdLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        orderIdLabel.setText("<order id here>");
        orderDeliveryPanel.add(orderIdLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 350, -1));

        orderDescriptionLabel.setBackground(new java.awt.Color(0, 0, 0));
        orderDescriptionLabel.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        orderDescriptionLabel.setForeground(new java.awt.Color(0, 0, 0));
        orderDescriptionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        orderDescriptionLabel.setText("<order description  here>");
        orderDeliveryPanel.add(orderDescriptionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 350, -1));

        orderDateLabel.setBackground(new java.awt.Color(0, 0, 0));
        orderDateLabel.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        orderDateLabel.setForeground(new java.awt.Color(0, 0, 0));
        orderDateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        orderDateLabel.setText("<order date here>");
        orderDeliveryPanel.add(orderDateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 350, -1));
        orderDeliveryPanel.add(orderLabelSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 190, -1));

        componentsPanel.add(orderDeliveryPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 10, 370, 230));

        addButton.setBackground(new java.awt.Color(255, 153, 0));
        addButton.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        addButton.setForeground(new java.awt.Color(0, 0, 0));
        addButton.setText("+");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        componentsPanel.add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 10, 70, 30));

        clearButton.setBackground(new java.awt.Color(255, 153, 0));
        clearButton.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        clearButton.setForeground(new java.awt.Color(0, 0, 0));
        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        componentsPanel.add(clearButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 70, 70, 120));

        inputPanel.add(componentsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 1240, 250));

        availableProductsLabel.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        availableProductsLabel.setForeground(new java.awt.Color(0, 0, 0));
        availableProductsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        availableProductsLabel.setText("AVAILABLE PRODUCTS");
        inputPanel.add(availableProductsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 1240, -1));
        inputPanel.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 322, 1220, 10));

        successLabel.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        successLabel.setForeground(new java.awt.Color(0, 204, 51));
        successLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        successLabel.setText("Order was delivered successfully.");
        inputPanel.add(successLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, 500, 20));

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

    /**
     * Log out the current user session and loads Login panel.
     *
     * @param evt Default event for Action Performed;
     */
    private void logOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutButtonActionPerformed
        LoadPanels loadPanels = new LoadPanels(this.workPanel);
        loadPanels.loadLoginPanel();
    }//GEN-LAST:event_logOutButtonActionPerformed

    /**
     * Make a hover over the button.
     *
     * @param evt Default event for Mouse entered;
     */
    private void logOutButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutButtonMouseEntered
        this.logOutButton.setForeground(Color.decode(Style.SOFT_ORANGE_CODE_COLOR));
    }//GEN-LAST:event_logOutButtonMouseEntered

    /**
     * Recover the original color when mouse exited the button.
     *
     * @param evt Default event Mouse exited
     */
    private void logOutButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutButtonMouseExited
        this.logOutButton.setForeground(Color.decode(Style.ORANGE_CODE_COLOR));
    }//GEN-LAST:event_logOutButtonMouseExited

    /**
     * Changes the text color to red when chicks on the button.
     *
     * @param evt Default event Mouse Pressed.
     */
    private void logOutButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutButtonMousePressed
        this.logOutButton.setForeground(Color.RED);
    }//GEN-LAST:event_logOutButtonMousePressed

    /**
     * Recover the original color for log on button when mouse released the
     * button.
     *
     * @param evt Default event Mouse released
     */
    private void logOutButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutButtonMouseReleased
        this.logOutButton.setForeground(Color.decode(Style.ORANGE_CODE_COLOR));
    }//GEN-LAST:event_logOutButtonMouseReleased

    /**
     * Make a hover over the buy button.
     *
     * @param evt Default event for Mouse Entered
     */
    private void buyButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buyButtonMouseEntered
        buyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(Style.SHOP_HOVER_BUTTON)));
    }//GEN-LAST:event_buyButtonMouseEntered

    /**
     * Recover the original icon when mouse exited.
     *
     * @param evt Default event for Mouse Exited
     */
    private void buyButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buyButtonMouseExited
        buyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(Style.SHOP_BUTTON)));
    }//GEN-LAST:event_buyButtonMouseExited

    /**
     * Replaces the original icon from clicked one.
     *
     * @param evt Default event for Mouse Pressed.
     */
    private void buyButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buyButtonMousePressed
        buyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(Style.SHOP_CLICKED_BUTTON)));
    }//GEN-LAST:event_buyButtonMousePressed

    /**
     * Recover the original button when mouse released from button
     *
     * @param evt Default event for Mouse Released.
     */
    private void buyButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buyButtonMouseReleased
        buyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(Style.SHOP_BUTTON)));
    }//GEN-LAST:event_buyButtonMouseReleased

    /**
     * Loads the AvailableProducts panel.
     *
     * @param evt Default event for Action Performed.
     */
    private void showProductsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showProductsButtonActionPerformed
        LoadPanels loadPanels = new LoadPanels(this.workPanel);
        loadPanels.loadAvailableProductsPanel(this.user);
    }//GEN-LAST:event_showProductsButtonActionPerformed

    /**
     * Makes a new order and asociates Order-Product with the products that the
     * user bought. Also, update the p roducts and reset the GUI, printing the
     * changes in the DB.
     *
     * @param evt Default event for Action Performed.
     */
    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmButtonActionPerformed
        if (this.shoppingTableModel.getRowCount() == 0) {
            setErrorLabel();
            this.errorLabel.setText(Translations.EMPTY_SHOPPING_CART_EXCEPTION);
            return;
        }
        try {
            boolean enoughtStock = enoughtStock();
            if (!enoughtStock) {
                setErrorLabel();
                this.errorLabel.setText(Translations.NOT_ENOUGHT_STOCK_EXCEPTION);
                return;
            }
            String orderDescription = Translations.ORDER_HEADER_TEXT + this.user.getId() + " - " + user.getUserName();
            Order order = this.orderService.createNewOrder(this.user, orderDescription);
            Set<OrderProduct> orderProductList = this.orderProductService.createNewOrderProductSet(order, this.buyedProducts);
            this.orderService.save(order);
            saveOrderProductList(orderProductList);
            updateProducts();
            clearShoppingTable();
            clearBuyedProductList();
            setSuccessLabel();
            setOrderInfo(order);
            getAll();
            setComboBox();
            printProducts();
        } catch (Exception exception) {
            setErrorLabel();
            this.errorLabel.setText(exception.getMessage());
            return;
        }
    }//GEN-LAST:event_confirmButtonActionPerformed

    /**
     * Loads ModifyProductsPanel Panel.
     *
     * @param evt Default event for Action Performed.
     */
    private void modifyProductsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyProductsButtonActionPerformed
        LoadPanels loadPanels = new LoadPanels(this.workPanel);
        loadPanels.loadModifyProductsPanel(this.user);
    }//GEN-LAST:event_modifyProductsButtonActionPerformed

    /**
     * Loads AddProducts Panel.
     *
     * @param evt Default event for Action Performed.
     */
    private void addProductButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProductButtonActionPerformed
        LoadPanels loadPanels = new LoadPanels(this.workPanel);
        loadPanels.loadAddProductsPanel(this.user);
    }//GEN-LAST:event_addProductButtonActionPerformed

    /**
     * Loads BuyProductsPanel Panel.
     *
     * @param evt Default event for Action Performed.
     */
    private void buyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyButtonActionPerformed
        LoadPanels loadPanels = new LoadPanels(this.workPanel);
        loadPanels.loadBuyProductsPanel(user);
    }//GEN-LAST:event_buyButtonActionPerformed

    /**
     * Allows to add an selected item from product Combo box into the shopping
     * cart list
     *
     * @param evt Default event for Action Performed.
     */
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        String productDescription = this.productComboBox.getSelectedItem().toString();
        for (Product product : productList) {
            if (product.getDescription().equals(productDescription)) {
                if (this.buyedProducts.containsKey(product)) {
                    return;
                }
                this.buyedProducts.put(product, (int) this.quantitySpinner.getValue());
            }
        }
        printShoppingCart();
        this.errorLabel.setVisible(false);
    }//GEN-LAST:event_addButtonActionPerformed

    /**
     * Clear the shopping cart table and shopping cart product list.
     *
     * @param evt Default event for Action Performed.
     */
    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        clearShoppingTable();
        clearBuyedProductList();
    }//GEN-LAST:event_clearButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel actionBarPanel;
    private javax.swing.JButton addButton;
    private javax.swing.JButton addProductButton;
    private javax.swing.JPanel adminPanel;
    private javax.swing.JLabel adminPanelLabel;
    private javax.swing.JSeparator adminPanelSepataror;
    private javax.swing.JLabel availableProductsLabel;
    private javax.swing.JButton buyButton;
    private javax.swing.JPanel buyPanel;
    private javax.swing.JButton clearButton;
    private javax.swing.JPanel componentsPanel;
    private javax.swing.JButton confirmButton;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JSeparator headerSeparator;
    private javax.swing.JPanel inputPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollShoppingTable;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton logOutButton;
    private javax.swing.JButton modifyProductsButton;
    private javax.swing.JLabel notLogedYet;
    private javax.swing.JLabel orderDateLabel;
    private javax.swing.JLabel orderDeliveryLabel;
    private javax.swing.JSeparator orderDeliveryLabelSeparator;
    private javax.swing.JPanel orderDeliveryPanel;
    private javax.swing.JLabel orderDescriptionLabel;
    private javax.swing.JLabel orderIdLabel;
    private javax.swing.JLabel orderInfoLabel;
    private javax.swing.JSeparator orderLabelSeparator;
    private javax.swing.JLabel placeAnOrderLabel;
    private javax.swing.JComboBox<String> productComboBox;
    private javax.swing.JTable productTable;
    private javax.swing.JSpinner quantitySpinner;
    private javax.swing.JButton searchButton;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JSeparator searchSeparator;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JLabel selectProductLabel;
    private javax.swing.JSeparator separator;
    private javax.swing.JLabel shopIcon;
    private javax.swing.JTable shoppingTable;
    private javax.swing.JButton showProductsButton;
    private javax.swing.JLabel stockLabel;
    private javax.swing.JLabel successLabel;
    private javax.swing.JLabel thankYouLabel;
    private javax.swing.JPanel userInfoPanel;
    private javax.swing.JLabel userNameInfoLabel;
    private javax.swing.JPanel workPanel;
    // End of variables declaration//GEN-END:variables
}
