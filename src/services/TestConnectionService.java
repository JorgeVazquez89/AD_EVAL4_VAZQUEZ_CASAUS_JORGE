package services;

import repository.TestConnectionRepository;

/**
 * TestConnectionService Class.
 *
 * Class that try to make a new test connection to DB as background process.
 *
 * @author Jorge Vázquez Casaus.
 * @version 1.0.
 * @since 16/12/2022.
 */
public class TestConnectionService {
    
    private TestConnectionRepository testConnectionRepository;
    
    /**
     * TestConnectionRepository Constructor.
     * 
     * @throws Exception if cant connect to DB.
     */
    public TestConnectionService() throws Exception{
        this.testConnectionRepository = new TestConnectionRepository();
    }
    
    /**
     * Calls testConnectionRepository and try to make a new connection.
     * 
     * @throws Exception if cant connect to DB.
     */
    public void testConnection()throws Exception{  
        this.testConnectionRepository.testConnection();
    } 
}
