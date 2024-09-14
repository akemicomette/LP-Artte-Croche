package entities;

public class TextEditor {
    private Text current;
    private Text lastAction;
    private Text undoRedo;

    public TextEditor() {
        this.current = null;
        this.lastAction = null;
        this.undoRedo = null;
    }

    public void addText(String text) {
        Text newContent = new Text(text);
        if (current == null) {
            current = newContent;
        } else {
            current.next = newContent;
            newContent.prev = current;
            current = newContent;
        }
        lastAction = current;
        undoRedo = current;
    }

    public void undo() {
        if (current == null) {
            System.out.println("Nada para desfazer.");
            return;
        }
        System.out.println("Desfazendo ultima ação, texto atual: " + current.text);
        undoRedo = current;
        current = current.prev;
        if(current != null) {
            lastAction = current;
        }
    }

    public void redo() {
        if (undoRedo == null) {
            System.out.println("Nenhuma ação para refazer");
            return;
        }
        System.out.println("Refazendo última ação, texto atual: " + current.text);
        current = undoRedo;
        lastAction = current;
        undoRedo = undoRedo.next;
    }

    public void displayText() {
        if (current == null) {
            System.out.println("Texto vazio.");
            return;
        }
        System.out.println("Texto atual: '" + current.text + "'.");
    }
}
