package am.admin;

import dao.SolutionDao;
import model.Solution;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class Program1 {
    public static void main(String[] args) {

        int userID=1;
        String option = null;
        SolutionDao solutionDao = new SolutionDao();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Wybierz jedną z opcji: ");
        System.out.println("add");
        System.out.println("view");
        option = scanner.next();
        switch (option) {
            case "add":

                Solution solution = new Solution();
                System.out.println(Arrays.toString(solutionDao.findAllExercisesWithoutSolution(userID)));
                System.out.println("Wprowadz id zadania do którego chcesz dodać odpowiedz: ");
                int exerciseID= scanner.nextInt();
                System.out.println("Wprowadz rozwiązanie zadania :");
                String description = scanner.nextLine();
                solution.setUser_id(userID);
                solution.setExercise_id(exerciseID);
                solution.setDescription(description);
                solution.setCreated(LocalDate.now().toString());
                solution.setUpdated(null);
                solutionDao.createSolution(solution);
                break;
            case "view":
                //SolutionDao solutionDao = new SolutionDao();
                Solution[] solutions = solutionDao.findAllSolutionsByUserId(userID);
                for (Solution solution1: solutions) {
                    System.out.println(solution1);
                }
                break;
            case "quit":
            default:
                break;
        } while ("quit".equalsIgnoreCase(option));
    }

}




