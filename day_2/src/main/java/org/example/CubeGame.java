package org.example;

import java.util.*;

public class CubeGame {
    private int gameId;
    private List<Integer> redNumbers;
    private List<Integer> blueNumbers;
    private List<Integer> greenNumbers;
    private int maxRed;
    private int maxBlue;
    private int maxGreen;
    private int powerCube;

    public int getPowerCube() {
        return powerCube;
    }

    public CubeGame(String oneGame) {
        this.blueNumbers = new ArrayList<Integer>();
        this.redNumbers = new ArrayList<Integer>();
        this.greenNumbers = new ArrayList<Integer>();
        this.maxBlue = 0;
        this.maxGreen = 0;
        this.maxRed = 0;
        this.powerCube = 0;


        String[] gameIdSeparators = oneGame.split(":");
        String onlyGame = gameIdSeparators[0];
        this.gameId = Integer.parseInt(onlyGame.replace("Game ", ""));

        String[] cubeGameSeparators = gameIdSeparators[1].split(";");
        for (String onePull: cubeGameSeparators
             ) {
            String[] singleTypes = onePull.split(",");
            for (String cubeType: singleTypes
                 ) {
                if(cubeType.contains("blue")){
                    cubeType = cubeType.replace(" ", "");
                    cubeType = cubeType.replace("blue", "");
                    blueNumbers.add(Integer.parseInt(cubeType));
                }
                if(cubeType.contains("red")){
                    cubeType = cubeType.replace(" ", "");
                    cubeType = cubeType.replace("red", "");
                    redNumbers.add(Integer.parseInt(cubeType));
                }
                if(cubeType.contains("green")){
                    cubeType = cubeType.replace(" ", "");
                    cubeType = cubeType.replace("green", "");
                    greenNumbers.add(Integer.parseInt(cubeType));
                }
            }
        }
        maxRed = maxValue(redNumbers);
        maxGreen = maxValue(greenNumbers);
        maxBlue = maxValue(blueNumbers);

        powerCube = maxRed * maxGreen * maxBlue;
    }

    public int maxValue(List<Integer> colourList){
        int max = colourList.stream().mapToInt(v -> v).max().orElseThrow(NoSuchElementException::new);
        return max;
    }

    public int getMaxRed() {
        return maxRed;
    }

    public int getMaxBlue() {
        return maxBlue;
    }

    public int getMaxGreen() {
        return maxGreen;
    }

    public int checkGame(){

        if (maxRed <= 12 && maxGreen <= 13 && maxBlue <= 14) {
            return getGameId();
        } else {
            return 0;
        }
    };


    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public List<Integer> getRedNumbers() {
        return redNumbers;
    }

    public void setRedNumbers(List<Integer> redNumbers) {
        this.redNumbers = redNumbers;
    }

    public List<Integer> getBlueNumbers() {
        return blueNumbers;
    }

    public void setBlueNumbers(List<Integer> blueNumbers) {
        this.blueNumbers = blueNumbers;
    }

    public List<Integer> getGreenNumbers() {
        return greenNumbers;
    }

    public void setGreenNumbers(List<Integer> greenNumbers) {
        this.greenNumbers = greenNumbers;
    }
}

