package repository;

import classes.User;
import dataBaseConnection.DataBase;
import org.hibernate.Query;
import org.hibernate.Session;
import resources.en_translations.Translations;

/**
 * UserRepository Class.
 *
 * Class to define the interaction with APP and DB relative to Users.
 *
 * @author Jorge Vázquez Casaus.
 * @version 1.0.
 * @since 16/12/2022.
 */
public class UserRepository {

    private final int FIRST_ITEM_OF_LIST = 0;
    private DataBase dataBase;

    /**
     * UserRepository constructor.
     *
     * @throws Exception if cant connect to DB.
     */
    public UserRepository() throws Exception {
        this.dataBase = new DataBase();
    }

    /**
     * Find and returns all users stored in db.
     *
     * @return an Arraylisy of all users of the DB.
     * @throws Exception that . If list is empty, sends the exception to
     * UserService.
     */
    public User findAll() throws Exception {
        Session session = this.dataBase.openDataBaseConnection();
        Query query = session.createQuery("FROM classes.User u");
        if (query.list().isEmpty()) {
            throw new Exception(Translations.EMPTY_USER_TABLE_EXCEPTION);
        }
        User user = (User) query.list().get(FIRST_ITEM_OF_LIST);
        this.dataBase.closeDataBaseConnection(session);
        return user;
    }

    /**
     * Find and return one user with an specific email stored in the DB.
     *
     * @param email Is the email asociated to an user attribute as String. It
     * matches with the User table column called with the same name.
     * @return User Is an object that references a User row in DB. It matches
     * with the product with the same name.
     * @throws Exception If the list is empty, sends the error to ProductService.
     */
    public User findOneByEmail(String email) throws Exception {
        Session session = this.dataBase.openDataBaseConnection();
        Query query = session.createQuery("FROM classes.User u WHERE u.email =:email_parameter");
        query.setString("email_parameter", email);
        if (query.list().isEmpty()) {
            throw new Exception(Translations.INCORRECT_USER_OR_PASSWORD_EXCEPTION);
        }
        User user = (User) query.list().get(FIRST_ITEM_OF_LIST);
        this.dataBase.closeDataBaseConnection(session);
        return user;
    }

    /**
     * Find and return one user with an specific email stored in the DB.
     *
     * @param userName Is the userName asociated to an user attribute as String.
     * It matches with the User table column called with the same name.
     * @return User Is an object that references a User row in DB. It matches
     * with the product with the same name.
     * @throws Exception If the list is empty, sends the error to ProductService.
     */
    public User findOneByUserName(String userName) throws Exception {
        Session session = this.dataBase.openDataBaseConnection();
        Query query = session.createQuery("FROM classes.User u WHERE u.userName =:userName_parameter");
        query.setString("userName_parameter", userName);
        if (query.list().isEmpty()) {
            throw new Exception(Translations.INVALID_USERNAME_EXCEPTION);
        }
        User user = (User) query.list().get(FIRST_ITEM_OF_LIST);
        this.dataBase.closeDataBaseConnection(session);
        return user;
    }

    /**
     * Save a new user object as a new row in DB.
     *
     * @param user Is an object that references a user row in DB. It matches
     * with the product with the same name.
     * @throws Exception If cant make the save order, sends the error to
     * OrderService.
     */
    public void save(User user) throws Exception {
        Session session = this.dataBase.openDataBaseConnection();
        session.save(user);
        session.getTransaction().commit();
        this.dataBase.closeDataBaseConnection(session);
    }

    /**
     * Update a new user object as a new row in DB.
     *
     * @param user Is an object that references a user row in DB. It matches
     * with the product with the same name.
     * @throws Exception If cant make the update order, sends the error to
     * OrderService.
     */
    public void update(User user) throws Exception {
        Session session = this.dataBase.openDataBaseConnection();
        session.update(user);
        session.getTransaction().commit();
        this.dataBase.closeDataBaseConnection(session);
    }

    /**
     * Delete a new user object as a new row in DB.
     *
     * @param user Is an object that references a user row in DB. It matches
     * with the product with the same name.
     * @throws Exception If cant make the delete order, sends the error to
     * OrderService.
     */
    public void delete(User user) throws Exception {
        Session session = this.dataBase.openDataBaseConnection();
        session.delete(user);
        session.getTransaction().commit();
        this.dataBase.closeDataBaseConnection(session);
    }
}
