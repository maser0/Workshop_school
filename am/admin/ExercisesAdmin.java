package am.admin;

import dao.ExerciseDao;
import model.Exercise;

import java.util.Scanner;

public class ExercisesAdmin {

    public static void main(String[] args) {
        ExerciseDao exerciseDao = new ExerciseDao();
        String option = null;
        do {
            Exercise[] allExercises = exerciseDao.findAll();
            for (Exercise exercise : allExercises) {
                System.out.println(exercise);
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
                    Exercise exercise = new Exercise();
                    System.out.print("Wprowadź nazwę nowego zadania: ");
                    String title = scanner.nextLine();
                    System.out.println("Wprowadz opis zadania : ");
                    String description = scanner.next();
                    exercise.setTitle(title);
                    exercise.setDescription(description);
                    exerciseDao.createExercise(exercise);
                    break;
                case "edit":
                    System.out.print("Podaj id zadania do edycji: ");
                    int exerciseId = scanner.nextInt();
                    Exercise toUpdate = exerciseDao.read(exerciseId);
                    if (toUpdate == null) {
                        System.out.println("Zadanie o takim id nie istnieje.");
                        break;
                    }
                    System.out.print("Wprowadź nową nazwę: ");
                    String newExerciseTitle = scanner.next();
                    System.out.println("Wprowadz nowy opis: ");
                    String newExerciseDescription = scanner.next();
                    toUpdate.setTitle(newExerciseTitle);
                    toUpdate.setDescription(newExerciseDescription);
                    exerciseDao.update(toUpdate);
                    break;
                case "delete":
                    System.out.print("Podaj id zadania do usunięcia: ");
                    exerciseId = scanner.nextInt();
                    exerciseDao.delete(exerciseId);
                    break;
                case "quit":
                default:
                    break;
            }
        } while (!"quit".equals(option));
    }
}

