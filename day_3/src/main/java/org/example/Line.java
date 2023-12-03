package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Line {
    public List<Integer> numbersChecked = new ArrayList<>();
    private int lineLength;

    Pattern pattern = Pattern.compile("\\d+");

    public Line(String inputString, String prevLine, String nextLine){

        lineLength = inputString.length();
        Matcher matcher = pattern.matcher(inputString);

        while (matcher.find()){
            if (isPartNumber(matcher, inputString, prevLine, nextLine)){
                numbersChecked.add(Integer.parseInt(matcher.group()));
            }
        }
    }
    private boolean symbolCheck(char symbol){
        return !Character.isDigit(symbol) && symbol != '.';
    }

    private boolean isPartNumber(Matcher matcher, String line, String prevLine, String nextLine){
        int startIndex = matcher.start();
        int endIndex = startIndex + matcher.group().length();

        if (startIndex > 0){
            char symbol = line.charAt(startIndex - 1);
            if (symbolCheck(symbol)){
                return true;
            }
        }
        if (endIndex < line.length()){
            char symbol = line.charAt(endIndex);
            if (symbolCheck(symbol)){
                return true;
            }
        }
        int start = Math.max(0, startIndex -1);
        int end = Math.min(endIndex + 1, lineLength);
        for (int i = start; i < end; i++) {
            if (prevLine != null && symbolCheck(prevLine.charAt(i))) {
                    return true;
            }
            if (nextLine != null && symbolCheck(nextLine.charAt(i))) {
                    return true;
            }
        }
        return false;
    }
}
