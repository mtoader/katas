package ro.redeul;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
//
//        System.out.println("Result: " + new Solution().maxPoints(new Point[]{
//
//        }));
//
//        System.out.println("Result: " + new Solution().maxPoints(new Point[]{
//                new Point(0, 0)
//        }));
//
//        System.out.println("Result: " + new Solution().maxPoints(new Point[]{
//                new Point(0, 0),
//                new Point(0, 0)
//        }));
//
//        System.out.println("Result: " + new Solution().maxPoints(new Point[]{
//                new Point(0, 0),
//                new Point(-1, -1),
//                new Point(2, 2)
//        }));
//
//        System.out.println("Result: " + new Solution().maxPoints(buildPoints(new int[][]{
//                {-54, -297}, {-36, -222}, {3, -2}, {30, 53}, {-5, 1}, {-36, -222}, {0, 2}, {1, 3}, {6, -47}, {0, 4},
//                {2, 3}, {5, 0}, {48, 128}, {24, 28}, {0, -5}, {48, 128}, {-12, -122}, {-54, -297}, {-42, -247}, {-5, 0},
//                {2, 4}, {0, 0}, {54, 153}, {-30, -197}, {4, 5}, {4, 3}, {-42, -247}, {6, -47}, {-60, -322}, {-4, -2},
//                {-18, -147}, {6, -47}, {60, 178}, {30, 53}, {-5, 3}, {-42, -247}, {2, -2}, {12, -22}, {24, 28}, {0, -72},
//                {3, -4}, {-60, -322}, {48, 128}, {0, -72}, {-5, 3}, {5, 5}, {-24, -172}, {-48, -272}, {36, 78}, {-3, 3}
//        })));
//
//        System.out.println("Result: " + new Solution().maxPoints(buildPoints(new int[][]{
//                {29, 87}, {145, 227}, {400, 84}, {800, 179}, {60, 950}, {560, 122}, {-6, 5}, {-87, -53}, {-64, -118},
//                {-204, -388}, {720, 160}, {-232, -228}, {-72, -135}, {-102, -163}, {-68, -88}, {-116, -95}, {-34, -13},
//                {170, 437}, {40, 103}, {0, -38}, {-10, -7}, {-36, -114}, {238, 587}, {-340, -140}, {-7, 2}, {36, 586},
//                {60, 950}, {-42, -597}, {-4, -6}, {0, 18}, {36, 586}, {18, 0}, {-720, -182}, {240, 46}, {5, -6},
//                {261, 367}, {-203, -193}, {240, 46}, {400, 84}, {72, 114}, {0, 62}, {-42, -597}, {-170, -76},
//                {-174, -158}, {68, 212}, {-480, -125}, {5, -6}, {0, -38}, {174, 262}, {34, 137}, {-232, -187},
//                {-232, -228}, {232, 332}, {-64, -118}, {-240, -68}, {272, 662}, {-40, -67}, {203, 158}, {-203, -164},
//                {272, 662}, {56, 137}, {4, -1}, {-18, -233}, {240, 46}, {-3, 2}, {640, 141}, {-480, -125}, {-29, 17},
//                {-64, -118}, {800, 179}, {-56, -101}, {36, 586}, {-64, -118}, {-87, -53}, {-29, 17}, {320, 65}, {7, 5},
//                {40, 103}, {136, 362}, {-320, -87}, {-5, 5}, {-340, -688}, {-232, -228}, {9, 1}, {-27, -95}, {7, -5},
//                {58, 122}, {48, 120}, {8, 35}, {-272, -538}, {34, 137}, {-800, -201}, {-68, -88}, {29, 87}, {160, 27},
//                {72, 171}, {261, 367}, {-56, -101}, {-9, -2}, {0, 52}, {-6, -7}, {170, 437}, {-261, -210}, {-48, -84},
//                {-63, -171}, {-24, -33}, {-68, -88}, {-204, -388}, {40, 103}, {34, 137}, {-204, -388}, {-400, -106}
//        })));

        System.out.println("Result: " + new Solution().maxPoints(buildPoints(new int[][]{
                {40, -23}, {9, 138}, {429, 115}, {50, -17}, {-3, 80}, {-10, 33}, {5, -21}, {-3, 80}, {-6, -65},
                {-18, 26}, {-6, -65}, {5, 72}, {0, 77}, {-9, 86}, {10, -2}, {-8, 85}, {21, 130}, {18, -6}, {-18, 26},
                {-1, -15}, {10, -2}, {8, 69}, {-4, 63}, {0, 3}, {-4, 40}, {-7, 84}, {-8, 7}, {30, 154}, {16, -5},
                {6, 90}, {18, -6}, {5, 77}, {-4, 77}, {7, -13}, {-1, -45}, {16, -5}, {-9, 86}, {-16, 11}, {-7, 84},
                {1, 76}, {3, 77}, {10, 67}, {1, -37}, {-10, -81}, {4, -11}, {-20, 13}, {-10, 77}, {6, -17}, {-27, 2},
                {-10, -81}, {10, -1}, {-9, 1}, {-8, 43}, {2, 2}, {2, -21}, {3, 82}, {8, -1}, {10, -1}, {-9, 1},
                {-12, 42}, {16, -5}, {-5, -61}, {20, -7}, {9, -35}, {10, 6}, {12, 106}, {5, -21}, {-5, 82}, {6, 71},
                {-15, 34}, {-10, 87}, {-14, -12}, {12, 106}, {-5, 82}, {-46, -45}, {-4, 63}, {16, -5}, {4, 1}, {-3, -53},
                {0, -17}, {9, 98}, {-18, 26}, {-9, 86}, {2, 77}, {-2, -49}, {1, 76}, {-3, -38}, {-8, 7}, {-17, -37},
                {5, 72}, {10, -37}, {-4, -57}, {-3, -53}, {3, 74}, {-3, -11}, {-8, 7}, {1, 88}, {-12, 42}, {1, -37},
                {2, 77}, {-6, 77}, {5, 72}, {-4, -57}, {-18, -33}, {-12, 42}, {-9, 86}, {2, 77}, {-8, 77}, {-3, 77},
                {9, -42}, {16, 41}, {-29, -37}, {0, -41}, {-21, 18}, {-27, -34}, {0, 77}, {3, 74}, {-7, -69}, {-21, 18},
                {27, 146}, {-20, 13}, {21, 130}, {-6, -65}, {14, -4}, {0, 3}, {9, -5}, {6, -29}, {-2, 73}, {-1, -15},
                {1, 76}, {-4, 77}, {6, -29}
        })));

    }

    static Point[] buildPoints(int[][] data) {
        Point points[] = new Point[data.length];
        for (int i = 0; i < data.length; i++) {
            points[i] = new Point(data[i][0], data[i][1]);
        }

        return points;
    }
}


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

class Solution {

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
