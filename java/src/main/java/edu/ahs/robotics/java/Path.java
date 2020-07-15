package edu.ahs.robotics.java;

import java.util.ArrayList;
import java.util.List;

public class Path {
    private List<WayPoint> wayPoints = new ArrayList<>();
    private double totalDistance = 0;

    /**
     * @param rawPoints Array of X,Y points.  Consecutive duplicate points are discarded
     *                  A path must have at least 2 non-identical points
     * @throws IllegalArgumentException for paths with fewer than 2 non-duplicate points.
     */
    public Path(Point[] rawPoints) {
        if (rawPoints.length < 2){
            throw new IllegalArgumentException("A Path must be defined by at least two non-duplicate points.");
        }
        wayPoints.add(new WayPoint(rawPoints[0], 0, 0, 0, 0));
        for (int i = 1; i < rawPoints.length; i++) {
            Point current = rawPoints[i];
            Point previous = rawPoints[i-1];

            //Checks for duplicates
            if (current.equals(previous)){
                continue;
            }

            //Calculate Path deltas
            double pathDeltaX = current.x - previous.x;
            double pathDeltaY = current.y - previous.y;

            //Calculate distanceFromPrevious and distanceToEnd
            double distanceFromPrevious = current.distanceToPoint(previous);
            totalDistance += distanceFromPrevious;

            wayPoints.add(new WayPoint(rawPoints[i], pathDeltaX, pathDeltaY, distanceFromPrevious, totalDistance));
        }
    }

    /**
     * @return total distance along the path
     */
    public double totalDistance() {
        return totalDistance;
    }

    /**
     * @return a point at the supplied distance along the path from the supplied current position
     * Note that the point will usually be interpolated between the points that originally defined the Path
     */
    public TargetPoint getTargetPoint(Point current, double lookAheadDistance) {
        return new TargetPoint(current, 0, 0);
    }

    List<TargetPoint> getPoints() {
        ArrayList<TargetPoint> targetPoints = new ArrayList<>();
        for (int i = 0; i < wayPoints.size(); i++) {
            targetPoints.add(new TargetPoint(wayPoints.get(i)));
        }
        return targetPoints;
    }

    public static class TargetPoint {
        public Point point;
        public double distanceFromStart;
        public double distanceToEnd;

        private TargetPoint(Point point, double distanceFromStart, double distanceToEnd) {
            this.point = point;
            this.distanceFromStart = distanceFromStart;
            this.distanceToEnd = distanceToEnd;
        }

        private TargetPoint(WayPoint wayPoint) {
            this.point = wayPoint.point;
            this.distanceFromStart = wayPoint.distanceFromStart;
            this.distanceToEnd = wayPoint.getDistanceToEnd();
        }
    }

    private class WayPoint {
        public Point point;
        private double deltaXFromPrevious;
        private double deltaYFromPrevious;
        private double distanceFromPrevious;
        private double distanceFromStart;

        public WayPoint(Point point, double deltaXFromPrevious, double deltaYFromPrevious, double distanceFromPrevious, double distanceFromStart) {
            this.point = point;
            this.deltaXFromPrevious = deltaXFromPrevious;
            this.deltaYFromPrevious = deltaYFromPrevious;
            this.distanceFromPrevious = distanceFromPrevious;
            this.distanceFromStart = distanceFromStart;
        }

        public double getDistanceToEnd() {
            return totalDistance() - distanceFromStart;
        }

        /**
         * Calculates the projection of the vector Vcurrent leading from the supplied current
         * point to this WayPoint onto the vector Vpath leading from the previous point on the path
         * to this WayPoint.  If the return value is positive, it means that the WayPoint is
         * farther along the path from the current point.  If the return value is negative, it means
         * that the WayPoint is before the current point (earlier on the path).
         * The magnitude of the value tells the
         * distance along the path.  The value is computed as the dot product between Vcurrent and
         * Vpath, normalized by the length of vPath
         *
         * @param current The source point to compare to the WayPoint
         */
        private double componentAlongPath(Point current) {
            double deltaXFromCurrent = point.x - current.x;
            double deltaYFromCurrent = point.y - current.y;

            double dp = deltaXFromCurrent * deltaXFromPrevious + deltaYFromCurrent * deltaYFromPrevious;
            return dp / distanceFromPrevious;
        }
    }


}
