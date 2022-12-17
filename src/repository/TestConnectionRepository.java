package repository;

import dataBaseConnection.DataBase;
import org.hibernate.Session;

/**
 * TestConnectionRepository Class.
 *
 * Class that try to make a connection with the DB with the objective of test if
 * DB is up.
 *
 * @author Jorge Vázquez Casaus.
 * @version 1.0.
 * @since 16/12/2022.
 */
public class TestConnectionRepository {

    private DataBase dataBase;

    /**
     * TestConnectionRepository constructor.
     *
     * @throws Exception if cant connect to DB.
     */
    public TestConnectionRepository() throws Exception {
        this.dataBase = new DataBase();
    }

    /**
     * Try to open and close one session with DB with the objective of test if
     * DB is up.
     *
     * @throws Exception if cant connect to DB.
     */
    public void testConnection() throws Exception {
        Session session = this.dataBase.openDataBaseConnection();
        this.dataBase.closeDataBaseConnection(session);
    }
}
