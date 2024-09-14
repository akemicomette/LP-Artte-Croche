package entities;

public class Client {
    String name;
    Client next;
    int id;

    public Client(int id, String name){
        this.name = name;
        this.id = id;
        this.next = null;
    }

    @Override
    public String toString() {
        return "Id: "+ id + " Cliente: " + name + ".";
    }
}
