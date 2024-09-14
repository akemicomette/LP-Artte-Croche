package entities;

public class PrintQueue {
    private PrintJob head;
    private PrintJob tail;

    public PrintQueue() {
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addPrintJob(String clientName, String jobName) {
        PrintJob newJob = new PrintJob(clientName, jobName);

        if(tail == null) {
            head = tail = newJob;
        } else {
            tail.next = newJob;
            tail = newJob;
        }
    }

    public void nextJob() {
        if (head == null) {
            System.out.println("Nenhuma impressão na fila.");
            return;
        }
        System.out.println("Processando impressão do cliente: " + head.clientName + " documento: " + head.jobName);
        head = head.next;
        if(head == null) {
            tail = null;
        }
    }

    public void displayPrintQueue(){
        PrintJob current = head;

        while(current != null) {
            System.out.println(current.clientName + " impressão: " + current.jobName + ".");
            current = current.next;
        }
    }
}
