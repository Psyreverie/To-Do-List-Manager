package main;

public class TaskList {
    private TaskNode head;

    public void addTask(String description) {
        Task newTask = new Task(description);
        TaskNode newNode = new TaskNode(newTask);
        if (head == null) {
            head = newNode;
        } else {
            TaskNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public boolean markTaskAsCompleted(String description) {
        TaskNode current = head;
        while (current != null) {
            if (current.task.getDescription().equalsIgnoreCase(description)) {
                current.task.markAsCompleted();
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void printTasks() {
        TaskNode current = head;
        if (current == null) {
            System.out.println("No tasks in the list.");
            return;
        }
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }
}
