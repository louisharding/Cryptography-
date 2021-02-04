package Classes;

import java.util.ArrayList;
import java.util.Arrays;

public class BCH {
    public static void main(String[] args) {
        ArrayList<Integer>[][] Vandermonde = new ArrayList[4][16];
        Vandermonde[0][0] = new ArrayList<Integer>();
        Vandermonde[1][0] = new ArrayList<Integer>();
        Vandermonde[2][0] = new ArrayList<Integer>();
        Vandermonde[3][0] = new ArrayList<Integer>();


        for (int i = 0; i < 16; i++) {
            Vandermonde[0][0].add(1);
            Vandermonde[1][0].add(i+1);
            Vandermonde[2][0].add((int) Math.pow(i+1, 2)%17);
            Vandermonde[3][0].add((int) Math.pow(i+1, 3)%17);
        }



        for (int i = 0; i < Vandermonde.length ; i++) {
            System.out.println(Vandermonde[i][0].toString());
        }

    }
}
