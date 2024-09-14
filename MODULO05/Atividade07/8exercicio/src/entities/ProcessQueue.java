package entities;
import java.util.LinkedList;
import java.util.Queue;

public class ProcessQueue {
    private Queue<ProcessNode> processQueue;

    public ProcessQueue() {
        processQueue = new LinkedList<>();
    }

    public void addProcess(ProcessNode processName) {
       processQueue.add(processName);
        System.out.println("Process: " + processName.getProcessName() + " adicionado à fila" );
    }

    public void removeOldestProcess() {
        if(processQueue.isEmpty()) {
            System.out.println("Nenhum processo na fila.");
        } else {
            ProcessNode removedProcess = processQueue.poll();
            System.out.println("Processo: " + removedProcess.getProcessName() + " removido.");
        }
    }

    public void displayProcesses() {
        if(processQueue.isEmpty()) {
            System.out.println("Sem processos na fila.");
        } else {
            System.out.println("Processos na fila: " + processQueue);
        }
    }
}
