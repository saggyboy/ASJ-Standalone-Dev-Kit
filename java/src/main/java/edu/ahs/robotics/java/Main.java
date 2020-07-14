package edu.ahs.robotics.java;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World! My name is Foo!");

        //Print 2+7 = 9
        System.out.println(2+7);

        //Print is 2 < 7
        System.out.println(2<7);

        //Print the result of 7/4 stored inside local variable num
        double num = 7.0/4.0;
        System.out.println(num);

        //Create a new point called a with x-value '1' and y-value '2'
        Point a = new Point(1,2);

        //Print the x value = 1
        System.out.println(a.x);

        //Print the y value = 2
        System.out.println(a.y);

        //Print out point a
        System.out.println(a);

        //Print the distance from origin of point a
        System.out.println(a.distanceFromOrigin());
    }
}