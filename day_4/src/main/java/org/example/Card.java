package org.example;

import java.util.ArrayList;

public class Card {
    private ArrayList<Integer> winningNumbers;
    private ArrayList<Integer> playingNumbers;
    private int cardNumber;

    public Card(String cardData) {
        this.winningNumbers = new ArrayList<>();
        this.playingNumbers = new ArrayList<>();
        String[] cardSplit = cardData.split(":");
        cardNumber = Integer.parseInt(cardSplit[0].replaceAll("Card", "").replaceAll(" ", ""));
        String[] ticketSplit = cardSplit[1].replace('|', 'B').split("B");
        String[] winningTicket = ticketSplit[0].split(" ");
        String[] playingTicket = ticketSplit[1].split(" ");
        for (String number : winningTicket
             ) {
            number = number.trim();
            if (!number.isEmpty()) {
                winningNumbers.add(Integer.parseInt(number));
            }
        }
        for (String number : playingTicket
             ) {
            number = number.trim();
            if (!number.isEmpty()) {
                playingNumbers.add(Integer.parseInt(number));
            }
        }
    }
    public int getMatches(){
        int  matches = 0;
        for (int number: playingNumbers
             ) {
            if (winningNumbers.contains(number)){
                matches += 1;
            }
        }
        return matches;
    }

    public int getScorePoints(){
        int totalPoints = switch (getMatches()) {
            case 1:
                yield 1;
            case 2:
                yield 2;
            case 3:
                yield 4;
            case 4:
                yield 8;
            case 5:
                yield 16;
            case 6:
                yield 32;
            case 7:
                yield 64;
            case 8:
                yield 128;
            case 9:
                yield 256;
            case 10:
                yield 512;
            default:
                yield 0;
        };
        return totalPoints;
    }
    public ArrayList<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public ArrayList<Integer> getPlayingNumbers() {
        return playingNumbers;
    }

    public int getCardNumber() {
        return cardNumber;
    }
}
