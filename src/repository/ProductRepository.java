package repository;

import classes.Product;
import dataBaseConnection.DataBase;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * ProductRepository Class.
 *
 * Class to define the interaction with APP and DB relative to Products.
 *
 * @author Jorge Vázquez Casaus.
 * @version 1.0.
 * @since 16/12/2022.
 */
public class ProductRepository {

    private final int FIRST_ITEM_OF_LIST = 0;
    private DataBase dataBase;

    /**
     * ProductRepository constructor.
     */
    public ProductRepository()  {
        this.dataBase = new DataBase();
    }

    /**
     * Find and returns all products stored in db.
     *
     * @return an Arraylisy of all products of the DB.
     * @throws Exception that . If list is empty, it send the exception to
     * ProductService.
     */
    public ArrayList<Product> findAll() throws Exception {
        Session session = this.dataBase.openDataBaseConnection();
        Query query = session.createQuery("FROM classes.Product p");
        ArrayList<Product> productList = (ArrayList<Product>) query.list();
        this.dataBase.closeDataBaseConnection(session);
        return productList;
    }

    /**
     * Find and return one product with an specific description name of the
     * products stored in the DB.
     *
     * @param description Is the description attribute from a product as String.
     * It matches with the Product table column called with the same name.
     * @return Product Is an object that references a Product row in DB. It
     * matches with the product with the same name.
     * @throws Exception If the list is empty send the error to ProductService.
     */
    public Product findOneByDescription(String description) throws Exception {
        Session session = this.dataBase.openDataBaseConnection();
        Query query = session.createQuery("FROM classes.Product p WHERE p.description =:description_parameter");
        query.setString("description_parameter", description);
        Product product = (Product) query.list().get(FIRST_ITEM_OF_LIST);
        this.dataBase.closeDataBaseConnection(session);
        return product;
    }

    /**
     * Save a new Product object as a new row in DB.
     *
     * @param product Is an object that references a Product row in DB. It
     * matches with the product with the same name.
     * @throws Exception If cant make the save order,sends the error to
     * OrderService.
     */
    public void save(Product product) throws Exception {
        Session session = this.dataBase.openDataBaseConnection();
        session.save(product);
        session.getTransaction().commit();
        this.dataBase.closeDataBaseConnection(session);
    }

    /**
     * Update a new Product object as a new row in DB.
     *
     * @param product Is an object that references a Product row in DB. It
     * matches with the product with the same name.
     * @throws Exception If cant update, sends the exception to ProductService.
     */
    public void update(Product product) throws Exception {
        Session session = this.dataBase.openDataBaseConnection();
        session.update(product);
        session.getTransaction().commit();
        this.dataBase.closeDataBaseConnection(session);
    }

    /**
     * Delete a product from DB.
     *
     * @param product Is an object that references a Product row in DB. It
     * @throws Exception If cant delete, sends the exception to ProductService.
     */
    public void delete(Product product) throws Exception {
        Session session = this.dataBase.openDataBaseConnection();
        session.delete(product);
        session.getTransaction().commit();
        this.dataBase.closeDataBaseConnection(session);
    }
}
