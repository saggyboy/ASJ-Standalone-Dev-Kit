package edu.ahs.robotics.java;

import java.util.Objects;

public class Point {
    public double x;
    public double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(point.x, x) == 0 &&
                Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public double distanceFromOrigin() {
        double distance = Math.sqrt(x * x + y * y);
        return distance;
    }

    public String getQuadrant() {
        if (x > 0 && y > 0) {
            return "Quadrant 1";
        } else if (x < 0 && y > 0) {
            return "Quadrant 2";
        } else if (x < 0 && y < 0) {
            return "Quadrant 3";
        } else if (x > 0 && y < 0) {
            return "Quadrant 4";
        } else if (x == 0 || y == 0) {
            return "Axes";
        } else {
            return null;
        }
    }

    public double distanceToPoint(Point other){
        double deltaX = x - other.x;
        double deltaY = y - other.y;
        double distance = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
        return distance;
    }

    public Point closestPoint(Point[] points){
        //Set the closest point to the first point in the array and calculate the distance
        Point closestPoint = points[0];
        double distanceToClosestPoint = distanceToPoint(closestPoint);

        //Loop through the points and see if the distance of the current point is less than the distance from the previously stored closest point
        for (int i = 1; i < points.length; i++) {
            Point currentPoint = points[i];
            double distanceToCurrent = distanceToPoint(currentPoint);
            if (distanceToCurrent < distanceToClosestPoint){

                //If so, update the distance and point to be the closest point and closest distance
                closestPoint = currentPoint;
                distanceToClosestPoint = distanceToCurrent;
            }
        }
        return closestPoint;
    }

}
