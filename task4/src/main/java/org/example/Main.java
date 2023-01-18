package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1){
            throw new IllegalArgumentException("Must be at least 1 file path");
        }
        File file = new File(args[0]);
        ArrayList<Integer> list = readFile(file);
        ArrayList<Integer> results = new ArrayList<>();
        list.forEach(integer -> {
            results.add(countSteps(list, integer));
        });
        System.out.println(Collections.min(results));
    }

    public static int countSteps(ArrayList<Integer> list, int baseNumber){
        int counter = 0;
        for (int i = 0; i < list.size(); i++){
            int num = list.get(i);
            if (num < baseNumber){
                while (num != baseNumber){
                    num++;
                    counter++;
                }
            }else if (num > baseNumber){
                while (num != baseNumber){
                    num--;
                    counter++;
                }
            }
        }
        return counter;
    }
    public static ArrayList<Integer> readFile(File file){
        ArrayList<Integer> result = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()){
                result.add(Integer.parseInt(scanner.nextLine().trim()));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}