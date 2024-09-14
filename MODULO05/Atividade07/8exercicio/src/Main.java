import java.util.Scanner;

import entities.ProcessNode;
import entities.ProcessQueue;

public class Main {
    public static void main(String[] args) {
        ProcessQueue processQueue = new ProcessQueue();
        Scanner scanner = new Scanner(System.in);
        int selection;

        do {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Adicionar processo à fila.");
            System.out.println("2. Remover processo mais antigo.");
            System.out.println("3. Mostrar fila de processos");
            System.out.println("4. Sair");
            System.out.print("> ");

            selection = scanner.nextInt();
            scanner.nextLine();

            switch (selection) {
                case 1:
                    System.out.println("Digite o protocolo do processo: ");
                    String processName = scanner.nextLine();
                    ProcessNode process = new ProcessNode(processName);
                    processQueue.addProcess(process);
                    break;

                case 2:
                    processQueue.removeOldestProcess();
                    break;

                case 3:
                    processQueue.displayProcesses();
                    break;

                case 4:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida, tente novamente!");
            }
        }while (selection != 4) ;
    }
}
