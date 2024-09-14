import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import entities.ManageCards;
import entities.Card;

public class Main {
    public static void main(String[] args) {
        ManageCards handManager = new ManageCards();
        Scanner scanner = new Scanner(System.in);

        int selection;
        List<String> validNumbers = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A");
        List<String> validSuits = Arrays.asList("paus", "ouro", "copas", "espadas");

        do {
            System.out.println("\nEscolha uma das opções abaixo: ");
            System.out.println("1. Adicionar uma carta: ");
            System.out.println("2. Remover uma carta.");
            System.out.println("3. Reorganize uma carta.");
            System.out.println("4. Mostrar as cartas.");
            System.out.println("5. Sair do menu.");
            System.out.print("> ");

            selection = scanner.nextInt();
            scanner.nextLine();

            switch (selection) {
                case 1:
                    String cardNumber;
                    while(true) {
                        System.out.print("Digite o número da carta (1, 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K, A): ");
                        cardNumber = scanner.nextLine().toUpperCase();
                        if(validNumbers.contains(cardNumber)){
                            break;
                        } else {
                            System.out.println("Número inválido. Tente novamente.");
                        }
                    }
                    String cardSuit;
                    while(true){
                        System.out.println("Escolha o naipe da carta (paus, ouro, copas, espadas): ");
                        cardSuit = scanner.nextLine().toLowerCase();
                        if(validSuits.contains(cardSuit)) {
                            break;
                        } else {
                            System.out.println("Naipe inválido. Tente novamente.");
                        }
                    }
                    Card card = new Card(cardNumber,cardSuit);
                    handManager.addCard(card);
                    break;

                case 2:
                    if(handManager.isEmpty()) {
                        System.out.println("A mão está vazia.");
                        return;
                    } else {
                        System.out.println("Digite a posição da carta que deseja remover: ");
                        int position = scanner.nextInt();
                        handManager.removeCard(position);
                    }
                    break;

                case 3:
                    if(handManager.isEmpty()) {
                        System.out.println("A mão está vazia.");
                        return;
                    } else {
                        System.out.println("Digite a posição da carta que deseja mover: ");
                        int initialPosition = scanner.nextInt();;
                        System.out.println("Digite a nova posição: ");
                        int finalPosition = scanner.nextInt();
                        handManager.moveCard(initialPosition, finalPosition);
                    }
                    break;

                case 4:
                    handManager.displayHand();
                    break;

                case 5:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Por favor tente novamente.");
            }
        } while (selection != 5);
    }
}
