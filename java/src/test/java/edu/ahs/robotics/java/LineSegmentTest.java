package edu.ahs.robotics.java;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LineSegmentTest {

    @Test
    public void subDivide() {
        //Creates a point array named pointsExpected of size 2 and adds 2 new points
        Point[] pointsExpected = new Point[2];
        pointsExpected[0] = new Point(1, 1);
        pointsExpected[1] = new Point(2, 2);

        //2 points are created and plugged into the subDivide method on lineSegment
        Point point1 = new Point(0, 0);
        Point point2 = new Point(3, 3);
        LineSegment lineSegment = new LineSegment(point1, point2);

        //pointsActual is the point array that is returned
        Point[] pointsActual = lineSegment.subDivide(3);

        //Loop over both point arrays and compare the points
        for (int i = 0; i < pointsActual.length; i++) {
            assertEquals(pointsExpected[i], pointsActual[i]);
        }
    }

    @Test
    public void interpolate() {
        Point point1 = new Point(1,0);
        Point point2 = new Point(5,0);

        LineSegment lineSegment = new LineSegment(point1, point2);
        Point interpolatedPoint = lineSegment.interpolate(3);

        assertEquals(new Point(4,0), interpolatedPoint);
    }
}