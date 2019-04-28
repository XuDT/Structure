package com.xudt.algorithm.test;

import com.xudt.algorithm.graph.Graph;

/**
 * @Description: 广度、深度优先算法测试类
 * @Author: XuDT
 */
public class GraphTest {
    public static void main(String[] args){
        //构建一个无向图
        Graph graph = new Graph(7);
        graph.addEdge(2, 3);
        graph.addEdge(3, 0);
        graph.addEdge(3, 1);
        graph.addEdge(0, 4);
        graph.addEdge(0, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 6);
        graph.addEdge(1, 6);
        graph.bfs(1, 5);
        graph.dfs(1, 5);
    }
}
