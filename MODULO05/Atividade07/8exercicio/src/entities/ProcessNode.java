package entities;

public class ProcessNode {
    String processName;

    public ProcessNode(String processName) {
        this.processName = processName;
    }

    public String getProcessName() {
        return processName;
    }

    @Override
    public String toString() {
        return "Processo: " + processName;
    }
}
