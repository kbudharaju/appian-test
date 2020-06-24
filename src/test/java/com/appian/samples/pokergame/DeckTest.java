package com.appian.samples.pokergame;

import org.junit.Test;

public class DeckTest {

    private Card card;

    @Test
    public void dealCards() {

        Deck deck = new Deck();
        deck.shuffle();
        int count = 0;

        // for each card print the characteristics of the card
        while((card = deck.dealOneCard()) != null) {
            System.out.println("Card# " + ++count + " has suit = " + card.getSuit() + " and face value = " + card.getValue());
        }
    }

}
