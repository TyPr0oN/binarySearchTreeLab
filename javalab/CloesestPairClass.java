package sample;

import javax.swing.*;

public class EasyClass {
    public static void main(String[] args) {
        int[][] point = new int[10][2];
        point[0][0] = 100; point[0][1]=50;
        point[1][0] = 200; point[1][1]=150;
        point[2][0] = 150; point[2][1]=300;
        point[3][0] = 100; point[3][1]=500;
        point[4][0] = 500; point[4][1]=180;
        point[5][0] = 250; point[5][1]=120;
        point[6][0] = 80;  point[6][1]=40;
        point[7][0] = 100; point[7][1]=150;
        point[8][0] = 400; point[8][1]=360;
        point[9][0] = 50; point[9][1]=190;

        int[] closestPair = new int[2];
        closestPair = findCloesestPair(point);
        System.out.println(closestPair[0]+" "+closestPair[1]);
        JFrame frame = new JFrame("Closest Pair Problem");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        XYPanel panel = new XYPanel(point,closestPair);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }
    public static int[][] findConvex(int[][] p){
        int[][] boundary = new int[p.length][2];
        int amount= 0;int a,b,c,cOfPoint;
        for (int i = 0; i < p.length-1; i++) {
            for (int j = i+1; j < p.length; j++) {
                a = p[j][1] - p[i][1];
                b = p[i][0] - p[j][0];
                c = p[i][0] * p[j][1] - p[j][0] * p[i][1];
                int moreThanC=0,lessThanC=0,k=0;
                for (k = 0; k < p.length; k++) {
                    cOfPoint = a*p[k][0] + b*p[k][1];
                    if (cOfPoint>=c) moreThanC++;
                    if (cOfPoint<=c) lessThanC++;
                    if (moreThanC != (k+1) && lessThanC != (k+1)){
                        break;
                    }
                    if (k == p.length) {
                        boundary[amount][0]=i;
                        boundary[amount][1]=j;
                        amount++;
                    }
                }
            }
        }
        return boundary;
    }

    public static int[] findCloesestPair(int[][] p){
        int closest =0,closest2=0;
        double closestDistanceSqure=1000000000;
        for (int i = 0; i < p.length; i++) {
            for (int j = i+1; j < p.length; j++) {
                double distanceSquare = Math.pow(p[i][0] - p[j][0],2) + Math.pow(p[i][1] - p[j][1],2);
                if (distanceSquare < closestDistanceSqure) {
                    closest =i; closest2=j;
                    closestDistanceSqure = distanceSquare;
                }
            }
        }

        int[] x = {closest,closest2};
        return  x;
    }
}