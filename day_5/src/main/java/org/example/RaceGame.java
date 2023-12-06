package org.example;

import java.util.ArrayList;
import java.util.List;

public class RaceGame {
    List<Integer> times;
    List<Integer> distances;
    public RaceGame() {
        this.times = new ArrayList<>();
        this.distances = new ArrayList<>();

    }
    private long ceilDiv(long x, long y){
        return -Math.floorDiv(-x, y);
    }

    public int waysToWin(long time, long distance){
        int waysToWin = 0;
        boolean isEvenTime = time % 2 == 0;

        for (long i = ceilDiv(time, 2); i <= time; i++) {
            long curDistance = i * (time - i);
            if (curDistance > distance) {
                waysToWin++;
            } else if (waysToWin > 0) {
                break;
            }
        }
        return isEvenTime ? waysToWin * 2 - 1 : waysToWin * 2;
    }

    public int findWaysToWin(){
        int total = 1;
        for (int i = 0; i < times.size(); i++) {
            total *= waysToWin(times.get(i), distances.get(i));
        }
        return total;
    }
    public long findWaysToWinPart2(){
        String finalTime = "";
        String finalDistance = "";
        for (int time: times ) {
            finalTime += String.valueOf(time);
        }
        for (int distance: distances) {
            finalDistance += String.valueOf(distance);
        }
        long totalWaysToWin = waysToWin(Long.valueOf(finalTime), Long.valueOf(finalDistance));
        return totalWaysToWin;
    }
}
