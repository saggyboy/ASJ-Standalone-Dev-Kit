package edu.ahs.robotics.java;

import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void distanceFromOrigin() {
        //1st Quadrant
        assertEquals(5, new Point(3,4).distanceFromOrigin(),.00001);
        //4th Quadrant
        assertEquals(13, new Point(5,-12).distanceFromOrigin(),.00001);
        //2nd Quadrant
        assertEquals(25, new Point(-7,24).distanceFromOrigin(),.00001);
        //3rd Quadrant
        assertEquals(Math.sqrt(2), new Point(-1,-1).distanceFromOrigin(),.00001);

    }

    @Test
    public void getQuadrant() {
        //Tests for points in the quadrants
        assertEquals("Quadrant 1",new Point(3,4).getQuadrant());
        assertEquals("Quadrant 2",new Point(-4.5,6).getQuadrant());
        assertEquals("Quadrant 3",new Point(-1,-1).getQuadrant());
        assertEquals("Quadrant 4",new Point(19,-3.2215).getQuadrant());

        //Tests for points on axes
        assertEquals("Axes",new Point(0,-7).getQuadrant());
        assertEquals("Axes",new Point(12,0).getQuadrant());
        assertEquals("Axes",new Point(0,0).getQuadrant());

    }

    @Test
    public void distanceToPoint() {
        //Test in a straight line
        Point point1 = new Point(1,0);
        Point point2 = new Point(3,0);

        assertEquals(2, point1.distanceToPoint(point2), 0.00001);

        //Test on a diagonal line
        point1 = new Point(1,1);
        point2 = new Point(3,3);

        assertEquals(2 * Math.sqrt(2), point1.distanceToPoint(point2), 0.00001);

        //Test with negative numbers
        point1 = new Point(-1,-1);
        point2 = new Point(-3,-3);

        assertEquals(2 * Math.sqrt(2), point1.distanceToPoint(point2), 0.00001);
    }

    @Test
    public void closestPoint() {
        //Create the point we will be finding the closest point to
        Point point1 = new Point(2,4);

        //Create an array of points which will be fed to the closestPoint method
        Point[] points = new Point[6];
        points[0] = new Point(-5,-2);
        points[1] = new Point(-1,-1);
        points[2] = new Point(0,0);
        points[3] = new Point(3,5);
        points[4] = new Point(3,5);
        points[5] = new Point(7,6);

        //Call the method on point1 given the point array and get the closest point back
        Point closestPoint = point1.closestPoint(points);

        assertEquals(new Point (3,5), closestPoint);
    }
}