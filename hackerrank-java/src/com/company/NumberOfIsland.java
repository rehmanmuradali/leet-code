package com.company;

import java.util.*;

public class NumberOfIsland {

    public static int numIslands(char[][] grid) {

        Set<String> visited = new HashSet<>();
        int numOfIslands = 0;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j< grid[i].length; j++) {
                if(grid[i][j] == '1' && !visited.contains(getKey(i,j))){
                    Queue<String> queue = new LinkedList<>();
                    queue.add(getKey(i,j));
                    while(!queue.isEmpty()){
                        System.out.println("Queue: " + queue);
                        System.out.println("Visited: " + visited);
                        String current = queue.poll();
                        visited.add(current);
                        String[] numbers = current.split(",");
                        int k = Integer.parseInt(numbers[0]);
                        int l = Integer.parseInt(numbers[1]);
                        System.out.println("Polling new element from queue, current: " + current);
                        if(k-1 >= 0 && grid[k-1][l] == '1' && !visited.contains(getKey(k-1,l))){
                            queue.add(getKey(k-1, l));
                            visited.add(getKey(i-1, j));
                        }

                        if(k+1< grid.length && grid[k+1][l] == '1' && !visited.contains(getKey(k+1,l))){
                            queue.add(getKey(k+1, l));
                            visited.add(getKey(i+1, j));
                        }
                        if(l-1>=0 && grid[k][l-1] == '1' && !visited.contains(getKey(k,l-1))){
                            queue.add(getKey(k, l-1));
                            visited.add(getKey(i, j-1));
                        }

                        if(l+1< grid[k].length && grid[k][l+1] == '1' && !visited.contains(getKey(k,l+1))){
                            queue.add(getKey(k, l+1));
                            visited.add(getKey(i, j+1));
                        }
                    }

                    System.out.println("found a new island");
                    numOfIslands++;
                }
            }
        }
        return numOfIslands;
    }

    public static String getKey(int i, int j) {
        return i + "," + j;
    }


    public static void main(String[] args) {
        char[][] arr = new char[][]{
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
//        char[][] arr = new char[][]{
//                {'1','1','1'},
//                {'0','1','0'},
//                {'1','1','1'}
//        };

        System.out.println(numIslands(arr));
    }
}
