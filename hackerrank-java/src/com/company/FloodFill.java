package com.company;

import java.util.Arrays;

public class FloodFill {

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        return floodFill(image, sr, sc, color, image[sr][sc]);
    }

    private static int[][] floodFill(int[][] image, int sr, int sc, int color, int prevColor) {
        if (sr<0 || sc<0 || sr>=image.length || sc>= image[0].length || image[sr][sc] != prevColor || color == prevColor) return image;
        image[sr][sc] = color;
        floodFill(image, sr + 1, sc, color, prevColor);
        floodFill(image, sr - 1, sc, color, prevColor);
        floodFill(image, sr, sc + 1, color, prevColor);
        floodFill(image, sr, sc - 1, color, prevColor);
        return image;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {0,0,0},
                {0,0,0},
                {0,0,0},
        };


        System.out.println(Arrays.deepToString(floodFill(arr, 0, 0, 0)));
    }
}
