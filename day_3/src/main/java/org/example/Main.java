package org.example;

import java.util.List;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

            List<String> lines = DataGrabber.lineGrabber();

            int lineCount = lines.size();
            System.out.println("Linecount : " + lineCount);

            String currentLine = null;
            String prevLine = null;
            String nextLine = null;

            List<Integer> validNumbers = new ArrayList<>();

            for (int i = 0; i < lineCount; i++) {
                String line = lines.get(i);
                if (i > 0){
                    prevLine = lines.get(i - 1);
                }
                if (i < lineCount - 1){
                    nextLine = lines.get(i + 1);
                }
                currentLine = line;
                Line parsedLine = new Line(currentLine, prevLine, nextLine);
                validNumbers.addAll(parsedLine.numbersChecked);
            }
        int sum = validNumbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum : " + sum);
        }

        }

