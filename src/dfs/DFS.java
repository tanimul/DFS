package dfs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Vector;

/**
 *
 * @author Fuad
 */
public class DFS {

    // This class represents a directed graph using adjacency 
    // list representation 
    static class Graph {

        int V; //Number of Vertices 

        LinkedList<Integer>[] adj; // adjacency lists 

        //Constructor 
        Graph(int V) {
            this.V = V;
            adj = new LinkedList[V];

            for (int i = 0; i < adj.length; i++) {
                adj[i] = new LinkedList<Integer>();
            }

        }

        //To add an edge to graph 
        void addEdge(int v, int w) {
            adj[v].add(w); // Add w to v’s list. 
        }

        // prints all not yet visited vertices reachable from s 
        void DFS(int s) {
            // Initially mark all vertices as not visited 
            Vector<Boolean> visited = new Vector<Boolean>(V);
            for (int i = 0; i < V; i++) {
                visited.add(false);
            }

            // Create a stack for DFS 
            Stack<Integer> stack = new Stack<>();

            // Push the current source node 
            stack.push(s);

            while (stack.empty() == false) {
                // Pop a vertex from stack and print it 
                s = stack.peek();
                stack.pop();

                // Stack may contain same vertex twice. So 
                // we need to print the popped item only 
                // if it is not visited. 
                if (visited.get(s) == false) {
                    System.out.print(s + " ");
                    visited.set(s, true);
                }

                // Get all adjacent vertices of the popped vertex s 
                // If a adjacent has not been visited, then push it 
                // to the stack. 
                Iterator<Integer> itr = adj[s].iterator();

                while (itr.hasNext()) {
                    int v = itr.next();
                    if (!visited.get(v)) {
                        stack.push(v);
                    }
                }

            }
        }
    }

    // Driver program to test methods of graph class 
    public static void main(String[] args) {
        // Total 5 vertices in graph 
        Graph g = new Graph(8);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 4);
        g.addEdge(2, 5);
        g.addEdge(2, 6);
        g.addEdge(3, 6);
        g.addEdge(4, 7);
        g.addEdge(5, 7);
        g.addEdge(6, 7);

        System.out.println("Following is the Depth First Traversal");
        g.DFS(0);
    }

}
