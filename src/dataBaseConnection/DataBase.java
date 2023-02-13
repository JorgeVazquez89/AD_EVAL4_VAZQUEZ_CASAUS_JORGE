package dataBaseConnection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * DataBase Class.
 *
 * Class that allow make a connection with MySQLDB.
 *
 * @author Jorge Vázquez Casaus.
 * @version 1.0.
 * @see NewHibernateUtil
 * @since 16/12/2022.
 */
public class DataBase {

    private SessionFactory sessionFactory;

    /**
     * Constructor of DataBase.
     */
    public DataBase() {
        this.sessionFactory = NewHibernateUtil.getSessionFactory();
    }

    /**
     * Open a new session/connection with MySQL DB.
     *
     * @return the current session with all the necessary parameters as
     * Transaction setted.
     */
    public Session openDataBaseConnection() {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        return session;
    }

    /**
     * Closes the session/connection with DB.
     *
     * @param session The current session with all the necessary parameters as
     * Transaction setted.
     */
    public void closeDataBaseConnection(Session session) {
        session.close();
    }
}
