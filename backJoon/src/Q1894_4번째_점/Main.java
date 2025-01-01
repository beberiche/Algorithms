package Q1894_4번째_점;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Point {
    double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point add(Point other) {
        return new Point(this.x + other.x, this.y + other.y);
    }

    public Point subtract(Point other) {
        return new Point(this.x - other.x, this.y - other.y);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Point point = (Point) obj;
        return Double.compare(point.x, x) == 0 && Double.compare(point.y, y) == 0;
    }

    @Override
    public String toString() {
        return String.format("%.3f %.3f", x, y);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            StringTokenizer stk = new StringTokenizer(line);

            Point a = new Point(Double.parseDouble(stk.nextToken()), Double.parseDouble(stk.nextToken()));
            Point b = new Point(Double.parseDouble(stk.nextToken()), Double.parseDouble(stk.nextToken()));
            Point c = new Point(Double.parseDouble(stk.nextToken()), Double.parseDouble(stk.nextToken()));
            Point d = new Point(Double.parseDouble(stk.nextToken()), Double.parseDouble(stk.nextToken()));

            Point res = null;
            if (a.equals(c)) res = d.add(b).subtract(a);
            if (a.equals(d)) res = c.add(b).subtract(a);
            if (b.equals(c)) res = d.add(a).subtract(b);
            if (b.equals(d)) res = c.add(a).subtract(b);

            if (res != null) {
                sb.append(res).append("\n");
            }
        }
        System.out.print(sb);
    }
}
