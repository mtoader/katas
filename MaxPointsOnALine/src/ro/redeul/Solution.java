package ro.redeul;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Point {
    int x;
    int y;

    Point() {
        x = 0;
        y = 0;
    }

    Point(int a, int b) {
        x = a;
        y = b;
    }

}

class Rational {
    int p, q;

    public Rational(int p, int q) {
        this.p = p;
        this.q = q;

        simplify();
    }

    private void simplify() {
        if ( q == 0 )
            return;

        int gcd = gcd(p, q);
        if (gcd != 0) {
            p /= gcd;
            q /= gcd;
        }
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rational rational = (Rational) o;

        if (p != rational.p) return false;
        if (q != rational.q) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = p;
        result = 31 * result + q;
        return result;
    }
}

class Line {
    Rational m, b;

    public Line(Point p1, Point p2) {
        if (p1.x != p2.x) {
            m = new Rational(p2.y - p1.y, p2.x - p1.x);
            b = new Rational(p1.y * p2.x - p1.x * p2.y, p2.x - p1.x);
        } else {
            m = new Rational(p2.x, 0);
            b = new Rational(p2.x, 0);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Line line = (Line) o;

        if (!b.equals(line.b)) return false;
        if (!m.equals(line.m)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = m.hashCode();
        result = 31 * result + b.hashCode();
        return result;
    }
}

class ComparablePoint extends Point {

    public ComparablePoint(Point p) {
        super(p.x, p.y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (x != point.x) return false;
        if (y != point.y) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}

public class Solution {

    public int maxPoints(Point[] points) {

        Map<Point, Integer> pointsCard = new HashMap<>();

        for (Point p : points) {
            ComparablePoint point = new ComparablePoint(p);
            Integer pointCard = pointsCard.get(point);
            if (pointCard == null)
                pointCard = 0;

            pointsCard.put(point, pointCard + 1);
        }

        Map<Line, Set<Point>> lines = new HashMap<>();

        int max = Math.min(points.length, 1);

        Point uniquePoints[] = new Point[pointsCard.keySet().size()];

        int pos = 0;
        for (Map.Entry<Point, Integer> entry : pointsCard.entrySet()) {
            max = Math.max(max, entry.getValue());
            uniquePoints[pos++] = entry.getKey();
        }

        for (int i = 0, uniquePointsLength = uniquePoints.length; i < uniquePointsLength - 1; i++) {
            Point p1 = uniquePoints[i];

            for (int j = i + 1; j < uniquePointsLength; j++) {
                Point p2 = uniquePoints[j];

                Line l = new Line(p1, p2);
                Set<Point> set = lines.get(l);
                if (set == null)
                    set = new HashSet<>();

                set.add(p1);
                set.add(p2);

                lines.put(l, set);

            }
        }

        for (Map.Entry<Line, Set<Point>> entry : lines.entrySet()) {
            int currentLineSize = 0;
            for (Point p : entry.getValue()) {
                currentLineSize += pointsCard.get(p);
            }

            max = Math.max(max, currentLineSize);
        }

        return max;
    }
}
