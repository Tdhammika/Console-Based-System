import java.util.*;

public class GraphOperations {
    private Map<Integer, List<Integer>> adjacencyList;

    public GraphOperations() {
        this.adjacencyList = new HashMap<>();
    }

    // Method to add a vertex to the graph
    public void addVertex(int vertex) {
        if (!adjacencyList.containsKey(vertex)) {
            adjacencyList.put(vertex, new ArrayList<>());
            System.out.println("Vertex " + vertex + " added successfully.");
        } else {
            System.out.println("Vertex " + vertex + " already exists in the graph.");
        }
    }

    // Method to add an edge between two vertices (undirected graph)
    public void addEdge(int source, int destination) {
        if (!adjacencyList.containsKey(source)) {
            addVertex(source);
        }
        if (!adjacencyList.containsKey(destination)) {
            addVertex(destination);
        }

        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source); // Remove this line if it's a directed graph
        System.out.println("Edge added between " + source + " and " + destination + ".");
    }

    // Method to display the graph
    public void displayGraph() {
        System.out.println("\n--- Graph Representation (Adjacency List) ---");
        for (Map.Entry<Integer, List<Integer>> entry : adjacencyList.entrySet()) {
            System.out.print("Vertex " + entry.getKey() + " is connected to: ");
            for (Integer neighbor : entry.getValue()) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
        System.out.println("---------------------------------------------");
    }

    // Method for Breadth-First Search (BFS) traversal
    public void bfsTraversal(int startVertex) {
        if (!adjacencyList.containsKey(startVertex)) {
            System.out.println("Vertex " + startVertex + " does not exist in the graph.");
            return;
        }

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(startVertex);
        queue.add(startVertex);

        System.out.println("\n--- BFS Traversal Starting from Vertex " + startVertex + " ---");
        
        long startTime = System.nanoTime(); // For performance tracking
        int steps = 0;

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            System.out.print(currentVertex + " ");
            steps++;

            for (int neighbor : adjacencyList.get(currentVertex)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        
        long endTime = System.nanoTime();
        System.out.println("\n[Performance] BFS completed in " + steps + " steps.");
        System.out.println("[Performance] BFS Execution Time: " + (endTime - startTime) + " ns");
        System.out.println("-------------------------------------------------");
    }

    // Method for Depth-First Search (DFS) traversal
    public void dfsTraversal(int startVertex) {
        if (!adjacencyList.containsKey(startVertex)) {
            System.out.println("Vertex " + startVertex + " does not exist in the graph.");
            return;
        }

        Set<Integer> visited = new HashSet<>();
        System.out.println("\n--- DFS Traversal Starting from Vertex " + startVertex + " ---");
        
        long startTime = System.nanoTime(); // For performance tracking
        
        int steps = dfsHelper(startVertex, visited, 0);
        
        long endTime = System.nanoTime();
        System.out.println("\n[Performance] DFS completed in " + steps + " steps.");
        System.out.println("[Performance] DFS Execution Time: " + (endTime - startTime) + " ns");
        System.out.println("-------------------------------------------------");
    }

    // Recursive helper method for DFS
    private int dfsHelper(int vertex, Set<Integer> visited, int steps) {
        visited.add(vertex);
        System.out.print(vertex + " ");
        steps++;

        for (int neighbor : adjacencyList.get(vertex)) {
            if (!visited.contains(neighbor)) {
                steps = dfsHelper(neighbor, visited, steps);
            }
        }
        return steps;
    }

    // Method to handle Graph Operations Menu
    public void showGraphMenu(Scanner scanner) {
        int choice;
        do {
            System.out.println("\n--- GRAPH OPERATIONS ---");
            System.out.println("1. Add Vertex");
            System.out.println("2. Add Edge");
            System.out.println("3. Display Graph");
            System.out.println("4. BFS Traversal");
            System.out.println("5. DFS Traversal");
            System.out.println("6. Return to Main Menu");
            System.out.print("Enter your choice: ");
            
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter vertex to add: ");
                    int vertex = scanner.nextInt();
                    addVertex(vertex);
                    break;
                case 2:
                    System.out.print("Enter source vertex: ");
                    int source = scanner.nextInt();
                    System.out.print("Enter destination vertex: ");
                    int destination = scanner.nextInt();
                    addEdge(source, destination);
                    break;
                case 3:
                    displayGraph();
                    break;
                case 4:
                    System.out.print("Enter starting vertex for BFS: ");
                    int startBFS = scanner.nextInt();
                    bfsTraversal(startBFS);
                    break;
                case 5:
                    System.out.print("Enter starting vertex for DFS: ");
                    int startDFS = scanner.nextInt();
                    dfsTraversal(startDFS);
                    break;
                case 6:
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);
    }
}