package ua.nure.piontkovskyi.Practice6.part4;

public class Part4 {

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        System.out.println(graph.addEdge(1, 2));
        System.out.println(graph.addEdge(3, 4));
        System.out.println(graph.addEdge(5, 6));
        System.out.println(graph.addEdge(3, 6) + System.lineSeparator());
        System.out.println(graph.getGraph() + System.lineSeparator());

        System.out.println("===Illegal edges===");
        System.out.println(graph.addEdge(100, 500));
        System.out.println(graph.addEdge(5, 5) + System.lineSeparator());

        System.out.println("===Already exists===");
        System.out.println(graph.addEdge(1, 2) + System.lineSeparator());

        System.out.println("===Removing edge===");
        System.out.println(graph.removeEdge(3, 6) + System.lineSeparator());

        System.out.println("===Removing edge that does not exist===");
        System.out.println(graph.removeEdge(4, 6) + System.lineSeparator());

        System.out.println("Result graph:");
        System.out.println(graph.getGraph());
    }

}
