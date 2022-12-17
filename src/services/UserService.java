package services;

import classes.User;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import repository.UserRepository;
import resources.en_translations.Translations;

/**
 * UserService Class.
 *
 * Class that manages and makes the users background processes.
 *
 * @author Jorge Vázquez Casaus.
 * @version 1.0.
 * @since 16/12/2022.
 */
public class UserService {

    private UserRepository userRepository;

    /**
     * UserService Constructor.
     *
     * @throws Exception if cant connect to DB.
     */
    public UserService() throws Exception {
        this.userRepository = new UserRepository();

    }

    /**
     * Check if the login fields are correct and can make the login.
     *
     * @param email Its the email attribute of an User. It matches with the
     * column in User table of DB with the same name.
     * @param password Its the password attribute of an User. It matches with
     * the column in User table of DB with the same name.
     * @return boolean true or false that depends the condition.
     * @throws Exception to the controller if the some input is incorrect.
     */
    public boolean isCorrectLogin(String email, String password) throws Exception {
        User user = this.userRepository.findOneByEmail(email);
        if (!user.getEmail().equals(email) || !user.getPassword().equals(password)) {
            throw new Exception(Translations.INCORRECT_USER_OR_PASSWORD_EXCEPTION);
        }
        return true;
    }

    /**
     * Check if the userName input is or not valid.
     *
     * @param userName Its the userName attribute of an User. It matches with
     * the column in User table of DB with the same name.
     * @return boolean true or false that depends the condition.
     * @throws Exception to the controller if the input is incorrect.
     */
    public boolean isValidUserName(String userName) throws Exception {
        if (userName.equals(Translations.DEFAULT_USERNAME_TEXT)) {
            throw new Exception(Translations.INVALID_USERNAME_EXCEPTION);
        }
        try {
            this.userRepository.findOneByUserName(userName);
        } catch (Exception exception) {
            return true;
        }
        throw new Exception(Translations.INVALID_USERNAME_EXCEPTION);
    }

    /**
     * Check if the email input is or not valid.
     *
     * @param email Its the email attribute of an User. It matches with the
     * column in User table of DB with the same name.
     * @return boolean true or false that depends the condition.
     * @throws Exception to the controller if the input is incorrect.
     */
    public boolean isValidEmail(String email) throws Exception {
        if (email.equals(Translations.DEFAULT_EMAIL_TEXT)) {
            throw new Exception(Translations.INVALID_EMAIL_EXCEPTION);
        }
        try {
            this.userRepository.findOneByEmail(email);
        } catch (Exception exception) {
            return true;
        }
        throw new Exception(Translations.INVALID_EMAIL_EXCEPTION);
    }

    /**
     * Check if the password input is or not valid.
     *
     * @param password Its the email attribute of an User. It matches with the
     * column in User table of DB with the same name.
     * @throws Exception to the controller if the input is incorrect.
     */
    public void isValidPassword(String password) throws Exception {
        if (password.equals(Translations.DEFAULT_PASSWORD_TEXT)) {
            throw new Exception(Translations.INVALID_PASSWORD_EXCEPTION);
        }
    }

    /**
     * Creates a new User object that references a user row in DB. It matches
     * with the product with the same name.
     *
     * @param userName Its the userName attribute of an User. It matches with
     * the column in User table of DB with the same name.
     * @param email Its the email attribute of an User. It matches with the
     * column in User table of DB with the same name.
     * @param password Its the email attribute of an User. It matches with the
     * column in User table of DB with the same name.
     * @param age Its the age of user. It matches with the column in User table
     * of DB with the same name.
     * @return
     */
    public User createNewUser(String userName, String email, String password, int age) {
        Timestamp now = Timestamp.valueOf(LocalDateTime.now());
        User user = new User(userName, email, password, age, false, now);
        user.setId(null);
        user.setModificationDate(null);
        return user;
    }

    /**
     * Calls the userRepository and try to save and store a new User in DB.
     * 
     * @param user Its object that references a user row in DB. It matches with
     * the product with the same name.
     * @throws Exception If cant make the save order, sends the error to the
     * controller.
     */
    public void save(User user) throws Exception {
        this.userRepository.save(user);
    }

    /**
     * Try to find, get and return one User by his attribute "email.
     * 
     * @param email Its the email attribute of an User. It matches with the
     * column in User table of DB with the same name.
     * @return User object that references a user row in DB. It matches with the
     * product with the same name.
     * @throws Exception If cant make the update order, sends the error to the
     * controller.
     */
    public User getUserByEmail(String email) throws Exception {
        return this.userRepository.findOneByEmail(email);
    }
}
