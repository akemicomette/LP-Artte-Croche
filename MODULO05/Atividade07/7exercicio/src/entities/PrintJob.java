package entities;

public class PrintJob {
    String jobName;
    String clientName;
    PrintJob next;

    public PrintJob(String clientName, String jobName){
        this.clientName = clientName;
        this.jobName = jobName;
        this.next = null;
    }

    @Override
    public String toString() {
        return "Cliente: " + clientName + " documento: " + jobName + ".";
    }
}
