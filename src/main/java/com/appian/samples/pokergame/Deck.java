package com.appian.samples.pokergame;

import java.util.Random;

public class Deck {
    // array to hold the Cards
    private Card[] deck;
    // number of cards in the deck
    private final int TOTAL_NUMBER_OF_CARDS = 52;
    private final String[] values = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    private final String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
    // to track the next card in the deck
    private int nextCardIndex;
    // used in shuffle method to generate random number
    private Random randomNumber;

    // constructor to create the deck of 52 cards
    public Deck()
    {
        deck = new Card[TOTAL_NUMBER_OF_CARDS];
        int count = 0;

        // for each suit and value combination create a Card object and assign it to the deck
        for (String suit:suits) {
            for (String value:values) {
                deck[count] = new Card(value, suit);
                count++;
            }
        }
        System.out.println("Total number of cards added = " + count);
        // reset the index to the first card
        nextCardIndex = 0;
        randomNumber = new Random();
    }

    // method to shuffle the full deck in a random order
    public void shuffle()
    {
        int rand;
        Card currentCard;

        // for each Card, pick another random Card and swap them
        for (int i = 0; i < deck.length; i++)
        {
            // nextInt will generate random integer in range 0 to 51
            rand =  randomNumber.nextInt(TOTAL_NUMBER_OF_CARDS);
            // swap this card with the card for the generated random integer
            currentCard = deck[i];
            deck[i] = deck[rand];
            deck[rand] = currentCard;
        }
        // finally reset the index to the first card
        nextCardIndex = 0;
    }

    // method to deal the next card from the deck
    public Card dealOneCard()
    {
        // return the card as long as cards are available in the deck
        if (nextCardIndex < deck.length)
            return deck[nextCardIndex++];
        else
            return null; // no cards available. Return null or may be an exception stating no cards left
    }
}
