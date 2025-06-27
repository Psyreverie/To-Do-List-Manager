package main;

public class User {
    private String name;
    private TaskList taskList;

    public User(String name) {
        this.name = name;
        this.taskList = new TaskList();
    }

    public String getName() {
        return name;
    }

    public void addTask(String description) {
        taskList.addTask(description);
    }

    public void completeTask(String description) {
        if (!taskList.markTaskAsCompleted(description)) {
            System.out.println("Task not found for user: " + name);
        }
    }

    public void printAllTasks() {
        System.out.println("Tasks for " + name + ":");
        taskList.printTasks();
    }
}

