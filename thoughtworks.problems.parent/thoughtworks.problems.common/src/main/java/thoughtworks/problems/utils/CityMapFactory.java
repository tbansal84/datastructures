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
import thoughtworks.problems.graphs.StationLink;
import thoughtworks.problems.graphs.Station;

/**
 * Factory to initialize the Map
 * @author tbansal
 *
 */
public class CityMapFactory {



	public static CityMap createTestMap() {
		CityMap graph = new CityMap();
		Map<String, Station> map = new HashMap<>();

		Station a = new Station("A");
		graph.addStation(a, true);

		Station b = new Station("B");
		graph.addStation(b, true);

		Station c = new Station("C");
		graph.addStation(c, true);

		Station d = new Station("D");
		graph.addStation(d, true);

		Station e = new Station("E");
		graph.addStation(e, true);

		graph.addLink(a, b, 5);
		graph.addLink(b, c, 4);
		graph.addLink(c, d, 8);
		graph.addLink(d, c, 8);
		graph.addLink(d, e, 6);
		graph.addLink(a, d, 5);
		graph.addLink(c, e, 2);
		graph.addLink(e, b, 3);
		graph.addLink(a, e, 7);

		return graph;

	}

	/**
	 * Create amp from file
	 * @param lines
	 * @return
	 * @throws IOException
	 */
	public static CityMap createMap(List<String> lines) throws IOException {
		ListIterator<String> itr = lines.listIterator();
		String[] nodes = itr.next().split(",");

		CityMap graph = new CityMap();
		Map<String, Station> vertices = new HashMap<>();

		for (String node : nodes) {

			Station vertex = new Station(node.trim());
			graph.addStation(vertex, true);
			vertices.put(node, vertex);

		}
		String edgeDescription = null;
		while (itr.hasNext()) {
			edgeDescription=itr.next();
			String[] edge = edgeDescription.split(",");
			graph.addLink(vertices.get(edge[0].trim()), vertices.get(edge[1].trim()), Integer.parseInt(edge[2]));
		}

		return graph;

	}
}
