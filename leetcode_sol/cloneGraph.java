public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }

        ArrayList<UndirectedGraphNode> nodes = new ArrayList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map
            = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();

        // clone nodes
        nodes.add(node);
        map.put(node, new UndirectedGraphNode(node.label));

        int start = 0;
        while (start < nodes.size()) {
            UndirectedGraphNode head = nodes.get(start++);
            for (int i = 0; i < head.neighbors.size(); i++) {
                UndirectedGraphNode neighbor = head.neighbors.get(i);
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                    nodes.add(neighbor);
                }
            }
        }

        // clone neighbors
        for (int i = 0; i < nodes.size(); i++) {
            UndirectedGraphNode newNode = map.get(nodes.get(i));
            for (int j = 0; j < nodes.get(i).neighbors.size(); j++) {
                newNode.neighbors.add(map.get(nodes.get(i).neighbors.get(j)));
            }
        }

        return map.get(node);
    }

    Node clone(Node graph) {
        if (graph == null) return null;
        Map map = new HashMap();
        Queue<Node> q = new ListList();
        q.push(graph);
        Node graphCopy = new Node();
        map[graph] = graphCopy;

        while (!q.empty()) {
            Node node = q.front();
            q.pop();
            int n = node.neighbors.size();
            for (int i = 0; i < n; i++) {
                Node neighbor = node.neighbors[i];
                // no copy exists
                if (!map.containKey(neighbor)) {
                    Node p = new Node();
                    map[node].neighbors.push_back(p);
                    map[neighbor] = p;
                    q.push(neighbor);
                } else {     // a copy already exists
                    map[node].neighbors.push_back(map[neighbor]);
                }
            }
        }
        return graphCopy;
    }
}