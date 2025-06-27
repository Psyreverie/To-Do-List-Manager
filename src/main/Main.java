package main;

import java.util.Scanner;

public class Main {
    private static final int MAX_USERS = 10;
    private static User[] users = new User[MAX_USERS];
    private static int userCount = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Welcome to the To-Do List Manager ===");

        boolean running = true;
        while (running) {
            printMenu();
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    createUser();
                    break;
                case "2":
                    addTaskToUser();
                    break;
                case "3":
                    markTaskAsCompleted();
                    break;
                case "4":
                    viewUserTasks();
                    break;
                case "5":
                    listAllUsers();
                    break;
                case "6":
                    running = false;
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\nMenu Options:");
        System.out.println("1. Create a new user");
        System.out.println("2. Add a task to a user");
        System.out.println("3. Mark a task as completed");
        System.out.println("4. View tasks for a user");
        System.out.println("5. View all users");
        System.out.println("6. Exit");
    }

    private static void createUser() {
        if (userCount >= MAX_USERS) {
            System.out.println("User limit reached.");
            return;
        }
        System.out.print("Enter new user's name: ");
        String name = scanner.nextLine();

        if (findUser(name) != null) {
            System.out.println("User with that name already exists.");
            return;
        }

        users[userCount++] = new User(name);
        System.out.println("User '" + name + "' created.");
    }

    private static void addTaskToUser() {
        User user = promptUser();
        if (user == null) return;

        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        user.addTask(description);
        System.out.println("Task added to " + user.getName() + "'s list.");
    }

    private static void markTaskAsCompleted() {
        User user = promptUser();
        if (user == null) return;

        System.out.print("Enter the description of the task to mark completed: ");
        String desc = scanner.nextLine();
        user.completeTask(desc);
    }

    private static void viewUserTasks() {
        User user = promptUser();
        if (user == null) return;

        user.printAllTasks();
    }

    private static void listAllUsers() {
        if (userCount == 0) {
            System.out.println("No users created yet.");
            return;
        }

        System.out.println("Registered users:");
        for (int i = 0; i < userCount; i++) {
            System.out.println("- " + users[i].getName());
        }
    }

    private static User promptUser() {
        if (userCount == 0) {
            System.out.println("No users available. Create a user first.");
            return null;
        }

        System.out.print("Enter user's name: ");
        String name = scanner.nextLine();
        User user = findUser(name);
        if (user == null) {
            System.out.println("User not found.");
        }
        return user;
    }

    private static User findUser(String name) {
        for (int i = 0; i < userCount; i++) {
            if (users[i].getName().equalsIgnoreCase(name)) {
                return users[i];
            }
        }
        return null;
    }
}
