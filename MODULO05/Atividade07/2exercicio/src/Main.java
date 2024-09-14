import java.util.Scanner;
import entities.BrowsingHistory;

public class Main {
    public static void main(String[] args) {
        BrowsingHistory browsingHistory = new BrowsingHistory(5);
        Scanner scanner = new Scanner(System.in);
        int selection;

        do {
            System.out.println("\n Escolha uma das opções abaixo: ");
            System.out.println("1. Adicione um link URL.");
            System.out.println("2. Remova um link URL.");
            System.out.println("3. Remova o link mais antigo do histórico");
            System.out.println("4. Mostre todo o histórico.");
            System.out.println("5. Sair do menu de opções.");
            System.out.print("> ");

            selection = scanner.nextInt();
            scanner.nextLine();

            switch (selection) {
                case 1:
                    System.out.println("Digite o link que deseja adicionar: ");
                    String linkURL = scanner.nextLine();
                    browsingHistory.addURL(linkURL);
                    break;
                case 2:
                    if (browsingHistory.isListEmpty()) {
                        System.out.println("Histórico vazio. Não há links para remover.");
                    } else {
                        System.out.println("Digite o código do link que deseja apagar:");
                        System.out.print("> ");
                        int removeId = scanner.nextInt();
                        browsingHistory.removeUrl(removeId);
                    }
                    break;
                case 3:
                    if (browsingHistory.isListEmpty()) {
                        System.out.println("Histórico vazio. Não há links para remover.");
                    } else {
                        System.out.println("Link mais antigo será removido");
                        browsingHistory.removeOldestUrl();
                    }
                    break;
                case 4:
                    if (browsingHistory.isListEmpty()) {
                        System.out.println("Histórico vazio. ");
                    } else {
                        browsingHistory.displayHistory();
                    }
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Por favor tente novamente");
            }
        } while (selection != 5);
    }
}