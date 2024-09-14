import java.util.Scanner;
import entities.TaskManager;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);
        int selection;


        do {
            System.out.println("\n Escolha uma das opções abaixo: ");
            System.out.println("1. Adicione uma tarefa.");
            System.out.println("2. Remova uma tarefa.");
            System.out.println("3. Marque uma tarefa como concluída.");
            System.out.println("4. Mostre todas as tarefas.");
            System.out.println("5. Sair do menu de opções.");
            System.out.print("> ");

            selection = scanner.nextInt();
            scanner.nextLine();

            switch (selection) {
                case 1:
                    System.out.println("Digite a tarefa que deseja adicionar: ");
                    String nameTask = scanner.nextLine();
                    taskManager.addTask(nameTask);
                    break;
                case 2:
                    if (taskManager.isListEmpty()){
                        System.out.println("Lista de tarefas vazia. Não há tarefas para remover.");
                    } else {
                        System.out.println("Digite o código da tarefa que deseja apagar:");
                        System.out.print("> ");
                        int removeId = scanner.nextInt();
                        taskManager.removeTask(removeId);
                    }
                    break;
                case 3:
                    if (taskManager.isListEmpty()){
                        System.out.println("Lista de tarefas vazia. Não há tarefas para marcar como concluídas.");
                    } else {
                        System.out.print("Digite o código da tarefa que deseja marcar como concluída: ");
                        System.out.print("> ");
                        int doneId = scanner.nextInt();
                        taskManager.isDoneId(doneId);
                    }
                    break;
                case 4:
                    if (taskManager.isListEmpty()){
                        System.out.println("Lista de tarefas vazia! ");
                    } else {
                        taskManager.displayTasks();
                    }
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Por favor tente novamente.");
            }
        } while
        (selection != 5);
    }
}
