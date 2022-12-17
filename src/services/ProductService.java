package services;

import classes.Product;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import repository.ProductRepository;
import resources.en_translations.Translations;

/**
 * ProductService Class.
 *
 * Class that manages and makes the Products background processes.
 *
 * @author Jorge Vázquez Casaus.
 * @version 1.0.
 * @since 16/12/2022.
 */
public class ProductService {

    private ProductRepository productRepository;

    /**
     * ProductService Constructor.
     *
     * @throws Exception if cant connect to DB.
     */
    public ProductService() throws Exception {
        this.productRepository = new ProductRepository();
    }

    /**
     * Calls productRepository and try to find all the products stored in DB.
     *
     * @return an ArrayList of all products stored in the DB.
     * @throws Exception If the list is empty, sends the error from repository to
     * the controller,
     */
    public ArrayList<Product> getAll() throws Exception {
        ArrayList<Product> productList = this.productRepository.findAll();
        return productList;
    }

    /**
     * Calls productRepository and try to find one product stored in DB with the
     * specific desrcription that matches with the column in DB with the same
     * name.
     *
     * @param description Is the description attribute from a product as String.
     * It matches with the Product table column called with the same name.
     * @return
     * @throws Exception If the list is empty, sends the error from repository to
     * the controller,
     */
    public Product findOneByDescription(String description) throws Exception {
        Product product = this.productRepository.findOneByDescription(description);
        return product;
    }
    
    /**
     * Get and returns the current instant of time.
     * 
     * @return the current instant of time as Timestamp.
     */
    public Timestamp getTimeStamp() {
        Timestamp now = Timestamp.valueOf(LocalDateTime.now());
        return now;
    }
    
    /**
     * Creates a new Product object that references a Product row in DB.
     * 
     * @param description Is the description attribute from a product as String.
     * It matches with the Product table column called with the same name.
     * @param price Is the stock attribute from a product as float.
     * It matches with the Product table column called with the same name.
     * @param weight Is the weight attribute from a product as float.
     * It matches with the Product table column called with the same name.
     * @param stock Is the stock attribute from a product as int.
     * It matches with the Product table column called with the same name.
     * @return a product that is an object that references a Product row in DB. It
     * matches with the product with the same name.
     */
    public Product createNewProduct(String description, float price, float weight, int stock) {
        Timestamp now = getTimeStamp();
        Product product = new Product(description, price, weight, stock, now);
        product.setId(null);
        product.setModificationDate(null);
        return product;
    }
    
    /**
     * Calls productRepository and try to save the product in DB.
     * 
     * @param product Is an object that references a Product row in DB. It
     * matches with the product with the same name.
     * @throws Exception If cant make the save order, sends the error to the
     * controller.
     */
    public void save(Product product) throws Exception {
        this.productRepository.save(product);
    }
    
    /**
     * Modify an existent product in DB.
     * 
     * @param product Is an object that references a Product row in DB. It
     * matches with the product with the same name.
     * @param description Is the description attribute from a product as String.
     * It matches with the Product table column called with the same name.
     * @param price Is the stock attribute from a product as float.
     * It matches with the Product table column called with the same name.
     * @param weight Is the weight attribute from a product as float.
     * It matches with the Product table column called with the same name.
     * @param stock Is the stock attribute from a product as int.
     * @return product object.
     */
    public Product modifyProduct(Product product, String description, float price,
            float weight, int stock) {
        product.setDescription(description);
        product.setPrice(price);
        product.setPrice(price);
        product.setWeight(weight);
        product.setStock(stock);
        Timestamp now = getTimeStamp();
        product.setModificationDate(now);
        return product;
    }
    
    /**
     * Calls productRepository and try to update the product in DB.
     * 
     * @param product Is an object that references a Product row in DB. It
     * matches with the product with the same name.
     * @throws Exception If cant make the update order, sends the error to the
     * controller.
     */
    public void update(Product product) throws Exception {
        this.productRepository.update(product);
    }
    
    /**
     * Check if the description field input is correct.
     * 
     * @param description Is the description attribute from a product as String.
     * It matches with the Product table column called with the same name.
     * @return boolean true or false that depends the condition.
     * @throws Exception to the controller if the description input is incorrect. 
     */
    public boolean isCorrectDescriptionField(String description) throws Exception {
        if (description.equals(Translations.DEFAULT_DESCRIPTION_TEXT)) {
            throw new Exception(Translations.INVALID_DESCRIPTION_EXCEPTION);
        }
        return true;
    }
    
    /**
     * Check if there are enought stock from a product to make a purchase order.
     * 
     * @param buyedProducts its an ArrayList of Products that the user want to buy.
     * @return boolean true or false that depends the condition.
     * @throws Exception to the controller if the stock isnt enought to buy. 
     */
    public boolean enoughtStock(HashMap<Product, Integer> buyedProducts) throws Exception {
        for (Product product : buyedProducts.keySet()) {
            int quantity = buyedProducts.get(product);
            Product queryProduct = this.productRepository.findOneByDescription(product.getDescription());
            if (queryProduct.getStock() < quantity) {
                throw new Exception(Translations.NOT_ENOUGHT_STOCK_EXCEPTION);
            }
        }
        return true;
    }
}
