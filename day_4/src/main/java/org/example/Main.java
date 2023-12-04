package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        List<String> data = DataGrabber.cardGrabber();
        ArrayList<Card> cardList = new ArrayList<>();
        for (String card: data
             ) {
            cardList.add(new Card(card));
        }
        System.out.println("There are " + cardList.size() + " cards to check");
        int score = 0;
        for (Card card: cardList
             ) {
            score += card.getScorePoints();
        }
        System.out.println("Total score from all cards is " + score);

        Map<Integer, Integer> cardInstances = new HashMap<>();

        for (Card card: cardList
             ) {
            int matchingNumbersCount = card.getMatches();
            int cardId = card.getCardNumber();
            int currentCardCount = cardInstances.getOrDefault(cardId, 0);
            cardInstances.put(cardId, ++currentCardCount);
            for (int i = cardId + 1; i < cardId +matchingNumbersCount + 1; i++) {
                int cardCount = cardInstances.getOrDefault(i, 0);
                cardCount += currentCardCount;
                cardInstances.put(i, cardCount);
            }
        }
        int sumOfCards = cardInstances.values().stream().mapToInt(Integer::intValue).sum();
        System.out.println("The total number of cards is " + sumOfCards);
    }
}