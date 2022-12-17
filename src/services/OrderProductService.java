package services;

import classes.Order;
import classes.OrderProduct;
import classes.Product;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import repository.OrderProductRepository;

/**
 * OrderProductService Class.
 *
 * Class that manages and makes the Order-Product background processes.
 *
 * @author Jorge Vázquez Casaus.
 * @version 1.0.
 * @see OrderService
 * @see ProductService
 * @see UserService
 * @since 16/12/2022.
 */
public class OrderProductService {

    private OrderProductRepository orderProductRepository;

    /**
     * OrderProductService Constructor.
     *
     * @throws Exception if cant connect to DB.
     */
    public OrderProductService() throws Exception {
        orderProductRepository = new OrderProductRepository();
    }

    /**
     * Creates a new object asociates an id order, with products buyed by user.
     * It matches with the OrderProduct table column called with the same name.
     * It sends to repository in order to save it.
     *
     * @param order Is an object that references a order row in DB. asociates an
     * userId. It matches with the Order table column called with the same name.
     * @param product Is an object that references a Product row in DB. It
     * matches with the product with the same name.
     * @return orderproduct Is an object that OrderProduct asociates an id
     * order, with products buyed by user. It matches with the OrderProduct
     * table column called with the same name.
     */
    public OrderProduct createNewOrderProduct(Order order, Product product) {
        Timestamp now = Timestamp.valueOf(LocalDateTime.now());
        OrderProduct orderProduct = new OrderProduct(order, product, now);
        return orderProduct;
    }

    /**
     * Create a set of orderProduct objects in order to store it in db.
     *
     * @param order Is an object that references a order row in DB. asociates an
     * userId. It matches with the Order table column called with the same name.
     * @param buyedProducts Its an ArrayList of selected products to buy from an
     * user.
     * @return a set of order-products objects to insert as a row in DB.
     */
    public Set<OrderProduct> createNewOrderProductSet(Order order, HashMap<Product, Integer> buyedProducts) {
        Set<OrderProduct> set = new HashSet<OrderProduct>(0);
        for (Product product : buyedProducts.keySet()) {
            Timestamp now = Timestamp.valueOf(LocalDateTime.now());
            OrderProduct orderProduct = new OrderProduct(order, product, now);
            set.add(orderProduct);
        }
        return set;
    }

    /**
     * Calls the orderProductRepository and try to save the orderProduct as a row
     * in DB.
     *
     * @param orderProduct Is an object that OrderProduct asociates an id order,
     * with products buyed by user. It matches with the OrderProduct table
     * column called with the same name.
     * @throws Exception If cant make the save order, sends the error to the
     * controller.
     */
    public void save(OrderProduct orderProduct) throws Exception {
        this.orderProductRepository.save(orderProduct);
    }
}
