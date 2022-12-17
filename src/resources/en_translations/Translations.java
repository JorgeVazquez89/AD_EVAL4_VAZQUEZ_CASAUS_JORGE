package resources.en_translations;

/**
 * Translations Class.
 *
 * Class that contains all text constants to show in user GUIs.
 *
 * @author Jorge Vázquez Casaus.
 * @version 1.0.
 * @since 16/12/2022.
 */
public class Translations {
    
    /**************/
    /*    HINTS   */
    /**************/
    public static final String HI_USERNAME_LABEL = "Hi: ";
    public static final String DEFAULT_USERNAME_TEXT = "Enter here your username.";
    public static final String DEFAULT_EMAIL_TEXT =  "Enter here your email.";
    public static final String DEFAULT_PASSWORD_TEXT =  "Password.";
    public static final String DEFAULT_DESCRIPTION_TEXT =  "Enter here the description of the new product.";
    public static final String ORDER_HEADER_TEXT =  "Order delivered by ";
    public static final String ORDER_ID_TEXT =  "ID#";
    public static final String ORDER_DESCRIPTION_TEXT =  "DESCRIPTION#";
    public static final String ORDER_DATE_TEXT =  "DATE#";
    
    /****************/
    /* UTIL STRINGS */
    /****************/
    public static final String EMPTY_STRING = "";
    public static final String ADMIN_USERNAME = "admin";
    public static final String POINT = ".";
    
    /**************/
    /* EXCEPTIONS */
    /**************/
    public static final String CANT_CONNECT_TO_DB_EXCEPTION =  "Unable to connect DB";
    public static final String EMPTY_USER_TABLE_EXCEPTION = "There are no users in our DB.";
    public static final String INCORRECT_USER_OR_PASSWORD_EXCEPTION = "Incorrect user or password.";
    public static final String INVALID_USERNAME_EXCEPTION =  "Invalid username.";
    public static final String INVALID_EMAIL_EXCEPTION =  "Invalid email.";
    public static final String INVALID_PASSWORD_EXCEPTION =  "Invalid password.";
    public static final String INVALID_DESCRIPTION_EXCEPTION =  "Invalid description for product.";   
    public static final String EMPTY_PRODUCT_TABLE_EXCEPTION = "There are no products in our DB.";
    public static final String PRODUCT_NOT_FOUND_EXCEPTION =  "Product not found"; 
    public static final String EMPTY_SHOPPING_CART_EXCEPTION =  "Your shopping cart is empty.";  
    public static final String NOT_ENOUGHT_STOCK_EXCEPTION =  "Not enought stock.";   
}
