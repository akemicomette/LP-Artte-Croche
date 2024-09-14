package entities;

public class ManageCards {
    private Node head;
    private Node end;

    public boolean isEmpty() {
        return head == null;
    }

    public void addCard(Card card) {
        Node newCard = new Node(card);

        if(isEmpty()) {
            head = end = newCard;
        } else {
            end.next = newCard;
            newCard.prev = end;
            end = newCard;
        }
        System.out.println("Carta adicionada: " + card);
    }

    public void removeCard(int position) {
        if(isEmpty()) {
            System.out.println("Não existem cartas na mão.");
            return;
        }
        Node current = head;
        int counter = 1;

        while(current != null && counter < position) {
            current = current.next;
            counter++;
        }
        if(current == null) {
            System.out.println("Posição invalida!");
            return;
        }
        if(current.prev != null){
            current.prev.next = current.next;
        } else {
            head = current.next;
        }
        if(current.next != null) {
            current.next.prev = current.prev;
        } else {
            end = current.prev;
        }
        System.out.println("Carta removida: " + current.card);
    }

    public void moveCard(int initialPosition, int finalPosition) {
        if(isEmpty()) {
            System.out.println("A mão está vazia.");
            return;
        }

        if (initialPosition == finalPosition) {
            System.out.println("As posições que deseja movimentar as cartas são iguais.");
            return;
        }

        Node current = head;
        int counter = 1;

        while (current != null && counter < initialPosition) {
            current = current.next;
            counter++;
        }

        if (current == null) {
            System.out.println("Posição de origem inválida.");
            return;
        }

        Card moveCard = current.card;

        if (current.prev != null) {
            current.prev.next = current.next;
        } else {
            head = current.next;
        }

        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            end = current.prev;
        }

        Node newCard = new Node(moveCard);
        if (finalPosition == 1) {
            newCard.next = head;
            if (head != null) {
                head.prev = newCard;
            }
            head = newCard;
            if (end == null) {
                end = newCard;
            }
        } else {
            Node currentPosition = head;
            counter = 1;

            while (currentPosition != null && counter < finalPosition - 1) {
                currentPosition = currentPosition.next;
                counter++;
            }

            if (currentPosition == null) {
                end.next = newCard;
                newCard.prev = end;
                end = newCard;
            } else {
                newCard.next = currentPosition.next;
                newCard.prev = currentPosition;
                if (currentPosition.next != null) {
                    currentPosition.next.prev = newCard;
                }
                currentPosition.next = newCard;
            }
        }
        System.out.println("Carta movida de posição " + initialPosition + " para " + finalPosition);
    }

    public void displayHand() {
        if(isEmpty()) {
            System.out.println("Não existem cartas na mão.");
            return;
        }

        Node current = head;
        int counter = 1;

        while (current != null) {
            System.out.println(counter + ": " + current.card);
            current = current.next;
            counter++;
        }
    }
}
