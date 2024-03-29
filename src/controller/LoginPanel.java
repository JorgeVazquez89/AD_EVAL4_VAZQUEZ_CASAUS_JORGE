package controller;

import classes.User;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import resources.en_translations.Translations;
import resources.style.Style;
import services.UserService;

/**
 * LoginPanel Class.
 *
 * Class to define the GUI that allow login in the APP.
 *
 * @author Jorge Vázquez Casaus.
 * @version 1.0.
 * @see LoadPanels
 * @since 16/12/2022.
 */
public class LoginPanel extends javax.swing.JPanel {

    private UserService userService;

    /**
     * Creates new form LoginPanel. LoginPanel class Constructor.
     *
     * @param workPanel WorkPanel, its the work area of the APP.
     */
    public LoginPanel(JPanel workPanel) {  
        this.userService = new UserService();
        this.workPanel = workPanel;
        initComponents();
        setComponents();
    }

    /**
     * Sets the componets with specific behaviour.
     */
    public void setComponents() {
        this.buyButton.setBorder(BorderFactory.createEmptyBorder());
        this.buyButton.setOpaque(false);
        this.buyButton.setContentAreaFilled(false);
        this.buyButton.setBorderPainted(false);
        this.loginButton.setBorder(BorderFactory.createEmptyBorder());
        this.loginButton.setOpaque(false);
        this.loginButton.setContentAreaFilled(false);
        this.loginButton.setBorderPainted(false);
        this.showPasswordButton.setBorder(BorderFactory.createEmptyBorder());
        this.showPasswordButton.setOpaque(false);
        this.showPasswordButton.setContentAreaFilled(false);
        this.showPasswordButton.setBorderPainted(false);
        this.createAnAccountButton.setBorder(BorderFactory.createEmptyBorder());
        this.createAnAccountButton.setOpaque(false);
        this.createAnAccountButton.setContentAreaFilled(false);
        this.createAnAccountButton.setBorderPainted(false);
        this.passwordField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        this.passwordField.setBackground(new java.awt.Color(0, 0, 0, 1));
        this.emailTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        this.emailTextField.setBackground(new java.awt.Color(0, 0, 0, 1));
        this.errorLabel.setVisible(false);
        this.successLabel.setVisible(false);
    }

    /**
     * Set the label that set an specific error message.
     */
    public void setErrorLabel() {
        this.errorLabel.setVisible(true);
        this.successLabel.setVisible(false);
    }

    /**
     * Set the label that set an specific error message.
     */
    public void setSuccessLabel() {
        this.errorLabel.setVisible(false);
        this.successLabel.setVisible(true);
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
        actionBarPanel = new javax.swing.JPanel();
        userInfoPanel = new javax.swing.JPanel();
        notLogedYet = new javax.swing.JLabel();
        userNameInfoLabel = new javax.swing.JLabel();
        buyPanel = new javax.swing.JPanel();
        buyButton = new javax.swing.JButton();
        placeAnOrderLabel = new javax.swing.JLabel();
        inputPanel = new javax.swing.JPanel();
        errorLabel = new javax.swing.JLabel();
        loginButton = new javax.swing.JButton();
        emaiLabel = new javax.swing.JLabel();
        emailTextField = new javax.swing.JTextField();
        emailSeparator = new javax.swing.JSeparator();
        passwordLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        passwordSeparator = new javax.swing.JSeparator();
        showPasswordButton = new javax.swing.JButton();
        successLabel = new javax.swing.JLabel();
        loginLayutLabel = new javax.swing.JLabel();
        registerPanel = new javax.swing.JPanel();
        dontHaveAccountLabel = new javax.swing.JLabel();
        createAnAccountButton = new javax.swing.JButton();

        setName("mainPanel"); // NOI18N
        setOpaque(false);

        workPanel.setName("workPanel"); // NOI18N
        workPanel.setOpaque(false);
        workPanel.setLayout(null);

        headerSeparator.setBackground(new java.awt.Color(0, 0, 0));
        headerSeparator.setForeground(new java.awt.Color(0, 0, 0));
        workPanel.add(headerSeparator);
        headerSeparator.setBounds(20, 140, 1230, 10);

        headerLabel.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        headerLabel.setForeground(new java.awt.Color(0, 0, 0));
        headerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerLabel.setText("LOGIN");
        workPanel.add(headerLabel);
        headerLabel.setBounds(0, 90, 1260, 40);

        actionBarPanel.setBackground(new java.awt.Color(51, 51, 51));
        actionBarPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        actionBarPanel.setName("actionBarPanel"); // NOI18N
        actionBarPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        actionBarPanel.add(userInfoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 1, 270, 80));

        buyPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        buyPanel.setOpaque(false);
        buyPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/buttons/shopping_car_disabled_70x40.png"))); // NOI18N
        buyButton.setName("buyButton"); // NOI18N
        buyPanel.add(buyButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 70, 40));

        placeAnOrderLabel.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        placeAnOrderLabel.setForeground(new java.awt.Color(255, 255, 255));
        placeAnOrderLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        placeAnOrderLabel.setText("Place an order");
        placeAnOrderLabel.setName("placeAnOrderLabel"); // NOI18N
        buyPanel.add(placeAnOrderLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, 130, 20));

        actionBarPanel.add(buyPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 1, -1, 80));

        workPanel.add(actionBarPanel);
        actionBarPanel.setBounds(0, 0, 1270, 81);

        inputPanel.setOpaque(false);
        inputPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        errorLabel.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        errorLabel.setForeground(new java.awt.Color(204, 0, 0));
        errorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errorLabel.setText("<<ERROR HERE>>");
        inputPanel.add(errorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 260, 260, 30));

        loginButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/buttons/loginButton.png"))); // NOI18N
        loginButton.setOpaque(false);
        loginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                loginButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                loginButtonMouseReleased(evt);
            }
        });
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        inputPanel.add(loginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 70, 200, 310));

        emaiLabel.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        emaiLabel.setForeground(new java.awt.Color(255, 102, 0));
        emaiLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        emaiLabel.setText("E-mail:");
        inputPanel.add(emaiLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 180, 90, -1));

        emailTextField.setForeground(new java.awt.Color(153, 153, 153));
        emailTextField.setText("Enter here your email.");
        emailTextField.setOpaque(false);
        emailTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                emailTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                emailTextFieldFocusLost(evt);
            }
        });
        inputPanel.add(emailTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 170, 170, 30));

        emailSeparator.setBackground(new java.awt.Color(204, 102, 0));
        inputPanel.add(emailSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 200, 170, 10));

        passwordLabel.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(255, 102, 0));
        passwordLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        passwordLabel.setText("Password:");
        inputPanel.add(passwordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 230, 90, -1));

        passwordField.setForeground(new java.awt.Color(153, 153, 153));
        passwordField.setText("Password.");
        passwordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordFieldFocusLost(evt);
            }
        });
        inputPanel.add(passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 220, 170, 30));

        passwordSeparator.setBackground(new java.awt.Color(204, 102, 0));
        inputPanel.add(passwordSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 250, 170, 10));

        showPasswordButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/buttons/show_password.png"))); // NOI18N
        showPasswordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPasswordButtonActionPerformed(evt);
            }
        });
        inputPanel.add(showPasswordButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 210, 60, 50));

        successLabel.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        successLabel.setForeground(new java.awt.Color(0, 204, 51));
        successLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        successLabel.setText("<SUCCES TEXT HERE>");
        inputPanel.add(successLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 260, 310, 30));

        loginLayutLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/layout/login_layout.png"))); // NOI18N
        inputPanel.add(loginLayutLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, -20, 700, 580));

        registerPanel.setForeground(new java.awt.Color(0, 0, 0));
        registerPanel.setOpaque(false);
        registerPanel.setLayout(null);

        dontHaveAccountLabel.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        dontHaveAccountLabel.setForeground(new java.awt.Color(0, 0, 0));
        dontHaveAccountLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dontHaveAccountLabel.setText("Don't have an account yet?");
        dontHaveAccountLabel.setToolTipText("");
        registerPanel.add(dontHaveAccountLabel);
        dontHaveAccountLabel.setBounds(0, 10, 370, 23);

        createAnAccountButton.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        createAnAccountButton.setForeground(new java.awt.Color(0, 153, 255));
        createAnAccountButton.setText("Create an account now");
        createAnAccountButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                createAnAccountButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                createAnAccountButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                createAnAccountButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                createAnAccountButtonMouseReleased(evt);
            }
        });
        createAnAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createAnAccountButtonActionPerformed(evt);
            }
        });
        registerPanel.add(createAnAccountButton);
        createAnAccountButton.setBounds(0, 40, 370, 30);

        inputPanel.add(registerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 440, 370, 70));

        workPanel.add(inputPanel);
        inputPanel.setBounds(0, 150, 1260, 580);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(workPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1270, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(workPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 739, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Check if username and password are correct. If correct, opens a new user
     * session. If dont, shows the error.
     *
     * @param evt Default event for Action Performed.
     */
    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        String email = this.emailTextField.getText();
        String password = this.passwordField.getText();
        try {
            boolean isCorrectLogin = this.userService.isCorrectLogin(email, password);
            if (isCorrectLogin) {
                setSuccessLabel();
                User user = this.userService.getUserByEmail(email);
                LoadPanels loadPanels = new LoadPanels(this.workPanel);
                loadPanels.loadAvailableProductsPanel(user);
            }
        } catch (Exception exception) {
            setErrorLabel();
            this.errorLabel.setText(exception.getMessage());
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    /**
     * Clean the text of the email TextField.
     *
     * @param evt Default event for Focus Gained.
     */
    private void emailTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailTextFieldFocusGained
        this.emailTextField.setText(Translations.EMPTY_STRING);
    }//GEN-LAST:event_emailTextFieldFocusGained

    /**
     * Recover the default text if email field is empty.
     *
     * @param evt Default event for Focus Lost.
     */
    private void emailTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailTextFieldFocusLost
        if (this.emailTextField.getText().equals(Translations.EMPTY_STRING)) {
            this.emailTextField.setText(Translations.DEFAULT_EMAIL_TEXT);
        }
    }//GEN-LAST:event_emailTextFieldFocusLost

    /**
     * Clean the text of the password TextField.
     *
     * @param evt Default event for Focus Gained.
     */
    private void passwordFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFieldFocusGained
        this.passwordField.setText(Translations.EMPTY_STRING);
    }//GEN-LAST:event_passwordFieldFocusGained

    /**
     * Recover the default text if password field is empty.
     *
     * @param evt Default event for Focus Lost.
     */
    private void passwordFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFieldFocusLost
        if (this.passwordField.getText().equals(Translations.EMPTY_STRING)) {
            this.passwordField.setText(Translations.DEFAULT_PASSWORD_TEXT);
        }
    }//GEN-LAST:event_passwordFieldFocusLost

    /**
     * Make a hover in the login button.
     *
     * @param evt Default event for Mouse Entered.
     */
    private void loginButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginButtonMouseEntered
        this.loginButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(resources.style.Style.LOGIN_HOVER_BUTTON)));
    }//GEN-LAST:event_loginButtonMouseEntered

    /**
     * Recover the original icon of the login button.
     *
     * @param evt Default event for Mouse Exited.
     */
    private void loginButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginButtonMouseExited
        this.loginButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(resources.style.Style.LOGIN_BUTTON)));
    }//GEN-LAST:event_loginButtonMouseExited

    /**
     * Set the icon of the login button for clicked one.
     *
     * @param evt Default event for Mouse Pressed.
     */
    private void loginButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginButtonMousePressed
        this.loginButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(resources.style.Style.LOGIN_CLICKED_BUTTON)));
    }//GEN-LAST:event_loginButtonMousePressed

    /**
     * Recover the original icon of the login button when mouse released.
     *
     * @param evt Default event for Mouse Released.
     */
    private void loginButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginButtonMouseReleased
        this.loginButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(resources.style.Style.LOGIN_BUTTON)));
    }//GEN-LAST:event_loginButtonMouseReleased

    /**
     * Loads the RegisterPanel.
     *
     * @param evt Default event for Action Performed.
     */
    private void createAnAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createAnAccountButtonActionPerformed
        LoadPanels loadPanels = new LoadPanels(this.workPanel);
        loadPanels.loadRegisterPanel();
    }//GEN-LAST:event_createAnAccountButtonActionPerformed

    /**
     * Set purple the text color when mouse entered in the button.
     *
     * @param evt Defaut event for Mouse Entered.
     */
    private void createAnAccountButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createAnAccountButtonMouseEntered
        this.createAnAccountButton.setForeground(Color.decode(Style.PURPLE_CODE_COLOR));
    }//GEN-LAST:event_createAnAccountButtonMouseEntered

    /**
     * Recover the original blue color when mouse exited of the button.
     *
     * @param evt Defaut event for Mouse Exited.
     */
    private void createAnAccountButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createAnAccountButtonMouseExited
        this.createAnAccountButton.setForeground(Color.decode(Style.BLUE_CODE_COLOR));
    }//GEN-LAST:event_createAnAccountButtonMouseExited

    /**
     * Set red the text color when mouse click the button.
     *
     * @param evt Defaut event for Mouse Pressed.
     */
    private void createAnAccountButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createAnAccountButtonMousePressed
        this.createAnAccountButton.setForeground(Color.RED);
    }//GEN-LAST:event_createAnAccountButtonMousePressed

    /**
     * Recover the original blue color when mouse exited of the button.
     *
     * @param evt Defaut event for Mouse Released.
     */
    private void createAnAccountButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createAnAccountButtonMouseReleased
        this.createAnAccountButton.setForeground(Color.decode(Style.BLUE_CODE_COLOR));
    }//GEN-LAST:event_createAnAccountButtonMouseReleased

    /**
     * Changes Hide/show password icon if password is hidded or visible.
     *
     * @param evt Defaut event for Action Performed.
     */
    private void showPasswordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPasswordButtonActionPerformed
        if (passwordField.getEchoChar() == (Style.ASTERISC)) {
            this.passwordField.setEchoChar((char) 0);
            this.showPasswordButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(Style.HIDE_PASSWORD_BUTTON)));
            return;
        }
        this.passwordField.setEchoChar(Style.ASTERISC);
        this.showPasswordButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(Style.SHOW_PASSWORD_BUTTON)));
    }//GEN-LAST:event_showPasswordButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel actionBarPanel;
    private javax.swing.JButton buyButton;
    private javax.swing.JPanel buyPanel;
    private javax.swing.JButton createAnAccountButton;
    private javax.swing.JLabel dontHaveAccountLabel;
    private javax.swing.JLabel emaiLabel;
    private javax.swing.JSeparator emailSeparator;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JSeparator headerSeparator;
    private javax.swing.JPanel inputPanel;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel loginLayutLabel;
    private javax.swing.JLabel notLogedYet;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JSeparator passwordSeparator;
    private javax.swing.JLabel placeAnOrderLabel;
    private javax.swing.JPanel registerPanel;
    private javax.swing.JButton showPasswordButton;
    private javax.swing.JLabel successLabel;
    private javax.swing.JPanel userInfoPanel;
    private javax.swing.JLabel userNameInfoLabel;
    private javax.swing.JPanel workPanel;
    // End of variables declaration//GEN-END:variables
}
