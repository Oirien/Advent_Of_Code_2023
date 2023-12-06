package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        RaceGame raceGame = new RaceGame();

        raceGame.times.add(53);
        raceGame.times.add(89);
        raceGame.times.add(76);
        raceGame.times.add(98);

        raceGame.distances.add(313);
        raceGame.distances.add(1090);
        raceGame.distances.add(1214);
        raceGame.distances.add(1201);

        int waysToWin = raceGame.findWaysToWin();
        long waysToWinPart2 = raceGame.findWaysToWinPart2();

        System.out.println("There are " + waysToWin + " ways to win.");
        System.out.println("There are " + waysToWinPart2 + " ways to win part 2.");
    }
}