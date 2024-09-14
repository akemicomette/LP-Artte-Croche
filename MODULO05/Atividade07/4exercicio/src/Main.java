import java.util.Scanner;
import entities.TextEditor;

public class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        Scanner scanner = new Scanner(System.in);
        int selection;

        do {
            System.out.println("\nEscolha uma das opções abaixo: ");
            System.out.println("1. Adicionar o texto: ");
            System.out.println("2. Desfazer a última ação.");
            System.out.println("3. Refazer a última ação");
            System.out.println("4. Mostrar texto atual.");
            System.out.println("5. Sair do menu.");
            System.out.print("> ");

            selection = scanner.nextInt();
            scanner.nextLine();

            switch (selection) {
                case 1:
                    System.out.print("Digite o texto que deseja adicionar: ");
                    String text = scanner.nextLine();
                    editor.addText(text);
                    break;
                case 2:
                    editor.undo();
                    break;
                case 3:
                    editor.redo();
                    break;
                case 4:
                    editor.displayText();
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

