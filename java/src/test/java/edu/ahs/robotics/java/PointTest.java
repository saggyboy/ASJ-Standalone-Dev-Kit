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
}