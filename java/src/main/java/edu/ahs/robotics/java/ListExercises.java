package edu.ahs.robotics.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListExercises {
    public static String printStrings(ArrayList<String> strings){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strings.size(); i++) {
            stringBuilder.append(strings.get(i));
        }
        return stringBuilder.toString();
    }

    public static String printStringsInReverse(ArrayList<String> strings){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = strings.size()-1; i > -1; i--) {
            stringBuilder.append(strings.get(i));
        }
        return stringBuilder.toString();
    }

    public static boolean isStringInList(ArrayList<String> strings, String targetString) {
        for (int i = 0; i < strings.size(); i++) {
            String current = strings.get(i);
            if (targetString.equals(current)){
                return true;
            }
        }
        return false;
    }

    public static int findLargestNumber(ArrayList<Integer> integers){
        int largestNumber = integers.get(0);
        for (int i = 1; i < integers.size(); i++) {
            int current = integers.get(i);
            if (largestNumber < current){
                largestNumber = current;
            }
        }
        return largestNumber;
    }

    public static ArrayList<Integer> getIntegerListLessThanTarget(ArrayList<Integer> integers, int targetNumber) {
        ArrayList<Integer> integersLessThanTarget = new ArrayList<>();
        for (int i = 0; i < integers.size(); i++) {
            int current = integers.get(i);
            if (current < targetNumber){
                integersLessThanTarget.add(current);
            }
        }
        return integersLessThanTarget;
    }

    public static ArrayList<Integer> putInOrder(ArrayList<Integer> integers){
        ArrayList<Integer> integersInOrder = new ArrayList<>();

        //addAll copies an entire list into another ArrayList
        integersInOrder.addAll(integers);

        //Collections.sort puts a list of integers in order
        Collections.sort(integersInOrder);
        return integersInOrder;
    }

}
