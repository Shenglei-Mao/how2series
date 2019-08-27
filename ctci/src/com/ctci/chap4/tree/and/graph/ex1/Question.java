package com.ctci.chap4.tree.and.graph.ex1;

import java.util.*;

/**
 * @author : Michael M
 * lintCode 176
 * Route Between Two Nodes
 */
public class Question {

}

class DirectedGraphNode {
    int label;
    ArrayList<DirectedGraphNode> neighbors;

    DirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<>();
    }
}

class Solution {
    /*
     * @param graph: A list of Directed graph node
     * @param s: the starting Directed graph node
     * @param t: the terminal Directed graph node
     * @return: a boolean value
     */

    /*0 for unvisited, 1 for visited*/
    public boolean hasRoute(ArrayList<DirectedGraphNode> graph, DirectedGraphNode s, DirectedGraphNode t) {
        // write your code here
        if (s == t) {
            return true;
        }

        Set<DirectedGraphNode> visted = new HashSet<>();
        Queue<DirectedGraphNode> queue = new LinkedList<>();

        queue.offer(s);
        visted.add(s);

        while (!queue.isEmpty()) {
            DirectedGraphNode node = queue.poll();
            for (DirectedGraphNode neighbor : node.neighbors) {
                if (!visted.contains(neighbor)) {
                    if (neighbor == t) {
                        return true;
                    } else {
                        queue.offer(neighbor);
                        visted.add(neighbor);
                    }
                }
            }
        }
        return false;

    }
}
