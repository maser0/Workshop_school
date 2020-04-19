package am;

import dao.UserDao;
import model.User;

public class Main1 {
    public static void main(String[] args) {
       User freshUser = new User ("Andrzej Moro", "moro@wp.pl", "ala", 1);
       // User freshUser = new User();

        UserDao user2 =  new UserDao();

        user2.createUser(freshUser);




    }
}
