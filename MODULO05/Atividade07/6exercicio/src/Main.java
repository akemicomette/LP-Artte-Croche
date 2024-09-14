import entities.BankQueue;
import entities.Client;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankQueue bankQueue = new BankQueue();
        Scanner scanner = new Scanner(System.in);
        Queue<Client> queue = new LinkedList<>();

        int clientCounter = 1;
        int selection;

        do {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Adicionar cliente à fila");
            System.out.println("2. Chamar próximo cliente");
            System.out.println("3. Mostrar fila de clientes");
            System.out.println("4. Sair");
            System.out.print("> ");

            selection = scanner.nextInt();
            scanner.nextLine();

            switch(selection) {
                case 1:
                    System.out.println("Digite o nome do cliente: ");
                    String nameClient = scanner.nextLine();
                    bankQueue.addClient(clientCounter++, nameClient);
                    break;

                case 2:
                    if(bankQueue.isEmpty()) {
                        System.out.println("A fila está vazia.");
                    } else {
                        bankQueue.callNextClient();
                    }
                    break;

                case 3:
                    if(bankQueue.isEmpty()) {
                        System.out.println("A fila está vazia.");
                    } else {
                        bankQueue.displayQueue();
                    }
                    break;

                case 4:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida, tente novamente!");
            }
        } while (selection != 4);
    }
}
