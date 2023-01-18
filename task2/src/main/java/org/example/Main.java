package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2){
            throw new IllegalArgumentException("Arguments are less then 2 and they must be file paths");
        }
        File circleFile = new File(args[0]);
        File coordsFile = new File(args[1]);

        Circle circle = getFromFile(circleFile);
        pointsFromFile(coordsFile).forEach(point -> {
            System.out.print(circle.getPointPosition(point.getX(), point.getY()) + " ");
        });
    }

    public static ArrayList<Point> pointsFromFile(File file){
        ArrayList<Point> points = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()){
                points.add(Point.fromLine(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return points;
    }

    public static Circle getFromFile(File file){
        ArrayList<String> lines = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()){
                lines.add(scanner.nextLine());
            }
            scanner.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int x = 0, y = 0, r = 0;
        String[] coords = lines.get(0).split(" ");
        x = Integer.parseInt(coords[0]);
        y = Integer.parseInt(coords[1]);
        r = Integer.parseInt(lines.get(1));
        return new Circle(x, y ,r);
    }
}

class Circle{
    private static final int INSIDE = 1;
    private static final int OUTSIDE = 2;
    private static final int EDGE = 0;

    double x, y, r;
    Circle(double x, double y, double r){
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public int getPointPosition(double xPointCoordinate, double yPointCoordinate){
        double hypotenuse = Math.sqrt(Math.pow(xPointCoordinate - x, 2) + Math.pow(yPointCoordinate - y, 2));
        if (hypotenuse > r){
            return OUTSIDE;
        } else if (hypotenuse == r) {
            return EDGE;
        } else {
            return INSIDE;
        }
    }
}

class Point{
    private int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public static Point fromLine(String line){
        String[] points = line.split(" ");
        int x = Integer.parseInt(points[0]);
        int y = Integer.parseInt(points[1]);
        return new Point(x, y);
    }
}