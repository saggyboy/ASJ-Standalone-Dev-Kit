package edu.ahs.robotics.java;

import java.util.List;

public class LineSegment {
    private Point point1;
    private Point point2;

    public LineSegment(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    public Point[] subDivide (int subSegments) {
        //First: Find the delta x and delta y of the line segment
        double deltaX = point2.x - point1.x;
        double deltaY = point2.y - point1.y;

        //Second: Divide the delta x and delta y by the amount of subSegments to find the xStep and yStep
        double xStep = deltaX/subSegments;
        double yStep = deltaY/subSegments;

        //Third: Add the x and y steps to point1 based on i
        //Create a new point array to return
        Point[] subDividedPoints = new Point[subSegments-1];
        for (int i = 0; i < subDividedPoints.length; i++) {
            double xSubDivided = point1.x + ((i+1) * xStep);
            double ySubDivided = point1.y + ((i+1) * yStep);

            //Create new subDivided points and fill them with xSubDivided and ySubDivided
            subDividedPoints[i] = new Point(xSubDivided, ySubDivided);
        }
        return subDividedPoints;
    }
}
