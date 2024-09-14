import java.util.Scanner;
import entities.Manager;

public class Main {
    public static void main(String[] args) {
        Manager undoManager = new Manager();
        Scanner scanner = new Scanner(System.in);
        int selection;

        do {
            System.out.println("\n Escolha uma das opções abaixo: ");
            System.out.println("1. Adicionar texto.");
            System.out.println("2. Remover texto.");
            System.out.println("3. Editar texto.");
            System.out.println("4. Desfazer última ação.");
            System.out.println("5. Exibir texto atual.");
            System.out.println("6. Sair do menu.");
            System.out.print("> ");

            selection = scanner.nextInt();
            scanner.nextLine();

            switch (selection) {
                case 1:
                    System.out.println("Digite o texto que deseja adicionar: ");
                    String newText = scanner.nextLine();
                    undoManager.addText(newText);
                    break;
                case 2:
                    System.out.println("Digite o texto que deseja remover: ");
                    String removeText = scanner.nextLine();
                    undoManager.removeText(removeText);
                    break;
                case 3:
                    System.out.println("Digite o texto que deseja editar: ");
                    String oldText = scanner.nextLine();
                    System.out.println("Digite o novo texto: ");
                    String newEditText = scanner.nextLine();
                    undoManager.editText(oldText, newEditText);
                    break;
               case 4:
                    undoManager.undo();
                    break;
               case 5:
                    undoManager.displayText();
                    break;
               case 6:
                    System.out.println("Saindo ");
                    break;

                default:
                    System.out.println("Opção inválida! Por favor tente novamente");
            }
        } while (selection != 6);
    }
}
