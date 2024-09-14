import java.util.Scanner;
import entities.PrintQueue;

public class Main {
    public static void main(String[] args) {
        PrintQueue printQueue = new PrintQueue();
        Scanner scanner = new Scanner(System.in);
        int selection;

        do {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Adicionar cliente à fila.");
            System.out.println("2. Processando trabalho");
            System.out.println("3. Mostrar fila de trabalhos");
            System.out.println("4. Sair");
            System.out.print("> ");

            selection = scanner.nextInt();
            scanner.nextLine();

            switch (selection) {
                case 1:
                    System.out.println("Digite o nome do cliente: ");
                    String clientName = scanner.nextLine();
                    System.out.println("Digite o nome do trabalho: ");
                    String jobName = scanner.nextLine();
                    printQueue.addPrintJob(clientName, jobName);
                    break;

                case 2:
                    if (printQueue.isEmpty()) {
                        System.out.println("A fila está vazia.");
                    } else {
                        printQueue.nextJob();
                    }
                    break;

                case 3:
                    if (printQueue.isEmpty()) {
                        System.out.println("A fila está vazia.");
                    } else {
                        printQueue.displayPrintQueue();
                    }
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
