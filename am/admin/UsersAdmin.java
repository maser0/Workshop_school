package am.admin;

import dao.UserDao;
import model.User;

import java.util.Scanner;

public class UsersAdmin {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        String option = null;
        do {
            User[] allUsers = userDao.findAll();
            for (User user : allUsers) {
                System.out.println(user);
            }
            System.out.print("Wybierz jedną z opcji: ");
            System.out.println("add");
            System.out.println("edit");
            System.out.println("delete");
            System.out.println("quit");
            Scanner scanner = new Scanner(System.in);
            while (!scanner.hasNextLine()) {
                System.out.print("Wprowadź poprawną opcję: ");
                scanner.nextLine();
            }
            option = scanner.nextLine();
            switch (option) {
                case "add":
                    User user = new User();
                    System.out.print("Wprowadź nazwę nowego użytkowninka: ");
                    String newName = scanner.nextLine();
                    System.out.print("Wprowadź email dla nowego użytkownika: ");
                    String newMail = scanner.nextLine();
                    System.out.print("Wprowadź hasło dla nowego użytkownika: ");
                    String newPassword = scanner.nextLine();
                    System.out.print("Wprowadź  id grupy: ");
                    int newGroupId = scanner.nextInt();
                    user.setUserName(newName);
                    user.setEmail(newMail);
                    user.setPassword(newPassword);
                    user.setGroupId(newGroupId);

                    userDao.createUser(user);
                    break;
                case "edit":
                    System.out.print("Podaj id użytkownika do edycji: ");
                    int userId = scanner.nextInt();
                    User toUpdate = userDao.read(userId);
                    if (toUpdate==null) {
                        System.out.println("Użytkownik o takim id nie istnieje.");
                        break;
                    }
                    System.out.print("Wprowadź nową nazwę: ");
                    String newUserName = scanner.next();
                    System.out.println("Wprowadz nowy email: ");
                    String newUserMail = scanner.next();
                    System.out.println("Wprowadz nowe hasło: ");
                    String newUserPassword = scanner.next();
                    System.out.println("Wprowadz nowe id grupy: ");
                    int newUserGroupID = scanner.nextInt();
                    toUpdate.setUserName(newUserName);
                    toUpdate.setEmail(newUserMail);
                    toUpdate.setPassword(newUserPassword);
                    toUpdate.setGroupId(newUserGroupID);
                    userDao.update(toUpdate);
                    break;
                case "delete":
                    System.out.print("Podaj id użytkownika do usunięcia: ");
                    userId = scanner.nextInt();
                    userDao.delete(userId);
                    break;
                case "quit":
                default:
                    break;
            }
        } while (!"quit".equals(option));
    }
}