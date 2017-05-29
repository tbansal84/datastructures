package thoughtworks.problems.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import thoughtworks.problems.entity.CityMap;
import thoughtworks.problems.graphs.Edge;
import thoughtworks.problems.graphs.Station;

/**
 * 
 * @author Michael Levet
 * @date June 09, 2015
 */
public class GraphFactory {

	public static void main(String[] args) {
		CityMap graph = new CityMap();

		// initialize some vertices and add them to the graph
		Station[] vertices = new Station[5];
		for (int i = 0; i < vertices.length; i++) {
			vertices[i] = new Station("" + i);
			graph.addVertex(vertices[i], true);
		}

		// illustrate the fact that duplicate edges aren't added
		for (int i = 0; i < vertices.length - 1; i++) {
			for (int j = i + 1; j < vertices.length; j++) {
				graph.addEdge(vertices[i], vertices[j]);
				graph.addEdge(vertices[i], vertices[j]);
				graph.addEdge(vertices[j], vertices[i]);
			}
		}

		// display the initial setup- all vertices adjacent to each other
		for (int i = 0; i < vertices.length; i++) {
			System.out.println(vertices[i]);

			for (int j = 0; j < vertices[i].getNeighborCount(); j++) {
				System.out.println(vertices[i].getNeighbor(j));
			}

			System.out.println();
		}

		// overwritte Vertex 3
		graph.addVertex(new Station("3"), true);
		for (int i = 0; i < vertices.length; i++) {
			System.out.println(vertices[i]);

			for (int j = 0; j < vertices[i].getNeighborCount(); j++) {
				System.out.println(vertices[i].getNeighbor(j));
			}

			System.out.println();
		}

		System.out.println("Vertex 5: " + graph.getVertex("5")); // null
		System.out.println("Vertex 3: " + graph.getVertex("3")); // Vertex 3

		// true
		System.out.println(
				"Graph Contains {1, 2}: " + graph.containsEdge(new Edge(graph.getVertex("1"), graph.getVertex("2"))));

		// true
		System.out.println(graph.removeEdge(new Edge(graph.getVertex("1"), graph.getVertex("2"))));

		// false
		System.out.println(
				"Graph Contains {1, 2}: " + graph.containsEdge(new Edge(graph.getVertex("1"), graph.getVertex("2"))));

		// false
		System.out.println(
				"Graph Contains {2, 3} " + graph.containsEdge(new Edge(graph.getVertex("2"), graph.getVertex("3"))));

		System.out.println(graph.containsVertex(new Station("1"))); // true
		System.out.println(graph.containsVertex(new Station("6"))); // false
		System.out.println(graph.removeVertex("2")); // Vertex 2
		System.out.println(graph.vertexKeys()); // [3, 1, 0, 4]

	}

	public static CityMap createGraphsForTravrsal() {
		CityMap graph = new CityMap();

		// initialize some vertices and add them to the graph
		Station[] vertices = new Station[10];
		for (int i = 0; i < vertices.length; i++) {
			vertices[i] = new Station("" + i);
			graph.addVertex(vertices[i], true);
		}

		graph.addEdge(vertices[0], vertices[1], 3);
		graph.addEdge(vertices[1], vertices[2], 6);
		graph.addEdge(vertices[2], vertices[3], 5);
		graph.addEdge(vertices[3], vertices[4], 4);
		graph.addEdge(vertices[4], vertices[5], 2);
		graph.addEdge(vertices[5], vertices[6], 1);
		graph.addEdge(vertices[6], vertices[7], 6);
		graph.addEdge(vertices[7], vertices[8], 5);
		graph.addEdge(vertices[8], vertices[9], 1);
		graph.addEdge(vertices[9], vertices[6], 2);
		graph.addEdge(vertices[2], vertices[8], 9);
		graph.addEdge(vertices[3], vertices[5], 11);
		graph.addEdge(vertices[0], vertices[5], 1);
		graph.addEdge(vertices[0], vertices[9], 1);

		return graph;

	}

	public static CityMap createTestGraph() {
		CityMap graph = new CityMap();
		Map<String, Station> map = new HashMap<>();

		Station a = new Station("A");
		graph.addVertex(a, true);

		Station b = new Station("B");
		graph.addVertex(b, true);

		Station c = new Station("C");
		graph.addVertex(c, true);

		Station d = new Station("D");
		graph.addVertex(d, true);

		Station e = new Station("E");
		graph.addVertex(e, true);

		graph.addEdge(a, b, 5);
		graph.addEdge(b, c, 4);
		graph.addEdge(c, d, 8);
		graph.addEdge(d, c, 8);
		graph.addEdge(d, e, 6);
		graph.addEdge(a, d, 5);
		graph.addEdge(c, e, 2);
		graph.addEdge(e, b, 3);
		graph.addEdge(a, e, 7);

		return graph;

	}

	public static CityMap createGraph(List<String> lines) throws IOException {
		ListIterator<String> itr = lines.listIterator();
		String[] nodes = itr.next().split(",");

		CityMap graph = new CityMap();
		Map<String, Station> vertices = new HashMap<>();

		for (String node : nodes) {

			Station vertex = new Station(node.trim());
			graph.addVertex(vertex, true);
			vertices.put(node, vertex);

		}
		String edgeDescription = null;
		while (itr.hasNext()) {
			edgeDescription=itr.next();
			String[] edge = edgeDescription.split(",");
			graph.addEdge(vertices.get(edge[0].trim()), vertices.get(edge[1].trim()), Integer.parseInt(edge[2]));
		}

		return graph;

	}
}
