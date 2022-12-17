package repository;

import classes.Order;
import dataBaseConnection.DataBase;
import org.hibernate.Session;

/**
 * OrderRepository Class.
 *
 * Class to define the interaction with APP and DB relative to Orders.
 *
 * @author Jorge Vázquez Casaus.
 * @version 1.0.
 * @see OrderProductRepository
 * @see ProductRepository
 * @since 16/12/2022.
 */
public class OrderRepository {

    private DataBase dataBase;

    /**
     * OrderRepository constructor.
     *
     * @throws Exception if cant connect to DB.
     */
    public OrderRepository() throws Exception {
        this.dataBase = new DataBase();
    }

    /**
     * Save a new OrderProduct object as a new row in DB. Asociates an id order,
     * with products buyed by user.
     *
     * @param order Is an object that references a order row in DB. asociates
     * an userId. It matches with the Order table column called with the same
     * name.
     * @throws Exception If cant make the save order, sends the error to
     * OrderService.
     */
    public void save(Order order) throws Exception {
        Session session = this.dataBase.openDataBaseConnection();
        session.save(order);
        session.getTransaction().commit();
        this.dataBase.closeDataBaseConnection(session);
    }
    
     /**
     * Update a new Order object as a new row in DB. Asociates an id order,
     * with products buyed by user.
     *
     * @param order Is an object that references a order row in DB. asociates
     * an userId. It matches with the Order table column called with the same
     * name.
     * @throws Exception If cant make the save order, sends the error to
     * OrderService.
     */
    public void update(Order order) throws Exception {
        Session session = this.dataBase.openDataBaseConnection();
        session.update(order);
        session.getTransaction().commit();
        this.dataBase.closeDataBaseConnection(session);
    }
}
