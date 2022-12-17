package services;

import classes.Order;
import classes.User;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import repository.OrderRepository;

/**
 * OrderService Class.
 *
 * Class that manages and makes the Orders background processes.
 *
 * @author Jorge Vázquez Casaus.
 * @version 1.0.
 * @see UserService
 * @since 16/12/2022.
 */
public class OrderService {

    private OrderRepository orderRepository;

    /**
     * OrderService Constructor.
     *
     * @throws Exception if cant connect to DB.
     */
    public OrderService() throws Exception {
        this.orderRepository = new OrderRepository();
    }

    /**
     * Creates a new Order object. An order, is an object that references a
     * order row in DB. asociates an userId. It matches with the Order table
     * column called with the same name.
     *
     * @param user Is an object that references a user row in DB. It matches
     * with the product with the same name.
     * @param orderDescription Is the description attribute from a orderproduct
     * as String. It matches with the OrderProduct table column called with the
     * same name.
     * matches with the product with the same name.
     * @return order Is an object that references a order row in DB. asociates
     * an userId. It matches with the Order table column called with the same
     * name.
     */
    public Order createNewOrder(User user, String orderDescription) {
        Timestamp now = Timestamp.valueOf(LocalDateTime.now());
        Order order = new Order(user, orderDescription, now);
        return order;
    }
    
    /**
     * Calls the orderProductRepository and try to save the Order as a row
     * in DB.
     * 
     * @param order Is an object that references a order row in DB. asociates an
     * userId. It matches with the Order table column called with the same name.
     * @throws Exception If cant make the save order, sends the error to the
     * controller.
     */
    public void save(Order order) throws Exception {
        this.orderRepository.save(order);
    }
    
    /**
     * Calls the orderProductRepository and try to update the Order as a row
     * in DB.
     * 
     * @param order Is an object that references a order row in DB. asociates an
     * userId. It matches with the Order table column called with the same name.
     * @throws Exception If cant make the update order, sends the error to the
     * controller.
     */
    public void update(Order order) throws Exception {
        this.orderRepository.update(order);
    }
}
