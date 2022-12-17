package repository;

import classes.OrderProduct;
import dataBaseConnection.DataBase;
import org.hibernate.Session;

/**
 * OrderProductRepository Class.
 *
 * Class to define the interaction with APP and DB relative to Order-Product.
 *
 * @author Jorge Vázquez Casaus.
 * @version 1.0.
 * @see OrderRepository
 * @see ProductRepository
 * @since 16/12/2022.
 */
public class OrderProductRepository {

    private DataBase dataBase;

    /**
     * OrderProductRepository constructor.
     *
     * @throws Exception if cant connect to DB.
     */
    public OrderProductRepository() throws Exception {
        this.dataBase = new DataBase();
    }

    /**
     * Save a new OrderProduct object as a new row in DB. Asociates an id order,
     * with products buyed by user.
     *
     * @param orderproduct Is an object that OrderProduct asociates an id order,
     * with products buyed by user. It matches with the OrderProduct table
     * column called with the same name.
     * @throws Exception If cant make the save order, sends the error to
     * OrderProductService.
     */
    public void save(OrderProduct orderproduct) throws Exception {
        Session session = this.dataBase.openDataBaseConnection();
        session.save(orderproduct);
        session.getTransaction().commit();
        this.dataBase.closeDataBaseConnection(session);
    }
}
