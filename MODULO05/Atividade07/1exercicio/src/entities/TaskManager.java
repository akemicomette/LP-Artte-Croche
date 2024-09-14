package entities;

public class TaskManager {

    private Task head;
    private int taskIdCounter;

    public TaskManager() {
        this.head = null;
        this.taskIdCounter = 1;
    }

    public void addTask(String nameTask) {
        Task newTask = new Task(taskIdCounter++, nameTask);
        if (head == null) {
            head = newTask;
        } else {
            Task current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newTask;
        }
    }

    public boolean isListEmpty() {
        return head == null;
    }

    public void removeTask(int id) {
        if (head == null){
            System.out.println("A lista esta vazia!");
            return;
        }
        if (head.id == id){
            head = head.next;
            return;
        }

        Task current = head;
        while(current.next != null) {
            if(current.next.id == id) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public void isDoneId(int id){
        Task current = head;
        while(current != null){
            if(current.id == id) {
                current.isDone();
                return;
            }
            current = current.next;
        }
    }

    public void displayTasks() {
        Task current = head;
        if (current == null) {
            System.out.println("Lista vazia");
        } else {
            System.out.println(current);
            current = current.next;
        }
    }
}
