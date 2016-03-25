package com.sywood.starbucks.ben;
import java.util.ArrayList;

class Graph {
    private ArrayList[] vertices;
    Graph(int points){
        vertices = new ArrayList[points];
        for (int i = 0; i < points; i++) {
            vertices[i] = new ArrayList<Integer>();
        }
    }
    void addEdge(int v1, int v2) {
        vertices[v1].add(v2);
        vertices[v2].add(v1);
    }
    ArrayList<Integer> adjacent(int v){
        return vertices[v];
    }
    int degree(int v){
        return vertices[v].size();
    }

}
