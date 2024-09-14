package entities;

public class Card {
    String cardNumber;
    String cardSuit;

    public Card(String cardNumber, String carSuit ) {
        this.cardNumber = cardNumber;
        this.cardSuit = carSuit;
    }

    @Override
    public String toString() {
        return cardNumber + " de " + cardSuit;
    }
}
