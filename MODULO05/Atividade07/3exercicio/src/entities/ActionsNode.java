package entities;

public class ActionsNode {
    int actions;
    String text;
    int index;
    ActionsNode next;

    public ActionsNode(int actions, String text, Integer index) {
        this.actions = actions;
        this.text = text;
        this.index = (index != null) ? index: -1;
        this.next = null;
    }
}
