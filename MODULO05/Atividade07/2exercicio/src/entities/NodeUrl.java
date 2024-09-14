package entities;

public class NodeUrl {
    int id;
    String linkURL;
    NodeUrl next;

    public NodeUrl(int id, String linkURL) {
        this.id = id;
        this.linkURL = linkURL;
        this.next = null;
    }

    @Override
    public String toString() {
        return "Link " + id + ": " + linkURL;
    }
}
