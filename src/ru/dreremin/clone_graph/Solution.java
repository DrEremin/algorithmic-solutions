package ru.dreremin.clone_graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Clone Graph
 */

public class Solution {
	
	private Map<Integer, Node> vertices;
	
	public Node cloneGraph(Node node) {
		vertices = new HashMap<>();     
		return node == null ? null : dfs(node, null);
    }
	
	private Node dfs(Node origin, Node parentCopy) {
		Node copy;
		boolean visited;
		
		if (visited = vertices.containsKey(origin.val)) {
			copy = vertices.get(origin.val);
		} else {
			copy = copyNode(origin);
			vertices.put(copy.val, copy);
		}
		
		if (parentCopy != null) {
			copy.neighbors.add(parentCopy);
		}
		
		if (!visited) {
			for (Node n : origin.neighbors) {
				dfs(n, copy);
			}
		}
		
		return copy;
	}
	
	private static Node copyNode(Node node) {
		return new Node(node.val, new ArrayList<>(node.neighbors.size()));
	}
}

class Node {
	
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int val) {
        this.val = val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int val, ArrayList<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}
