package am.admin;

import dao.ExerciseDao;
import dao.SolutionDao;
import dao.UserDao;
import model.Exercise;
import model.Solution;
import model.User;

import java.time.LocalDate;
import java.util.Scanner;

public class SolutionsAdmin {
    public static void main(String[] args) {
        SolutionDao solutionDao = new SolutionDao();
        String option = null;

        do {
            Solution[] allSolutions = solutionDao.findAll();
            for (Solution solution : allSolutions) {
                System.out.println(solution);
            }
            System.out.print("Wybierz jedną z opcji: ");
            System.out.println("add");
            System.out.println("view");
            System.out.println("quit");
            Scanner scanner = new Scanner(System.in);
            while (!scanner.hasNextLine()) {
                scanner.nextLine();
                System.out.print("Wybierz poprawną opcję: ");
            }
            option = scanner.next();
            Solution solution = new Solution();
            switch (option) {
                case "add":
                   // Date date = new Date();
                    UserDao userDao = new UserDao();
                    User[] users = userDao.findAll();
                    ExerciseDao exerciseDao = new ExerciseDao();
                 //   Exercise exercise = new Exercise();
                    for (User user: users) {
                        System.out.println(user);
                    }
                    System.out.println("Wybierz id użytkownika");
                    int userId = scanner.nextInt();
                    Exercise[] exercises = exerciseDao.findAll();
                    for(Exercise exercise1: exercises) {
                        System.out.println(exercise1);
                    }
                    System.out.println("Wybierz id zadania: ");
                    int exerciseId = scanner.nextInt();
                    solution.setCreated(LocalDate.now().toString());
                    solution.setUpdated(null);
                    solution.setDescription(null);
                    solution.setExercise_id(exerciseId);
                    solution.setUser_id(userId);
                    solutionDao.createSolution(solution);
                    break;
                case "view":
                    System.out.println("Wprowadź id użytkownika, którego rozwiązania chcesz zobaczyć: ");
                    int solutionId = scanner.nextInt();
                    Solution[] solutions = solutionDao.findAllSolutionsByUserId(solutionId);
                    for (Solution solution1: solutions) {
                        System.out.println(solution1);
                    }
                    break;
                case "quit":
                default:
                    break;
            }
        } while ("quit".equalsIgnoreCase(option));
    }
}
