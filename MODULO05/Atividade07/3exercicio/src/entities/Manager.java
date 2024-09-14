package entities;

public class Manager {
    private ActionsNode head;
    private StringBuilder text;

    public Manager(){
        this.head = null;
        this.text = new StringBuilder();
    }

    public void addText(String newText) {
        ActionsNode newNode = new ActionsNode(1, newText, null);
        newNode.next = head;
        head = newNode;
        text.append(newText);
        System.out.println("Ação concluída! Texto adicionado: '" + newText + "'.");
    }

    public void removeText(String textRemoved) {
        int index = text.indexOf(textRemoved);
        if(index != -1) {
            ActionsNode newNode = new ActionsNode(2, textRemoved, index);
            newNode.next = head;
            head = newNode;

            text.delete(index, index + textRemoved.length());
            System.out.println("Texto removido: '" + textRemoved + "'.");
        } else {
            System.out.println("Texto não encontrado.");
        }
    }

    public void editText(String oldText, String newText) {
        int index = text.indexOf(oldText);
        if (index != -1) {
            ActionsNode newNode = new ActionsNode(3, oldText, index);
            newNode.next = head;
            head = newNode;

            text.replace(index, index + oldText.length(), newText);
            System.out.println("Texto editado: '" + oldText + "' para '" + newText + "'.");
        } else {
            System.out.println("Texto não encontrado: '" + oldText + "'.");
        }
    }

    public void undo() {
        if (head != null) {
            switch (head.actions) {
                case 1:
                    text.delete(text.length() - head.text.length(), text.length());
                    System.out.println("Adição de texto desfeita. Texto atualizado para: '" + head.text + "'.");
                    break;
                case 2:
                    text.insert(head.index, head.text);
                    System.out.println("Remoção de texto desfeita. Texto atualizado para: '" + head.text + "'.");
                    break;
                case 3:
                    text.replace(head.index, head.index + head.text.length(), head.text);
                    System.out.println("Edição de texto desfeita. Texto atualizado para: '" + head.text + "'.");
                    break;
                default:
                    System.out.println("Ação inválida, tente novamente!");
                    break;
            }
            head = head.next;
        } else {
            System.out.println("Nenhuma ação no histórico para desfazer.");
        }
    }

    public void displayText() {
        System.out.println("Texto atual: '" + text.toString() + "'.");
    }
}
