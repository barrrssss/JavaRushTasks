package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    public static class Point{
        private final int x;
        private final int y;
        private final boolean isTrue;
        private boolean isVisited = false;

        private Point upperPoint;
        private Point lowerPoint;
        private Point rightPoint;
        private Point leftPoint;

        private void setUpperPoint(Point upperPoint) {
            if (this.upperPoint == null) this.upperPoint = upperPoint;
        }

        private void setLowerPoint(Point lowerPoint) {
            if (this.lowerPoint == null) this.lowerPoint = lowerPoint;
        }

        private void setRightPoint(Point rightPoint) {
            if (this.rightPoint == null) this.rightPoint = rightPoint;
        }

        private void setLeftPoint(Point leftPoint) {
            if (this.leftPoint == null) this.leftPoint = leftPoint;
        }

        public void setNeighborPoints(Point upperPoint, Point lowerPoint, Point rightPoint, Point leftPoint){
            setUpperPoint(upperPoint);
            setLowerPoint(lowerPoint);
            setRightPoint(rightPoint);
            setLeftPoint(leftPoint);
        }

        public Point(int x, int y, boolean isTrue) {
            this.x = x;
            this.y = y;
            this.isTrue = isTrue;
        }

        public static Point[][] getRectangleOfPoint(byte[][] array){
            Point[][] points = new Point[array.length][array[0].length];
            for (int i = 0; i < array.length - 1; i++) {
                for (int j = 0; j < array[0].length - 1; j++) {
                    points[i][j] = new Point(i + 1, j + 1, array[i][j] == 1);
                }
            }
            return points;
        }

        public static void initializePoints(Point[][] points){
            for (int i = 0; i < points.length - 1; i++) {
                for (int j = 0; j < points[0].length - 1; j++) {
                    Point upperPoint = null;
                    Point lowerPoint = null;
                    Point rightPoint = null;
                    Point leftPoint = null;

                    if (i != 0) upperPoint = points[i - 1][j];
                    if (i != points.length - 1) lowerPoint = points[i + 1][j];
                    if (j != 0) leftPoint = points[i][j - 1];
                    if (j != points[0].length - 1) rightPoint = points[i][j + 1];

                    points[i][j].setNeighborPoints(upperPoint, lowerPoint, rightPoint, leftPoint);
                }
            }
        }


    }

    public static int getRectangleCount(byte[][] a) {
        Point[][] points = Point.getRectangleOfPoint(a);
        Point.initializePoints(points);

        

        return 0;
    }


    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
//        byte[][] a2 = new byte[][]{
//                {1, 0, 0, 1},
//                {0, 0, 0, 0},
//                {0, 0, 0, 0},
//                {1, 0, 0, 1}
//        };
//
//        int count1 = getRectangleCount(a1);
//        System.out.println("count = " + count1 + ". Должно быть 2");
//        int count2 = getRectangleCount(a2);
//        System.out.println("count = " + count2 + ". Должно быть 4");





    }


}
