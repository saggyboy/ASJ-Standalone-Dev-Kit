package edu.ahs.robotics.java;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListExercisesTest {

    @Test
    public void printStrings() {
        ArrayList<String> strings = new ArrayList();
        strings.add("are ");
        strings.add("you ");
        strings.add("as ");
        strings.add("clever ");
        strings.add("as ");
        strings.add("I ");
        strings.add("am");

        assertEquals("are you as clever as I am", ListExercises.printStrings(strings));

    }

    @Test
    public void printStringsInReverse() {
        ArrayList<String> strings = new ArrayList();
        strings.add("are");
        strings.add("you ");
        strings.add("as ");
        strings.add("clever ");
        strings.add("as ");
        strings.add("I ");
        strings.add("am ");

        assertEquals("am I as clever as you are", ListExercises.printStringsInReverse(strings));
    }

    @Test
    public void isStringInList() {
        ArrayList<String> strings = new ArrayList();
        strings.add("Hello");
        strings.add("Mine");
        strings.add("Sunflower");
        strings.add("Cool");
        strings.add("Sea");

        //Test for a String that is in the list
        String targetString = "Cool";
        assertTrue(ListExercises.isStringInList(strings, targetString));

        //Test for a string not in the list
        targetString = "Heart";
        assertFalse(ListExercises.isStringInList(strings, targetString));
    }

    @Test
    public void findLargestNumber() {
        ArrayList<Integer> integers = new ArrayList();
        integers.add(-1);
        integers.add(-4);
        integers.add(12);
        integers.add(12);
        integers.add(4);
        integers.add(7);

        //Tests using both positive, negatives, and duplicates
        int largestNumber = ListExercises.findLargestNumber(integers);
        assertEquals(12, largestNumber);

        integers.clear();
        integers.add(-1);
        integers.add(-4);
        integers.add(-3);
        integers.add(-7);

        //Tests using only negatives
        largestNumber = ListExercises.findLargestNumber(integers);
        assertEquals(-1, largestNumber);
    }

    @Test
    public void getIntegerListLessThanTarget() {
        ArrayList<Integer> integers = new ArrayList();
        integers.add(-1);
        integers.add(-4);
        integers.add(12);
        integers.add(12);
        integers.add(4);
        integers.add(7);

        ArrayList<Integer> integersBelowTarget = ListExercises.getIntegerListLessThanTarget(integers, 7);

        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(-1);
        expected.add(-4);
        expected.add(4);

        assertEquals(expected, integersBelowTarget);
    }

    @Test
    public void putInOrder() {
        ArrayList<Integer> integers = new ArrayList();
        integers.add(-1);
        integers.add(-4);
        integers.add(12);
        integers.add(12);
        integers.add(4);
        integers.add(7);

        ArrayList<Integer> integerInOrder = ListExercises.putInOrder(integers);

        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(-4);
        expected.add(-1);
        expected.add(4);
        expected.add(7);
        expected.add(12);
        expected.add(12);

        assertEquals(expected, integerInOrder);
    }
}