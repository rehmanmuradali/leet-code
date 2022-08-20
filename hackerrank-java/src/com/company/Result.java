package com.company;

import java.util.ArrayList;
import java.util.List;

public class Result {

    int N;
    ArrayList<ArrayList<Integer>> adjList;

    public static void main(String[] args) {
        List<String> arr =new ArrayList<>();
//        arr.add("1100");
//        arr.add("1110");
//        arr.add("0110");
//        arr.add("0001");
        arr.add("10000");
        arr.add("01000");
        arr.add("00100");
        arr.add("00010");
        arr.add("00001");

        System.out.println(countGroups(arr));
    }

    Result(int N)
    {
        this.N = N;
        adjList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adjList.add(i, new ArrayList<>());
        }
    }

    void addConnectedEdge(int i, int j)
    {
        adjList.get(i).add(j);
        adjList.get(j).add(i);

    }

    void performDFS(int v, boolean[] visited)
    {
        visited[v] = true;
        for (int x : adjList.get(v)) {
            if (!visited[x])
                performDFS(x, visited);
        }
    }
    int getDistinctNumberOfGroups()
    {

        int count = 0;
        boolean[] isVisited = new boolean[N];
        for (int i = 0; i < N; ++i) {
            if (!isVisited[i]) {
                performDFS(i, isVisited);
                count++;
            }
        }
        return count;
    }

    public static int countGroups(List<String> related) {
        Result g = new Result(related.size());
        for (int i=0; i<related.size(); i++ ){
            String s = related.get(i);
            for ( int j = i+1; j < s.length(); j++) {
                if(s.charAt(j) == '1') {
                    g.addConnectedEdge(i, j);
                }
            }
        }
        return g.getDistinctNumberOfGroups();
    }


}
