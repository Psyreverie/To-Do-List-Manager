package main;

public class Task {
    private String description;
    private boolean isCompleted;

    public Task(String description) {
        this.description = description;
        this.isCompleted = false;
    }

    public void markAsCompleted() {
        isCompleted = true;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    @Override
    public String toString() {
        return description + " [" + (isCompleted ? "Completed" : "Pending") + "]";
    }
}

