package study2024.graph;

/**
 * @author xiaotian
 * @description 图
 * @date 2024-04-20 11:59
 */
import java.util.ArrayList;
import java.util.List;

public class Graph {
    private final int numVertices;
    private final List<List<Integer>> adjList;

    public Graph(int numVertices) {
        this.numVertices = numVertices;
        this.adjList = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            this.adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int start, int end) {
        adjList.get(start).add(end);
    }

    public List<List<Integer>> getAdjList() {
        return adjList;
    }

    public int getNumVertices() {
        return numVertices;
    }
}

