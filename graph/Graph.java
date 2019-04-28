package com.xudt.algorithm.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: 实现无向图的广度优先算法
 * @Author: XuDT
 */
public class Graph {
    /**
     * 顶点的个数
     */
    private int v;
    /**
     * 邻接表
     */
    private LinkedList<Integer> adj[];
    /**
     * 是否找到目标
     */
    boolean isFound = false;

    /**
     * 无向图
     *
     * @param v
     */
    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * 添加关系，无向图一条边存两次
     * @param source 起点
     * @param target 终点
     */
    public void addEdge(int source, int target) {
        adj[source].add(target);
        adj[target].add(source);
    }

    /**
     * 递归打印 source -> target 的路径
     * @param prev   搜索路径，前驱顶点
     * @param source 起点
     * @param target 终点
     */
    public void print(int[] prev, int source, int target) {
        if (prev[target] != -1 && target != source) {
            print(prev, source, prev[target]);
        }
        System.out.print(target + " ");
    }

    /**
     * BFS 广度搜索算法
     * @param source 起点
     * @param target 终点
     */
    public void bfs(int source, int target) {
        //已到终点
        if (source == target) {
            return;
        }
        //记录已经被访问的顶点，用来避免顶点被重复访问，已访问的标记为true
        boolean[] visited = new boolean[v];
        visited[source] = true;
        //存储已经被访问、但相连的顶点还没有被访问的顶点
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        //反向记录搜索路径,存储的是前驱顶点
        int[] prev = new int[v];
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }
        while (queue.size() != 0) {
            int w = queue.poll();
            for (int i = 0; i < adj[w].size(); ++i) {
                int q = adj[w].get(i);
                if (!visited[q]) {
                    prev[q] = w;
                    if (q == target) {
                        print(prev, source, target);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }

    /**
     * DFS 深度优先搜索
     * @param source 起点
     * @param target 终点
     */
    public void dfs(int source, int target) {
        isFound = false;
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }
        recurDfs(source, target, visited, prev);
        print(prev, source, target);
    }

    public void recurDfs(int w, int target, boolean[] visited, int[] prev) {
        if (isFound) {
            return;
        }
        visited[w] = true;
        if (w == target) {
            isFound = true;
            return;
        }
        for (int i = 0; i < adj[w].size(); ++i) {
            int q = adj[w].get(i);
            if (!visited[q]) {
                prev[q] = w;
                recurDfs(q, target, visited, prev);
            }
        }
    }
}
