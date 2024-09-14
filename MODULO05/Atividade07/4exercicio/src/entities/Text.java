package entities;

public class Text {
    String text;
    Text prev;
    Text next;

    public Text(String text) {
        this.text = text;
        this.prev = null;
        this.next = null;
    }

    @Override
    public String toString() {
        return text;
    }
}
