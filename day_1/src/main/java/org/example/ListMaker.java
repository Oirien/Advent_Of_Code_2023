package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListMaker {
    private static final Map<String, String> writtenToNumeric = new HashMap<>();

    static {
        writtenToNumeric.put("one", "o1ne");
        writtenToNumeric.put("two", "t2wo");
        writtenToNumeric.put("three", "t3hree");
        writtenToNumeric.put("four", "f4our");
        writtenToNumeric.put("five", "f5ive");
        writtenToNumeric.put("six", "s6ix");
        writtenToNumeric.put("seven", "s7even");
        writtenToNumeric.put("eight", "e8ight");
        writtenToNumeric.put("nine", "n9ine");
    }
    public static String parseWrittenNumbers(String stringToChange) {
        for (Map.Entry<String, String> entry : writtenToNumeric.entrySet()) {
            stringToChange = stringToChange.replaceAll(entry.getKey(), entry.getValue());
        }
        return stringToChange;
    }
    public List<String> makeListOfStrings(String input){
        List<String> stringSubsets = new ArrayList<>();
        int startPoint = 0;

        for(int i=0; i < input.length();  i++){
            if (input.charAt(i) == '\n'){
                stringSubsets.add(parseWrittenNumbers(input.substring(startPoint, i)));
                startPoint = i + 1;
            }
        }
        stringSubsets.add(parseWrittenNumbers(input.substring(startPoint)));
        return stringSubsets;
    }


    public int findCalibration(List<String> stringList) {
        List<Integer> intList = new ArrayList<>();
        int calibrationValue = 0;

        for (String caseString : stringList) {
            String tempInt = "";
            boolean digitFound = false;

            for (int i = 0; i < caseString.length(); i++) {
                if (Character.isDigit(caseString.charAt(i))) {
                    tempInt += caseString.charAt(i);
                    digitFound = true;
                    break;
                }
            }

            for (int i = caseString.length() - 1; i >= 0; i--) {
                if (Character.isDigit(caseString.charAt(i))) {
                    tempInt += caseString.charAt(i);
                    digitFound = true;
                    break;
                }
            }

            if (digitFound) {
                    intList.add(Integer.valueOf(tempInt));
            } else {
                System.out.println("No Int Found: " + caseString);
            }
        }

        for (int calibrationItem : intList) {
            calibrationValue += calibrationItem;
        }

        return calibrationValue;
    }
}
