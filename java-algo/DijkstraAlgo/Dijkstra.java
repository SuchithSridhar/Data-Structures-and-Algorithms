/* Author: Suchith Sridhar
 * Date: 06th Dec 2022
 * 
 * The Dijkstra Algorithm to find the shortest
 * path to a node in a weighted graph.
 */
import java.util.ArrayList;

/**
 * Represents a Graph node
 * for the graph data structure
 */
class GraphNode<T> {
    public T data;
    public GraphNode(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        if (data == null) {
            return String.format("%s", "Null");
        }
        return String.format("%s", data.toString());
    }
}

/**
 * This object represents an edge in a graph,
 * stored along with the weight of the edge.
 */
class PathNode<T> {
    public GraphNode<T> destinationNode;
    public GraphNode<T> sourceNode;
    public int weight;

    public PathNode(GraphNode<T> sourceNode, GraphNode<T> destinationNode, int weight) {
        this.destinationNode = destinationNode;
        this.weight = weight;
    }

}

/**
 * This object stores all the edges that a particular
 * source node is connected to.
 */
class PathsNode<T> {
    public GraphNode<T> sourceNode;
    public ArrayList<PathNode<T>> destinationArray;

    public PathsNode(GraphNode<T> sourceNode, ArrayList<PathNode<T>> destArr) {
        this.sourceNode = sourceNode;
        this.destinationArray = destArr;
    }
}

/**
 * This objects holds the shortest path to a given node
 * from a given node.
 */
class ShortestPathNode<T> {
    public GraphNode<T> sourceNode;
    /* The destination node */
    public GraphNode<T> destinationNode;
    /* The next node to jump to in the shortest path. */
    public GraphNode<T> nextHop;
    public int totalCost;

    public ShortestPathNode (GraphNode<T> sourceNode, GraphNode<T> destinationNode, GraphNode<T> nextHop, int totalCost) {
        this.sourceNode = sourceNode;
        this.destinationNode = destinationNode;
        this.nextHop = nextHop;
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        String nextHopString;
        if (nextHop == null) {
            nextHopString = "null";
        } else {
            nextHopString = nextHop.toString();
        }
        return String.format("(%s, %d, %s)", destinationNode.toString(), totalCost, nextHopString);
    }
}

class Dijkstra {
    public static <T> ArrayList<ShortestPathNode<T>> findShortestPaths(ArrayList<PathsNode<T>> paths, GraphNode<T> sourceNode) {
        ArrayList<ShortestPathNode<T>> confirmedList = new ArrayList<ShortestPathNode<T>> ();
        ArrayList<ShortestPathNode<T>> tentitiveList = new ArrayList<ShortestPathNode<T>> ();
        ArrayList<PathNode<T>> destinationList = new ArrayList<PathNode<T>> ();

        // insert source node

        confirmedList.add(new ShortestPathNode<T>(sourceNode, sourceNode, null, 0));

        for (PathsNode<T> node : paths) {
            if (node.sourceNode == sourceNode) {
                destinationList = node.destinationArray;
                break;
            }
        }

        if (destinationList.isEmpty()) return confirmedList;

        for (PathNode<T> path : destinationList) {
            tentitiveList.add(new ShortestPathNode<T>(sourceNode, path.destinationNode, path.destinationNode, path.weight));
        }

        ShortestPathNode<T> lowestNode;
        while (!tentitiveList.isEmpty()) {
            lowestNode = tentitiveList.get(0);
            for (ShortestPathNode<T> curNode : tentitiveList) {
                if (curNode.totalCost < lowestNode.totalCost) lowestNode = curNode;
            }

            tentitiveList.remove(lowestNode);
            confirmedList.add(lowestNode);

            for (PathsNode<T> node : paths) {
                if (node.sourceNode == lowestNode.destinationNode) {
                    destinationList = node.destinationArray;
                    break;
                }
            }

            ShortestPathNode<T> computedNewPath;
            ShortestPathNode<T> nodeToRemove = null;
            int computedCost;
            boolean isInTentitive = false;
            boolean isInConfirmed = false;
            boolean shouldSwitch = false;

            for (PathNode<T> path : destinationList) {
                isInTentitive = false;
                isInConfirmed = false;
                shouldSwitch = false;

                computedCost = lowestNode.totalCost + path.weight;
                computedNewPath = new ShortestPathNode<T>(sourceNode, path.destinationNode, lowestNode.nextHop, computedCost);
                for (ShortestPathNode<T> curNode : confirmedList) {
                    if (curNode.destinationNode == computedNewPath.destinationNode) {
                        isInConfirmed = true;
                        break;
                    }
                }

                if (isInConfirmed) continue;

                for (ShortestPathNode<T> curNode : tentitiveList) {
                    if (curNode.destinationNode == computedNewPath.destinationNode) {
                        isInTentitive = true;
                        if (computedCost < curNode.totalCost) {
                            nodeToRemove = curNode;
                            shouldSwitch = true;
                        }
                        break;
                    }
                }

                if (shouldSwitch) {
                    // nodeToRemove will always be initialized is shouldSwitch is true
                    tentitiveList.remove(nodeToRemove);
                    tentitiveList.add(computedNewPath);
                }

                if (!isInTentitive) {
                    tentitiveList.add(computedNewPath);
                }
            }
        }

        return confirmedList;
    }
}
