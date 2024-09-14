package entities;

public class BrowsingHistory {
    private NodeUrl head;
    private int linkIdCounter;
    private int size;
    private int maxSize;

    public BrowsingHistory(int maxSize) {
        this.head = null;
        this.linkIdCounter = 1;
        this.size = 0;
        this.maxSize = maxSize;
    }

    public void addURL(String linkURL) {
        NodeUrl newNodeUrl = new NodeUrl(linkIdCounter++, linkURL);
        if (head == null) {
            head = newNodeUrl;
        } else {
            NodeUrl current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNodeUrl;
        }
        size++;

        if(size > maxSize) {
            removeOldestUrl();
        }
    }

    public boolean isListEmpty() {
        return head == null;
    }

    public void removeOldestUrl() {
        if(head == null) {
            System.out.println("O histórico está vazio!");
            return;
        }
        head = head.next;
        size--;
    }

    public void removeUrl(int id) {
        if(head == null) {
            System.out.println("O histórico está vazio!");
            return;
        }
        if (head.id == id){
            head = head.next;
            return;
        }
        NodeUrl current = head;
        while(current.next != null) {
            if(current.next.id == id) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public void displayHistory(){
        NodeUrl current = head;
        if(current == null){
            System.out.println("Histórico vazio!");
        } else {
            System.out.println("Histórico de navegação: ");
            while (current != null) {
                System.out.println(current);
                current = current.next;
            }
        }
    }
}
