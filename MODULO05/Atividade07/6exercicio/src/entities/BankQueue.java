package entities;

public class BankQueue {
    private Client first;
    private Client last;

    public BankQueue() {
        this.first = null;
        this.last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void addClient(Integer id, String name){
        Client newClient = new Client(id, name);
        if(last == null){
            first = last = newClient;
        } else {
            last.next = newClient;
            last = newClient;
        }
    }

    public void callNextClient(){
        if(isEmpty()) {
            System.out.println("Não existem clientes na fila.");
            return;
        }
        System.out.println("Próximo cliente: " + first.id + " " + first.name);
        first = first.next;
        if(first == null) {
            last = null;
        }
    }

    public void displayQueue() {
        if(isEmpty()){
            System.out.println("Não há mais clientes na fila.");
            return;
        }
        Client current = first;
        while(current != null) {
            System.out.println(current + " ");
            current = current.next;
        }
    }
}
