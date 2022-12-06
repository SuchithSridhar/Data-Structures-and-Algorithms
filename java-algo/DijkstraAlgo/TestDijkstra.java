/* Author: Suchith Sridhar
 * Date: 06th Dec 2022
 * 
 * The Program to test Dijkstra's
 * shortest path algorithm.
 * 
 * Dependency: Dijkstra.java
 */
import java.util.ArrayList;

public class TestDijkstra {
    public static void main(String[] args) {
        GraphNode<String> A = new GraphNode<String>("A");
        GraphNode<String> B = new GraphNode<String>("B");
        GraphNode<String> C = new GraphNode<String>("C");
        GraphNode<String> D = new GraphNode<String>("D");
        GraphNode<String> E = new GraphNode<String>("E");
        GraphNode<String> F = new GraphNode<String>("F");
        GraphNode<String> G = new GraphNode<String>("G");

        ArrayList<PathNode<String>> A_paths = new ArrayList<PathNode<String>> ();
        A_paths.add(new PathNode<String>(A, B, 4));
        A_paths.add(new PathNode<String>(A, G, 1));

        ArrayList<PathNode<String>> B_paths = new ArrayList<PathNode<String>> ();
        B_paths.add(new PathNode<String>(B, A, 4));
        B_paths.add(new PathNode<String>(B, G, 2));
        B_paths.add(new PathNode<String>(B, C, 1));

        ArrayList<PathNode<String>> C_paths = new ArrayList<PathNode<String>> ();
        C_paths.add(new PathNode<String>(C, B, 1));
        C_paths.add(new PathNode<String>(C, F, 1));
        C_paths.add(new PathNode<String>(C, D, 4));

        ArrayList<PathNode<String>> D_paths = new ArrayList<PathNode<String>> ();
        D_paths.add(new PathNode<String>(D, C, 4));
        D_paths.add(new PathNode<String>(D, E, 1));

        ArrayList<PathNode<String>> E_paths = new ArrayList<PathNode<String>> ();
        E_paths.add(new PathNode<String>(E, D, 1));
        E_paths.add(new PathNode<String>(E, F, 1));

        ArrayList<PathNode<String>> F_paths = new ArrayList<PathNode<String>> ();
        F_paths.add(new PathNode<String>(F, C, 1));
        F_paths.add(new PathNode<String>(F, G, 2));
        F_paths.add(new PathNode<String>(F, E, 1));

        ArrayList<PathNode<String>> G_paths = new ArrayList<PathNode<String>> ();
        G_paths.add(new PathNode<String>(G, A, 1));
        G_paths.add(new PathNode<String>(G, B, 2));
        G_paths.add(new PathNode<String>(G, F, 2));

        ArrayList<PathsNode<String>> paths = new ArrayList<PathsNode<String>> ();
        paths.add(new PathsNode<String>(A, A_paths));
        paths.add(new PathsNode<String>(B, B_paths));
        paths.add(new PathsNode<String>(C, C_paths));
        paths.add(new PathsNode<String>(D, D_paths));
        paths.add(new PathsNode<String>(E, E_paths));
        paths.add(new PathsNode<String>(F, F_paths));
        paths.add(new PathsNode<String>(G, G_paths));

        ArrayList<ShortestPathNode<String>> shortestPaths = Dijkstra.findShortestPaths(paths, B);
        System.out.println(shortestPaths);

    }
}
