package entities;

public class Task {
    int id;
    String nameTask;
    boolean done;
    Task next;

    public Task(int id, String nameTask) {
        this.id = id;
        this.nameTask = nameTask;
        this.done = false;
        this.next = null;
    }

    public void isDone() {
        this.done = true;
    }

    @Override
    public String toString() {
        return "Tarefa " + id + ": " + nameTask + (done ? " [X]" : " [ ]");
    }
}
