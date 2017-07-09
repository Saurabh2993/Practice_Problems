package leetcode_medium;

import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Clone_Graph {
	
	class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;
		
		UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
		
	}
	
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) {
            return null;
        }
        
        UndirectedGraphNode head = new UndirectedGraphNode(node.label);
        Queue<UndirectedGraphNode> node_queue = new LinkedList<>();
        HashMap<Integer, UndirectedGraphNode> node_map = new HashMap<>();
        
        node_map.put(head.label, head);
        node_queue.add(node);
        
        while(!node_queue.isEmpty()) {
            
            UndirectedGraphNode temp = node_queue.remove();
            
            for(UndirectedGraphNode x : temp.neighbors) {
                if(!node_map.containsKey(x.label)) {
                    node_map.put(x.label, new UndirectedGraphNode(x.label));
                    node_queue.add(x);
                }
                node_map.get(temp.label).neighbors.add(node_map.get(x.label));
            }
        }
        
        return head;
    }

}
